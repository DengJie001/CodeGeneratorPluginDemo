package club.codemata.exception;

public class LogFileException extends Exception {
    private String message;

    public LogFileException(String message) {
        super(message);
        this.message = message;
    }
}
