package com.evpa.licenses;
/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LicensingApplicationTest {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testApplicationIsNotNull() {
        LicensingApplication classUnderTest = new LicensingApplication();
        Assertions.assertThat(classUnderTest).isNotNull();
    }
}
