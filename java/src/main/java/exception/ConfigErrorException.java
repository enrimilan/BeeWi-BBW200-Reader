package exception;

public class ConfigErrorException extends RuntimeException {

    public ConfigErrorException(Exception e) {
        super(e);
    }

    public ConfigErrorException(String s) {
        super(s);
    }

}
