package navbar;

import model.Student;

import java.util.Arrays;
import java.util.Scanner;

public class Navbar {
    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("------STUDENT MANAGE------");
            System.out.println("1. Show List Student");
            System.out.println("2. Create Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Sort Student By Age(Tăng dần)");
            System.out.println("0. Exits");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            Student[] students = new Student[3];
            students[0] = new Student(1, "Tô Trần Hiếu", 18);
            students[1] = new Student(2, "Nguyễn Trọng Nhân", 17);
            students[2] = new Student(3, "Đinh Văn Khiết", 16);
            Student[] studentsNewArr = new Student[students.length - 1];
            Student student = new Student();
            switch (choice) {
                case 1:
                    System.out.println(Arrays.toString(students));
                    ;
                    break;
                case 2:
                    Student[] studentsNew = new Student[students.length + 1];
                    System.out.println("Nhập vào studentId");
                    int studentId = input.nextInt();
                    System.out.println("Nhập vào studentName");
                    input.nextLine();
                    String studentName = input.nextLine();
                    System.out.println("Nhập vào age");
                    int age = input.nextInt();
                    Student newStudent = new Student(studentId, studentName, age);
                    studentsNew[studentsNew.length - 1] = newStudent;
                    int a = 0;
                    for (int i = 0; i < students.length; i++) {
                        studentsNew[a++] = students[i];
                    }
                    System.out.println(Arrays.toString(studentsNew));
                    break;
                case 3:
                    System.out.println("nhập vào id muốn sửa");
                    int id = input.nextInt();
                    for (int i = 0; i < students.length; i++) {
                        if (students[i].studentId == id) {
                            input.nextLine();
                            System.out.println("Nhập vào studentName");
                            String nameUpdate = input.nextLine();
                            students[i].setStudentName(nameUpdate);
                            System.out.println("Nhập vào age");
                            int ageUpdate = input.nextInt();
                            students[i].setAge(ageUpdate);
                        }
                        System.out.println(students[i] + "");
                    }
                    break;
                case 4:
                    System.out.println("nhập vào id muốn xóa");
                    int idDel = input.nextInt();
                    int j = 0;
                    for (int i = 0; i < students.length; i++) {
                        if (students[i].studentId == idDel) {
                            continue;
                        }
                        studentsNewArr[j++] = students[i];
                    }
                    System.out.println(Arrays.toString(studentsNewArr));
                    break;
                case 5:
                    Student temp;
                    for (int i = 0; i < students.length; i++) {
                        for (int k = i + 1; k < students.length; k++) {
                            if (students[i].age > students[k].age) {
                                temp = students[k];
                                students[k] = students[i];
                                students[i] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < students.length; i++) {
                        System.out.println(students[i]);
                    }

                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}
