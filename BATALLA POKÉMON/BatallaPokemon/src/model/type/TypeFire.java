package model.type;

import model.Effectiveness;

import java.util.List;

public class TypeFire extends Type {
    public static final String NAME = "FUEGO";

    public TypeFire() {
        super(NAME);
        putEffectiveness(Effectiveness.LOW, List.of(TypeWater.NAME));
        putEffectiveness(Effectiveness.MEDIUM, List.of(TypeElectric.NAME));
        putEffectiveness(Effectiveness.SUPER, List.of(TypePlant.NAME));
    }
}