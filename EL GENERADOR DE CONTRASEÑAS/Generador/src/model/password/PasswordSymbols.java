package model.password;

public class PasswordSymbols extends PasswordCreator {
    private static final String code = ";_^¡¿?!\"#$%&'()*+,\\-.";

    public PasswordSymbols(PasswordManager passwordManager) {
        super(passwordManager);
        super.code = code;
    }
}
