
// COMPARATOR

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    String name;
    Integer id;
    Integer total_marks;

    Student(String a, int b, int c) {
        name = a;
        id = b;
        total_marks = c;
    }
}

public class test1 {
    public static void main(String[] args) {
        Student stud1 = new Student("suraj", 1, 90);
        Student stud2 = new Student("rahul", 4, 60);
        Student stud3 = new Student("harshit", 2, 78);
        Student stud4 = new Student("neha", 6, 65);
        Student stud5 = new Student("ridhi", 5, 95);
        Student stud6 = new Student("vatsal", 3, 81);
        ArrayList<Student> list = new ArrayList<>();
        list.add(stud1);
        list.add(stud2);
        list.add(stud3);
        list.add(stud4);
        list.add(stud5);
        list.add(stud6);

        // sorting according to id
        Collections.sort(list, new Mycmp1());
        display(list);
        // sorting according to marks
        Collections.sort(list, new Mycmp2());
        display(list);
        // sorting according to name
        Collections.sort(list, new Mycmp3());
        display(list);

    }

    public static void display(ArrayList<Student> list) {
        for (Student stud : list)
            System.out.println(stud.name + " " + stud.id + " " + stud.total_marks);
    }

}

class Mycmp1 implements Comparator<Student> {
    public int compare(Student stud1, Student stud2) {
        return stud1.id - stud2.id;
    }
}

class Mycmp2 implements Comparator<Student> {
    public int compare(Student stud1, Student stud2) {
        return stud1.total_marks - stud2.total_marks;
    }
}

class Mycmp3 implements Comparator<Student> {
    public int compare(Student stud1, Student stud2) {
        return stud1.name.compareTo(stud2.name);
    }
}
