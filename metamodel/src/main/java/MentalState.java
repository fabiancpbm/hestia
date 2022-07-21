import java.util.List;

public class MentalState {
    private int id;
    private List<Belief> initialBeliefs;

    private List<AgentGoal> initialGoals;

    public MentalState(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Belief> getInitialBeliefs() {
        return initialBeliefs;
    }

    public void setInitialBeliefs(List<Belief> initialBeliefs) {
        this.initialBeliefs = initialBeliefs;
    }

    public List<AgentGoal> getInitialGoals() {
        return initialGoals;
    }

    public void setInitialGoals(List<AgentGoal> initialGoals) {
        this.initialGoals = initialGoals;
    }
}
