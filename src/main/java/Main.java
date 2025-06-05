import file.entity.File;
import file.entity.FileSystemEntity;
import file.entity.Folder;

public class Main {

    public static void main(String[] args) {

        Folder root=new Folder("root");


        File file1= new File("File inside root");
        Folder folder1=new Folder("subfolder inside root");
        File file2= new File("File inside subfolder");
        root.addChild(file1);
        root.addChild(folder1);
        folder1.addChild(file2);

        dfs(root);


    }

    private static void dfs(FileSystemEntity root) {

        if(root.isFile()){
            System.out.println(root.getTitle());
        }else{
            Folder folder= (Folder) root;
            System.out.println(folder.getTitle());
            for(FileSystemEntity fileSystemEntity: folder.getChildren())
                dfs(fileSystemEntity);
        }
    }
}
