package model.printer.text;

public abstract class StaticText {

    protected final String line;
    protected final String voidSpace;
    protected final String symbol;
    protected static final String WHITE_SPACE = " ";
    protected static final String SEPARATION = "\n";

    protected StaticText(String symbol, int size) {
        line = createLine(symbol, size);
        voidSpace = createVoidSpace(symbol, size);
        this.symbol = symbol;
    }

    private String createLine(String symbol, int size) {
        return SEPARATION + symbol.repeat(size) + SEPARATION;
    }

    private String createVoidSpace(String symbol, int size) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ".repeat(size));
        stringBuilder.setCharAt(0, symbol.charAt(0));
        stringBuilder.setCharAt(stringBuilder.length() - 1, symbol.charAt(0));
        return stringBuilder.toString();
    }

    protected StringBuilder appendText(String text, int size) {
        StringBuilder stringBuilder = new StringBuilder();
        appendInit(stringBuilder);
        stringBuilder.append(text);
        appendFinale(size, stringBuilder);
        return stringBuilder;
    }

    private void appendFinale(int size, StringBuilder stringBuilder) {
        int remainingSize = (size - stringBuilder.length() - 1);
        if (remainingSize < 0) {
            remainingSize = 0;
        }
        stringBuilder.append(StaticText.WHITE_SPACE.repeat((remainingSize))).append(symbol).append("\n");
    }

    private void appendInit(StringBuilder stringBuilder) {
        stringBuilder.append(symbol).append(StaticText.WHITE_SPACE);
    }
}