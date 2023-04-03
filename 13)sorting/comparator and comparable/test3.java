import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//ARRAYS.SORT() FOR SORTING ARRAYS

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

public class test3 {
    public static void main(String[] args) {
        Integer[] arr = { 5, 2, 3, 4, 1, 6, 7, 10, 9, 8 };

        // natural sorting of arr
        Arrays.sort(arr, 1, 5, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
        // reverse of natural order
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));

        // sorting array of objects
        Student stud1 = new Student("suraj", 1, 90);
        Student stud2 = new Student("rahul", 4, 60);
        Student stud3 = new Student("harshit", 2, 78);
        Student stud4 = new Student("neha", 6, 65);
        Student stud5 = new Student("ridhi", 5, 95);
        Student stud6 = new Student("vatsal", 3, 81);

        // sorting using customer comparator
        Student[] arr2 = new Student[] { stud1, stud2, stud3, stud4, stud5, stud6 };
        Arrays.sort(arr2, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.id - o2.id;
            }
        });

        display(arr2);

        // sort using comparator lamba expression
        Arrays.sort(arr2, (a, b) -> a.name.compareTo(b.name));
        display(arr2);

        // this will throw error beacause there is no natural order for objects of
        // Student class
        // Arrays.sort(arr2, Collections.reverseOrder());
        // display(arr2);

    }

    public static void display(Student[] list) {
        for (Student stud : list)
            System.out.println(stud.name + " " + stud.id + " " + stud.total_marks);
    }
}
