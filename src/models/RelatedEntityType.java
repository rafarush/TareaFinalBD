package models;

public class RelatedEntityType {
    private String relatedEntityType;
    public RelatedEntityType() {}

    public RelatedEntityType(String relatedEntityType) {
        setRelatedEntityType(relatedEntityType);
    }

    public String getRelatedEntityType() {
        return relatedEntityType;
    }

    public void setRelatedEntityType(String relatedEntityType) {
        this.relatedEntityType = relatedEntityType;
    }

}