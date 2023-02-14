package model.password;

public class PasswordMayus extends PasswordCreator {
    private static final String CODE = "ABCDEFGHIJKLMNOPQRSTUWXYZ";

    public PasswordMayus(PasswordManager passwordManager) {
        super(passwordManager, CODE);
    }
}
