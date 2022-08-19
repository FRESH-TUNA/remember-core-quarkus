package com.remember.response;

import java.util.Collection;

public class CollectionResponse <T> extends BasicResponse{
    private Collection<T> data;

    protected CollectionResponse() {}

    protected CollectionResponse(Collection<T> data) {
        super();
        this.data = data;
    }

    public Collection<T> getData() {
        return data;
    }

    public static <T> CollectionResponse<T> of(Collection<T> data) {
        return new CollectionResponse<T>(data);
    }
}
