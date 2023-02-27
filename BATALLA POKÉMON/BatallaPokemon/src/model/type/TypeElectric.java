package model.type;

import model.Effectiveness;

import java.util.List;

public class TypeElectric extends Type {
    public static final String NAME = "ELÉCTRICO";

    public TypeElectric() {
        super(NAME);
        putEffectiveness(Effectiveness.LOW, List.of(TypePlant.NAME));
        putEffectiveness(Effectiveness.MEDIUM, List.of(TypeFire.NAME));
        putEffectiveness(Effectiveness.SUPER, List.of(TypeWater.NAME));
    }
}