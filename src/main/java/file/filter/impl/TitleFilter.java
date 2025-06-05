package file.filter.impl;

import file.entity.FileSystemEntity;
import file.filter.Filter;

public class TitleFilter implements Filter {

    private String title;

    public TitleFilter(String title) {
        this.title = title;
    }

    @Override
    public boolean matches(FileSystemEntity entity) {
        return entity.getTitle().toLowerCase().contains(title.toLowerCase());
    }
}
