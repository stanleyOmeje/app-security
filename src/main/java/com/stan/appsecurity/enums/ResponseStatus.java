package com.stan.appsecurity.enums;

public enum ResponseStatus {
    SUCCESS("00", "successful"),
    FAILED("01", "failed"),
    INTERNAL_SERVER_ERROR("5000", "unknown error"),
    NOT_FOUND("4000", "not found"),
    INVALID_PARAMETER("4001", "parameter is invalid"),
    INVALID_URL("4004", "invalid url"),
    ALREADY_EXIST("4005", "already exist"),
    REQUIRED_PARAMETER("4006", "parameter is required"),
    FIELD_MUST_BE_NUMERIC("4007", "field must be numeric"),
    FAILED_REQUIREMENT("4008", "bad request"),
    SUBSCRIPTION_NOT_FOUND("4009", "subscription not found"),
    INCORRECT_AMOUNT("4010", "incorrect product amount");

    private String code;

    private String message;

    ResponseStatus(String code, String message) {
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
