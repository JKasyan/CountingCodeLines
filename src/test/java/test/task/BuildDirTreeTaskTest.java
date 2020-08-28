package test.task;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuildDirTreeTaskTest {

    private BuildDirTreeTask buildDirTreeTask;


    @Before
    public void setUp() {
        final File file = new File(System.getProperty("user.dir") + "/src/test/resources");
        buildDirTreeTask = new BuildDirTreeTask(file);
    }

    @Test
    public void computeTest() {
        final FileOrDirectory root = buildDirTreeTask.compute();

        Assert.assertNotNull(root);
        Assert.assertEquals("resources", root.getName());
        Assert.assertEquals(5, root.getRowsNumber());
        Assert.assertEquals(2, root.getChildren().size());

        List<FileOrDirectory> files = new ArrayList<>(root.getChildren());

        final FileOrDirectory file2 = files.get(0);
        Assert.assertEquals("file2.txt", file2.getName());
        Assert.assertEquals(2, file2.getRowsNumber());

        final FileOrDirectory file1 = files.get(1);
        Assert.assertEquals("file1.txt", file1.getName());
        Assert.assertEquals(3, file1.getRowsNumber());
    }
}
