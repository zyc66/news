package com.qihang.news.check;

import com.qihang.news.dto.QhArticleInfoCreateDTO;
import com.qihang.news.enums.ErrorEnum;
import com.qihang.news.exception.CheckException;
import org.apache.commons.lang3.StringUtils;

public class QhArticleInfoCheck {
    public static void checkParam(QhArticleInfoCreateDTO qhArticleInfoCreateDTO) {
        if (StringUtils.isBlank(qhArticleInfoCreateDTO.getTitle())) {
            throw new CheckException(ErrorEnum.TITLE_NOT_NULL.getCode(),ErrorEnum.TITLE_NOT_NULL.getMsg());
        }
        if (StringUtils.isBlank(qhArticleInfoCreateDTO.getAuthor())) {
            throw new CheckException(ErrorEnum.AUTHOR_NOT_NULL.getCode(),ErrorEnum.AUTHOR_NOT_NULL.getMsg());
        }
        if (StringUtils.isBlank(qhArticleInfoCreateDTO.getBigCategoryId())) {
            throw new CheckException(ErrorEnum.BIG_CATEGORY_NOT_NULL.getCode(),ErrorEnum.BIG_CATEGORY_NOT_NULL.getMsg());
        }
        if (StringUtils.isBlank(qhArticleInfoCreateDTO.getBigCategoryId())) {
            throw new CheckException(ErrorEnum.SMALL_CATEGORY_NOT_NULL.getCode(),ErrorEnum.SMALL_CATEGORY_NOT_NULL.getMsg());
        }
    }
}
