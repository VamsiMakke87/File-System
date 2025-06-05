package file.entity;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemEntity {

    private List<FileSystemEntity> children;

    public Folder(String title) {
        super(title);
        this.children = new ArrayList<>();
    }

    @Override
    public boolean isFile() {
        return false;
    }

    public void addChild(FileSystemEntity fileSystemEntity) {
        children.add(fileSystemEntity);
    }

    public List<FileSystemEntity> getChildren() {
        return children;
    }

}
