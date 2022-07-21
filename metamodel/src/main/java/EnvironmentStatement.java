public class EnvironmentStatement {
    protected int id;

    protected String name;
    protected String statement;

    public EnvironmentStatement(int id, String name, String statement) {
        this.id = id;
        this.name = name;
        this.statement = statement;
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

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

}
