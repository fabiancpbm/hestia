import java.util.List;

public class Environment {
    private int id;
    private String name;
    private String description;
    private List<Resource> resources;
    private List<FacetDefinition> facets;
    private List<Agent> agents;

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

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<FacetDefinition> getFacets() {
        return facets;
    }

    public void setFacets(List<FacetDefinition> facets) {
        this.facets = facets;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

}
