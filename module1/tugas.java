import java.util.Scanner;
import java.lang.*;

class tugas {

    
    public static void main(String[] args){

        while(true){
            System.out.println("===== Librarty System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.println("Choose Option(1-3): ");
            Scanner scan = new Scanner(System.in);
            int pilih = scan.nextInt();

            if(pilih == 1){
                log_student();
            }else if(pilih == 2){
                log_admin();
            }else{
                System.out.println("adios");
                System.exit(0);
            }
        }

    }

    static void log_student(){

        long[] data = {202310370311483L, 202210370311483L, 202010370311483L};

        System.out.print("Enter your NIM : ");
        Scanner scan = new Scanner(System.in);
        long nim = scan.nextLong();
        int check = 0;
        for(int i = 0; i < data.length; i++){
            if((Long.toString(nim).length()==15)&&(nim == data[i])){
                check = 1;
                break;
           }
        }
        if(check>0){
            System.out.println("Successful Login as Student");
        }else{
            System.out.println("User Not Found");
        }

    }

    static void log_admin(){

        String[] duser = {"admin", "adm1n", "root"};
        String[] dpass = {"admln", "adm1n123", "passwd"};

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your username (admin) : ");
        String user = scan.nextLine();
        System.out.print("Enter your password (admin) : ");
        String pwd = scan.nextLine();
        int check = 0;
        for(int i = 0; i < duser.length; i++){
            if(user.equals(duser[i]) && pwd.equals(dpass[i])){
                check = 1;
                break;
           }
        }
        if(check>0){
            System.out.println("Successful Login as Admin");
        }else{
            System.out.println("Admin User Not Found!!");
        }
    }

}
//ngetes git