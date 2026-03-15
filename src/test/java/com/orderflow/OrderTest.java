package com.orderflow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void addLine_andGetTotal() {
        Order order = new Order("O1", "U1", "USD");
        order.addLine(new Product("P1", "Widget", "USD", 10.0), 2);
        order.addLine(new Product("P2", "Gadget", "USD", 5.0), 1);
        assertEquals(2, order.getLines().size());
        assertEquals(25.0, order.getTotal(), 0.001);
    }

    @Test
    void getLines_isUnmodifiable() {
        Order order = new Order("O1", "U1", "USD");
        order.addLine(new Product("P1", "X", "USD", 1.0), 1);
        assertThrows(UnsupportedOperationException.class, () ->
            order.getLines().add(new Order.OrderLine("P2", "Y", 2.0, 1))
        );
    }

    @Test
    void constructor_rejectsNullId() {
        assertThrows(NullPointerException.class, () -> new Order(null, "U1", "USD"));
    }
}
