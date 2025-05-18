package models;

import java.sql.Date;

public class License {
    private int licenseId;
    private int driverId;
    private String licenseType;
    private Date issueDate;
    private Date expirationDate;
    private String restrictions;
    private boolean renewed;
    private String licenseStatus;

    public License() {}

    public License(int licenseId, int driverId, String licenseType, Date issueDate, Date expirationDate,
                   String restrictions, boolean renewed, String licenseStatus) {
        setLicenseId(licenseId);
        setDriverId(driverId);
        setLicenseType(licenseType);
        setIssueDate(issueDate);
        setExpirationDate(expirationDate);
        setRestrictions(restrictions);
        setRenewed(renewed);
        setLicenseStatus(licenseStatus);
    }

    public int getLicenseId() {
        return licenseId; }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId; }

    public int getDriverId() {
        return driverId; }

    public void setDriverId(int driverId) {
        this.driverId = driverId; }

    public String getLicenseType() {
        return licenseType; }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType; }

    public Date getIssueDate() {
        return issueDate; }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate; }

    public Date getExpirationDate() {
        return expirationDate; }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate; }

    public String getRestrictions() {
        return restrictions; }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions; }

    public boolean isRenewed() {
        return renewed; }

    public void setRenewed(boolean renewed) {
        this.renewed = renewed; }

    public String getLicenseStatus() {
        return licenseStatus; }

    public void setLicenseStatus(String licenseStatus) {
        this.licenseStatus = licenseStatus; }
}
