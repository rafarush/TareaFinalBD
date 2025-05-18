package models;

public class InfractionType {
    private String infractionType;

    public InfractionType() {}

    public InfractionType(String infractionType) {
        setInfractionType(infractionType);
    }

    public String getInfractionType() {
        return infractionType;
    }

    public void setInfractionType(String infractionType) {
        this.infractionType = infractionType;
    }
}
