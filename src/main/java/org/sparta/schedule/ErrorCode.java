package org.sparta.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_SAME_PASSWD(500,"COMMON-ERR-500","비밀번호가 일치 하지 않습니다."),
    DELETE_SERVER_ERROR(500,"COMMON-ERR-500","이미 삭제가 되었거나 없는 정보 입니다."),
    NOT_LIST(500,"COMMON-ERR-500","삭제가 되어 정보를 찾을수 없습니다."),
    NOT_FOUND(404,"COMMON-ERR-404","PAGE NOT FOUND")
    ;

    private final int status;
    private final String errorCode;
    private final String message;

}
