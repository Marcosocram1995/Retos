package model;

import model.type.Type;

public enum Effectiveness {
    SUPER(1, "súper"), MEDIUM(0.5f, ""), LOW(0.25f, "poco");
    private final float multiplier;
    private final String name;

    public float getMultiplier() {
        return multiplier;
    }

    public String getName() {
        return name;
    }

    Effectiveness(float multiplier, String name) {
        this.multiplier = multiplier;
        this.name = name;
    }

    public static Effectiveness calculateEffectiveness(Type firstType, Type secondType) {
        final Effectiveness[] effectiveness = {MEDIUM};

        firstType.getEffectivenessList().entrySet().stream().
                filter(effectivenessList ->
                        effectivenessList.getValue().contains(secondType.getName()))
                .findFirst().ifPresent(effectivenessListEntry -> effectiveness[0] = effectivenessListEntry.getKey());

        return effectiveness[0];
    }
}