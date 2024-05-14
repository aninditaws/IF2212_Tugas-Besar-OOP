package Exception;

public class IllegalMoveException extends Exception {

    private String message;
    public IllegalMoveException(String s) {
        message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
