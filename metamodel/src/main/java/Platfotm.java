import java.util.List;
import java.util.Map;

public class Platfotm {
    private int id;
    private String name;
    private String description;
    private MASSystem masSystem;
    private List<PhysicalResource> physicalResources;
    private Map<String, Microcontroller> portMicrocontrollerMap;

    public Platfotm(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MASSystem getMasSystem() {
        return masSystem;
    }

    public void setMasSystem(MASSystem masSystem) {
        this.masSystem = masSystem;
    }

    public List<PhysicalResource> getPhysicalResources() {
        return physicalResources;
    }

    public void setPhysicalResources(List<PhysicalResource> physicalResources) {
        this.physicalResources = physicalResources;
    }

    public Map<String, Microcontroller> getPortMicrocontrollerMap() {
        return portMicrocontrollerMap;
    }

    public void setPortMicrocontrollerMap(Map<String, Microcontroller> portMicrocontrollerMap) {
        this.portMicrocontrollerMap = portMicrocontrollerMap;
    }
}
