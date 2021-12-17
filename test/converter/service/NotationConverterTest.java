package converter.service;

import converter.exception.InvalidValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotationConverterTest {
    private final NotationConverter converter=new NotationConverter();

    @Test
    void shouldReturn1990() {
        assertEquals(1990,converter.toArabic("MCMXC"));

    }
    @Test
    void shouldReturnExceptionCauseNull(){
        assertAll(
                ()->assertThrows(InvalidValueException.class,()->converter.toArabic("")),
                ()->assertThrows(InvalidValueException.class,()->converter.toArabic(null)),
                ()->assertThrows(InvalidValueException.class, ()->converter.toArabic("A"))
        );
    }
}