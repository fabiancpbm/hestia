public class Pin {
    private int id;
    private String name;
    private String isAnalog;
    private String isInput;
    private Port port;

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

    public String getIsAnalog() {
        return isAnalog;
    }

    public void setIsAnalog(String isAnalog) {
        this.isAnalog = isAnalog;
    }

    public String getIsInput() {
        return isInput;
    }

    public void setIsInput(String isInput) {
        this.isInput = isInput;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

}
