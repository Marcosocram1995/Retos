package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Checker {
    private final HashSet<Long> ids;
    private final List<Product> productList;

    public Checker(List<Product> products) {
        this.productList = products;
        this.ids = new HashSet<>();
    }

    public boolean isRepeated() {
        return productList.stream()
                .map(product -> ids.add(product.getId()))
                .toList().contains(false);
    }

    public List<Product> getWithoutRepeated() {
        List<Product> listWhitoutRepeated = new ArrayList<>();
        ids.forEach(aLong ->
                listWhitoutRepeated.add(productList.stream()
                        .filter(product -> product.getId() == aLong)
                        .findFirst().orElseThrow())
        );
        return listWhitoutRepeated;
    }
}
