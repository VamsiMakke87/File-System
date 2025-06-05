package file.filter;

import file.entity.FileSystemEntity;

public interface Filter {

    boolean matches(FileSystemEntity entity);
}
