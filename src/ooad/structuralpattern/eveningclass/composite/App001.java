package ooad.structuralpattern.eveningclass.composite;
import java.util.ArrayList;
import java.util.List;
// component
interface FileSystem{
    void printInfo();
    Double getSize();
}
// leaf
class FFile implements FileSystem{
    private Double size;
    private String fileName;
    public FFile(Double size, String fileName){
        this.fileName =fileName;
        this.size = size;
    }
    @Override
    public void printInfo() {
        System.out.println("Size: " + size);
        System.out.println("File name: " + fileName);
    }

    @Override
    public Double getSize() {
        return size;
    }
}
// composite
class FFolder implements FileSystem{
    // composite
    private List<FileSystem> fileSystems = new ArrayList<>();
    //
    private Double size;
    private String fileName;
    public FFolder(Double size, String fileName){
        this.fileName =fileName;
        this.size = size;
    }
    @Override
    public void printInfo() {
        System.out.println("Size: " + getSize());
        System.out.println("File name: " + fileName);
    }

    @Override
    public Double getSize() {
        // calculate
        Double totalSize = 0.0;
        for(FileSystem fileSystem: fileSystems){
            totalSize+=fileSystem.getSize();
        }
        this.size = totalSize;
        return totalSize;
    }
    public void addFileSystem(FileSystem fileSystem){
        fileSystems.add(fileSystem);
    }
}

public class App001 {
    public static void main(String[] args) {
        FileSystem file1 = new FFile(1.00,"user.txt");
        FileSystem file2 = new FFile(2.00,"data.txt");
        FFolder folder0 = new FFolder(0.0,"logs");
        folder0.addFileSystem(file2);
        folder0.addFileSystem(file1);
        folder0.printInfo();
    }
}
