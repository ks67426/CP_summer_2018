package pl.waw.sgh.bank.exceptions;

public class NegativeAmountException extends BankException {
    public NegativeAmountException(String s) {
        super(s);
    }
}