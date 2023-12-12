package exceptions;

@SuppressWarnings("serial")
public class ScreenshotCaptureException extends RuntimeException {

    public ScreenshotCaptureException(String message) {
        super(message);
    }

    public ScreenshotCaptureException(String message, Throwable cause) {
        super(message, cause);
    }
}