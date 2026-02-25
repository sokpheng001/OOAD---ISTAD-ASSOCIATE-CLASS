package ooad.structuralpattern.afternoonclass.composite;

//
import java.util.ArrayList;
import java.util.List;

//component
interface FileSystem{
    void info();
    double getSize();
}
// leaf
class FFile implements FileSystem{
    private String fileName;
    public FFile(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void info() {
        System.out.println("This is info");
        System.out.println("Filename: " + fileName);
    }

    @Override
    public double getSize() {
        return fileName.length();
    }
}
// composite
class FFolder implements FileSystem{
    private List<FileSystem> fileSystems;
    private String folderName;
    public FFolder(String folderName){
        this.fileSystems = new ArrayList<>();
        this.folderName = folderName;
    }
    public void add(FileSystem fileSystem){
        this.fileSystems.add(fileSystem);
    }

    @Override
    public void info() {
        System.out.println("Folder info: ");
        System.out.println("Foldername: " + folderName);
    }

    @Override
    public double getSize() {
        double size = 0.0;
        for(FileSystem fileSystem: fileSystems){
            size+=fileSystem.getSize();
        }
        return size+folderName.length();
    }
}

public class App6 {
    public static void main(String[] args) {
        FFile file1 = new FFile("user.db");
        System.out.println("File1 size: " + file1.getSize());
        FFile file2 = new FFile("backup.db");
        System.out.println("File2 size: " + file2.getSize());
        FFolder folder1 = new FFolder("data1");
        FFolder folder2 = new FFolder("data2");
        //
        folder2.add(file1);
        folder2.add(file2);
        folder1.add(folder2);
        //
        System.out.println("Folder1 size: " + folder1.getSize());
        System.out.println("Folder2 size: " + folder2.getSize());
    }
}
