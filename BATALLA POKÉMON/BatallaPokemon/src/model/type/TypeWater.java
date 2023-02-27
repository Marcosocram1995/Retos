package model.type;

import model.Effectiveness;

import java.util.List;

public class TypeWater extends Type {
    public static final String NAME = "AGUA";

    public TypeWater() {
        super(NAME);
        putEffectiveness(Effectiveness.LOW, List.of(TypePlant.NAME));
        putEffectiveness(Effectiveness.MEDIUM, List.of(TypeElectric.NAME));
        putEffectiveness(Effectiveness.SUPER, List.of(TypeFire.NAME));
    }
}