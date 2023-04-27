package br.com.chongroup.hestia.metamodel;

public class Pin {
    private int id;
    private String name;
    private boolean isAnalog;
    private boolean isInput;
    private Port port;

    public Pin(int id, String name, boolean isAnalog, boolean isInput) {
        this.id = id;
        this.name = name;
        this.isAnalog = isAnalog;
        this.isInput = isInput;
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

    public boolean getIsAnalog() {
        return isAnalog;
    }

    public void setIsAnalog(boolean isAnalog) {
        this.isAnalog = isAnalog;
    }

    public boolean getIsInput() {
        return isInput;
    }

    public void setIsInput(boolean isInput) {
        this.isInput = isInput;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

}
