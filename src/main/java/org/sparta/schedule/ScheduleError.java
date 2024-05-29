package org.sparta.schedule;

import lombok.Getter;

@Getter
public class ScheduleError extends RuntimeException {
    private final ErrorCode errorCode;

        public ScheduleError(String message, ErrorCode errorCode) {
            super(message);
            this.errorCode = errorCode;
        }
}
