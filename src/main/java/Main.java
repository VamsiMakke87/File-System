import file.entity.File;
import file.entity.FileSystemEntity;
import file.entity.Folder;
import file.filter.Filter;
import file.filter.impl.TitleFilter;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        Folder root=new Folder("root");


        File file1= new File("Text-File-inside-root",".txt");
        Folder folder1=new Folder("subfolder-inside-root");
        File file2= new File("PDF-File-inside-subfolder",".pdf");
        root.addChild(file1);
        root.addChild(folder1);
        folder1.addChild(file2);

        dfs(root);

        Filter filter=new TitleFilter("f");

        List<FileSystemEntity> matchedEntities= new ArrayList<>();

        dfs(root,filter,matchedEntities);

        System.out.println(matchedEntities);


    }

    private static void dfs(FileSystemEntity root, Filter filter, List<FileSystemEntity> matchedEntities) {

        if(root.isFile()){
            File file=(File) root;
            if(filter.matches(file))
                matchedEntities.add(root);
        }else{
            Folder folder=(Folder) root;
            if(filter.matches(folder))
                matchedEntities.add(root);
            for(FileSystemEntity entity: folder.getChildren())
                dfs(entity,filter,matchedEntities);
        }

    }


    private static void dfs(FileSystemEntity root) {

        if(root.isFile()){
            File file=(File) root;
            System.out.println(file.getTitleWithExtension());
        }else{
            Folder folder= (Folder) root;
            System.out.println(folder.getTitle());
            for(FileSystemEntity fileSystemEntity: folder.getChildren())
                dfs(fileSystemEntity);
        }
    }
}
