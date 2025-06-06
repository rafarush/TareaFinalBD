package models;

import java.sql.Date;

public class Test {
    private String testCode;
    private String testType;
    private Date date;
    private boolean result;
    private String entityName;
    private String examinerName;
    private String driverId;
    private String licenseType;

    public Test() {}

    public Test(String testCode, String testType, Date date, boolean result, String entityName,
                String examinerName, String driverId, String licenseType) {
        setTestCode(testCode);
        setTestType(testType);
        setDate(date);
        setResult(result);
        setEntityName(entityName);
        setExaminerName(examinerName);
        setDriverId(driverId);
        setLicenseType(licenseType);
    }

    public String getTestCode() { return testCode; }
    public void setTestCode(String testCode) { this.testCode = testCode; }

    public String getTestType() { return testType; }
    public void setTestType(String testType) { this.testType = testType; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public boolean getResult() { return result; }
    public void setResult(boolean result) { this.result = result; }

    public String getEntityName() { return entityName; }
    public void setEntityName(String entityName) { this.entityName = entityName; }

    public String getExaminerName() { return examinerName; }
    public void setExaminerName(String examinerName) { this.examinerName = examinerName; }

    public String getDriverId() { return driverId; }
    public void setDriverId(String driverId) { this.driverId = driverId; }

    public String getLicenseType() { return licenseType; }
    public void setLicenseType(String licenseType) { this.licenseType = licenseType; }
}
