package file.filter.impl;

import file.entity.FileSystemEntity;
import file.filter.Filter;

import java.util.Arrays;
import java.util.List;

public class OrFilter implements Filter {

    private List<Filter> filters;

    public OrFilter(Filter... filters) {
        this.filters = Arrays.asList(filters);
    }

    @Override
    public boolean matches(FileSystemEntity entity) {
        for (Filter filter : filters) {
            if (filter.matches(entity)) return true;
        }
        return false;
    }
}
