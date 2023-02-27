package model.printer.text.parts;

import model.printer.text.StaticText;

public class Footer extends StaticText {
    private final StringBuilder footer;

    public String getFooter() {
        return footer.toString();
    }

    protected Footer(String symbol, int size) {
        super(symbol, size);
        this.footer = new StringBuilder();
        appendFooter(size);
    }

    private void appendFooter(int size) {
        footer.append(voidSpace).append(SEPARATION);
        appendChangePokemon(size);
        footer.append(voidSpace);
        footer.append(line);
    }

    private void appendChangePokemon(int size) {
        String text = "9 Cambiar Pokemon";
        footer.append(appendText(text, size));
    }
}
