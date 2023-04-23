package br.com.chongroup.hestia.metamodel;

import java.util.List;

public class Plan {
    private int id;
    private String name;
    private String description;
    private String failureCondition;

    /** The success condition to execute the plan. If this field is empty, this plan will be treated as a failure plan,
     * like -!plan <- someAction. */
    private String successCondition;
    private List<Action> actions;

    public Plan(int id, String name, String description) {
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

    public String getFailureCondition() {
        return failureCondition;
    }

    public void setFailureCondition(String failureCondition) {
        this.failureCondition = failureCondition;
    }

    public String getSuccessCondition() {
        return successCondition;
    }

    public void setSuccessCondition(String successCondition) {
        this.successCondition = successCondition;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

}
