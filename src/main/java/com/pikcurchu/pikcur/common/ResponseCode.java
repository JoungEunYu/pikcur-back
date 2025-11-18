package com.pikcurchu.pikcur.common;

public enum ResponseCode {
    SUCCESS("SUCCESS", "성공"),
    DUPLICATE("DUPLICATE", "중복 데이터"),
    MAIL_SEND_FAIL("MAIL_SEND_FAIL", "메일 전송 실패"),
    INVALID_REQUEST("INVALID_REQUEST", "잘못된 요청"),
    EXPIRATION("EXPIRATION", "만료"),
    INCONSISTENCY("INCONSISTENCY", "불일치");

    private final String code;
    private final String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
