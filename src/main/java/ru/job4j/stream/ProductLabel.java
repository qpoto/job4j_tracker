package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> product.getStandard() - product.getActual() >= 0)
                .filter(product.getStandard() - product.getActual() <= 0)
                .product.getsize/2
                .collect(Collectors.toList());
    }
}