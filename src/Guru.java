import java.util.ArrayList;
import java.util.Scanner;

class Guru extends User implements OperasiCRUD {
  private static ArrayList<Guru> guruList = new ArrayList<>();

  public Guru(int id, String nama) {
    super(id, nama);
  }

  public int getId() {
    return id;
  }

  public String getNama() {
    return nama;
  }
  
  @Override
  public String getDetails() {
      return nama + " - " + id
;  }

  // Method to create a new student and add to the list
  public static void create(int id, String nama) {
    Guru newSiswa = new Guru(id, nama);
    System.out.println(nama);

    guruList.add(newSiswa);
    System.out.println("Guru berhasil ditambahkan!");
  }

  public static void readAll() {
    System.out.println(Console.Green("\n--- Daftar Guru ---"));
    if (guruList.isEmpty()) {
      System.out.println("Guru tidak ditemukan.");
    } else {
      int index = 1;
      for (Guru guru : guruList) {
        System.out.println(index + ". " + guru.getDetails());
        index++;
      }
    }
  }

  // Method to update a student's name by NIS
  public static void update(int id, String newName) {
    for (Guru guru : guruList) {
      if (guru.id == id) {
        guru.nama = newName;
        System.out.println("Guru updated successfully!");
        return;
      }
    }
    System.out.println("Guru tidak ditemukan.");
  }

  // Method to delete a student by ID
  public static void delete(int id) {
    for (Guru guru : guruList) {
      if (guru.id == id) {
        guruList.remove(guru);
        System.out.println("Guru berhasil dihapus!");
        return;
      }
    }
    System.out.println("Guru tidak ditemukan.");
  }

  public static Guru getGuruById(int id) {
    for (Guru guru : guruList) {
      if (guru.id == id) {
        return guru;
      }
    }
    return null;
  }

  public static void cariGuru() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Masukkan ID Guru: ");

    int id = scanner.nextInt();
    scanner.nextLine();

    Guru guru = getGuruById(id);

    if (guru != null) {
      System.out.println("Guru Ditemukan.");
      System.out.println("ID Guru: " + guru.getId());
      System.out.println("Nama: " + guru.getNama());

    } else {
      System.out.println("Guru tidak ditemukan.");
    }

    Menu.menuGuru();

    scanner.close();
  }

}