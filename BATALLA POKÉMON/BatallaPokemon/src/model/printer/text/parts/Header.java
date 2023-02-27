package model.printer.text.parts;

import model.printer.text.StaticText;

public class Header extends StaticText {
    private final StringBuilder header;

    public String getHeader() {
        return header.toString();
    }

    protected Header(String symbol, int size, String versus) {
        super(symbol, size);
        header = new StringBuilder();
        appendHeader(versus);
    }

    private void appendHeader(String versus) {
        header.append(line);
        header.append(versus).append(SEPARATION);
        header.append(voidSpace);
    }
}
