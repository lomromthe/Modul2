package IO;

import Sever.ManagerStudent;
import SinhVien.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class io {

    public static void writeFile(ArrayList<Student> student) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("student.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(student);
            outputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
        }
    }

        public static ArrayList<Student> readAccount() {
            try {
                FileInputStream fileInputStream = new FileInputStream("student.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                return (ArrayList<Student>) objectInputStream.readObject();
            } catch (Exception e) {
            }
            return new ArrayList<>();
        }
    }


