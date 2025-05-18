package models;

public class LicenseCategory {
    private String licenseType;
    private String licenseCategory;

    public LicenseCategory() {}

    public LicenseCategory(String licenseType, String licenseCategory) {
        setLicenseType(licenseType);
        setLicenseCategory(licenseCategory);
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getLicenseCategory() {
        return licenseCategory;
    }

    public void setLicenseCategory(String licenseCategory) {
        this.licenseCategory = licenseCategory;
    }
}
