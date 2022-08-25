package com.qihang.news.translate;

import com.qihang.news.dto.QhArticleInfoCreateDTO;
import com.qihang.news.dto.QhArticleInfoReqDTO;
import com.qihang.news.entity.QhArticleInfoEntity;
import org.springframework.beans.BeanUtils;

public class QhArticleInfoTranslate {
    public static QhArticleInfoEntity toQhArticleInfoEntity(QhArticleInfoCreateDTO qhArticleInfoCreateDTO) {
        QhArticleInfoEntity qhArticleInfoEntity = new QhArticleInfoEntity();
        BeanUtils.copyProperties(qhArticleInfoCreateDTO,qhArticleInfoEntity);
        return qhArticleInfoEntity;
    }
}
