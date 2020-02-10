package com.lx.parkms.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FreeStation {

    private Integer freeLargeCount;
    private Integer freeMiddleCount;
    private Integer freeSmallCount;

    public FreeStation(Integer freeLargeCount, Integer freeMiddleCount, Integer freeSmallCount) {
        this.freeLargeCount = freeLargeCount;
        this.freeMiddleCount = freeMiddleCount;
        this.freeSmallCount = freeSmallCount;
    }
}
