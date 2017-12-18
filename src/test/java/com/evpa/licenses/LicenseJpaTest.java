package com.evpa.licenses;

import com.evpa.licenses.model.License;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LicenseJpaTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testFindByOrganizationId() {
        License license =
                testEntityManager.persistAndFlush(
                        new License("f4841f8c-c338-4ebe-a82a-e2fc1d1ff78a"
                        ,"e254f8c-c442-4ebe-a82a-e2fc1d1ff78b"
                        ,"license","type"));
        Assertions.assertThat(license.getLicenseId()).isNotNull();
    }
}
