import file.entity.File;
import file.entity.FileSystemEntity;
import file.entity.Folder;
import file.filter.Filter;
import file.filter.impl.AndFilter;
import file.filter.impl.OrFilter;
import file.filter.impl.SearchByFileExtensionFilter;
import file.filter.impl.SearchByTitleFilter;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        Folder root=new Folder("root");


        File file1= new File("Text-File-inside-root","txt");
        Folder folder1=new Folder("subfolder-inside-root");
        File file2= new File("PDF-File-inside-subfolder","pdf");
        File file3= new File("PDF-File2-inside-subfolder","pdf");
        File file4= new File("file","txt");
        File file5= new File("file","pdf");
        root.addChild(file1);
        root.addChild(folder1);
        folder1.addChild(file2);
        folder1.addChild(file3);
        folder1.addChild(file4);folder1.addChild(file5);


        dfs(root);

        String title="file";

        Filter titleFilter=new SearchByTitleFilter(title);

        List<FileSystemEntity> matchedEntitiesByTitle= new ArrayList<>();

        dfs(root,titleFilter,matchedEntitiesByTitle);

        System.out.println("File entities matched by title '"+title+"'" +matchedEntitiesByTitle);

        String fileExtension="pdf";

        Filter fileExtensionFilter= new SearchByFileExtensionFilter(fileExtension);

        List<FileSystemEntity> matchedEntitiesByFileExtension= new ArrayList<>();

        dfs(root,fileExtensionFilter,matchedEntitiesByFileExtension);

        System.out.println("File entities matched by file extension '."+fileExtension+"'" +matchedEntitiesByFileExtension);

        Filter andFilter= new AndFilter(titleFilter,fileExtensionFilter);
        List<FileSystemEntity> matchedEntitiesByTitleAndFileExtension= new ArrayList<>();
        dfs(root,andFilter,matchedEntitiesByTitleAndFileExtension);

        System.out.println("File entities matched by title '"+title+"' file extension '."+fileExtension+"'" +matchedEntitiesByTitleAndFileExtension);

        Filter orFilter= new OrFilter(titleFilter,fileExtensionFilter);
        List<FileSystemEntity> matchedEntitiesByTitleOrFileExtension= new ArrayList<>();
        dfs(root,orFilter,matchedEntitiesByTitleOrFileExtension);

        System.out.println("File entities matched by title '"+title+"' file extension '."+fileExtension+"'" +matchedEntitiesByTitleOrFileExtension);

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
