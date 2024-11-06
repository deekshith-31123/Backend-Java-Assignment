/*
Implement a generic MyList class with a member that holds a generic array of size 100. This class should support the following operations: adding a new value, deleting an element based on its index, deleting an element based on its value, and retrieving a value from a specific index. The class should be capable of creating lists for Integer, String, and custom classes. Use the same structure as the previous class and make it generic.
*/


import java.util.Arrays;

public class MyList {
    private int[] array;
    private int size;

    public MyList() {
        this.array = new int[100];  
        this.size = 0;
    }

    public void add(int value) {
        if (size == array.length) {
            resize(array.length * 2);  
        }
        array[size] = value;
        size++;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);  
        }
    }

    public void deleteByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                deleteByIndex(i);
                return;
            }
        }
        System.out.println("Value not found in list.");
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    private void resize(int newCapacity) {
        array = Arrays.copyOf(array, newCapacity);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        
        list.add(10);
        list.add(20);
        list.add(30);
        
        System.out.println("Element at index 1: " + list.get(1));
        
        list.deleteByIndex(1);
        System.out.println("After deleting index 1, element at index 1: " + list.get(1));
        
        list.deleteByValue(30);
        System.out.println("Size after deletion: " + list.size());
    }
}
