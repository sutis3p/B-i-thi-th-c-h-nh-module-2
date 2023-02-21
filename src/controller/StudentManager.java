package controller;

import io.ReadWriteFile;
import model.Student;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentManager implements Serializable {
    Scanner scanner = new Scanner(System.in);
    public static ReadWriteFile readWriteFile = new ReadWriteFile();
    public static File fileStudent = new File("Student.txt");
    public static ArrayList<Student> students = readWriteFile.read(fileStudent);

    public void add(Student student) {
        students.add(student);
        readWriteFile.write(fileStudent, students);
    }

    public Student create() {
        System.out.println("Nhập Code sinh viên : ");
        String Code = scanner.nextLine();
        System.out.println("Nhập tên sinh viên : ");
        String Name = scanner.nextLine();
        System.out.println("Nhập tuổi : ");
        int Age = 0;
        while (true) {
            try {
                Age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Phải nhập số");
            }
        }
        System.out.println("Nhập giới tính : ");
        String Gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ : ");
        String address = scanner.nextLine();
        System.out.println("Nhập điểm trung bình : ");
        double GPA = 0;
        while (true) {
            try {
                GPA = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Phải nhập số");
            }
        }
        Student student = new Student(Code, Name, Age, Gender, address, GPA);
        return student;
    }

    public void show() {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-7s\n", "Code", "Name", "Age", "Gender", "Address", "GPA");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public int findIdByCode(String code) {
        for (int i = 0; i < students.size(); i++) {
            if (code.equals(students.get(i).getCode())) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int index) {
        try {
            students.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Không tìm thấy sinh viên theo mã trên");
        }
    }

    public void edit(int index, Student student) {
        students.set(index, student);
        students.get(index).setCode(student.getCode());
        students.get(index).setName(student.getName());
        students.get(index).setAge(student.getAge());
        students.get(index).setGender(student.getGender());
        students.get(index).setAddress(student.getAddress());
        students.get(index).setGPA(student.getGPA());
        readWriteFile.write(fileStudent, students);
    }

    public static void sortGPA() {
        List<Student> sortedListStudent = students.stream().sorted(Comparator.comparing(o -> o.getGPA())).collect(Collectors.toList());
        for (int i = 0; i < sortedListStudent.size(); i++) {
            System.out.println(sortedListStudent.get(i));
        }
    }
}
