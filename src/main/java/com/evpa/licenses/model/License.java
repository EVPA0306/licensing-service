package com.evpa.licenses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "licenses")
public class License {
    @Id
    //@GeneratedValue
    @Column(name = "license_id", nullable = false)
    private String licenseId;
    @Column(name = "organization_id", nullable = false)
    private String organizationId;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "license_type")
    private String licenseType;

    public License() {}

    public License(String licenseId, String organizationId, String productName, String licenseType) {
        this.licenseId = licenseId;
        this.organizationId = organizationId;
        this.productName = productName;
        this.licenseType = licenseType;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public License withId(String licenseId){
        setLicenseId(licenseId);
        return this;
    }

    public License withOrganizationId(String organizationId){
        setOrganizationId(organizationId);
        return this;
    }

    public License withProductName(String productName){
        setProductName(productName);
        return this;
    }

    public License withLicenseType(String licenseType){
        setLicenseType(licenseType);
        return this;
    }

    //public License withComment(String comment) {
    //}
}
