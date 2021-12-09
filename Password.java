public class Password {
    private static Password uniqueInstance = new Password();
    String pass = "admin";

    private Password() {}

    public static Password getInstance() {
        return uniqueInstance;
    }

    public void changePass(String pass_baru) {
        this.pass = pass_baru;
    }

    public String getPass() {
        return pass;
    }
}