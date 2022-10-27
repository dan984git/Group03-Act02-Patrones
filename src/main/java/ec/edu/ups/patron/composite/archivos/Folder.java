package ec.edu.ups.patron.composite.archivos;

import java.util.ArrayList;

public class Folder extends FileObject {

    ArrayList<FileObject> list;

    public Folder(String name) {
        super(name);
        list = new ArrayList<>();
    }

    public void add(FileObject fileObject) {
        list.add(fileObject);
    }

    public void delete(FileObject fileObject) {
        list.remove(fileObject);
    }

    @Override
    public int getSize() {
        var size = 0;
        for (var obj : list) {
            size += obj.getSize();
        }
        return size;
    }

    public void listFiles() {
        for (var obj : list) {
            if (obj instanceof Folder) {
                System.out.printf("%s <folder>\n", obj.getName());
                continue;
            }

            System.out.printf("%s : %sKB\n", obj.getName(), obj.getSize());
        }
    }

    public ArrayList<FileObject> getList() {
        return list;
    }

    public void setList(ArrayList<FileObject> list) {
        this.list = list;
    }

}
