package com.remember.paging;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PageInfoImpl implements PageInfo{
    private int pageNumber;
    private int pageSize;
    private int totalSize;

    public static PageInfo of(Pageable pageable, int count) {
        return new PageInfoImpl(pageable.getPageNumber(), pageable.getPageSize(), count);
    }
}
