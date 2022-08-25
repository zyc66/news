package com.qihang.news.dto;

import lombok.Data;

@Data
public class QhArticleInfoCreateDTO {
    /**
     * 大类id
     */
    private String bigCategoryId;
    /**
     * 小类id
     */
    private String smallCategoryId;
    /**
     * 标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章内容
     */
    private String author;
}
