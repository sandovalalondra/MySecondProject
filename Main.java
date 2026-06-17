import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(105, "Maria", "Denver"));
        students.add(new Student(101, "John", "Seattle"));
        students.add(new Student(109, "Alex", "Phoenix"));
        students.add(new Student(103, "Sarah", "Dallas"));
        students.add(new Student(107, "David", "Chicago"));
        students.add(new Student(102, "Emma", "Boston"));
        students.add(new Student(110, "Chris", "Miami"));
        students.add(new Student(104, "Olivia", "Atlanta"));
        students.add(new Student(108, "James", "Houston"));
        students.add(new Student(106, "Sophia", "Portland"));

        System.out.println("Original List:");
        printStudents(students);

        SelectionSort.sort(students, new NameComparator());

        System.out.println("\nSorted By Name:");
        printStudents(students);

        SelectionSort.sort(students, new RollNoComparator());

        System.out.println("\nSorted By Roll Number:");
        printStudents(students);
    }

    public static void printStudents(ArrayList<Student> students) {

        for (Student student : students) {
            System.out.println(student);
        }
    }
}