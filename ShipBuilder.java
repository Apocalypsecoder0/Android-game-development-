Java
import java.util.HashMap;
import java.util.Map;

public class ShipBuilder {

    // Define the ship costs as constants
    private static final Map<String, Map<String, Integer>> SHIP_COST = new HashMap<>();
    static {
        Map<String, Integer> fighterShipCost = new HashMap<>();
        fighterShipCost.put("metal", 300);
        fighterShipCost.put("crystal", 200);
        fighterShipCost.put("deuterium", 100);
        SHIP_COST.put("FighterShip", fighterShipCost);

        Map<String, Integer> cruiserShipCost = new HashMap<>();
        cruiserShipCost.put("metal", 600);
        cruiserShipCost.put("crystal", 400);
        cruiserShipCost.put("deuterium", 300);
        SHIP_COST.put("CruiserShip", cruiserShipCost);

        // Add more ships and their costs as needed
    }

    public static boolean buildShip(String type, Map<String, Integer> resources) {
        Map<String, Integer> cost = SHIP_COST.get(type);
        if (resources.get("metal") >= cost.get("metal") &&
            resources.get("crystal") >= cost.get("crystal") &&
            resources.get("deuterium") >= cost.get("deuterium")) {
            resources.put("metal", resources.get("metal") - cost.get("metal"));
            resources.put("crystal", resources.get("crystal") - cost.get("crystal"));
            resources.put("deuterium", resources.get("deuterium") - cost.get("deuterium"));
            return true; // Ship building successful
        }
        return false; // Not enough resources
    }

    public static void main(String[] args) {
        // Example usage
        Map<String, Integer> resources = new HashMap<>();
        resources.put("metal", 1000);
        resources.put("crystal", 800);
        resources.put("deuterium", 500);

        boolean result = buildShip("FighterShip", resources);
        System.out.println("Building FighterShip: " + (result ? "Success" : "Failure"));
        System.out.println("Remaining Resources: " + resources);
    }
}
