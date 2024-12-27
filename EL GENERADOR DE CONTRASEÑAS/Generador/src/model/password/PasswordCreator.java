package model.password;

import java.util.Random;

public class PasswordCreator {
    private String code = "";
    private final Random random;
    private final PasswordManager manager;

    protected PasswordCreator(PasswordManager manager, String code) {
        random = new Random();
        this.code = code;
        this.manager = manager;
    }

    public String create() {
        String password = null;
        if (!code.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < manager.passwordLength; i++) {
                stringBuilder.append(code.charAt(random.nextInt(code.length())));
            }
            password = stringBuilder.toString();
        }
        return password;
    }

    public String mix(String password) {
        String secondPassword = create();
        String lastPassword = null;
        if (!password.isEmpty() && !secondPassword.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(password);
            int randomNumber = random.nextInt(manager.passwordLength / manager.getConfigurationPasswords().size());
            int count = 0;
            do {
                int position = random.nextInt(manager.passwordLength);
                if (!manager.getChanged().contains(position)) {
                    manager.getChanged().add(position);
                    stringBuilder.setCharAt(position, secondPassword.charAt(random.nextInt(manager.passwordLength)));
                    count++;
                }
            } while (count <= randomNumber);
            lastPassword = stringBuilder.toString();
        }
        return lastPassword;
    }
}
