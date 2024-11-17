  public class Main {
    public static void main(String[] args) {
      Siswa.create(1, "Audhe Supriyono");
      Siswa.create(2, "Fuji Ramadhana");
      Siswa.create(3, "Muhammad Dhafa");

      Guru.create(111, "Basmallah Ramadhani Aisya");
      Guru.create(222, "Muhamad Haikal");
      Guru.create(333, "Agi Candra Bramantia");

      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println();

      Menu.login();
    }
  }
