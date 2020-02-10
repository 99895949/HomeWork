package com.lx.parkms.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PageVO<T> {

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 总数量
     */
    private Long totalElements;

    /**
     * 数据
     */
    private List<T> content;
}
