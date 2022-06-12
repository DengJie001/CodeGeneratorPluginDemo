package club.codemata.exception;

public class YamlException extends Exception {
    private String message;

    public YamlException(String message) {
        super(message);
        this.message = message;
    }
}
