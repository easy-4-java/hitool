package hitool.core.beanutils;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class BeanPropertyIndexedConversionTest {
    @Test
    public void convertsFormValuesForExistingAndExpandedNumericArrays() {
        Root root = new Root();
        root.setChild(new Child());
        root.getChild().setNumbers(new int[] {1, 4});

        BeanPropertyUtils.setProperty(root, "child.numbers[0]", "2", true);
        assertArrayEquals(new int[] {2, 4}, root.getChild().getNumbers());

        BeanPropertyUtils.setProperty(root, "child.numbers[3]", new String[] {"7"}, true);
        assertArrayEquals(new int[] {2, 4, 0, 7}, root.getChild().getNumbers());
    }

    @Test
    public void initializesNullArraysAndPreservesStringNulls() {
        Root root = new Root();
        root.setChild(new Child());
        BeanPropertyUtils.setProperty(root, "child.numbers[0]", "3", true);
        assertArrayEquals(new int[] {3}, root.getChild().getNumbers());

        BeanPropertyUtils.setProperty(root, "child.labels[1]", new String[] {"label"}, true);
        assertEquals("label", root.getChild().getLabels()[1]);
        assertNull(root.getChild().getLabels()[0]);
        BeanPropertyUtils.setProperty(root, "child.labels[0]", null, true);
        assertNull(root.getChild().getLabels()[0]);
    }

    @Test
    public void invalidIndexDoesNotChangeExistingElements() {
        Root root = new Root();
        root.setChild(new Child());
        root.getChild().setNumbers(new int[] {5});
        try {
            BeanPropertyUtils.setProperty(root, "child.numbers[invalid]", "2", true);
            fail("Expected invalid indexed property to fail");
        } catch (RuntimeException expected) {
            assertArrayEquals(new int[] {5}, root.getChild().getNumbers());
        }
    }

    public static class Root {
        private Child child;
        public Child getChild() { return child; }
        public void setChild(Child child) { this.child = child; }
    }

    public static class Child {
        private int[] numbers;
        private String[] labels;
        public int[] getNumbers() { return numbers; }
        public void setNumbers(int[] numbers) { this.numbers = numbers; }
        public String[] getLabels() { return labels; }
        public void setLabels(String[] labels) { this.labels = labels; }
    }
}
