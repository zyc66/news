package com.qihang.news.entity;

import lombok.Data;
@Data
public class QhArticleCategoryEntity extends BaseEntity {
    /**
     * 父类id
     */
    private long parentId;
    /**
     * 类别名称
     */
    private String categoryName;
}
