package file.filter.impl;

import file.entity.File;
import file.entity.FileSystemEntity;
import file.filter.Filter;

public class FileExtensionFilter implements Filter {

    private String fileExtension;

    public FileExtensionFilter(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public boolean matches(FileSystemEntity entity) {

        return  false;
    }
}
