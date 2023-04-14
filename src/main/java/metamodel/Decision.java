package metamodel;

import java.util.ArrayList;
import java.util.List;

public class Decision extends Block {
    private String condition;

    private List<Block> trueBlocks = new ArrayList<>();

    private List<Block> falseBlocks = new ArrayList<>();

    public Decision(int id, int order, String condition) {
        super(id, order);
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<Block> getTrueBlocks() {
        return trueBlocks;
    }

    public void setTrueBlocks(List<Block> trueBlocks) {
        this.trueBlocks = trueBlocks;
    }

    public List<Block> getFalseBlocks() {
        return falseBlocks;
    }

    public void setFalseBlocks(List<Block> falseBlocks) {
        this.falseBlocks = falseBlocks;
    }
}
