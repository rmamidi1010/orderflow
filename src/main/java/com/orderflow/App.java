package com.orderflow;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Stage 1 console app: reads YAML config, uses entities and collections.
 */
public class App {

    public static void main(String[] args) {
        AppConfig config = loadConfig();
        if (config == null) {
            System.err.println("Could not load application.yaml");
            return;
        }

        System.out.println(config.getAppName() + " (" + config.getEnv() + ")");
        System.out.println("Currency: " + config.getCurrency() + ", default page size: " + config.getDefaultPageSize());
        System.out.println();

        // Use entities and collections
        List<Product> catalog = List.of(
            new Product("P1", "Widget", config.getCurrency(), 9.99),
            new Product("P2", "Gadget", config.getCurrency(), 24.50)
        );
        Set<String> productIds = Set.of("P1", "P2");
        User user = new User("U1", "alice@example.com");
        Order order = new Order("O1", user.getId(), config.getCurrency());
        order.addLine(catalog.get(0), 2);
        order.addLine(catalog.get(1), 1);

        System.out.println("Order " + order.getId() + " for user " + user.getEmail());
        order.getLines().forEach(line ->
            System.out.println("  " + line.getQuantity() + " x " + line.getProductName() + " @ " + line.getUnitPrice())
        );
        System.out.println("Total: " + config.getCurrency() + " " + String.format("%.2f", order.getTotal()));
    }

    @SuppressWarnings("unchecked")
    static AppConfig loadConfig() {
        Yaml yaml = new Yaml();
        try (InputStream in = App.class.getResourceAsStream("/application.yaml")) {
            if (in == null) return null;
            Map<String, Object> map = yaml.load(in);
            return AppConfig.fromYaml(map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
