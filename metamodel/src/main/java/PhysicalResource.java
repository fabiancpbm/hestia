import java.util.List;

public class PhysicalResource {
    private int id;
    private String name;
    private String description;
    private Resource resource;
    private List<Topic> topics;
    private List<Command> commands;
    private List<PhysicalResource> childResources;
    private List<Component> components;
}
