package test.task;

import java.io.File;
import java.util.concurrent.RecursiveTask;

public class BuildDirTreeTask extends RecursiveTask<FileOrDirectory> {

    private final File path;
    private RowsNumberCounter counter = new RowsNumberCounter();

    public BuildDirTreeTask(File path) {
        this.path = path;
    }

    @Override
    protected FileOrDirectory compute() {
        FileOrDirectory pd = new FileOrDirectory(path.getName());
        final File[] files = path.listFiles();
        if (files == null)
            return null;
        for (File file : files) {
            if (file.isDirectory()) {
                handleDirectory(file, pd);
            } else if (file.isFile()) {
                handleFile(file, pd);
            }
        }
        return pd;
    }

    private void handleDirectory(File file, FileOrDirectory pd) {
        BuildDirTreeTask t = new BuildDirTreeTask(file);
        FileOrDirectory computedFileOrDirectory = t.compute();

        if (computedFileOrDirectory != null) {
            pd.getChildren().add(computedFileOrDirectory);
            pd.addRows(computedFileOrDirectory.getRowsNumber());
        }
    }

    private void handleFile(File file, FileOrDirectory pd) {
        FileOrDirectory d = new FileOrDirectory(file.getName());
        d.setRowsNumber(Util.countNumberRowsInFile(file.getPath()));
        pd.getChildren().add(d);
        pd.addRows(d.getRowsNumber());
    }


}
