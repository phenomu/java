import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

class codelab {

    public static void main(String[] args) {
        //Merupakan Class Yang Sebelumny sudah di import
        Scanner scan = new Scanner(System.in);
        System.out.print("\nNama : ");
        //Digunakan untuk menerima input dari user
        String nama = scan.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        String kelamin = scan.nextLine();
        System.out.print("Tanggal Lahhir (yyyy-mm-dd) : ");
        String tgl = scan.nextLine();
        scan.close();

        //kondisi jika user memasukan jenis kelamin P / L, lebih baik kita jadikan lower/uppercase dahulu sebelum di compare
        if(kelamin.toLowerCase().equals("p")){
            kelamin = "Perempuan";
        }else if (kelamin.toLowerCase().equals("l")) {
            kelamin = "Laki-Laki";
        }else{
            kelamin = "*Secret";
        }
        //digunakan untuk mengambil waktu yang sekarang
        LocalDate date = LocalDate.now(); 
        //digunaakan untuk memparse data yang kita masukan sebagai parameter dengan format tertentu
        LocalDate tglx = LocalDate.parse(tgl);
        //menghhitung range dari tanggal lahir ke waktu yang sekarang
        Period umur = Period.between(tglx,date);

        System.out.println("\n\n\nNama : " + nama);
        System.out.println("Jenis Kelamin : " + kelamin);
        System.out.println("Umur Anda : " + umur.getYears() + " Tahun " + umur.getMonths() + " Bulan");
    }

}