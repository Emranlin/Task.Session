package service;

import classes.Student;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface StudentService {
    String createStudent(List<Student> students);
    List<Student>getAll();
    Map<Integer,Student> getAge(List<Student>students);
    String takeMoney(List<Student>students,List<Student>students1, String name, BigDecimal money);
    List<Student>findByName(List<Student>students,String name);
    List<Student>findById(List<Student>students,long number);
    String deleteById(List<Student>students,long number);
}
