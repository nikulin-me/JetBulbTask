package converter;

import converter.exception.InvalidValueException;
import converter.service.NotationConverter;

public class Main {
    public static void main(String[] args) throws InvalidValueException {
        NotationConverter notationConverter = new NotationConverter();
        System.out.println(notationConverter.toArabic("HUI"));
    }
}
