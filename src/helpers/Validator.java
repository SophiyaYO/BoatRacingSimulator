package helpers;

public class Validator {

    public static boolean validateModel(String model) {
        return model.length() >= 5;
    }

    public static boolean validateParam(int param) {
        return param > 0;
    }

    public static boolean validateSailEfficiency(int efiiciency) {
        return efiiciency > 0 && efiiciency < 101;
    }

    public static String generateErrorMessage(String paramName) {
        return String.format("%s  must be a positive integer.", paramName);
    }
}
