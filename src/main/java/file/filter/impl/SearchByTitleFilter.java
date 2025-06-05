package file.filter.impl;

import file.entity.FileSystemEntity;
import file.filter.Filter;

public class SearchByFileTitleFilter implements Filter {

    private String title;

    public SearchByTitleFilter(String title) {
        this.title = title;
    }

    @Override
    public boolean matches(FileSystemEntity entity) {
        return entity.getTitle().toLowerCase().contains(title.toLowerCase());
    }
}
