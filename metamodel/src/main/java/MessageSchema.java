import java.util.Arrays;

public class MessageSchema {
    public static final MessageSchema TELL_MESSAGE_SCHEMA = new MessageSchema("tellMessageSchema", "ilocutionaryForce;message");
    private String name;
    private String parameterDefinition;

    public MessageSchema(String name, String parameterDefinition) {
        this.name = name;
        this.parameterDefinition = parameterDefinition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameterDefinition() {
        return parameterDefinition;
    }

    public void setParameterDefinition(String parameterDefinition) {
        this.parameterDefinition = parameterDefinition;
    }

}
