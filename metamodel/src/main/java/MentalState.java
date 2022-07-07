import java.util.List;

public class MentalState {
    private int id;
    private List<Belief> initialBeliefs;

    public List<Belief> getInitialBeliefs() {
        return initialBeliefs;
    }

    public void setInitialBeliefs(List<Belief> initialBeliefs) {
        this.initialBeliefs = initialBeliefs;
    }

    private List<AgentGoal> initialGoals;
}
