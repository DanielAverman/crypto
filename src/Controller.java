import java.math.BigInteger;

public class Controller {

    public static void main(String[] args) throws Exception {
        Input input = new Input();
        Output output = new Output();
        CryptoUtil crypto = new CryptoUtil();
//------------------------------    #1 -------------------------------------------------------------------------
//        String messageToEncrypt = input.getMessage2Encrypt();
//        String encryptedMessage = crypto.simpleSubstitutionEncrypt(messageToEncrypt);
//        output.printMessage(encryptedMessage,"The encrypted text for message '" + messageToEncrypt + "' is ");
//        output.printMessage(crypto.simpleSubstitutionDecrypt(encryptedMessage),
//                "The decrypted text for message '" + encryptedMessage + "' is ");
//
//        String messageToDecrypt = input.getMessage2Decrypt();
//        output.printMessage(crypto.AffineDecrypt(messageToDecrypt, 29, 29),
//                 "The decrypted text for message '" + messageToDecrypt + "' is ");
//
// ------------------------------    #3 -------------------------------------------------------------------------
//        RSLOS rslos = new RSLOS();
//
//        String rslos_v1 = rslos.doRSLOS(input.RSLOS_V1_N, input.RSLOS_V1_A, input.RSLOS_V1_C);
//        String rslos_v2 = rslos.doRSLOS(input.RSLOS_V2_N, input.RSLOS_V2_A, input.RSLOS_V2_C);
//        String rslos_v3 = rslos.doRSLOS(input.RSLOS_V3_N, input.RSLOS_V3_A, input.RSLOS_V3_C);
//        output.printMessage(rslos_v1,"RSLOS V1 (Period " + rslos_v1.length() + "): ");
//        output.printMessage(rslos_v2,"RSLOS V2 (Period " + rslos_v2.length() + "): ");
//        output.printMessage(rslos_v3,"RSLOS V3 (Period " + rslos_v3.length() + "): ");
//
//        String geffeGen = rslos.GeffeGen(rslos_v1, rslos_v2, rslos_v3);
//        output.printMessage(geffeGen, "Geffe Generator: ");
//        output.printMessage(String.valueOf(rslos.getCount(geffeGen, '1')), "Count of '1' = ");
//        output.printMessage(String.valueOf(rslos.getCount(geffeGen, '0')), "Count of '0' = ");
//
//        int k = 1;
//        for (int i : rslos.getThy(geffeGen, 5)) {
//            output.printMessage(String.valueOf(i), "Thi[" + k + "] = ");
//            k++;
//        }
// ------------------------------    #4 -------------------------------------------------------------------------
        RSA rsa = new RSA();

        output.printMessage(rsa.getD().toString(), "Inverse element (d) = ");
        RSA.Triple GCD = rsa.getExtendGCD();
        while (!GCD.A.equals(GCD.A.abs())) {
            GCD.A = GCD.A.add(rsa.getFiN());
        }
        output.printMessage(GCD.toString(), "");
        output.printMessage(rsa.encrypt().toString(), "Encrypted message for X1 = ");
        output.printMessage(rsa.decrypt(rsa.encrypt()).toString(), "Decrypted message for Y1 = ");
        output.printMessage(rsa.decrypt().toString(), "Decrypted message for Y2 = ");

    }
}
