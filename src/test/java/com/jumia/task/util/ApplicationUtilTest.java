package com.jumia.task.util;

import com.jumia.task.entity.enums.CountryEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ApplicationUtilTest {

    @Test
    public void isValidPhoneTestWithValidData() {
        assertTrue(ApplicationUtils.isValidPhone(CountryEnum.Cameroon, "(237) 697151594"));
    }

    @Test
    public void isValidPhoneTestWithNullPhone() {
        assertFalse(ApplicationUtils.isValidPhone(CountryEnum.Cameroon, null));
    }

    @Test
    public void getCountryTestWithValidData() {
        assertEquals(CountryEnum.Cameroon, ApplicationUtils.getCountry("(237) 677046616"));
        assertEquals(CountryEnum.Uganda, ApplicationUtils.getCountry("(256) 775069443"));
        assertEquals(CountryEnum.Ethiopia, ApplicationUtils.getCountry("(251) 914701723"));
        assertEquals(CountryEnum.Mozambique, ApplicationUtils.getCountry("(258) 847651504"));
        assertEquals(CountryEnum.Morocco, ApplicationUtils.getCountry("(212) 633963130"));
    }

    @Test
    public void getCountryTestWithInvalidPhone() {
        assertNull(ApplicationUtils.getCountry("INVALID"));
    }

    @Test
    public void getCountryTestWithNullPhone() {
        assertNull(ApplicationUtils.getCountry(null));
    }

    @Test
    public void getCountryTestWithEmptyPhone() {
        assertNull(ApplicationUtils.getCountry(""));
    }

}
