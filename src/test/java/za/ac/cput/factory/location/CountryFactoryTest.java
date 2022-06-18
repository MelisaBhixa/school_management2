package za.ac.cput.factory.location;

/*
 *CountryFactoryTest class
 *CountryFactoryTest.java
 * Thina Mbiza: 217217095
 * Date: 18/06/2022
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.location.Country;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {

    Country country_id = CountryFactory.build("244", "Angola");

    @Test
    public void saveCountryTest() {
        Country country = CountryFactory.build("244", "Angola");// TODO: 2022/06/13 Implement with proper Name instance.
        System.out.println(country);
        assertNotNull(country);
    }//Save new country...TEST IS SUPPOSED TO PASS

    @Test
    public void failInvalidNameTest() {
        Country country = CountryFactory.build("244", null);
        System.out.println(country);
        assertNotNull(country);
    } // No Id provided...TEST IS SUPPOSED TO FAIL!

    @Test
    public void failInvalidIdTest() {
        Country country = CountryFactory.build(null, "Angola");
        System.out.println(country);
        assertNotNull(country);
    } // No ID provided...TEST IS SUPPOSED TO FAIL!

    @Test
    public void testForIdentity() {
        assertSame("244", "424");
    } //Not same ID provided...TEST IS SUPPOSED TO FAIL!

    @Test
    @org.junit.jupiter.api.Timeout(value = 1000, unit = TimeUnit.NANOSECONDS)
    public void testTimeout() {
        System.out.println("Setting the Timeout");
        assertEquals("1000", "1500");
    } // Timeout ended...TEST IS SUPPOSED TO FAIL

    @Disabled("Test Disabled")
    @Test
    public void testDisable() {
        Country country = CountryFactory.build("001", "United States");
        assertSame("United States", country.getId());
        org.junit.jupiter.api.Assertions.fail("This test should fail. Program still being developed!");
    }//Test has been disabled...EST IS SUPPOSED TO BE IGNORED!
}


