import classes.Student;
import enums.Gender;
import service.impl.StudentServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student1=new Student(1564,"Zhiidegul", LocalDate.of(1993,1,15), Gender.FEMALE, BigDecimal.valueOf(20000));
        Student student2=new Student(1515,"Lira", LocalDate.of(1984,7,15), Gender.FEMALE, BigDecimal.valueOf(15000));
        Student student3=new Student(1516,"Syimyk", LocalDate.of(1998,1,15), Gender.MALE, BigDecimal.valueOf(40000));
        Student student4=new Student(1520,"Meerim", LocalDate.of(1983,1,15), Gender.FEMALE, BigDecimal.valueOf(50000));
        List<Student>students=new ArrayList<>(List.of(student1,student2,student3,student4));
        List<Student>students1=new ArrayList<>(List.of(student1,student2,student3,student4));
        Scanner scanner1=new Scanner(System.in);
        Scanner scanner2=new Scanner(System.in);
        Scanner scanner3=new Scanner(System.in);
        Scanner scanner4=new Scanner(System.in);
        StudentServiceImpl studentService=new StudentServiceImpl();
        while (true){
            System.out.println("""
                    1.Create student
                    2.Get all
                    3.Get age
                    4.Take money
                    5.Find by name
                    6.Find by id
                    7.Delete by id
                    """);
            switch (scanner1.nextByte()) {
                case 1 -> System.out.println(studentService.createStudent(students));
                case 2 -> System.out.println(studentService.getAll());
                case 3 -> System.out.println(studentService.getAge(students));
                case 4 -> {
                    System.out.println("Please write name");
                    System.out.println("How much money would you take");
                    System.out.println(studentService.takeMoney(students, students, scanner2.nextLine(), scanner3.nextBigDecimal()));
                }
                case 5 -> {
                    System.out.println("Please write name");
                    System.out.println(studentService.findByName(students, scanner2.nextLine()));
                }
                case 6 -> {
                    System.out.println("Please write te id");
                    System.out.println(studentService.findById(students, scanner4.nextLong()));
                }
                case 7 -> {
                    System.out.println("Please write te id");
                    System.out.println(studentService.deleteById(students, scanner4.nextLong()));
                }
            }
        }
    }
}