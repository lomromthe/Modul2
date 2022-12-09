import IO.io;
import Sever.ManagerStudent;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
            ManagerStudent managerStudent=new ManagerStudent();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String string = """
                    \n------------------------CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN---------------------
                                   
                    1. Xem danh sách sinh viên
                    2. Thêm mới
                    3. Cập nhật
                    4. Xoá
                    5. Sắp xếp
                    6. Đọc từ file
                    7. Ghi vào file
                    8. Thoát""";
                System.out.println(string);
                int choice;
                do {
                    try {
                        System.out.println("Mời nhập lựa chọn: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (InputMismatchException | NumberFormatException e) {
                        System.out.println("\nPhải nhập số!");
                        System.out.print("Nhấn ENTER để tiếp tục");
                        scanner.nextLine();
                    }
                } while (true);
                switch (choice) {
                    case 1:
                        managerStudent.show();
                        break;
                    case 2:
                        System.out.println("Nhập thông tin sinh viên muốn thêm");
                        managerStudent.add();
                        break;
                    case 3:
                        managerStudent.edit();
                        break;
                    case 4:
                        managerStudent.delete();
                        break;
                    case 5:
                        managerStudent.sort();
                        break;
                    case 6:
                        System.out.println("Bạn có muốn cập nhật bộ nhớ không? Nhấn 'Y' để đồng ý!");
                        String update=scanner.nextLine();
                        if (update.equals("Y")){
                            io.readAccount();
                            System.out.println("\nĐã cập nhật lại bộ nhớ");
                            System.out.print("Nhấn ENTER để tiếp tục");
                            scanner.nextLine();
                        }else {
                            System.out.println("\nChưa nhật lại bộ nhớ");
                            System.out.print("Nhấn ENTER để tiếp tục");
                            scanner.nextLine();
                        }
                        break;
                    case 7:
                        io.writeFile(ManagerStudent.getStudent());
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        }
    }


