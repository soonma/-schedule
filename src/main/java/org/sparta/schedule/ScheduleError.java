package org.sparta.schedule;

import lombok.Getter;

@Getter
public class ScheduleError extends RuntimeException {
    private ErrorCode errorCode;

        public ScheduleError(String message, ErrorCode errorCode) {
            super(message);
            this.errorCode = errorCode;
        }
}
