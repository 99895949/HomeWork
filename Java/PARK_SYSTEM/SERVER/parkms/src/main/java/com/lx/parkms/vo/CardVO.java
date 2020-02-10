package com.lx.parkms.vo;

import com.lx.parkms.entity.Car;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class CardVO {
    /**
     * 停车卡号
     */
    private String cardId;

    /**
     * 停车卡主姓名
     */
    private String userName;

    /**
     * 卡主密码
     */
    private String userPassword;

    /**
     * 卡主电话
     */
    private String userPhone;

    /**
     * 卡片类型号
     */
    private Integer cardType;

    /**
     * 卡余额
     */
    private BigDecimal cardBalance;

    /**
     * 该卡绑定的车
     */
    private List<Car> cars;



}
