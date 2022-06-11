import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class CSVreaderTest {

    CSVreader reader;
    Map<String,Division> map;

    @Before
    public void init() throws NoSuchFieldException, IllegalAccessException {
        reader = new CSVreader();
        map = new HashMap<>();
        map.put("A",new Division(1L,"A"));
        map.put("B",new Division(2L,"B"));
        map.put("C",new Division(3L,"C"));

        Field field = reader.getClass().getDeclaredField("map");
        field.setAccessible(true);
        field.set(reader,map);
    }

    @Test
    void getDivision() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Assert.assertTrue(map.containsKey("A"));

        Method method = reader.getClass().getDeclaredMethod("getDivision");
        method.setAccessible(true);
        method.invoke(reader,"E");

        Field field = reader.getClass().getDeclaredField("map");
        field.setAccessible(true);

        Assert.assertTrue(((Map<String, Division>) field.get(reader)).containsKey("E"));
        Division division = (Division) method.invoke(reader,"E");
        Assert.assertTrue(division!=null);
    }

    @Test
    public void download() throws IOException {
        Assert.assertThrows(FileNotFoundException.class,()->reader.download("/src/resources/foreign_names.csv"));
    }

}