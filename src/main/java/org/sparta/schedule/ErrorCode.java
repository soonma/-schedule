package org.sparta.schedule;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode {
    NOT_SAME_PASSWD(500,"COMMON-ERR-500","비밀번호가 일치 하지 않습니다."),
    DELETE_SERVER_ERROR(500,"COMMON-ERR-500","이미 삭제가 되었거나 없는 정보 입니다."),
    NOT_LIST(500,"COMMON-ERR-500","삭제가 되어 정보를 찾을수 없습니다."),
    ;

    private int status;
    private String errorCode;
    private String message;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
