package test.task;

import java.util.concurrent.RecursiveTask;

public class PrintDirectoriesTask extends RecursiveTask<StringBuilder> {

    private final FileOrDirectory root;
    private final long deep;
    private final StringBuilder margin;

    public PrintDirectoriesTask(FileOrDirectory root, long deep) {
        this.root = root;
        this.deep = deep;
        this.margin = initMargin(deep);
    }

    public PrintDirectoriesTask(FileOrDirectory root) {
        this(root, 0L);
    }

    private StringBuilder initMargin(long deep) {
        StringBuilder sb = new StringBuilder();
        while (deep + 1 != 0) {
            sb.append(" ");
            deep--;
        }
        return sb;
    }

    @Override
    protected StringBuilder compute() {
        StringBuilder sb = new StringBuilder();
        sb.append(root).append("\n");
        for (FileOrDirectory child : root.getChildren()) {
            StringBuilder compute = new PrintDirectoriesTask(child, deep + 1).compute();
            sb.append(margin).append(compute);
        }
        return sb;
    }
}
