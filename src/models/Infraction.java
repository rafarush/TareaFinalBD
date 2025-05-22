package models;

import java.sql.Date;

public class Infraction {
    private String infractionCode;
    private int licenseId;
    private String violationType;
    private Date date;
    private String location;
    private String description;
    private int points;
    private boolean ispaid;

    public Infraction() {}

    public Infraction(String infractionCode, int licenseId, String violationType, Date date, String location,
                      String description, int points, boolean ispaid) {
        setInfractionCode(infractionCode);
        setLicenseId(licenseId);
        setViolationType(violationType);
        setDate(date);
        setLocation(location);
        setDescription(description);
        setPoints(points);
        setIspaid(ispaid);
    }

    public String getInfractionCode() {
        return infractionCode; }

    public void setInfractionCode(String infractionCode) {
        this.infractionCode = infractionCode; }

    public int getLicenseId() {
        return licenseId; }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId; }

    public String getViolationType() {
        return violationType; }

    public void setViolationType(String violationType) {
        this.violationType = violationType; }

    public Date getDate() {
        return date; }

    public void setDate(Date date) {
        this.date = date; }

    public String getLocation() {
        return location; }

    public void setLocation(String location) {
        this.location = location; }

    public String getDescription() {
        return description; }

    public void setDescription(String description) {
        this.description = description; }

    public int getPoints() {
        return points; }

    public void setPoints(int points) {
        this.points = points; }

    public boolean getIspaid() {
        return ispaid;
    }

    public void setIspaid(boolean ispaid) {
        this.ispaid = ispaid;
    }
}
