package model.printer.text.parts;

import model.movement.Movement;
import model.printer.text.StaticText;

import java.util.List;

public class Body extends StaticText {
    private final StringBuilder body;

    public String getBody() {
        return body.toString();
    }

    protected Body(String symbol, int size, List<Movement> movementList) {
        super(symbol, size);
        this.body = new StringBuilder();
        appendMovementList(movementList, size);
        removeLineBreak();
    }

    private void appendMovementList(List<Movement> movements, int size) {
        for (int i = 0; i < movements.size(); i++) {
            String text = (i + 1) + WHITE_SPACE + movements.get(i).getName();
            body.append(appendText(text, size));
        }
    }

    private void removeLineBreak() {
        body.setCharAt(body.length() - 1, StaticText.WHITE_SPACE.charAt(0));
    }
}
