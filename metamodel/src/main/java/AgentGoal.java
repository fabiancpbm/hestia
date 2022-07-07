public class AgentGoal extends EnvironmentStatement {
    private boolean commited;
    private Plan planDescriptor;

    public boolean isCommited() {
        return commited;
    }

    public void setCommited(boolean commited) {
        this.commited = commited;
    }

    public Plan getPlanDescriptor() {
        return planDescriptor;
    }

    public void setPlanDescriptor(Plan planDescriptor) {
        this.planDescriptor = planDescriptor;
    }

}
