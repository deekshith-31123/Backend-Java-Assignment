/*Create a class named Employee with the following fields: id (String), name (String), age (int), and dateOfJoining (Date). Use this Employee object with the previously implemented MyList class. */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Employee {
    private String id;
    private String name;
    private int age;
    private Date dateOfJoining;

    public Employee(String id, String name, int age, Date dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}

class MyList<T> {
    private List<T> list = new ArrayList<>();

    public void add(T element) {
        list.add(element);
    }

    public T get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }
}

public class Main {
    public static void main(String[] args) {
        MyList<Employee> employeeList = new MyList<>();

        Employee emp1 = new Employee("E001", "Alice", 30, new Date());
        Employee emp2 = new Employee("E002", "Bob", 28, new Date());

        employeeList.add(emp1);
        employeeList.add(emp2);

        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i));
        }
    }
}
