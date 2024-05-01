package ma.enset.digitalbanking.exceptions;

public class CustomerException extends Exception {
    public CustomerException(String customerNotFound) {
        super(customerNotFound);
    }
}
