package file.filter.impl;

import file.entity.File;
import file.entity.FileSystemEntity;
import file.filter.Filter;

public class SearchByFileExtensionFilter implements Filter {

    private String fileExtension;

    public SearchByFileExtensionFilter(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public boolean matches(FileSystemEntity entity) {
        if(entity.isFile()){
            File file= (File)entity;
            return file.getFileExtension().equals(fileExtension);
        }
        return false;
    }
}
