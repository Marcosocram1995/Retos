package main;

import model.configuration.ConfigurationPassword;
import model.password.PasswordManager;

public class Main {

    public static void main(String[] args) {
        PasswordManager passwordManager = new PasswordManager(15);
        passwordManager.addConfiguration(ConfigurationPassword.MAYUS);
        passwordManager.addConfiguration(ConfigurationPassword.SYMBOLS);
        passwordManager.addConfiguration(ConfigurationPassword.NUMBERS);
        passwordManager.initialize();
        System.out.println(passwordManager.getPasswordString());
        passwordManager.removeConfiguration(ConfigurationPassword.NUMBERS);
        passwordManager.initialize();
        System.out.println(passwordManager.getPasswordString());
        passwordManager.setPasswordLength(8);
        passwordManager.removeConfiguration(ConfigurationPassword.SYMBOLS);
        passwordManager.initialize();
        System.out.println(passwordManager.getPasswordString());
    }
}