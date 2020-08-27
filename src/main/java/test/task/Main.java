package test.task;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        final String path = args[0];
        final File file = new File(path);
        if(file.isFile()) {
            long count = Util.countNumberRowsInFile(file.getPath());
            System.out.println(file.getName() + ":" + count);
        } else {
            final ForkJoinPool forkJoinPool = new ForkJoinPool();
            final FileOrDirectory tree = forkJoinPool.invoke(new BuildDirTreeTask(file));
            final StringBuilder sb = forkJoinPool.invoke(new PrintDirectoriesTask(tree));
            System.out.println(sb);
        }
    }
}
