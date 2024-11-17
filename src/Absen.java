import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Absen {
  public static HashMap<Integer, ArrayList<String>> attendanceRecords = new HashMap<>();

  public static void manageAttendance() {
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
      attendanceRecords.computeIfAbsent(siswaId, k -> new ArrayList<>()).add("Hadir");
      System.out.println(Console.Green("Presensi Berhasil dengan" + " NIS: " + siswa.getNis() + " Nama: " + siswa.getNama()) );

    } else {
      System.out.println("Siswa tidak ditemukan.");
    }

    manageAttendance();
    scanner.close();
  }

  public static void lihatPresensi() {
    Scanner scanner = new Scanner(System.in);
    // Memastikan bahwa attendanceRecords tidak kosong
    if (attendanceRecords.isEmpty()) {
      System.out.println();
      System.out.println("Data Presensi Tidak Ditemukan!");

      Absen.manageAttendance();
      scanner.close();
      return;
    }

    // Menampilkan semua data absen tanpa meminta ID siswa
    for (Map.Entry<Integer, ArrayList<String>> entry : attendanceRecords.entrySet()) {
      int siswaId = entry.getKey();
      ArrayList<String> records = entry.getValue();

      Siswa siswa = Siswa.getSiswaById(siswaId);

      System.out.println();
      System.out.println("Absen untuk Siswa: " + siswa.getNama() + " - " + siswa.getNis() + ": " + records);
    }

    Menu.menuGuru();

    scanner.close();
  }
}
