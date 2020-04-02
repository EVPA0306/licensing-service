package com.evpa.licenses.service;

import com.evpa.licenses.model.License;
import com.evpa.licenses.repository.LicenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LicenseService {

    private LicenseRepository licenseRepository;

    public License createLicense(final String organizationId) {

        final License license = new License()
                .withId(UUID.randomUUID().toString())
                .withOrganizationId(organizationId)
                .withProductName("Windows 10");

        return licenseRepository.save(license);
    }

    public License getLicense(String organizationId, String licenseId) {
        return licenseRepository.findByOrganizationIdAndLicenseId(organizationId,licenseId);
    }

    public List<License> getLicensesByOrg(String organizationId) {
        return licenseRepository.findByOrganizationId(organizationId);
    }

    public License getLicenseById(final String licenseId) {
        return licenseRepository.findByLicenseId(licenseId);
    }

    public List<License> getAll() {
        return licenseRepository.findAll();
    }

    public String deleteLicense(String organizationId, String licenseId) {
        License licenseForDeletion =
                licenseRepository.findByOrganizationIdAndLicenseId(organizationId,licenseId);
        licenseRepository.delete(licenseForDeletion);
        return licenseForDeletion.getLicenseId();
    }

    public License updateLicense(String organizationId, License license) {
        License licenseForUpdate =
                licenseRepository.findByOrganizationIdAndLicenseId(organizationId,license.getLicenseId());
        return licenseForUpdate;
    }
}
