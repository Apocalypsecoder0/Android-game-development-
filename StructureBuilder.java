Java
import java.util.HashMap;
import java.util.Map;

public class StructureBuilder {

    // Define the build costs as constants
    private static final Map<String, Map<String, Integer>> BUILD_COST = new HashMap<>();
    static {
        Map<String, Integer> metalStructureCost = new HashMap<>();
        metalStructureCost.put("metal", 100);
        metalStructureCost.put("crystal", 50);
        BUILD_COST.put("MetalStructure", metalStructureCost);

        Map<String, Integer> crystalStructureCost = new HashMap<>();
        crystalStructureCost.put("metal", 150);
        crystalStructureCost.put("crystal", 100);
        BUILD_COST.put("CrystalStructure", crystalStructureCost);

        // Add more structures and their costs as needed
    }

    public static boolean buildStructure(String type, Map<String, Integer> resources) {
        Map<String, Integer> cost = BUILD_COST.get(type);
        if (resources.get("metal") >= cost.get("metal") && resources.get("crystal") >= cost.get("crystal")) {
            resources.put("metal", resources.get("metal") - cost.get("metal"));
            resources.put("crystal", resources.get("crystal") - cost.get("crystal"));
            return true; // Building successful
        }
        return false; // Not enough resources
    }

    public static void main(String[] args) {
        // Example usage
        Map<String, Integer> resources = new HashMap<>();
        resources.put("metal", 200);
        resources.put("crystal", 150);

        boolean result = buildStructure("MetalStructure", resources);
        System.out.println("Building MetalStructure: " + (result ? "Success" : "Failure"));
        System.out.println("Remaining Resources: " + resources);
    }
}
