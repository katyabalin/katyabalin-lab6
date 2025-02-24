public class Enigma {
    private Rotor inner, middle, outer;

    private static final String[] ROTORS = {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    /**
     * Constructs an Enigma machine with three rotors.
     */
    public Enigma(int innerIndex, int middleIndex, int outerIndex, String startPos) {
        inner = new Rotor(ROTORS[innerIndex - 1], startPos.charAt(0));
        middle = new Rotor(ROTORS[middleIndex - 1], startPos.charAt(1));
        outer = new Rotor(ROTORS[outerIndex - 1], startPos.charAt(2));
    }

    /**
     * Encrypts a given message.
     */
    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            int index = inner.getIndex(c);
            char middleChar = middle.getCharAt(index);
            index = middle.getIndex(middleChar);
            char encryptedChar = outer.getCharAt(index);
            encryptedMessage.append(encryptedChar);
            rotateRotors();
        }
        return encryptedMessage.toString();
    }

    /**
     * Decrypts a given message.
     */
    public String decrypt(String message) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            int index = outer.getIndex(c);
            char middleChar = middle.getCharAt(index);
            index = middle.getIndex(middleChar);
            char decryptedChar = inner.getCharAt(index);
            decryptedMessage.append(decryptedChar);
            rotateRotors();
        }
        return decryptedMessage.toString();
    }

    /**
     * Rotates the rotors following the odometer-like behavior.
     */
    private void rotateRotors() {
        inner.rotate();
        if (inner.hasCompletedFullRotation()) {
            middle.rotate();
            if (middle.hasCompletedFullRotation()) {
                outer.rotate();
            }
        }
    }
}
