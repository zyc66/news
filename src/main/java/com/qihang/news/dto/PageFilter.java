package com.qihang.news.dto;

import lombok.Data;

import java.util.List;


/**
 * @program: rems
 * @description: 分页类
 * @author: hu.chen
 * @createDate: 2021年04月23日 18:26
 **/
@Data
public class PageFilter<T> {

    /**
     * 总条数
     */
    private long total;

    /**
     * 当前页码
     */
    private String pageNum;

    /**
     * 每页记录数
     */
    private String pageSize;

    /**
     * 总页数
     */
    private Integer pages;

    private List<T> data;

    /**
     * @param obj 继承了PageFilter类的子类
     * @param response 从数据库查询出来的参数
     * @return
     */
    public PageFilter<T> getPageFilter(PageFilter<T> obj,List<T> response) {
        PageFilter<T> pages = new PageFilter<>();
        pages.setPageNum(String.valueOf(obj.getPageNum()));
        pages.setPages(obj.getPages());
        pages.setPageSize(String.valueOf(obj.getPageSize()));
        pages.setTotal(obj.getTotal());
        pages.setData(response);
        return pages;
    }
}
