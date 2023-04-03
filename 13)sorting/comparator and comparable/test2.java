
//COMPARABLE

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable<Student> {
    String name;
    Integer id;
    Integer total_marks;

    Student(String a, int b, int c) {
        name = a;
        id = b;
        total_marks = c;
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
}

public class test2 {
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

        // Natural sorting of object of Student class
        Collections.sort(list);
        display(list);
        // sorting according to marks
        Collections.sort(list, new Mycmp2());
        display(list);
        // reverse the natural sorting
        Collections.sort(list, Collections.reverseOrder());
        display(list);
    }

    public static void display(ArrayList<Student> list) {
        for (Student stud : list)
            System.out.println(stud.name + " " + stud.id + " " + stud.total_marks);
    }
}

class Mycmp2 implements Comparator<Student> {
    public int compare(Student stud1, Student stud2) {
        return stud1.total_marks - stud2.total_marks;
    }
}