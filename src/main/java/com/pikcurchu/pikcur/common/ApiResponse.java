package com.pikcurchu.pikcur.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String code;
    private String message;
    private T data;
    private Integer httpStatus;

    public ApiResponse(boolean success, String code, String message, T data, Integer httpStatus) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.httpStatus = httpStatus;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "SUCCESS", "성공", data, 200);
    }

    public static <T> ApiResponse<T> fail(String code, String message, Integer httpStatus) {
        return new ApiResponse<>(false, code, message, null, httpStatus);
    }
}
