package test.task;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

public class PrintDirectoriesTaskTest {

    private PrintDirectoriesTask task;
    @Mock
    private FileOrDirectory root;

    @Before
    public void setUp() {
        root = initRootDir();
        root.getChildren().addAll(initSubfolders());
        task = new PrintDirectoriesTask(root);
    }

    @Test
    public void computeTest() {
        final StringBuilder compute = task.compute();
        String expectedResult = "" +
                "root:30\n" +
                " file1.txt:10\n" +
                " file2.txt:20\n";
        Assert.assertEquals(expectedResult, compute.toString());
    }

    private FileOrDirectory initRootDir() {
        return new FileOrDirectory("root", 30);
    }

    private List<FileOrDirectory> initSubfolders() {
        return Arrays.asList(
                new FileOrDirectory("file1.txt", 10),
                new FileOrDirectory("file2.txt", 20)
        );
    }
}
