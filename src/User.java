abstract class User {
  protected int id;
  protected String nama;

  public User(int id, String nama) {
    this.id = id;
    this.nama = nama;
  }

  public int getId() {
    return id;
  }

  public String getNama() {
    return nama;
  }

  // Abstract method for getting details
  public abstract String getDetails();
}
