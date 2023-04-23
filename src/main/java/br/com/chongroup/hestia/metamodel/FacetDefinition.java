package br.com.chongroup.hestia.metamodel;

public class FacetDefinition {
    private int id;
    private String name;
    private String dataType;
    private boolean canBeSensed;
    private boolean canBeChanged;
    private String initialValue;
    private boolean canChange;

    public FacetDefinition(int id, String name, String dataType) {
        this.id = id;
        this.name = name;
        this.dataType = dataType;
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isCanBeSensed() {
        return canBeSensed;
    }

    public void setCanBeSensed(boolean canBeSensed) {
        this.canBeSensed = canBeSensed;
    }

    public boolean isCanBeChanged() {
        return canBeChanged;
    }

    public void setCanBeChanged(boolean canBeChanged) {
        this.canBeChanged = canBeChanged;
    }

    public String getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(String initialValue) {
        this.initialValue = initialValue;
    }

    public boolean isCanChange() {
        return canChange;
    }

    public void setCanChange(boolean canChange) {
        this.canChange = canChange;
    }
}
