package com.remember.response;

public class BasicResponse {
    private String statusCode;
    private String message;

    /**
     * constructors
     */
    protected BasicResponse() {}

    protected BasicResponse(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    /**
     * getters
     */
    public String getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
