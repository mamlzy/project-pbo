import java.util.ArrayList;
import java.util.Scanner;

class Siswa extends User implements OperasiCRUD {
  private static ArrayList<Siswa> siswaList = new ArrayList<>();

  public Siswa(int id, String nama) {
    super(id, nama);
  }

  @Override
  public String getDetails() {
      return "Siswa - NIS: " + id + ", Nama: " + nama;
  }

  public int getNis() {
    return id;
  }

  public String getNama() {
    return nama;
  }

  // Method to create a new student and add to the list
  public static void create(int id, String nama) {
    Siswa newSiswa = new Siswa(id, nama);
    System.out.println(nama);

    siswaList.add(newSiswa);
    System.out.println("Siswa added successfully!");
  }

  // Method to view all students
  public static void readAll() { 
    System.out.println("\n--- Daftar Siswa ---");
    if (siswaList.isEmpty()) {
      System.out.println("No students found.");
    } else {
      int index = 1;
      for (Siswa siswa : siswaList) {
        System.out.println(index + ". " + siswa.nama + " - " + siswa.id);
        index++;
      }
    }
  }

  // Method to update a student's name by NIS
  public static void update(int id, String newName) {
    for (Siswa siswa : siswaList) {
      if (siswa.id == id) {
        siswa.nama = newName;
        System.out.println("Siswa updated successfully!");
        return;
      }
    }
    System.out.println();
    System.out.println("Siswa tidak ditemukan.");
  }

  // Method to delete a student by ID
  public static void delete(int id) {
    for (Siswa siswa : siswaList) {
      if (siswa.id == id) {
        siswaList.remove(siswa);
        System.out.println("Siswa deleted successfully!");
        return;
      }
    }
    System.out.println("Siswa not found.");
  }

  public static Siswa getSiswaById(int id) {
    for (Siswa siswa : siswaList) {
      if (siswa.id == id) {
        return siswa;
      }
    }
    return null;
  }

  public static void cekBiodata() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter NIS: ");
    int id = scanner.nextInt();

    Siswa siswa = Siswa.getSiswaById(id);

    System.out.println("Nama: " + siswa.getNama());
    System.out.println("NIS: " + siswa.getNis());

    Menu.menuSiswa();

    scanner.close();
  }

  public static void cekPresensi() {
    System.out.print("Masukkan NIS siswa: ");

    Scanner scanner = new Scanner(System.in);

    int id = scanner.nextInt();
    scanner.nextLine();

    Siswa siswa = Siswa.getSiswaById(id);
    if (siswa == null) {
      System.out.println();
      System.out.println("Siswa tidak ditemukan.");
      Menu.menuAdminSiswa();
    }

    ArrayList<String> records = Absen.attendanceRecords.get(id);
    if (records != null && !records.isEmpty()) {
      System.out.println("Kehadiran untuk NIS " + id + ": " + records);
    } else {
      System.out.println("Siswa dengan NIS " + id + " tidak hadir.");
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