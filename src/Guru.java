import java.util.ArrayList;
import java.util.Scanner;

class Guru {
  private int id;
  private String nama;
  private static ArrayList<Guru> guruList = new ArrayList<>();

  public Guru(int id, String nama) {
    this.id = id;
    this.nama = nama;
  }

  @Override
  public String toString() {
    return nama;
  }

  public int getId() {
    return id;
  }

  public String getNama() {
    return nama;
  }

  // Method to create a new student and add to the list
  public static void createGuru(int id, String nama) {
    Guru newSiswa = new Guru(id, nama);
    System.out.println(nama);

    guruList.add(newSiswa);
    System.out.println("Guru added successfully!");
  }

  // Method to view all students
  public static void viewGuru() {
    System.out.println("\n--- List of Guru ---");
    if (guruList.isEmpty()) {
      System.out.println("No students found.");
    } else {
      int index = 1;
      for (Guru guru : guruList) {
        System.out.println(index + ". " + guru.nama + " - " + guru.id);
        index++;
      }
    }
  }

  // Method to update a student's name by NIS
  public static void updateGuru(int id, String newName) {
    for (Guru guru : guruList) {
      if (guru.id == id) {
        guru.nama = newName;
        System.out.println("Guru updated successfully!");
        return;
      }
    }
    System.out.println("Guru not found.");
  }

  // Method to delete a student by ID
  public static void deleteGuru(int id) {
    for (Guru guru : guruList) {
      if (guru.id == id) {
        guruList.remove(guru);
        System.out.println("Guru deleted successfully!");
        return;
      }
    }
    System.out.println("Guru not found.");
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