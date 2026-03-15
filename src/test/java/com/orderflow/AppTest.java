package com.orderflow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void loadConfig_loadsFromClasspathYaml() {
        AppConfig config = App.loadConfig();
        assertNotNull(config);
        assertEquals("Orderflow", config.getAppName());
        assertEquals("dev", config.getEnv());
        assertEquals("USD", config.getCurrency());
    }
}
