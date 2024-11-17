import java.util.ArrayList;
import java.util.Scanner;

class Siswa extends User implements OperasiCRUD {
  private static ArrayList<Siswa> siswaList = new ArrayList<>();

  public Siswa(int id, String nama) {
    super(id, nama);
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String getNama() {
    return nama;
  }

  @Override
  public String getDetails() {
    return nama + " - " + id;
  }


  // Method to create a new student and add to the list
  public static void create(int id, String nama) {
    Siswa newSiswa = new Siswa(id, nama);
    siswaList.add(newSiswa);

    System.out.println(Console.Green("\nSiswa " + nama + " berhasil ditambahkan!") );
  }

  // Method to view all students
  public static void readAll() {
    System.out.println(Console.Green("\n--- Daftar Siswa ---"));
    if (siswaList.isEmpty()) {
      System.out.println("Siswa tidak diteukan.");
    } else {
      int index = 1;
      for (Siswa siswa : siswaList) {
        System.out.println(index + ". " + siswa.getDetails());
        index++;
      }
    }
  }

  // Method to update a student's name by NIS
  public static void update(int id, String newName) {
    for (Siswa siswa : siswaList) {
      if (siswa.id == id) {
        siswa.nama = newName;
        System.out.println("Siswa berhasil diubah!");
        return;
      }
    }
    System.out.println();
    System.out.println(Console.Red("Siswa tidak ditemukan."));
  }

  // Method to delete a student by ID
  public static void delete(int id) {
    for (Siswa siswa : siswaList) {
      if (siswa.id == id) {
        siswaList.remove(siswa);
        System.out.println("Siswa berhasil dihapus!");
        return;
      }
    }
    System.out.println(Console.Red("Siswa tidak ditemukan."));
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
    System.out.print("\nMasukkan NIS: ");
    int id = scanner.nextInt();

    Siswa siswa = Siswa.getSiswaById(id);

    if (siswa == null) {
      System.out.println(Console.Red("\nSiswa tidak ditemukan."));
      Menu.menuSiswa();
    }

    System.out.println(Console.Green("\nNama: " + siswa.getNama()));
    System.out.println(Console.Green("NIS: " + siswa.getId()));

    Menu.menuSiswa();

    scanner.close();
  }

  public static void cekPresensi() {
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);

    System.out.print("\nMasukkan NIS siswa: ");

    int id = scanner.nextInt();
    scanner.nextLine();

    Siswa siswa = Siswa.getSiswaById(id);

    ArrayList<String> records = Presensi.presensiList.get(id);
    if (siswa == null) {
      System.out.println();
      System.out.println(Console.Red("Siswa tidak ditemukan."));
    } else if (records != null && !records.isEmpty()) {
      System.out.println("Kehadiran untuk NIS " + id + ": " + records);

    } else {
      System.out
          .println("Siswa dengan NIS: " + siswa.id + ", Nama: " + siswa.nama + ", " + Console.Red("tidak hadir."));
    }

  }

  public static void cariSiswa() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("\nMasukkan NIS: ");

    int id = scanner.nextInt();
    scanner.nextLine();

    Siswa siswa = getSiswaById(id);

    if (siswa != null) {
      System.out.println(Console.Green("\nSiswa Ditemukan."));
      System.out.println("NIS: " + siswa.getId());
      System.out.println("Nama: " + siswa.getNama());
    } else {
      System.out.println(Console.Red("\nSiswa tidak ditemukan."));
    }

    Menu.menuGuru();

    scanner.close();
  }
}