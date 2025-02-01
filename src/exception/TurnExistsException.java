package exception;

public class TurnExistsException extends Exception {
    public TurnExistsException() {
        super("این نوبت قبلا رزرو شده است!");
    }
}
