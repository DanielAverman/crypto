public class Controller {

    public static void main(String[] args) throws Exception {
        Input input = new Input();
        Output output = new Output();
        CryptoUtil crypto = new CryptoUtil();

        String messageToEncrypt = input.getMessage2Encrypt();
        String encryptedMessage = crypto.simpleSubstitutionEncrypt(messageToEncrypt);
        output.printMessage(encryptedMessage,"The encrypted text for message '" + messageToEncrypt + "' is ");
        output.printMessage(crypto.simpleSubstitutionDecrypt(encryptedMessage),
                "The decrypted text for message '" + encryptedMessage + "' is ");

        String messageToDecrypt = input.getMessage2Decrypt();
        output.printMessage(crypto.AffineDecrypt(messageToDecrypt, 29, 29),
                 "The decrypted text for message '" + messageToDecrypt + "' is ");
    }
}
