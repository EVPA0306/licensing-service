package com.evpa.licenses.repository;

import com.evpa.licenses.model.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends JpaRepository<License,String> {

    License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);

    List<License> findByOrganizationId(String organizationId);
}
