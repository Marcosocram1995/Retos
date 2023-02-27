package model.type;

import model.Effectiveness;

import java.util.ArrayList;
import java.util.Arrays;

public class TypeNormal extends Type {
    public static final String NAME = "NORMAL";

    public TypeNormal() {
        super(NAME);
    }

    @Override
    protected void createMap() {
        Arrays.stream(Effectiveness.values())
                .forEach(effectiveness -> getEffectivenessList().put(effectiveness, new ArrayList<>()));

        getEffectivenessList().get(Effectiveness.MEDIUM).add(this.getName());
    }
}