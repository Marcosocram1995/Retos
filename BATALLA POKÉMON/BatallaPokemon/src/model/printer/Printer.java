package model.printer;

import model.Effectiveness;
import model.movement.Movement;
import model.printer.text.parts.Text;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Printer {
    private static final String ASTERISK = "*";
    private static final int LONG_WAIT = 3;
    private static final int SHORT_WAIT = 1;

    private void print(String text) {
        System.out.println(text);
    }

    public void printScreen(String firstPokemon, String secondPokemon, List<Movement> movements) {
        Text text = new Text(ASTERISK, firstPokemon, secondPokemon, movements);
        print(text.getHeader());
        print(text.getBody());
        print(text.getFooter());
    }

    public int getInputUser() {
        Scanner in = new Scanner(System.in);
        int input = 1;
        try {
            input = in.nextInt();
        } catch (InputMismatchException ignore) {
            input = getInputUser();
        }
        return input;
    }

    public void printDamage(int damage) {
        print("¡" + damage + " puntos de daño!");

    }

    public void printCritic() {
        print("¡Golpe crítico!");
    }

    public void printEffectiveness(Effectiveness effectiveness) {
        if (effectiveness != Effectiveness.MEDIUM) {
            print("¡El ataque ha sido " + effectiveness.getName() + " efectivo!");
        }
    }

    public void printHealth(String name, int health) {
        Waiter.sleep(SHORT_WAIT);
        if (health < 0) {
            health = 0;
        }
        print(name + ": " + health + "hp");
        Waiter.sleep(LONG_WAIT);
    }

    public void printMovement(String name, String movement) {
        print("\n" + name + " utilizó " + movement);
        Waiter.sleep(SHORT_WAIT);
    }

    public void printWinner(String winner) {
        print("\nHa ganado " + winner);
    }

    public void printExpGained(float exp) {
        print(exp + " puntos de experiencia ganados");
        Waiter.sleep(SHORT_WAIT);
    }
}
