package metamodel;

import java.util.List;

public class Microcontroller {
    private int id;
    private String name;
    private long baudRate;
    private List<Port> ports;

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

    public long getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(long baudRate) {
        this.baudRate = baudRate;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

}
