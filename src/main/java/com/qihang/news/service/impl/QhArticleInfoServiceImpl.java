package com.qihang.news.service.impl;

import com.qihang.news.annotation.Page;
import com.qihang.news.check.QhArticleInfoCheck;
import com.qihang.news.dto.PageFilter;
import com.qihang.news.dto.QhArticleInfoCreateDTO;
import com.qihang.news.dto.QhArticleInfoReqDTO;
import com.qihang.news.dto.QhArticleInfoRespDTO;
import com.qihang.news.entity.QhArticleInfoEntity;
import com.qihang.news.mapper.QhArticleInfoDao;
import com.qihang.news.service.QhArticleInfoService;
import com.qihang.news.translate.QhArticleInfoTranslate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QhArticleInfoServiceImpl implements QhArticleInfoService {
    @Autowired
    private QhArticleInfoDao qhArticleInfoDao;

    @Override
    public QhArticleInfoEntity findByPrimaryKey(Long id) {
        return qhArticleInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public PageFilter<QhArticleInfoRespDTO> findByBigCategoryId(QhArticleInfoReqDTO qhArticleInfoReqDTO) {
        return getQhArticleInfoResp(qhArticleInfoReqDTO);
    }

    @Override
    public PageFilter<QhArticleInfoRespDTO> findBySmallCategoryId(QhArticleInfoReqDTO qhArticleInfoReqDTO) {
        return getQhArticleInfoResp(qhArticleInfoReqDTO);
    }

    @Override
    public int save(QhArticleInfoCreateDTO qhArticleInfoCreateDTO) {
        QhArticleInfoCheck.checkParam(qhArticleInfoCreateDTO);
        return qhArticleInfoDao.insert(QhArticleInfoTranslate.toQhArticleInfoEntity(qhArticleInfoCreateDTO));
    }


    @Page
    private PageFilter<QhArticleInfoRespDTO> getQhArticleInfoResp(QhArticleInfoReqDTO qhArticleInfoReqDTO) {
        List<QhArticleInfoRespDTO> qhArticleInfoResp = qhArticleInfoDao.selectByBigCategoryId(qhArticleInfoReqDTO).stream().map(item -> {
            QhArticleInfoRespDTO qhArticleInfo = new QhArticleInfoRespDTO();
            BeanUtils.copyProperties(item, qhArticleInfo);
            return qhArticleInfo;
        }).collect(Collectors.toList());
        return qhArticleInfoReqDTO.getPageFilter(qhArticleInfoReqDTO,qhArticleInfoResp);
    }


}
