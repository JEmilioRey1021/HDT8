import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    @org.junit.jupiter.api.Test
    void add() {
        VectorHeap<String> abc = new VectorHeap<>();
        abc.add("0");
        abc.add("5");
        abc.add("10");
        abc.add("20");
        abc.add("25");
        abc.add("-10");
        abc.add("-9");
        abc.add("5");

        abc.print();

    }

    @org.junit.jupiter.api.Test
    void remove() {
        VectorHeap<String> abc = new VectorHeap<>();
        abc.add("0");
        abc.add("5");
        abc.add("10");
        abc.add("20");
        abc.add("25");
        abc.add("-10");
        abc.add("-9");
        abc.add("5");
        
        abc.remove();
        abc.remove();

        abc.print();

    }
}