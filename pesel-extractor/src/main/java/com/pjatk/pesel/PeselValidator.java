package com.pjatk.pesel;

public class PeselValidator {
    private static final int[] NUM_CONTROL = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

    public static boolean isValid(String pesel){
        if(!pesel.matches("^\\d{11}$")){
            return  false;
        }

        int[] numPesel = extractDigits(pesel);
        int sum = calculateControlSum(numPesel);
        int calculatedControlSum = 10 - (sum % 10);
        calculatedControlSum = (calculatedControlSum == 10) ? 0 : calculatedControlSum;

        return calculatedControlSum == numPesel[10];
    }

    private static int[] extractDigits(String pesel) {
        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Character.getNumericValue(pesel.charAt(i));
        }
        return digits;
    }

    private static int calculateControlSum(int[] numPesel) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += numPesel[i] * NUM_CONTROL[i];
        }
        return sum;
    }
}
