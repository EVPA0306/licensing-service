package com.evpa.licenses;

import com.evpa.licenses.model.License;
import com.evpa.licenses.repository.LicenseRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LicenseRepositoryTest {

    //private License license;
    private String organizationId = "e254f8c-c442-4ebe-a82a-e2fc1d1ff78b";
    private String licenseId = "f4841f8c-c338-4ebe-a82a-e2fc1d1ff78a";

    @Autowired
    private LicenseRepository licenseRepository;

    @Before
    public void setUp() {
        License license = new License(licenseId
                ,organizationId
                ,"license","type");
        licenseRepository.save(license);
    }

    @Test
    public void findByOrganizationIdAndLicenseIdTest() {
        License license =
                licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        Assertions.assertThat(license).isNotNull();
    }


    @Test
    public void findByOrganizationIdTest() {
        List<License> licenses =  licenseRepository.findByOrganizationId(organizationId);
        Assertions.assertThat(licenses).size().isGreaterThan(1);
    }

}
