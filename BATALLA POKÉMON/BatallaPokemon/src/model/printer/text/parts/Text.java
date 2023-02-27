package model.printer.text.parts;

import model.movement.Movement;

import java.util.List;

public class Text {
    private final Header header;
    private final Body body;
    private final Footer footer;

    public String getHeader() {
        return header.getHeader();
    }

    public String getBody() {
        return body.getBody();
    }

    public String getFooter() {
        return footer.getFooter();
    }

    public Text(String symbol, String firstPokemon, String secondPokemon, List<Movement> movements) {
        String versus = getVersus(symbol, firstPokemon, secondPokemon);
        int size = versus.length();
        header = new Header(symbol, size, versus);
        body = new Body(symbol, size, movements);
        footer = new Footer(symbol, size);
    }

    private String getVersus(String symbol, String firstPokemon, String secondPokemon) {
        return symbol + " " + firstPokemon + " VS " + secondPokemon + " " + symbol;
    }
}
