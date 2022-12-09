package Sever;

import SinhVien.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerStudent {
    static ArrayList<Student> student = new ArrayList<Student>();
     static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Student> getStudent() {
        return student;
    }

    public static void setStudent(ArrayList<Student> student) {
        ManagerStudent.student = student;
    }

    public void show() {
        new ManagerStudent().sort();
        if (student.size() == 0) {
            System.out.println("Danh sách rỗng! Mời nhập thêm sinh viên");
            student.add(new ManagerStudent().taosv());
        } else {
            for (Student s : student) {
                System.out.println(s.toString());
            }
        }
    }

    public void add() {
        System.out.println("");
        student.add(taosv());
    }

    public void edit() {
        if (student.size() == 0) {
            System.out.println("\nDanh sách chưa có sinh viên nào");
            System.out.print("Nhấn ENTER để tiếp tục");
            scanner.nextLine();
        }
        int index;
        index = findIndexbyMSV();
        if (index == -1) {
            System.out.println("Không tìm được sinh viên trong danh sách");
        } else {
            do {
                System.out.println("Bạn muốn thay đổi thông tin nào của sinh viên");
                System.out.println("1. Mã sinh viên");
                System.out.println("2. Họ tên");
                System.out.println("3. Tuổi");
                System.out.println("4. Giới tính");
                System.out.println("Địa chỉ");
                System.out.println("Điểm trung bình");


            } while (true);
        }
    }

    public void delete() {
        int msv = 0;
        if (student.size() == 0) {
            System.out.println("\nDanh sách chưa có sinh viên nào");
            System.out.print("Nhấn ENTER để tiếp tục");
            scanner.nextLine();
        }

        Student newsstudent = null;
        do {
            do {
                try {
                    System.out.println("Nhap mã sinh viên cần xóa");
                    msv = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Xin mời nhập bằng số");
                }
            } while (true);
            if (msv < 1)
                System.out.println("ID lớn hơn 1");
        } while (msv < 1);
        for (int i = 0; i < student.size(); i++) {
            if (student.get(i).getMasinhvien() == msv) {
                newsstudent = student.get(i);
                break;
            }
        }
        if (newsstudent != null) {
            System.out.println("Bạn có chắn muốn xóa không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int dele= Integer.parseInt(scanner.nextLine());
            switch (dele){
                case 1:
                    student.remove(newsstudent);


                    System.out.println("Xóa thành công");
                    break;
                case 2:
                    return;
            }
        } else {
            System.out.println("Không có mã sinh viên trong danh sách");
        }
    }


//    public void sort() {
//        Collections.sort(student, (o1, o2) -> (o1.getFullName().compareTo(o2.getFullName())));
//    }

    public Student taosv() {
        int masinhvien;
        do {
            try {
                System.out.println("Nhập mã sinh viên");
                masinhvien = Integer.parseInt(scanner.nextLine());
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Phải nhập số");

            }
        }while (true) ;

            System.out.println("Nhập họ tên sinh viên");
            String fullname = scanner.nextLine();

            int age;
            do {
                try {
                    System.out.println("Nhập tuổi sinh viên");
                    age = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số");
                }
            }while (true) ;
                System.out.println("Nhập giới tính");
                String gender = scanner.nextLine();
                System.out.println("Nhập địa chỉ");
                String address = scanner.nextLine();

                double avgmark;
                do {
                    try {
                        do {
                            System.out.println("Nhập điểm trung bình");
                            avgmark = Double.parseDouble(scanner.nextLine());
                            if (avgmark < 0 || avgmark > 10) {
                                System.out.println("Mời nhập lại trong khoảng 0-10");
                            }
                        } while (avgmark < 0 || avgmark > 10);
                        break;
                    } catch (Exception e) {
                        System.out.println("Mời nhập lại cho đúng");
                    }
                } while (true);
                Student sv = new Student(masinhvien, fullname, age, gender, address, avgmark);
                return sv;
            }


            public int findIndexbyMSV () {
                int msv;
                do {
                    try {
                        System.out.println("Nhập mã sinh viên cần tìm");
                        msv = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (InputMismatchException | NumberFormatException e) {
                        System.out.println("Phải nhập số");
                    }
                } while (true);
                for (int i = 0; i < student.size(); i++) {
                    if (student.get(i).getMasinhvien() == msv) {
                        return msv;
                    }
                }
                return -1;
            }
    public void sort() {
        int choose = 3;
        while (true) {
            System.out.println("----Sắp xếp sinh viên theo điểm trung bình---");
            System.out.println("Chọn chức năng theo số để tiếp tục");
            System.out.println("1. Sắp xếp điểm trung bình tăng dần");
            System.out.println("2. Sắp xếp điểm trung bình giảm dần---");
            System.out.println("3. Thoát");
            System.out.println("Chọn chức năng: ");
            do {
                if (choose > 3) System.out.println("Vui lòng nhập lại");
                choose = Integer.parseInt(scanner.nextLine());
            } while (choose > 3);
            switch (choose) {
                case 1 -> sortAvgUp();
                case 2 -> sortAvgDown();
                case 3 -> {
                    return;
                }
            }
        }
    }


    public void sortAvgUp() {
        Student temp;
        for (int i = 0; i < student.size() - 1; i++) {
            for (int j = i + 1; j < student.size(); j++) {
                if (student.get(i).getAvgmark() > student.get(j).getAvgmark()) {
                    temp = student.get(i);
                    student.set(i, student.get(j));
                    student.set(j, temp);
                }
            }
        }
        show();
    }

    public void sortAvgDown() {
        Student temp;
        for (int i = 0; i <student.size() - 1; i++) {
            for (int j = i + 1; j < student.size(); j++) {
                if (student.get(i).getAvgmark() < student.get(j).getAvgmark()) {
                    temp = student.get(i);
                    student.set(i, student.get(j));
                    student.set(j, temp);
                }
            }
        }
        show();
    }
        }
