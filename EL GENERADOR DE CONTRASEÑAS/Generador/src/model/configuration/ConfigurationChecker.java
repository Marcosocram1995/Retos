package model.configuration;

import model.password.*;

public class ConfigurationChecker implements Checkeable {
    private final PasswordManager passwordManager;

    public ConfigurationChecker(PasswordManager passwordManager) {
        this.passwordManager = passwordManager;
    }

    @Override
    public String check() {
        String passwordString = new PasswordMinus(passwordManager).create();
        for (int i = 0; i < passwordManager.getConfigurationPasswords().size(); i++) {
            switch (passwordManager.getConfigurationPasswords().get(i)) {
                case MAYUS -> passwordString = new PasswordMayus(passwordManager).mix(passwordString);
                case SYMBOLS -> passwordString = new PasswordSymbols(passwordManager).mix(passwordString);
                case NUMBERS -> passwordString = new PasswordNumbers(passwordManager).mix(passwordString);
            }
        }
        return passwordString;
    }
}