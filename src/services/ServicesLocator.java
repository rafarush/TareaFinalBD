package services;

public class ServicesLocator {
    // ServicesLocator (Singleton)
    private static ServicesLocator instance;

    // Services instances
    private final CenterServices centerServices;
    private final DriverServices driverServices;
    private final InfractionServices infractionServices;
    private final InfractionTypeServices infractionTypeServices;
    private final LicenseCategoryServices licenseCategoryServices;
    private final LicenseServices licenseServices;
    private final LicenseStatusServices licenseStatusServices;
    private final RelatedEntityServices relatedEntityServices;
    private final RelatedEntityTypeServices relatedEntityTypeServices;
    private final TestServices testServices;
    private final TestTypeServices testTypeServices;

    
    private ServicesLocator(CenterServices centerServices, DriverServices driverServices, InfractionServices infractionServices,
                            InfractionTypeServices infractionTypeServices, LicenseCategoryServices licenseCategoryServices,
                            LicenseServices licenseServices, LicenseStatusServices licenseStatusServices,
                            RelatedEntityServices relatedEntityServices, RelatedEntityTypeServices relatedEntityTypeServices,
                            TestServices testServices, TestTypeServices testTypeServices) {
        this.centerServices = centerServices;
        this.driverServices = driverServices;
        this.infractionServices = infractionServices;
        this.infractionTypeServices = infractionTypeServices;
        this.licenseCategoryServices = licenseCategoryServices;
        this.licenseServices = licenseServices;
        this.licenseStatusServices = licenseStatusServices;
        this.relatedEntityServices = relatedEntityServices;
        this.relatedEntityTypeServices = relatedEntityTypeServices;
        this.testServices = testServices;
        this.testTypeServices = testTypeServices;
    }

    public static ServicesLocator getInstance() {
        if (instance == null) {
            instance = new ServicesLocator(new CenterServices(), new DriverServices(), new InfractionServices(),
                    new InfractionTypeServices(), new LicenseCategoryServices(), new LicenseServices(), new LicenseStatusServices(),
                    new RelatedEntityServices(), new RelatedEntityTypeServices(), new TestServices(), new TestTypeServices());
        }
        return instance;
    }

    public CenterServices getCenterServices() {
        return centerServices;
    }

    public DriverServices getDriverServices() {
        return driverServices;
    }

    public InfractionServices getInfractionServices() {
        return infractionServices;
    }

    public InfractionTypeServices getInfractionTypeServices() {
        return infractionTypeServices;
    }

    public LicenseCategoryServices getLicenseCategoryServices() {
        return licenseCategoryServices;
    }

    public LicenseServices getLicenseServices() {
        return licenseServices;
    }

    public LicenseStatusServices getLicenseStatusServices() {
        return licenseStatusServices;
    }

    public RelatedEntityServices getRelatedEntityServices() {
        return relatedEntityServices;
    }

    public RelatedEntityTypeServices getRelatedEntityTypeServices() {
        return relatedEntityTypeServices;
    }

    public TestServices getTestServices() {
        return testServices;
    }

    public TestTypeServices getTestTypeServices() {
        return testTypeServices;
    }
}

