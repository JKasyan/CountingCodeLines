package test.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileOrDirectory {

    private final File path;
    private List<FileOrDirectory> children = new ArrayList<>();
    private long rowsNumber;

    public FileOrDirectory(File path) {
        this.path = path;
    }

    public List<FileOrDirectory> getChildren() {
        return children;
    }

    public void setChildren(List<FileOrDirectory> children) {
        this.children = children;
    }

    public long getRowsNumber() {
        return rowsNumber;
    }

    public void setRowsNumber(long rowsNumber) {
        this.rowsNumber = rowsNumber;
    }

    public void addRows(long c) {
        this.rowsNumber += c;
    }

    @Override
    public String toString() {
        return path.getName() + ":" + rowsNumber;
    }
}
