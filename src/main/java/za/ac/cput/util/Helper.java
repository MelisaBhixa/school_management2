package za.ac.cput.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.LongValidator;

public class Helper {
    public static void isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(email)) {

        } else {
            throw new IllegalArgumentException("Invalid email address provided");
        }
    }
    public static void isObjectNull(Object object) {
        if (object == null)
            throw new NullPointerException("Object is of Null value");
    }
    public static boolean isEmptyOrNull(String string) {
        return StringUtils.isEmpty(string);
    }
    public static String setEmptyIfNull(String string) {
        if (isEmptyOrNull(string))
            return StringUtils.EMPTY;
        return string;
    }
    public static void isValidName(String name) {
        LongValidator validator = LongValidator.getInstance();
        if (validator.isValid(name)) {

        } else {
            throw new IllegalArgumentException("Invalid name provided!");
        }

    }
    public static void isValidId(String id) {
        LongValidator validator = LongValidator.getInstance();
        if (validator.isValid(id)) {

        } else {
            throw new IllegalArgumentException("Invalid ID provided!");
        }
    }
    public static void checkStringParam(String paramName, String paramValue) {
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }
}
