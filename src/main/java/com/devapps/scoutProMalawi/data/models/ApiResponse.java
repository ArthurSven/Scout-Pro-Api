package com.devapps.scoutProMalawi.data.models;

public class ApiResponse {
    private boolean success;
    private String message;



    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
