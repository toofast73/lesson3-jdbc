package lesson1;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class UserCsvReaderTest extends TestCase {


    public void testRead() throws IOException {
        UserCsvReader reader = new UserCsvReader();
        File input = new File("C:\\Temp\\JavaTest-Maven\\src\\test\\resources\\user.csv");
        Assert.assertTrue(input.exists());

        List<User> users = reader.readCsv(input);
        Assert.assertEquals(1, users.size());
    }

}