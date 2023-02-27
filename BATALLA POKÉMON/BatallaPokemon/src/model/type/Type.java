package model.type;


import model.Effectiveness;

import java.util.*;

public abstract class Type {
    private final String name;
    private final EnumMap<Effectiveness, List<String>> effectivenessList;

    public Map<Effectiveness, List<String>> getEffectivenessList() {
        return effectivenessList;
    }

    public String getName() {
        return name;
    }

    protected Type(String name) {
        this.name = name;
        this.effectivenessList = new EnumMap<>(Effectiveness.class);
        createMap();
    }

    protected void createMap() {
        Arrays.stream(Effectiveness.values())
                .forEach(effectiveness -> effectivenessList.put(effectiveness, new ArrayList<>()));
        effectivenessList.get(Effectiveness.MEDIUM).add(TypeNormal.NAME);
        effectivenessList.get(Effectiveness.LOW).add(this.name);
    }

    protected void putEffectiveness(Effectiveness effectiveness, List<String> typeList) {
        effectivenessList.get(effectiveness).addAll(typeList);
    }
}
