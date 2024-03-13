import java.lang.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

class Student {
    static String name;
    static String faculty;
    static String programStudi;

    static void displayBooks(String[][] data){
        System.out.println("===========================================================================================");
        System.out.println("|| No.\t|| Id buku\t\t|| Nama Buku\t|| Author\t|| Category\t|| Stock ||");
        System.out.println("===========================================================================================");
        for (String[] booklist : data) {
            System.out.println("|| "+booklist[0]+"\t|| "+booklist[1]+"\t|| "+booklist[2]+"\t|| "+booklist[3]+"\t|| "+booklist[4]+"\t|| "+booklist[5]+"\t ||");
        }
        System.out.println("===========================================================================================\n");
        System.out.println("Input Id buku yang ingin dipinjam (input 99 untuk kembali)");
    }
    static void logout(int book){
        System.out.println("Total Buku Yang Dipinjam : "+String.valueOf(book));
        System.out.println("System Logout...\n");
    }
}

class Admin {
    static String adminUsername = "admin";
    static String adminPassword = "admln";
    static String studentList[][];

    static void displayStudents() {
        studentList = Main.userStudent;
        System.out.println("List Of Registered Students: ");
        for (String[] students : studentList) {
            System.out.println("Name\t: "+students[0]);
            System.out.println("Faculty\t: "+students[1]);
            System.out.println("NIM\t: "+students[2]);
            System.out.println("Program\t: "+students[3]+"\n");
        }
    }

    static void addStudent() {
        String data[] = new String[4];
        studentList = Main.userStudent;
        Scanner scans = new Scanner(System.in);
            System.out.print("Masukkan nama mahasiswa: ");
            data[0] = scans.nextLine();
            System.out.print("Masukkan NIM mahasiswa: ");
            data[2] = scans.nextLine();
            while(true){
                if (String.valueOf(data[2]).length() != 15 ) {
                    System.out.print(String.valueOf(data[1]).length());
                    System.out.print("Nim Harus 15 Digit!!!\n");
                    System.out.print("Masukkan NIM mahasiswa: ");
                    data[2] = scans.nextLine();
                }else{
                    break;
                }
            }
            System.out.print("Masukkan ProgramStudi mahasiswa: ");
            data[3] = scans.nextLine();
            System.out.print("Masukkan Fakultas mahasiswa: ");
            data[1] = scans.nextLine();

        Main.userStudent = Arrays.copyOf(studentList, studentList.length+1);
        Main.userStudent[studentList.length] = data;
        System.out.println();
    }
}

class Main {
    static int buku_dipinjam = 0;
    static String[][] bookList = {
        {"1","388c-e681-9152","title","author","Sejarah","4"},
        {"2","ed90-be30-5cdb","title","author","Sejarah","0"},
        {"3","d95e-0c4a-9523","title","author","Sejarah","2"},
    };
    static String[][] userStudent ={
        {"Hadrian Rakha", "Teknik","202310370311483","Informatika"},
        {"Udin kopling", "Teknik","202310300001337","Mesin"},
        {"Bilal Nyetut", "Sihir","202310300006969","Perdukunan"},
    };
    
    static void menu(){
        System.out.println("===== Library System =====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose Option(1-3): ");
        Scanner scan = new Scanner(System.in);
        int pilih = scan.nextInt();

        if(pilih == 1){
            inputNim();
        }else if(pilih == 2){
            log_admin();
        }else{
            System.out.println("Thankyou.. *Exiting Program.");
            System.exit(0);
        }
    }

    static void menuAdmin(){
        while(true){
            System.out.println("=== Admin Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Logout");
            System.out.print("Choose Option(1-3): ");
            Scanner scan = new Scanner(System.in);
            int pilih = scan.nextInt();

            if(pilih == 1){
                Admin.addStudent();
            }else if(pilih == 2){
                Admin.displayStudents();
            }else if(pilih == 3){
                break;
            }
        }
    }

    static void menuStudent(){
        while(true){
            System.out.println("=== Student Menu ===");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Pinjam buku atau Logout");
            System.out.print("Choose Option(1-3): ");
            Scanner scan = new Scanner(System.in);
            int pilih = scan.nextInt();

            if(pilih == 1){
                System.out.println("Buku Yang Sedang Dipinjam ada "+String.valueOf(buku_dipinjam)+"\n");
            }else if(pilih == 2){
                Student.displayBooks(bookList);
                System.out.print("Input : ");
                Scanner scanpinjam = new Scanner(System.in);
                int pinjam = scanpinjam.nextInt();
                
                for (int i = 0; i < bookList.length; i++) {
                    if (String.valueOf(pinjam).equals(bookList[i][0])&&((Integer.parseInt(bookList[i][5])-1) >= 0)) {
                        System.out.println("Buku dengan Id "+bookList[i][1]+" Berhasil Dipinjam");
                        bookList[i][5] = String.valueOf(Integer.parseInt(bookList[i][5])-1);
                        buku_dipinjam++;
                    }else if(String.valueOf(pinjam).equals(bookList[i][0])&&((Integer.parseInt(bookList[i][5])-1) <= 0)){
                        System.out.println("Stok Buku dengan Id "+bookList[i][1]+" Sedang Kosong");
                    }
                }

            }else if(pilih == 3){
                Student.logout(buku_dipinjam);
                break;
            }else if(pilih == 99){
                break;
            }
        }
    }

    static void checkNim(String data){
        int val = 0;
        for (int i = 0 ; i<userStudent.length ; i++ ) {
            if (data.equals(userStudent[i][2])) {
                System.out.println("Successfull Login as "+userStudent[i][0]+"\n");
                val++;
                menuStudent();
            }
        }if (val==0){
            System.out.println("NIM "+data+" not found in database!\n");
        }
    }

    static void inputNim(){

        System.out.print("Enter your NIM : ");
        Scanner scan = new Scanner(System.in);
        String nim = scan.nextLine();

        while(true){
            if (nim.length() != 15 ) {
                System.out.print("Nim Harus 15 Digit!!!\n");
                System.out.print("Masukkan NIM mahasiswa: ");
                nim = scan.nextLine();
            }else{
                Main cn = new Main();
                cn.checkNim(nim);
                break;
            }
        }
    }

    static void log_admin(){

        System.out.print("Enter your username (admin) : ");
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        System.out.print("Enter your password (admln) : ");
        String pwd = scan.nextLine();

        if (user.equals(Admin.adminUsername)&&pwd.equals(Admin.adminPassword)) {
            System.out.println();
            Main.menuAdmin();
        }else{
            System.out.println("Invalid credentials for admin.\n");
        }
    }

    public static void main(String[] args) {
        while(true){
            Main.menu();
        }
    }

}