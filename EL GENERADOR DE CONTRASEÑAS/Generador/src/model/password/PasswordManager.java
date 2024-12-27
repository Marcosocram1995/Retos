package model.password;

import model.configuration.ConfigurationChecker;
import model.configuration.ConfigurationPassword;

import java.util.ArrayList;
import java.util.List;

public class PasswordManager {
    private final List<ConfigurationPassword> configurationPasswords = new ArrayList<>();
    private String passwordString = "";
    protected int passwordLength;
    private List<Integer> changed;

    protected List<Integer> getChanged() {
        return changed;
    }

    public void setPasswordLength(int passwordLength) {
        checkLength(passwordLength);
        this.passwordLength = passwordLength;
    }

    public String getPasswordString() {
        return passwordString;
    }

    public List<ConfigurationPassword> getConfigurationPasswords() {
        return configurationPasswords;
    }

    public PasswordManager(int passwordLength) {
        this.passwordLength = passwordLength;
        checkLength(passwordLength);
        this.changed = new ArrayList<>();
    }

    public void addConfiguration(ConfigurationPassword configurationPassword) {
        configurationPasswords.add(configurationPassword);
    }

    public void removeConfiguration(ConfigurationPassword configurationPassword) {
        configurationPasswords.remove(configurationPassword);
    }

    public void initialize() {
        passwordString = "";
        changed = new ArrayList<>();
        ConfigurationChecker checker = new ConfigurationChecker(this);
        passwordString = checker.check();
    }

    private void checkLength(int passwordLength) {
        if (passwordLength < 8 || passwordLength > 16) {
            throw new IllegalArgumentException("La longitud de la contraseña debe ser entre 8 y 16 caracteres");
        }
    }
}
