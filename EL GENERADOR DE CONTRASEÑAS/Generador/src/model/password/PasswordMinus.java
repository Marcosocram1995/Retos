package model.password;

public class PasswordMinus extends PasswordCreator {
    private static final String CODE = "abcdefghijklmnopqrstuvwxyz";

    public PasswordMinus(PasswordManager passwordManager) {
        super(passwordManager, CODE);
    }
}
