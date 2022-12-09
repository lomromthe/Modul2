package SinhVien;

import java.io.Serializable;

public class Student implements Serializable {
    private int Masinhvien;
    private String FullName;
    private int Age;
    private String gender;
    private String Address;
    private double Avgmark;

    public Student(int masinhvien, String fullName, int age, String gender, String address, double avgmark) {
        FullName = fullName;
        Masinhvien = masinhvien;
        Age = age;
        this.gender = gender;
        Address = address;
        Avgmark = avgmark;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getMasinhvien() {
        return Masinhvien;
    }

    public void setMasinhvien(int masinhvien) {
        Masinhvien = masinhvien;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getAvgmark() {
        return Avgmark;
    }

    public void setAvgmark(double avgmark) {
        Avgmark = avgmark;
    }

    @Override
    public String toString() {
        return "Student{" +
                " Masinhvien=" + Masinhvien +
                "FullName='" + FullName + '\'' +
                ", Age=" + Age +
                ", gender='" + gender + '\'' +
                ", Address='" + Address + '\'' +
                ", Avgmark=" + Avgmark +
                '}';
    }
}
