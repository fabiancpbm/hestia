import java.util.List;

public class MentalState {
    private int id;
    private List<Belief> initialBeliefs;

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

}
