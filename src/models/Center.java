package models;

public class Center {
    private String centerCode;
    private String centerName;
    private String postalAddress;
    private String phone;
    private String centerEmail;
    private String generalDirectorName;
    private String hrManager;
    private String accountingManager;
    private String secretaryName;
    private String logo;

    public Center() {}

    public Center(String centerCode, String centerName, String postalAddress, String phone, String centerEmail,
                  String generalDirectorName, String hrManager, String accountingManager,
                  String secretaryName, String logo) {
        setCenterCode(centerCode);
        setCenterName(centerName);
        setPostalAddress(postalAddress);
        setPhone(phone);
        setCenterEmail(centerEmail);
        setGeneralDirectorName(generalDirectorName);
        setHrManager(hrManager);
        setAccountingManager(accountingManager);
        setSecretaryName(secretaryName);
        setLogo(logo);
    }

    public String getCenterCode() {
        return centerCode; }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode; }

    public String getCenterName() {
        return centerName; }

    public void setCenterName(String centerName) {
        this.centerName = centerName; }

    public String getPostalAddress() {
        return postalAddress; }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress; }

    public String getPhone() {
        return phone; }

    public void setPhone(String phone) {
        this.phone = phone; }

    public String getCenterEmail() {
        return centerEmail; }

    public void setCenterEmail(String centerEmail) {
        this.centerEmail = centerEmail; }

    public String getGeneralDirectorName() {
        return generalDirectorName; }

    public void setGeneralDirectorName(String generalDirectorName) {
        this.generalDirectorName = generalDirectorName; }

    public String getHrManager() {
        return hrManager; }

    public void setHrManager(String hrManager) {
        this.hrManager = hrManager; }

    public String getAccountingManager() {
        return accountingManager; }

    public void setAccountingManager(String accountingManager) {
        this.accountingManager = accountingManager; }

    public String getSecretaryName() {
        return secretaryName; }

    public void setSecretaryName(String secretaryName) {
        this.secretaryName = secretaryName; }

    public String getLogo() {
        return logo; }

    public void setLogo(String logo) {
        this.logo = logo; }
}