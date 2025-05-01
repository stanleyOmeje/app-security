package com.stan.appsecurity.enums;

public enum TransactionStatus {
    SUCCESS("00", "Success"),
    APPROVED("00", "Approved"),
    CONFIRMED("00", "Transaction Confirmed"),
    COMPLETED("00", "Transaction Completed"),
    TRANSACTION_FAILED("01", "Transaction failed"),
    BAD_REQUEST("02", "Bad Request/Customer info could not be retrieved"),
    AUTHENTICATION_ERROR("04", "Authentication error/You cannot vend for this customer"),
    SYSTEM_ERROR("05", "System error"),
    UNKNOWN_CODE("06", "Unknown code"),
    LIMIT_REACHED("07", "Limit reached"),
    UNKNOWN_PAYMENT_REFERENCE("08", "Unknown payment reference"),
    PENDING("09", "Transaction pending"),
    INSUFFICIENT_AMOUNT("10", "Insufficient amount"),
    INSUFFICIENT_BALANCE("11", "Insufficient balance"),
    INVALID_EXCHANGE_REQUEST("12", "Invalid exchange request/similar transaction"),
    USER_VERIFICATION_REQUIRED("13", "User verification required"),
    AMOUNT_EXCEEDED("14", "Amount exceeded"),
    INVALID_UNIQUE_IDENTIFIER("15", "Invalid phone number");

    private String code;
    private String message;

    TransactionStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
