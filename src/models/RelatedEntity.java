package models;

public class RelatedEntity {
    private String entityName;
    private String entityType;
    private String address;
    private String phone;
    private String contactEmail;
    private String directorName;
    private String centerCode;

    public RelatedEntity() {}

    public RelatedEntity(String entityName, String entityType, String address, String phone, String contactEmail,
                         String directorName, String centerCode) {
        setEntityName(entityName);
        setEntityType(entityType);
        setAddress(address);
        setPhone(phone);
        setContactEmail(contactEmail);
        setDirectorName(directorName);
        setCenterCode(centerCode);
    }

    public String getEntityName() {
        return entityName; }

    public void setEntityName(String entityName) {
        this.entityName = entityName; }

    public String getEntityType() {
        return entityType; }

    public void setEntityType(String entityType) {
        this.entityType = entityType; }

    public String getAddress() {
        return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhone() {
        return phone; }

    public void setPhone(String phone) {
        this.phone = phone; }

    public String getContactEmail() {
        return contactEmail; }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail; }

    public String getDirectorName() {
        return directorName; }
    public void setDirectorName(String directorName) {
        this.directorName = directorName; }

    public String getCenterCode() {
        return centerCode; }
    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode; }
}
