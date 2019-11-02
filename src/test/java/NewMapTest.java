import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NewMapTest {
    private int mapCapacity = 16;
    private NewMap newMap = new NewMap(mapCapacity);
    private Random rand = new Random();

    @Test
    void put() {
        // Positive test
        assertNull(newMap.put(1, "first"));
        assertNull(newMap.put(null, "null"));
        assertEquals("first", newMap.get(1));
        assertEquals("null", newMap.get(null));
        assertEquals("first", newMap.put(1, "second"));
        assertEquals("null",  newMap.put(null, "secondNull"));

        // Negative test
        try {
            for (int i = 0; i < 5000; i++) {
                newMap.put(rand.nextInt(500), rand.nextInt(100));
            }
            Assert.fail("Expected IOException");
        } catch (ArrayIndexOutOfBoundsException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    void get() {
        newMap.put(1, "first");
        newMap.put(null, "null");

        // Positive test
        assertEquals("first", newMap.get(1));
        assertEquals("null", newMap.get(null));
        assertNull(newMap.get(123));
    }

    @Test
    void remove() {
        // Positive test
        newMap.put(1, "first");
        assertEquals("first",newMap.remove(1));
        assertNull(newMap.get(1));
    }

    @Test
    void containsKey() {
        // Positive test
        newMap.put(1, "first");
        assertTrue(newMap.containsKey(1));
        assertFalse(newMap.containsKey(5));
    }

    @Test
    void size() {
        // Positive test
        assertEquals(0,newMap.size());
        newMap.put(1, "first");
        assertEquals(1,newMap.size());
        newMap.remove(1);
        assertEquals(0,newMap.size());
    }
}