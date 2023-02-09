package model.password;

public class PasswordNumbers extends PasswordCreator {
    private static final String code = "0123456789";

    public PasswordNumbers(PasswordManager passwordManager) {
        super(passwordManager);
        super.code = code;
    }
}
