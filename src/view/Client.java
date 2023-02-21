package view;

import controller.StudentManager;
import io.ReadWriteFile;

import java.io.Serializable;
import java.util.Scanner;

public class Client implements Serializable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        ReadWriteFile readWriteFile = new ReadWriteFile();
        int a = 0;
        while (true) {
            {
                System.out.println("""
                        ------------------------------------------
                        |---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----|
                        ------------------------------------------
                        | 1. Thêm sinh viên                      |
                        | 2. Hiển thị tất cả sinh viên           |
                        | 3. Xóa Sinh viên                       |
                        | 4. Sửa danh sách các sinh viên         |
                        | 5. Hiển thị danh sách đã được sắp xếp  |
                        | 6. Thoát                               |
                        | Mời bạn nhập lựa chọn                  |
                        -----------------------------------------
                        """);
                a = Integer.parseInt(scanner.nextLine());
                switch (a) {
                    case 1 -> {
                        System.out.println("Nhập sinh viên muốn thêm : ");
                        studentManager.add(studentManager.create());
                        readWriteFile.write(StudentManager.fileStudent, StudentManager.students);
                        readWriteFile.read(StudentManager.fileStudent);
                    }
                    case 2 -> {
                        studentManager.show();
                    }
                    case 3 -> {
                        System.out.println("Nhập mã sinh viên muốn xóa : ");
                        String code = scanner.nextLine();
                        studentManager.delete(studentManager.findIdByCode(code));
                        readWriteFile.write(StudentManager.fileStudent, StudentManager.students);
                        readWriteFile.read(StudentManager.fileStudent);
                    }
                    case 4 -> {
                        System.out.println("Nhập mã sinh viên muốn sửa : ");
                        String code1 = scanner.nextLine();
                        studentManager.edit(studentManager.findIdByCode(code1), studentManager.create());
                        readWriteFile.write(StudentManager.fileStudent, StudentManager.students);
                        readWriteFile.read(StudentManager.fileStudent);
                    }
                    case 5 -> {
                        studentManager.sortGPA();
                        readWriteFile.write(StudentManager.fileStudent, StudentManager.students);
                        readWriteFile.read(StudentManager.fileStudent);
                    }
                    case 6 -> {
                        System.out.println("bạn đã thoát chương trình");
                        return;
                    }
                }
            }
        }
    }
}
