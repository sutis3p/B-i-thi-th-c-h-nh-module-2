package model;

import java.io.Serializable;

public class Student implements Serializable {
    private String Code;
    private String Name;
    private int Age;
    private String Gender;
    private String Address;
    private double GPA;

    public Student() {
    }

    public Student(String code, String name, int age, String gender, String address, double GPA) {
        Code = code;
        Name = name;
        Age = age;
        Gender = gender;
        Address = address;
        this.GPA = GPA;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s%-10s%-10s%-10s%-7s\n", Code, Name, Age, Gender, Address, GPA);
    }
}
