public class Main {
  public static void main(String[] args) {
    Siswa.createSiswa(1, "Audhe Supriyono");
    Siswa.createSiswa(2, "Fuji Ramadhana");
    Siswa.createSiswa(3, "Dhafa");

    Guru.createGuru(111, "Sri Wahyuni");
    Guru.createGuru(222, "Jokowi");
    Guru.createGuru(333, "Prabowo");

    Menu.tampilMenu();
  }
}
