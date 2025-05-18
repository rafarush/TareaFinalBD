package models;

public class LicenseStatus {
    private String licenseStatus;

    public LicenseStatus() {}

    public LicenseStatus(String licenseStatus) {
        setLicenseStatus(licenseStatus);
    }

    public String getLicenseStatus() {
        return licenseStatus;
    }

    public void setLicenseStatus(String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }
}
