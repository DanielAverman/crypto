public class Input {

    private static final String MESSAGE_TO_ENCRYPT = "криптография";
    private static final String MESSAGE_TO_DECRYPT = "ЬЮИНЛЦЩЁ";

    public final int[] RSLOS_V1_A = {0, 1, 1, 0, 1};
    public final int[] RSLOS_V1_C = {1, 0, 1, 1, 1};
    public final int RSLOS_V1_N = 5;

    public final int[] RSLOS_V2_A = {1, 1, 0, 1, 1, 1, 1};
    public final int[] RSLOS_V2_C = {1, 1, 0, 0, 0, 0, 1};
    public final int RSLOS_V2_N = 7;

    public final int[] RSLOS_V3_A = {0, 0, 0, 0, 0, 0, 1, 1};
    public final int[] RSLOS_V3_C = {1, 1, 0, 0, 1, 1, 0, 1};
    public final int RSLOS_V3_N = 8;

    public String getMessage2Encrypt() {
        return MESSAGE_TO_ENCRYPT;
    }

    public String getMessage2Decrypt() {
        return MESSAGE_TO_DECRYPT;
    }
}
