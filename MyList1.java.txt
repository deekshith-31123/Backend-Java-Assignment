/*
Implement a generic MyList class with a member that holds a generic array of size 100. This class should support the following operations: adding a new value, deleting an element based on its index, deleting an element based on its value, and retrieving a value from a specific index. The class should be capable of creating lists for Integer, String, and custom classes. Use the same structure as the previous class and make it generic.
*/

import java.util.Arrays;

public class MyList1<T> {
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyList1() {
        this.array = (T[]) new Object[100];
        this.size = 0;
    }

    public void add(T value) {
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
        array[size] = null;   
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);   
        }
    }

     
    public void deleteByValue(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                deleteByIndex(i);
                return;
            }
        }
        System.out.println("Value not found in list.");
    }

     
    public T get(int index) {
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
         
        MyList1<Integer> intList = new MyList1<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        System.out.println("Integer List: " + intList.get(1)); 

        
        MyList1<String> strList = new MyList1<>();
        strList.add("Hello");
        strList.add("World");
        System.out.println("String List: " + strList.get(1)); 

         
        MyList1<Person> personList = new MyList1<>();
        personList.add(new Person("John", 25));
        personList.add(new Person("Alice", 30));
        System.out.println("Person List: " + personList.get(1)); 
    }
}
 
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
