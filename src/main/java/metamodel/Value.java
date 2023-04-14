package metamodel;

public class Value {
    private int id;
    private String name;
    private String content;
    private ValueType type;

    public Value(int id, String name, String content, ValueType type) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.type = type;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ValueType getType() {
        return type;
    }

    public void setType(ValueType type) {
        this.type = type;
    }

}
