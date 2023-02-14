package model.password;

public class PasswordNumbers extends PasswordCreator {
    private static final String CODE = "0123456789";

    public PasswordNumbers(PasswordManager passwordManager) {
        super(passwordManager, CODE);
    }
}
