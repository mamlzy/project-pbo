import java.util.Scanner;

public class Menu {
  public static void login() {
    Scanner scanner = new Scanner(System.in);

    System.out.println(Console.Green("\n--- Login ---"));
    System.out.print("Masukkan username: ");
    String username = scanner.nextLine();

    System.out.print("Masukkan password: ");
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
      System.out.println("Usrname atau Password salah!");
    }

    scanner.close();
  }

  public static void menuSiswa() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println(Console.Green("\n--- Menu Siswa ---"));
      System.out.println("1. Cek biodata");
      System.out.println("2. Cek Presensi");
      System.out.println("3. Logout");
      System.out.print("Pilih opsi: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> Siswa.cekBiodata();
        case 2 -> {
          Siswa.cekPresensi();
          Menu.menuSiswa();
        }
        case 3 -> login();
        default -> System.out.println("\nMenu tidak ditemukan, mohon diulang");
      }
    }

    scanner.close();
  }

  public static void menuGuru() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println(Console.Green("\n--- Menu Guru ---"));
      System.out.println("1. Presensi");
      System.out.println("2. Cari Siswa");
      System.out.println("3. Logout");
      System.out.print("Pilih opsi: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> Presensi.menuPresensi();
        case 2 -> Siswa.cariSiswa();
        case 3 -> login();
        default -> System.out.println("\nMenu tidak ditemukan, mohon diulang");
      }
    }

    scanner.close();
  }

  public static void menuKepsek() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println(Console.Green("\n--- Menu Kepala Sekolah ---"));
      System.out.println("1. Lihat Daftar Guru");
      System.out.println("2. Lihat Daftar Siswa");
      System.out.println("3. Logout");
      System.out.print("Pilih opsi: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> Guru.readAll();
        case 2 -> Siswa.readAll();
        case 3 -> login();
        default -> System.out.println("\nMenu tidak ditemukan, mohon diulang");
      }
    }

    scanner.close();
  }

  public static void menuAdmin() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println(Console.Green("\n--- Menu Admin ---"));
      System.out.println("1. Data Siswa");
      System.out.println("2. Data Guru");
      System.out.println("3. Logout");
      System.out.print("Pilih opsi: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> menuAdminSiswa();
        case 2 -> menuAdminGuru();
        case 3 -> login();
        default -> System.out.println("\nMenu tidak ditemukan, mohon diulang");
      }
    }

    scanner.close();
  }

  // Admin access for Siswa (students)
  public static void menuAdminSiswa() {
    Scanner scanner = new Scanner(System.in);

    boolean exit = false;
    while (!exit) {
      System.out.println(Console.Green("\n--- Menu Admin (Siswa) ---"));
      System.out.println("1. Tambah Siswa");
      System.out.println("2. Lihat Daftar Siswa");
      System.out.println("3. Ubah Siswa");
      System.out.println("4. Hapus Siswa");
      System.out.println("5. Cek Presensi Siswa");
      System.out.println("6. Kembali ke Menu Utama Admin");
      System.out.println("7. Logout");
      System.out.print("Pilih opsi: ");
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
        case 5 -> {
          Siswa.cekPresensi();
          Menu.menuAdmin();
        }
        case 6 -> Menu.menuAdmin();
        case 7 -> Menu.login();
        default -> System.out.println("\nMenu tidak ditemukan, mohon diulang");
      }
    }

    scanner.close();
  }

  public static void menuAdminGuru() {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while (!exit) {
      System.out.println(Console.Green("\n--- Menu Admin (Guru) ---"));
      System.out.println("1. Tambah Guru");
      System.out.println("2. Lihat Guru");
      System.out.println("3. Ubah Guru");
      System.out.println("4. Hapus Guru");
      System.out.println("5. Kembali ke Menu Utama Admin");
      System.out.println("6. Logout");
      System.out.print("Pilih opsi: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> {
          System.out.print("\nMasukkan ID Guru: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Masukkan nama Guru: ");
          String name = scanner.nextLine();

          Guru.create(id, name);
        }
        case 2 -> Guru.readAll();
        case 3 -> {
          System.out.print("\nMasukkan ID Guru yang ingin diubah: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Masukkan nama baru Guru: ");
          String newName = scanner.nextLine();

          Guru.update(id, newName);
        }
        case 4 -> {
          System.out.print("\nMasukkan ID Guru yang ingin dihapus: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          Guru.delete(id);
        }
        case 5 -> menuAdmin();
        case 6 -> Menu.login();
        default -> {
          System.out.println("\nMenu tidak ditemukan, mohon diulang");
        }
      }
    }

    scanner.close();
  }
}
