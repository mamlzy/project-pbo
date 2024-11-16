import java.util.ArrayList;
import java.util.Scanner;

class Siswa {
  private int nis;
  private String nama;
  private static ArrayList<Siswa> siswaList = new ArrayList<>();

  public Siswa(int nis, String nama) {
    this.nis = nis;
    this.nama = nama;
  }

  @Override
  public String toString() {
    return nama;
  }

  public int getNis() {
    return nis;
  }

  public String getNama() {
    return nama;
  }

  // Method to create a new student and add to the list
  public static void createSiswa(int nis, String nama) {
    Siswa newSiswa = new Siswa(nis, nama);
    System.out.println(nama);

    siswaList.add(newSiswa);
    System.out.println("Siswa added successfully!");
  }

  // Method to view all students
  public static void viewSiswa() {
    System.out.println("\n--- List of Siswa ---");
    if (siswaList.isEmpty()) {
      System.out.println("No students found.");
    } else {
      int index = 1;
      for (Siswa siswa : siswaList) {
        System.out.println(index + ". " + siswa.nama + " - " + siswa.nis);
        index++;
      }
    }
  }

  // Method to update a student's name by NIS
  public static void updateSiswa(int nis, String newName) {
    for (Siswa siswa : siswaList) {
      if (siswa.nis == nis) {
        siswa.nama = newName;
        System.out.println("Siswa updated successfully!");
        return;
      }
    }
    System.out.println();
    System.out.println("Siswa tidak ditemukan.");
  }

  // Method to delete a student by ID
  public static void deleteSiswa(int nis) {
    for (Siswa siswa : siswaList) {
      if (siswa.nis == nis) {
        siswaList.remove(siswa);
        System.out.println("Siswa deleted successfully!");
        return;
      }
    }
    System.out.println("Siswa not found.");
  }

  public static Siswa getSiswaById(int nis) {
    for (Siswa siswa : siswaList) {
      if (siswa.nis == nis) {
        return siswa;
      }
    }
    return null;
  }

  public static void cekBiodata() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter NIS: ");
    int nis = scanner.nextInt();

    Siswa siswa = Siswa.getSiswaById(nis);

    System.out.println("Nama: " + siswa.getNama());
    System.out.println("NIS: " + siswa.getNis());

    Menu.menuSiswa();

    scanner.close();
  }

  public static void cekPresensi() {
    System.out.print("Masukkan NIS siswa: ");

    Scanner scanner = new Scanner(System.in);

    int nis = scanner.nextInt();
    scanner.nextLine();

    Siswa siswa = Siswa.getSiswaById(nis);
    if (siswa == null) {
      System.out.println();
      System.out.println("Siswa tidak ditemukan.");
      Menu.menuAdminSiswa();
    }

    ArrayList<String> records = Absen.attendanceRecords.get(nis);
    if (records != null && !records.isEmpty()) {
      System.out.println("Kehadiran untuk NIS " + nis + ": " + records);
    } else {
      System.out.println("Siswa dengan NIS " + nis + " tidak hadir.");
      Menu.menuAdminSiswa();
    }

    Menu.menuSiswa();

    scanner.close();
  }

  public static void cariSiswa() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Masukkan NIS: ");

    int id = scanner.nextInt();
    scanner.nextLine();

    Siswa siswa = getSiswaById(id);

    if (siswa != null) {
      System.out.println();
      System.out.println("Siswa Ditemukan.");
      System.out.println("NIS: " + siswa.getNis());
      System.out.println("Nama: " + siswa.getNama());
    } else {
      System.out.println();
      System.out.println("Siswa tidak ditemukan.");
    }

    Menu.menuGuru();

    scanner.close();
  }
}