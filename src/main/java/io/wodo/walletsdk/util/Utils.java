package io.wodo.walletsdk.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.springframework.beans.support.PagedListHolder.DEFAULT_PAGE_SIZE;

public class Utils {

    public static Pageable createPageableBySizeAndPage(Integer page, Integer size) {

        if (size == null || size > 10 || size < 0) {
            size = DEFAULT_PAGE_SIZE;
        }
        if (page == null || page < 0) {
            page = 0;
        }

        return PageRequest.of(page, size);
    }
}