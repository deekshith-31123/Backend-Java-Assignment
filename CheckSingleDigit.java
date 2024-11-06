class SingleDigitException extends Exception {
    public SingleDigitException(String message) {
        super(message);
    }
}

public class CheckSingleDigit {
    public static void checkSingleDigit(int number) throws SingleDigitException {
        if (number < -9 || number > 9) {
            throw new SingleDigitException("The number has more than one digit: " + number);
        }
    }

    public static void main(String[] args) {
        int number = 2;

        try {
            checkSingleDigit(number);
            System.out.println("The number is a single-digit number: " + number);
        } catch (SingleDigitException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
