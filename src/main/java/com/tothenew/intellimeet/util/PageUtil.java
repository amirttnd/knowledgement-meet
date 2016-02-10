package com.tothenew.intellimeet.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageUtil {

    public static Sort orderByIdDesc() {
        return new Sort(Sort.Direction.DESC, "id");
    }

    public static Sort orderByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }

    public static Pageable page(int page, int size) {
        return new PageRequest(page, size, orderByIdDesc());
    }
}
