import java.util.ArrayList;
import java.util.List;

public class ReadFromPin extends Assignment {

    private static final Function TARGET_FUNCTION = new Function();
    Pin pin;

    public ReadFromPin(int id, int order, Value variable, Pin pin) {
        super(id, order, TARGET_FUNCTION, new ArrayList<>(), variable);
        this.pin = pin;
    }
}
