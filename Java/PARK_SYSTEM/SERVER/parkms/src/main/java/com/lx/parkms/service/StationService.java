package com.lx.parkms.service;

import com.lx.parkms.entity.Station;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StationService {

    Page<Station> getAll(Integer page,Integer size);

    Station getOne(Integer id);

    Station remove(Integer id);

    Station save(Station station);

    /**
     * 小型车空余车位
     * @return
     */
    List<Station> findSmallAll();

    /**
     * 中型车空余车位
     * @return
     */
    List<Station> findMiddleAll();

    /**
     * 大型车空余车位
     * @return
     */
    List<Station> findLargeAll();
}
