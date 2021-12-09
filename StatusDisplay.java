import static java.lang.Thread.sleep;
import java.util.Scanner;

public class StatusDisplay implements Observer, Display {
    Password password = Password.getInstance();
    User user = new User();
    private String pass;
    static int i = 1;

    public StatusDisplay(User user) {
        this.user = user;
        user.registerObserver(this);
    }

    public void update(String pass) {
        this.pass = pass;
        display();
    }

    public void failed() {
        try {
            System.out.println("\t<-> Lampu Merah, Bunyi Alarm, dan Limit <->");
            Thread.sleep(10000);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void display() {
        Items item = new Items();
        Scanner scan = new Scanner(System.in);

        if (pass.equals(password.getPass())) {
            System.out.println("\t<-> Lampu Hijau <->");
            System.out.println("\t1. Buka Brankas");
            System.out.println("\t2. Ubah Password");
            System.out.print("Pilih : ");
            int pilih = scan.nextInt();
            if (pilih == 1) {
                System.out.println("\t> Brankas Terbuka <");
                for (Iterator iter = item.getIterator(); iter.hasNext();) {
                    String name = (String)iter.next();
                    System.out.println("\tItem : " + name);
                }
            } else if (pilih == 2) {
                System.out.print("Ganti Password : ");
                scan.nextLine();
                String pass = scan.nextLine();
                password.changePass(pass);
                // System.out.println(password.getPass());
            }
        } else {
            if (i == 5 || i >= 5) {
                failed();
            } else {
                System.out.println("\t<-> Lampu Merah <->");
            }
            i++;
        }
    }
}