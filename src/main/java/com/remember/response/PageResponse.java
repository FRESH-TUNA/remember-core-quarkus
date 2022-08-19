package com.remember.response;

import com.remember.paging.PageInfo;

import java.util.Collection;

public class PageResponse<T> extends CollectionResponse<T> {
    private PageInfo page;

    private PageResponse() {}

    private PageResponse(Collection<T> data, PageInfo pageInfo) {
        super(data);
        this.page = pageInfo;
    }

    public static <T> PageResponse<T> of(Collection<T> datas, PageInfo pageInfo) {
        return new PageResponse<>(datas, pageInfo);
    }

    public PageInfo getPage() {
        return page;
    }
}
