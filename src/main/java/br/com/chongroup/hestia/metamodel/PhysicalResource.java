package br.com.chongroup.hestia.metamodel;

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

    public PhysicalResource(int id, String name, String description) {
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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public List<PhysicalResource> getChildResources() {
        return childResources;
    }

    public void setChildResources(List<PhysicalResource> childResources) {
        this.childResources = childResources;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

}
