package file.entity;

public abstract class FileSystemEntity {

    private String title;

    public FileSystemEntity(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract boolean isFile();

    @Override
    public String toString() {
        return "FileSystemEntity{" +
                "title='" + title + '\'' +
                '}';
    }
}
