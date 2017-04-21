package exception;

public class ProcessCallException extends RuntimeException {

    public ProcessCallException(Exception e) {
        super(e);
    }

    public ProcessCallException(String s) {
        super(s);
    }

}
