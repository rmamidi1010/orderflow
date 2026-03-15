package com.orderflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Order entity: belongs to a user and contains product line items. */
public class Order {
    private final String id;
    private final String userId;
    private final List<OrderLine> lines;
    private final String currency;

    public Order(String id, String userId, String currency) {
        this.id = Objects.requireNonNull(id, "id");
        this.userId = Objects.requireNonNull(userId, "userId");
        this.currency = currency != null ? currency : "USD";
        this.lines = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getCurrency() { return currency; }
    public List<OrderLine> getLines() { return Collections.unmodifiableList(lines); }

    public void addLine(Product product, int quantity) {
        lines.add(new OrderLine(product.getId(), product.getName(), product.getPrice(), quantity));
    }

    public double getTotal() {
        return lines.stream()
            .mapToDouble(line -> line.getUnitPrice() * line.getQuantity())
            .sum();
    }

    /** Single line in an order. */
    public static class OrderLine {
        private final String productId;
        private final String productName;
        private final double unitPrice;
        private final int quantity;

        public OrderLine(String productId, String productName, double unitPrice, int quantity) {
            this.productId = productId;
            this.productName = productName;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        public String getProductId() { return productId; }
        public String getProductName() { return productName; }
        public double getUnitPrice() { return unitPrice; }
        public int getQuantity() { return quantity; }
    }
}
