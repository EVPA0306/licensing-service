package com.evpa.licenses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "licenses")
public class License extends RepresentationModel<License> {
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
}
