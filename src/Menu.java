import java.util.Scanner;

public class Menu {
  public static void tampilMenu() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter username: ");
    String username = scanner.nextLine();

    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    if (username.equals("siswa") && password.equals("rahasia")) {
      System.out.println("Login successful! Welcome, Student.");
      menuSiswa();
    } else if (username.equals("guru") && password.equals("rahasia")) {
      System.out.println("Login successful! Welcome, Teacher.");
      menuGuru();
    } else if (username.equals("admin") && password.equals("rahasia")) {
      System.out.println("Login successful! Welcome, Administration.");
      menuAdmin();
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
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1 -> Siswa.cekBiodata();
        case 2 -> Siswa.cekPresensi();
        case 3 -> tampilMenu();
        default -> System.out.println("Invalid choice. Please try again.");
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
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1 -> Absen.manageAttendance();
        case 2 -> Siswa.cariSiswa();
        case 3 -> tampilMenu();
        default -> System.out.println("Invalid choice. Please try again.");
      }
    }

    scanner.close();
  }

  // Main menu to choose between Siswa and Guru
  public static void menuAdmin() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println("\n--- Menu Tata Usaha ---");
      System.out.println("1. Data Siswa");
      System.out.println("2. Data Guru");
      System.out.println("3. Logout");
      System.out.print("Pilih opsi berikut: ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1 -> menuAdminSiswa();
        case 2 -> menuAdminGuru();
        case 3 -> {
          System.out.println();
          tampilMenu();
        }
        default -> System.out.println("Invalid choice. Please try again.");
      }
    }

    scanner.close();
  }

  // Admin access for Siswa (students)
  public static void menuAdminSiswa() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println("\n--- Admin Menu (Siswa) ---");
      System.out.println("1. Create Siswa");
      System.out.println("2. View Siswa");
      System.out.println("3. Update Siswa");
      System.out.println("4. Delete Siswa");
      System.out.println("5. Cek Presensi Siswa");
      System.out.println("6. Back to Main Menu");
      System.out.print("Pilih opsi berikut: ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1 -> {
          System.out.print("Enter Siswa ID: ");
          int id = scanner.nextInt();
          scanner.nextLine(); // Consume newline

          System.out.print("Enter Siswa name: ");
          String name = scanner.nextLine();

          Siswa.createSiswa(id, name);
        }
        case 2 -> Siswa.viewSiswa();
        case 3 -> {
          System.out.print("Enter the Siswa ID to update: ");
          int id = scanner.nextInt();
          scanner.nextLine(); // Consume newline

          System.out.print("Enter new name for Siswa: ");
          String newName = scanner.nextLine();

          Siswa.updateSiswa(id, newName);
        }
        case 4 -> {
          System.out.print("Enter the Siswa ID to delete: ");
          int id = scanner.nextInt();
          scanner.nextLine(); // Consume newline

          Siswa.deleteSiswa(id);
        }
        case 5 -> Siswa.cekPresensi();
        case 6 -> Menu.tampilMenu(); // Go back to the main menu
        default -> System.out.println("Invalid choice. Please try again.");
      }
    }

    scanner.close();
  }

  // Admin access for Guru (teachers)
  public static void menuAdminGuru() {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while (!exit) {
      System.out.println("\n--- Admin Menu (Guru) ---");
      System.out.println("1. Create Guru");
      System.out.println("2. View Guru");
      System.out.println("3. Update Guru");
      System.out.println("4. Delete Guru");
      System.out.println("5. Back to Main Menu");
      System.out.print("Pilih opsi berikut: ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1 -> {
          System.out.print("Enter Guru ID: ");
          int id = scanner.nextInt();
          scanner.nextLine(); // Consume newline

          System.out.print("Enter Guru name: ");
          String name = scanner.nextLine();

          Guru.createGuru(id, name);
        }
        case 2 -> Guru.viewGuru();
        case 3 -> {
          System.out.print("Enter the Guru ID to update: ");
          int id = scanner.nextInt();
          scanner.nextLine(); // Consume newline

          System.out.print("Enter new name for Guru: ");
          String newName = scanner.nextLine();

          Guru.updateGuru(id, newName);
        }
        case 4 -> {
          System.out.print("Enter the Guru ID to delete: ");
          int id = scanner.nextInt();
          scanner.nextLine(); // Consume newline

          Guru.deleteGuru(id);
        }
        case 5 -> exit = true;
        default -> System.out.println("Invalid choice. Please try again.");
      }
    }

    scanner.close();
  }

  // penutup MAIN
}
