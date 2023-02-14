package model.password;

public class PasswordSymbols extends PasswordCreator {
    private static final String CODE = ";_^¡¿?!\"#$%&'()*+,\\-.";

    public PasswordSymbols(PasswordManager passwordManager) {
        super(passwordManager, CODE);
    }
}
