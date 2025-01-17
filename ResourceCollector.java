Java
import java.util.HashMap;
import java.util.Map;

public class ResourceCollector {

    // Define the production rates as constants
    private static final double METAL_PRODUCTION_RATE = 1.5; // Example rate
    private static final double CRYSTAL_PRODUCTION_RATE = 1.2; // Example rate
    private static final double DEUTERIUM_PRODUCTION_RATE = 0.8; // Example rate

    public static Map<String, Double> collectResources(Map<String, Integer> mines) {
        // Calculate the resources based on the production rates
        double metal = mines.get("metal") * METAL_PRODUCTION_RATE;
        double crystal = mines.get("crystal") * CRYSTAL_PRODUCTION_RATE;
        double deuterium = mines.get("deuterium") * DEUTERIUM_PRODUCTION_RATE;

        // Create a map to store the collected resources
        Map<String, Double> resources = new HashMap<>();
        resources.put("metal", metal);
        resources.put("crystal", crystal);
        resources.put("deuterium", deuterium);

        return resources;
    }

    public static void main(String[] args) {
        // Example usage
        Map<String, Integer> mines = new HashMap<>();
        mines.put("metal", 100);
        mines.put("crystal", 50);
        mines.put("deuterium", 30);

        Map<String, Double> resources = collectResources(mines);
        System.out.println("Collected Resources: " + resources);
    }
}
