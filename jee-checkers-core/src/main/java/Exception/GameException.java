package Exception;

/**
 * Created by Nicolas on 10/01/2017.
 */
public class GameException extends Exception {

    public GameException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
