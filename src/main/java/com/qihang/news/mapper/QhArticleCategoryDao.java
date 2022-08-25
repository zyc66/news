package com.qihang.news.mapper;

import com.qihang.news.entity.QhArticleCategoryEntity;

public interface QhArticleCategoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(QhArticleCategoryEntity record);

    int insertSelective(QhArticleCategoryEntity record);

    QhArticleCategoryEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QhArticleCategoryEntity record);

    int updateByPrimaryKey(QhArticleCategoryEntity record);
}