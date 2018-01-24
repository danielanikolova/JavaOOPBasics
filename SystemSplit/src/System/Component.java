package System;

public class Component {
    private String name;
    private String type;


    Component(String name) {
        this.name = name;
    }


    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}
