package com.remember.response;

public class EntityResponse<T> extends BasicResponse{
    private T data;

    protected EntityResponse() {}

    protected EntityResponse(T data) {
        super();
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public static <T> EntityResponse<T> of(T data) {
        return new EntityResponse<T>(data);
    }
}
