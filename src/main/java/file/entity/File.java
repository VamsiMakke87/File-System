package file.entity;

public class File extends FileSystemEntity{


    public File(String tile) {
        super(tile);
    }

    @Override
    public boolean isFile() {
        return true;
    }
}
