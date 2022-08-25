package com.qihang.news.dto;

import lombok.Data;

@Data
public class QhArticleInfoReqDTO extends PageFilter<QhArticleInfoRespDTO>{
    private Long smallCategoryId;
    private Long BigCategoryId;
}
