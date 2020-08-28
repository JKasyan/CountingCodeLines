package test.task;

import java.util.SortedSet;
import java.util.TreeSet;

public class FileOrDirectory implements Comparable<FileOrDirectory> {

    private final String name;
    private SortedSet<FileOrDirectory> children = new TreeSet<>();
    private long rowsNumber;

    public FileOrDirectory(String name) {
        this(name, 0);
    }

    public FileOrDirectory(String name, long rowsNumber) {
        this.name = name;
        this.rowsNumber = rowsNumber;
    }

    public String getName() {
        return name;
    }

    public SortedSet<FileOrDirectory> getChildren() {
        return children;
    }

    public void setChildren(SortedSet<FileOrDirectory> children) {
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
        return this.name + ":" + rowsNumber;
    }

    @Override
    public int compareTo(FileOrDirectory that) {
        return that.name.compareTo(this.name);
    }
}
