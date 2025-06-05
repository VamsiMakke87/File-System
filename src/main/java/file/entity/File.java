package file.entity;

public class File extends FileSystemEntity{

    private String fileExtension;
    public File(String tile,String fileExtension) {
        super(tile);
        this.fileExtension=fileExtension;

    }

    public String getFileExtension() {
        return fileExtension;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    public String getTitleWithExtension() {
        return super.getTitle()+fileExtension;
    }


}
