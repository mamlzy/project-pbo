import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Presensi {
  public static HashMap<Integer, ArrayList<String>> presensiList = new HashMap<>();

  public static void menuPresensi() {
    System.out.println(Console.Green("\n--- Menu Guru (Presensi) ---"));
    System.out.println("1. Pencatatan Presensi");
    System.out.println("2. Lihat Presensi");
    System.out.println("3. Kembali ke Menu Utama Guru");
    System.out.print("Pilih opsi: ");

    Scanner scanner = new Scanner(System.in);
    int choice = scanner.nextInt();
    scanner.nextLine(); 

    switch (choice) {
      case 1 -> catatPresensi();
      case 2 -> lihatPresensi();
      case 3 -> Menu.menuGuru() ;

      default -> System.out.println("Invalid choice.");
    }

    scanner.close();
  }

  public static void catatPresensi() {
    System.out.print("\nMasukkan NIS: ");
    Scanner scanner = new Scanner(System.in);

    int siswaId = scanner.nextInt();
    scanner.nextLine();

    Siswa siswa = Siswa.getSiswaById(siswaId);
    if (siswa != null) {
      presensiList.computeIfAbsent(siswaId, k -> new ArrayList<>()).add("Hadir");
      System.out.println(Console.Green("Presensi Berhasil dengan" + " NIS: " + siswa.getNis() + " Nama: " + siswa.getNama()) );

    } else {
      System.out.println(Console.Red("Siswa tidak ditemukan."));
    }

    menuPresensi();
    scanner.close();
  }

  public static void lihatPresensi() {
    Scanner scanner = new Scanner(System.in);
    // Memastikan bahwa presensiList tidak kosong
    if (presensiList.isEmpty()) {
      System.out.println(Console.Red("\nData Presensi Belum Ada!"));

      Presensi.menuPresensi();
      scanner.close();
      return;
    }

    // Menampilkan semua data absen tanpa meminta ID siswa
    for (Map.Entry<Integer, ArrayList<String>> entry : presensiList.entrySet()) {
      int siswaId = entry.getKey();
      ArrayList<String> value = entry.getValue(); // [Hadir] atau [Tidak Hadir]

      Siswa siswa = Siswa.getSiswaById(siswaId);

      System.out.println("\nAbsen untuk Siswa: " + siswa.getNama() + " - " + siswa.getNis() + ": " + value);
    }

    Menu.menuGuru();

    scanner.close();
  }
}
