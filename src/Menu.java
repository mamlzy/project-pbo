import java.util.Scanner;

public class Menu {
  public static void tampilMenu() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter username: ");
    String username = scanner.nextLine();

    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    if (username.equals("siswa") && password.equals("rahasia")) {
      menuSiswa();
    } else if (username.equals("guru") && password.equals("rahasia")) {
      menuGuru();
    } else if (username.equals("admin") && password.equals("rahasia")) {
      menuAdmin();
    } else if (username.equals("kepsek") && password.equals("rahasia")) {
      menuKepsek();
    } else {
      System.out.println("Invalid username or password.");
    }

    scanner.close();
  }

  public static void menuSiswa() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println("\n--- Main Menu ---");
      System.out.println("1. Cek biodata");
      System.out.println("2. Cek Presensi");
      System.out.println("3. Logout");
      System.out.print("Pilih opsi berikut: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> Siswa.cekBiodata();
        case 2 -> Siswa.cekPresensi();
        case 3 -> tampilMenu();
        default -> {
          System.out.println();
          System.out.println("Menu tidak ditemukan, mohon diulang");
        }
      }
    }

    scanner.close();
  }

  public static void menuGuru() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println("\n--- Menu Guru ---");
      System.out.println("1. Absensi");
      System.out.println("2. Cari Siswa");
      System.out.println("3. Logout");
      System.out.print("Pilih opsi berikut: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> Absen.manageAttendance();
        case 2 -> Siswa.cariSiswa();
        case 3 -> tampilMenu();
        default -> {
          System.out.println();
          System.out.println("Menu tidak ditemukan, mohon diulang");
        }
      }
    }

    scanner.close();
  }

  public static void menuKepsek() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println("\n--- Menu Kepsek ---");
      System.out.println("1. Lihat Daftar Guru");
      System.out.println("2. Lihat Daftar Siswa");
      System.out.println("3. Logout");
      System.out.print("Pilih opsi berikut: ");
      int choice = scanner.nextInt();
      scanner.nextLine();


      switch (choice) {
        case 1 -> Guru.readAll();
        case 2 -> Siswa.readAll();
        case 3 -> {
          System.out.println();
          tampilMenu();
        }
        default -> {
          System.out.println();
          System.out.println("Menu tidak ditemukan, mohon diulang");
        }
      }
    }

    scanner.close();
  }

  // Main menu to choose between Siswa and Guru
  public static void menuAdmin() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println("\n--- Menu Admin ---");
      System.out.println("1. Data Siswa");
      System.out.println("2. Data Guru");
      System.out.println("3. Logout");
      System.out.print("Pilih opsi berikut: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> menuAdminSiswa();
        case 2 -> menuAdminGuru();
        case 3 -> {
          System.out.println();
          tampilMenu();
        }
        default -> {
          System.out.println();
          System.out.println("Menu tidak ditemukan, mohon diulang");
        }
      }
    }

    scanner.close();
  }

  // Admin access for Siswa (students)
  public static void menuAdminSiswa() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println("\n--- Menu Admin (Siswa) ---");
      System.out.println("1. Create Siswa");
      System.out.println("2. View Siswa");
      System.out.println("3. Update Siswa");
      System.out.println("4. Delete Siswa");
      System.out.println("5. Cek Presensi Siswa");
      System.out.println("6. Back to Main Menu");
      System.out.print("Pilih opsi berikut: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> {
          System.out.print("Masukkan NIS: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Masukkan nama siswa: ");
          String name = scanner.nextLine();

          Siswa.create(id, name);
        }
        case 2 -> Siswa.readAll();
        case 3 -> {
          System.out.print("Masukkan NIS siswa yang ingin diubah: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Masukkan nama baru siswa: ");
          String newName = scanner.nextLine();

          Siswa.update(id, newName);
        }
        case 4 -> {
          System.out.print("Masukkan NIS siswa yang ingin dihapus: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          Siswa.delete(id);
        }
        case 5 -> Siswa.cekPresensi();
        case 6 -> Menu.tampilMenu(); // Go back to the main menu
        default -> {
          System.out.println();
          System.out.println("Menu tidak ditemukan, mohon diulang");
        }
      }
    }

    scanner.close();
  }

  // Admin access for Guru (teachers)
  public static void menuAdminGuru() {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while (!exit) {
      System.out.println("\n--- Menu Admin (Guru) ---");
      System.out.println("1. Tambah Guru");
      System.out.println("2. Lihat Guru");
      System.out.println("3. Ubah Guru");
      System.out.println("4. Hapus Guru");
      System.out.println("5. Kembali ke Menu Utama");
      System.out.print("Pilih opsi berikut: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> {
          System.out.print("Enter Guru ID: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Enter Guru name: ");
          String name = scanner.nextLine();

          Guru.create(id, name);
        }
        case 2 -> Guru.readAll();
        case 3 -> {
          System.out.print("Enter the Guru ID to update: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Enter new name for Guru: ");
          String newName = scanner.nextLine();

          Guru.update(id, newName);
        }
        case 4 -> {
          System.out.print("Enter the Guru ID to delete: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          Guru.delete(id);
        }
        case 5 -> menuAdmin();
        default -> {
          System.out.println();
          System.out.println("Menu tidak ditemukan, mohon diulang");
        }
      }
    }

    scanner.close();
  }

  // penutup MAIN
}
