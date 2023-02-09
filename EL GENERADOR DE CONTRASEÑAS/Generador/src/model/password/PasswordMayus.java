package model.password;

public class PasswordMayus extends PasswordCreator {
    private static String code = "ABCDEFGHIJKLMNOPQRSTUWXYZ";

    public PasswordMayus(PasswordManager passwordManager) {
        super(passwordManager);
        super.code = this.code;
    }
}
