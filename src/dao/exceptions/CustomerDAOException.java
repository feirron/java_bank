package dao.exceptions;

public class CustomerDAOException extends RuntimeException {
    public CustomerDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
