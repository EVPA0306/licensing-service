package com.evpa.licenses.controller;

import com.evpa.licenses.model.License;
import com.evpa.licenses.service.LicenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@AllArgsConstructor
@RestController
@RequestMapping("v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    private LicenseService licenseService;

    @GetMapping
    public List<License> getAllLicenses() {
        return licenseService.getAll();
    }

    @GetMapping(value = "/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId) {

        //final License license = licenseService.getLicense(licenseId,organizationId);
        final License license = licenseService.getLicenseById(licenseId);

        license.add(
                linkTo(methodOn(LicenseServiceController.class).getLicense(organizationId, license.getLicenseId())).withSelfRel(),
                linkTo(methodOn(LicenseServiceController.class).createLicense(organizationId)).withRel("createLicense"),
                //linkTo(methodOn(LicenseServiceController.class).updateLicense(organizationId, license)).withRel("updateLicense"),
                linkTo(methodOn(LicenseServiceController.class).deleteLicense(organizationId, license.getLicenseId())).withRel("deleteLicense")
        );

        return ResponseEntity.ok(license);

    }

    @DeleteMapping(value = "/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId) {
        return ResponseEntity.ok(licenseService.deleteLicense(organizationId,licenseId));
    }

    @PutMapping()
    private ResponseEntity<License> updateLicense(@PathVariable("organizationId") String organizationId,
            @RequestBody License license) {
        return ResponseEntity.ok(licenseService.updateLicense(organizationId,license));
    }

    @PostMapping
    public License createLicense(@PathVariable("organizationId") String organizationId) {
        return licenseService.createLicense(organizationId);
    }
}

