package com.evpa.licenses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
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

    public License(String licenseId, String organizationId, String productName, String licenseType) {
        this.licenseId = licenseId;
        this.organizationId = organizationId;
        this.productName = productName;
        this.licenseType = licenseType;
    }

    public License withId(String licenseId){
        this.setLicenseId(licenseId);
        return this;
    }

    public License withOrganizationId(String organizationId){
        this.setOrganizationId(organizationId);
        return this;
    }

    public License withProductName(String productName){
        this.setProductName(productName);
        return this;
    }

    public License withLicenseType(String licenseType){
        this.setLicenseType(licenseType);
        return this;
    }

    //public License withComment(String comment) {
    //}
}
