package assessment;

import java.util.ArrayList;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("Arya");
        p1.setAge(28);

        Person p2 = new Person();
        p2.setName("Akhil");
        p2.setAge(25);

        Person p3 = new Person();
        p3.setName("Aditya");
        p3.setAge(18);

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        for (Person p : people) {
            System.out.println("Name:" + p.getName() + ", Age:" + p.getAge());
        }
    }
}


