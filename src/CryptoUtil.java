import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CryptoUtil {

    private static final String KEY = "ЬИУЗРОЫЭБХГШТЦНЁКЖПЛВЩЧЙМЮСЯЪДФАЕ";
    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final int[] PRIMES = {2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 49, 53, 59, 61, 67, 71, 73, 79, 83, 89, 91, 97};

    public String simpleSubstitutionEncrypt(@NotNull String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            encryptedMessage.append(KEY.charAt(ALPHABET.indexOf(message.toUpperCase().charAt(i))));
        }
        return encryptedMessage.toString();
    }

    public String simpleSubstitutionDecrypt(@NotNull String message) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++){
            decryptedMessage.append(ALPHABET.charAt(KEY.indexOf(message.toUpperCase().charAt(i))));
        }
        return decryptedMessage.toString();
    }

    public String AffineDecrypt(@NotNull String message, int a, int b) throws Exception {
        StringBuilder decryptedMessage = new StringBuilder();
        int aInverse = getInverse(a, ALPHABET.length());

        for (int i = 0; i < message.length(); i++){
            int charIndex = ALPHABET.indexOf(message.toUpperCase().charAt(i));
            if (charIndex < b) {
                charIndex += ALPHABET.length();
            }
            int newCharIndex = (aInverse*(charIndex-b))%ALPHABET.length();
            if (newCharIndex < 0) {
                newCharIndex += ALPHABET.length();
            }
            decryptedMessage.append(ALPHABET.charAt(newCharIndex));
        }
        return decryptedMessage.toString();
    }

    private int getInverse(int number, int mod) throws Exception {
        int power = getEulerFunctionValue(mod) - 1;
        int result = 1;
        for (int i = 0; i < power; i++){
            result = (result * number) % ALPHABET.length();
        }
        return result;
    }

    private int getEulerFunctionValue(int num) throws Exception {
        List<Integer> divisors = getPrimeDivisors(num);
        Collections.sort(divisors);
        int result = 1;
        for (int i = 0; i < divisors.size();){
            int divisor = divisors.get(i);
            int divisorCount = Collections.frequency(divisors, divisor);
            result *= getPrimeNumberEulerFunctionValue(divisor, divisorCount);
            i = divisors.lastIndexOf(divisor)+1;
        }
        return result;
    }

    private List<Integer> getPrimeDivisors(int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 2; i <= number; i++){
            if ((Arrays.binarySearch(PRIMES, i) >= 0) && (number % i == 0)) {
                divisors.add(i);
                number /= i;
                i--;
            }
        }
        return divisors;
    }

    private int getPrimeNumberEulerFunctionValue(int number, int power) throws Exception {
        if (!isPrimeNumber(number)) {
            throw new Exception("The number is not prime. Impossible to count an Euler's function value.");
        }
        return (int) (Math.pow(number, power) - Math.pow(number, power-1));
    }

    private boolean isPrimeNumber(int number) {
        for (int i = 2; i < Math.sqrt(number); i++){
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void getFrequencyAnalyse(@NotNull String message) {
        int[] occurrences = new int[ALPHABET.length()];
        for (int i = 0; i < message.length(); i++){
            occurrences[ALPHABET.indexOf(message.toUpperCase().charAt(i))]++;
        }
        for (int i = 0; i < ALPHABET.length(); i++)  {
            System.out.println(ALPHABET.charAt(i) + " - " + Math.round(1000*occurrences[i]/message.length())/1000.);
        }
    }

}
