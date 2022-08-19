package com.remember.paging;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PageRequest implements Pageable {
    private int page;
    private int size;

    @Override
    public int getPageNumber() {
        return page;
    }

    @Override
    public int getPageSize() {
        return size;
    }

    public static PageRequest of(int page, int size) {
        return new PageRequest(page, size);
    }
}
