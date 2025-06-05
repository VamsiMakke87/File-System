package file.filter.impl;

import file.entity.File;
import file.entity.FileSystemEntity;
import file.filter.Filter;

import java.util.Arrays;
import java.util.List;

public class AndFilter implements Filter {

    private List<Filter> filters;

    public AndFilter(Filter... filters) {
        this.filters = Arrays.asList(filters);
    }

    @Override
    public boolean matches(FileSystemEntity entity) {
        for (Filter filter : filters) {
            if (!filter.matches(entity)) return false;
        }
        return true;
    }
}
