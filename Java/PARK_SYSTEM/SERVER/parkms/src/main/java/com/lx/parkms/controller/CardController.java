package com.lx.parkms.controller;

import com.lx.parkms.entity.Car;
import com.lx.parkms.entity.Card;
import com.lx.parkms.service.CarService;
import com.lx.parkms.service.CardService;
import com.lx.parkms.vo.CardVO;
import com.lx.parkms.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/card")
@CrossOrigin
@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private CarService carService;

    @GetMapping("/list")
    public PageVO<CardVO> getAll(Integer page, Integer size, String phone) {
        PageVO<CardVO> pageVO = new PageVO<>();
        List<CardVO> cardVOList = new ArrayList<>();

        Page<Card> cards = cardService.getAll(page, size, phone);

        String cardId = "";
        List<Car> cars = null;
        for (Card card :
                cards.getContent()) {
            CardVO cardVO = new CardVO();
            pageVO.setTotalElements(cards.getTotalElements());
            pageVO.setTotalPages(cards.getTotalPages());
            cardId = card.getCardId();
            cars = carService.getCarByCardId(cardId);
            cardVO.setCars(cars);
            BeanUtils.copyProperties(card, cardVO);
            cardVOList.add(cardVO);
        }
        pageVO.setContent(cardVOList);
        return pageVO;
    }

    /**
     * 停车卡和车牌号级联增加
     *
     * @param card
     * @param carIds
     * @return
     */
    @PostMapping("/cardAll")
    public Card addAll(@RequestBody Card card, @RequestParam List<String> carIds) {
        Card res = cardService.save(card);
        for (String carId :
                carIds) {
            Car car = new Car();
            car.setCarId(carId);
            car.setCarType("");
            car.setCardId(card.getCardId());
            carService.save(car);
        }
        return res;
    }

    /**
     * 停车卡和停车号级联修改
     *
     * @param card
     * @param carIds
     * @return
     */
    @PutMapping("/updateAll")
    public Card updateAll(@RequestBody Card card, @RequestParam List<String> carIds) {
        // 修改卡信息
        Card res = cardService.save(card);

        // 删除原来卡绑定的车信息
        List<Car> cars = carService.getCarByCardId(card.getCardId());
        for (Car car :
                cars) {
            carService.remove(car.getCarId());
        }

        // 新增卡绑定的车信息
        for (String carId :
                carIds) {
            Car car = new Car();
            car.setCarId(carId);
            car.setCarType("");
            car.setCardId(card.getCardId());
            carService.save(car);
        }
        return res;
    }

    @PutMapping("/card")
    public Card update(@RequestBody Card card) {
        return cardService.save(card);
    }

    @PostMapping("/card")
    public Card add(@RequestBody Card card) {
        return cardService.save(card);
    }

    @GetMapping("/card")
    public Card add(@RequestParam String phone) {
        return cardService.findByUserPhone(phone);
    }

    @DeleteMapping("/card/{id}")
    public Card remove(@PathVariable String id) {

        // 先删除关联的车
        List<Car> cars = carService.getCarByCardId(id);
        for (Car car :
                cars) {
            carService.remove(car.getCarId());
        }

        // 再删除停车卡本身
        return cardService.remove(id);
    }

    /**
     * 充值
     *
     * @param phone 手机号
     * @param money 充值金额
     * @return
     */
    @PostMapping("/addMoney")
    public Card addMoney(@RequestParam String phone, @RequestParam Double money) {
        return cardService.addMoney(phone, money);
    }


}
