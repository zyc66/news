package com.qihang.news.mapper;

import com.qihang.news.dto.QhArticleInfoReqDTO;
import com.qihang.news.entity.QhArticleInfoEntity;

import java.util.List;

public interface QhArticleInfoDao {
    int deleteByPrimaryKey(Long id);

    int insert(QhArticleInfoEntity record);

    int insertSelective(QhArticleInfoEntity record);

    QhArticleInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QhArticleInfoEntity record);

    int updateByPrimaryKey(QhArticleInfoEntity record);

    List<QhArticleInfoEntity> selectByBigCategoryId(QhArticleInfoReqDTO qhArticleInfoReqDTO);
}