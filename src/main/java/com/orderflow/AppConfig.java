package com.orderflow;

import java.util.Map;

/**
 * Loaded from application.yaml; holds app name, env, and catalog defaults.
 */
public class AppConfig {
    private String appName;
    private String env;
    private int defaultPageSize;
    private String currency;

    @SuppressWarnings("unchecked")
    public static AppConfig fromYaml(Map<String, Object> yaml) {
        AppConfig c = new AppConfig();
        if (yaml.containsKey("app")) {
            Map<String, Object> app = (Map<String, Object>) yaml.get("app");
            c.appName = (String) app.get("name");
            c.env = (String) app.get("env");
        }
        if (yaml.containsKey("catalog")) {
            Map<String, Object> catalog = (Map<String, Object>) yaml.get("catalog");
            c.defaultPageSize = catalog.containsKey("defaultPageSize")
                ? ((Number) catalog.get("defaultPageSize")).intValue()
                : 10;
            c.currency = (String) catalog.get("currency");
        }
        return c;
    }

    public String getAppName() { return appName; }
    public String getEnv() { return env; }
    public int getDefaultPageSize() { return defaultPageSize; }
    public String getCurrency() { return currency; }
}
