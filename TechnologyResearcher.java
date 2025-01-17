Java
import java.util.HashMap;
import java.util.Map;

public class TechnologyResearcher {

    // Define the research costs as constants
    private static final Map<String, Map<String, Integer>> RESEARCH_COST = new HashMap<>();
    static {
        Map<String, Integer> tech1Cost = new HashMap<>();
        tech1Cost.put("metal", 200);
        tech1Cost.put("crystal", 100);
        RESEARCH_COST.put("Tech1", tech1Cost);

        Map<String, Integer> tech2Cost = new HashMap<>();
        tech2Cost.put("metal", 300);
        tech2Cost.put("crystal", 150);
        RESEARCH_COST.put("Tech2", tech2Cost);

        // Add more technologies and their costs as needed
    }

    public static boolean researchTechnology(String tech, Map<String, Integer> resources) {
        Map<String, Integer> cost = RESEARCH_COST.get(tech);
        if (resources.get("metal") >= cost.get("metal") && resources.get("crystal") >= cost.get("crystal")) {
            resources.put("metal", resources.get("metal") - cost.get("metal"));
            resources.put("crystal", resources.get("crystal") - cost.get("crystal"));
            return true; // Research successful
        }
        return false; // Not enough resources
    }

    public static void main(String[] args) {
        // Example usage
        Map<String, Integer> resources = new HashMap<>();
        resources.put("metal", 500);
        resources.put("crystal", 200);

        boolean result = researchTechnology("Tech1", resources);
        System.out.println("Researching Tech1: " + (result ? "Success" : "Failure"));
        System.out.println("Remaining Resources: " + resources);
    }
}
