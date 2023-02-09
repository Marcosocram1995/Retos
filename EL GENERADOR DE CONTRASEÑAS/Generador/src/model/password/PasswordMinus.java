package model.password;

public class PasswordMinus extends PasswordCreator {
    private static final String code = "abcdefghijklmnopqrstuvwxyz";

    public PasswordMinus(PasswordManager passwordManager) {
        super(passwordManager);
        super.code = code;
    }
}
