import java.math.BigInteger;

public class RSA {

    private final BigInteger P = new BigInteger("563036103490583");
    private final BigInteger Q = new BigInteger("1063300642915937");
    private final BigInteger E = new BigInteger("372585779765210097553647509959");

    private final BigInteger X1 = new BigInteger("399754188907643924420059310699");
    private final BigInteger Y2 = new BigInteger("293314580135454643114146935352");

    public BigInteger encrypt() {
        return X1.modPow(E, getN());
    }

    public BigInteger decrypt() {
        return decrypt(Y2);
    }
    public BigInteger decrypt(BigInteger Y) {
        return Y.modPow(getD(), getN());
    }

    public BigInteger getD() {
        return E.modInverse(getFiN());
    }

    public BigInteger getFiN() {
        return P.subtract(new BigInteger("1")).multiply(Q.subtract(new BigInteger("1")));
    }

    private BigInteger getN() {
        return P.multiply(Q);
    }

    public Triple getExtendGCD() {
        return getExtendGCD(E, getFiN());
    }

    public Triple getExtendGCD(BigInteger a, BigInteger n) {
        BigInteger s1 = new BigInteger("1"), s2 = new BigInteger("0");
        BigInteger t1 = new BigInteger("0"), t2 = new BigInteger("1");
        while(!n.equals(new BigInteger("0"))) {
            BigInteger quotient = a.divide(n);
            BigInteger r = a.mod(n);
            a = n;
            n = r;
            BigInteger tempS = s1.subtract(s2.multiply(quotient));
            s1 = s2;
            s2 = tempS;
            BigInteger tempR = t1.subtract(t2.multiply(quotient));
            t1 = t2;
            t2 = tempR;
        }
        return new Triple(a, s1, t1);
    }

    public final class Triple {

        BigInteger GCD, A, B;

        private Triple(BigInteger gcd, BigInteger a, BigInteger b) {
            GCD = gcd;
            A = a;
            B = b;
        }

        @Override
        public String toString() {
            return "GCD = " + GCD.toString() + "\nA = " + A.toString() + " \nB = " + B.toString();
        }

    }
}
