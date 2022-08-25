package com.qihang.news.enums;

/**
 * @author lixiang
 * 使用枚举类型来封装异常码和异常信息
 */
public enum ErrorEnum {
    TITLE_NOT_NULL(10001, "文章标题不能为空"),
    SMALL_CATEGORY_NOT_NULL(10002, "大类ID不能为空"),
    BIG_CATEGORY_NOT_NULL(10003, "小类ID不能为空"),
    AUTHOR_NOT_NULL(10004, "作者不能为空"),
    ;

    private final String msg;
    private final int code;

    private ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getCode() {
        return this.code;
    }

}