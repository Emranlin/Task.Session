package service.impl;

import classes.Student;
import service.StudentService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class StudentServiceImpl implements StudentService {
    List<Student> createStudents = new ArrayList<>();

    @Override
    public String createStudent(List<Student> students) {
        this.createStudents.addAll(students);
        return "Successful created";
    }

    @Override
    public List<Student> getAll() {
        return createStudents;
    }

    @Override
    public Map<Integer, Student> getAge(List<Student> students) {
        Map<Integer, Student> getAge = new HashMap<>();
        for (Student student : students) {
            int years = Period.between(student.getDateOfBirth(), LocalDate.now()).getYears();
            getAge.put(years, student);
        }
        return getAge;
    }


    @Override
    public String takeMoney(List<Student> students, List<Student> students1, String name, BigDecimal money) {
        List<Student> takeMoney = new ArrayList<>();
        List<Student> giveMoney = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                for (Student student1 : students) {
                    if (student.getMoney().equals(name)) {
                        boolean b = student.getMoney().intValue() > money.intValue();
                        if (b) {
                            takeMoney.add(student);
                            BigDecimal m = student1.getMoney().subtract(money);
                            student.setMoney(student.getMoney().add(m));
                            student1.setMoney(student1.getMoney().subtract(m));
                        }
                    }
                }
                return "Yesterday return money";
            } else {
                return "I haven't enough money";


            }
        }
        return null;
    }
    @Override
    public List<Student> findByName(List<Student> students, String name) {
        List<Student>findingStudent=new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(name)){
                findingStudent.add(student);
            }

        }
        return findingStudent;
    }

    @Override
    public List<Student> findById(List<Student> students, long number) {
        List<Student>findingId=new ArrayList<>();
        for (Student student : students) {
            if (student.getId()==number){
                findingId.add(student);
            }

        }
        return findingId;
    }

    @Override
    public String deleteById(List<Student> students, long number) {
       boolean isRemoved = false;
        Iterator<Student> iterator = createStudents.iterator();
        while (iterator.hasNext()){
            Student next = iterator.next();
            if (next.getId()==number){
                iterator.remove();
            }
        }
        return"Successful";
    }
}
