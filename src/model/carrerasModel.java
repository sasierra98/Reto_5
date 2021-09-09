package model;

public class carrerasModel {

    private String name, capability;
    private int capacity;
    private float difficulty;

    public carrerasModel(){}

    public carrerasModel(String name){
        this.name = name;
    }

    public carrerasModel(String name, int capacity, String capability, float difficulty){
        this.name = name;
        this.capacity = capacity;
        this.capability = capability;
        this.difficulty = difficulty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDifficulty(float difficulty) {
        this.difficulty = difficulty;
    }

    public float getDifficulty() {
        return difficulty;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public Object[] toArray() {
        return new Object[]{name, capacity, capability, difficulty};
    }
}
