import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        StatusDisplay status = new StatusDisplay(user);
        Scanner scan = new Scanner(System.in);
        boolean play = true;

        while (play) {
            System.out.print("Masukkan password : ");
            String pass = scan.next();
            user.setMeasurements(pass);
            System.out.println("\nMasuk lagi ? [Y/n]");
            String jawaban = scan.next();
            if (jawaban.equalsIgnoreCase("Y")) {
                play = true;
            } else {
                play = false;
            }
            System.out.println();
        }
    }
}