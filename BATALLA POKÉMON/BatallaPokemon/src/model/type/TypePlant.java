package model.type;

import model.Effectiveness;

import java.util.List;

public class TypePlant extends Type {
    public static final String NAME = "PLANTA";

    public TypePlant() {
        super(NAME);
        putEffectiveness(Effectiveness.LOW, List.of(TypeFire.NAME));
        putEffectiveness(Effectiveness.MEDIUM, List.of(TypeElectric.NAME));
        putEffectiveness(Effectiveness.SUPER, List.of(TypeWater.NAME));
    }
}