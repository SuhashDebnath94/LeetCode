package DesignPatterns.Structural.Composite.example1;

public class Driver {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("File1.txt");
        FileSystemComponent file2 = new File("File2.txt");

        Directory folder = new Directory("Folder1");
        folder.addComponent(file1);
        folder.addComponent(file2);

        FileSystemComponent file3 = new File("File3.txt");
        Directory rootFolder = new Directory("RootFolder");
        rootFolder.addComponent(folder);
        rootFolder.addComponent(file3);

        System.out.println("Displaying the entire file system:");
        rootFolder.showDetails();
    }
}
