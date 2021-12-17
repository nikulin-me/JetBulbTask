package converter.service;

import converter.exception.InvalidValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotationConverterTest {
    private final NotationConverter converter = new NotationConverter();

    @Test
    void shouldReturnCorrectNumbers() {
        assertAll(
                ()->assertEquals(3,converter.toArabic("III")),
                ()->assertEquals(12,converter.toArabic("XII")),
                ()->assertEquals(59,converter.toArabic("LIX")),
                ()->assertEquals(1990, converter.toArabic("MCMXC"))
        );
    }

    @Test
    void shouldReturnExceptionCauseNull() {
        assertAll(
                () -> assertThrows(InvalidValueException.class, () -> converter.toArabic("")),
                () -> assertThrows(InvalidValueException.class, () -> converter.toArabic(null)),
                () -> assertThrows(InvalidValueException.class, () -> converter.toArabic("A")),
                ()->assertThrows(InvalidValueException.class,()->converter.toArabic("VI1"))
        );
    }
}