public class Console {
  // ANSI escape codes
  private static final String RESET = "\033[0m";
  private static final String GREEN = "\033[32m";
  private static final String RED = "\033[31m";

  // Green text
  public static String Green(String text) {
      return GREEN + text + RESET;
  }

  // Red text
  public static String Red(String text) {
      return RED + text + RESET;
  }
}