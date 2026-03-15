package com.orderflow;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AppConfigTest {

    @Test
    void fromYaml_readsAppAndCatalog() {
        Map<String, Object> yaml = Map.of(
            "app", Map.of("name", "Orderflow", "env", "test"),
            "catalog", Map.of("defaultPageSize", 20, "currency", "EUR")
        );
        AppConfig c = AppConfig.fromYaml(yaml);
        assertEquals("Orderflow", c.getAppName());
        assertEquals("test", c.getEnv());
        assertEquals(20, c.getDefaultPageSize());
        assertEquals("EUR", c.getCurrency());
    }

    @Test
    void fromYaml_usesDefaultPageSizeWhenMissing() {
        Map<String, Object> yaml = Map.of(
            "app", Map.of("name", "App", "env", "dev"),
            "catalog", Map.of("currency", "USD")
        );
        AppConfig c = AppConfig.fromYaml(yaml);
        assertEquals(10, c.getDefaultPageSize());
    }
}
