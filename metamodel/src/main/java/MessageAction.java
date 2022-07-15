public class MessageAction extends Action {
    private String parameter;

    private Agent to;

    private MessageSchema template;

    public MessageAction(int id, String name, String description, Agent to, int order) {
        super(id, name, description, order);
        this.to = to;
    }

    public MessageAction(int id, String name, String description, Agent to, int order, String... params) {
        super(id, name, description, order, params);
        this.to = to;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public MessageSchema getTemplate() {
        return template;
    }

    public void setTemplate(MessageSchema template) {
        this.template = template;
    }

}
