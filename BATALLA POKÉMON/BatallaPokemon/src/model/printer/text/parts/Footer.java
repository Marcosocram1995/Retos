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
        appendFooter();
    }

    private void appendFooter() {
        footer.append(voidSpace);
        footer.append(line);
    }
}
