package club.codemata.exception;

public class LogFileException extends Exception {
    private String message;
    public LogFileException() {
        super();
    }

    public LogFileException(String message) {
        super(message);
        this.message = message;
    }

    public LogFileException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }
}
