package com.qihang.news.service;

import com.qihang.news.dto.PageFilter;
import com.qihang.news.dto.QhArticleInfoCreateDTO;
import com.qihang.news.dto.QhArticleInfoReqDTO;
import com.qihang.news.dto.QhArticleInfoRespDTO;
import com.qihang.news.entity.QhArticleInfoEntity;

public interface QhArticleInfoService {
    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    QhArticleInfoEntity findByPrimaryKey(Long id);

    /**
     * 根据大类id查询文章列表
     *
     * @param qhArticleInfoReqDTO
     * @return
     */
    PageFilter<QhArticleInfoRespDTO> findByBigCategoryId(QhArticleInfoReqDTO qhArticleInfoReqDTO);

    /**
     * 根据大类id查询文章列表
     *
     * @param qhArticleInfoReqDTO
     * @return
     */
    PageFilter<QhArticleInfoRespDTO> findBySmallCategoryId(QhArticleInfoReqDTO qhArticleInfoReqDTO);

    int save(QhArticleInfoCreateDTO qhArticleInfoCreateDTO);
}
