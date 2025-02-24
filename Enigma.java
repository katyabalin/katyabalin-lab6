public class Enigma {
    private Rotor[] rotors = new Rotor[3];

    private static final String[] ROTORS = {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    public Enigma(int innerIndex, int middleIndex, int outerIndex, String startPos) {
        rotors[0] = new Rotor(ROTORS[innerIndex - 1], startPos.charAt(0));
        rotors[1] = new Rotor(ROTORS[middleIndex - 1], startPos.charAt(1));
        rotors[2] = new Rotor(ROTORS[outerIndex - 1], startPos.charAt(2));
    }

    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            int index = rotors[0].indexOf(c);
            char middleChar = rotors[1].charAt(index);
            index = rotors[1].indexOf(middleChar);
            char encryptedChar = rotors[2].charAt(index);

            encryptedMessage.append(encryptedChar);
            rotateRotors();
        }
        return encryptedMessage.toString();
    }

    public String decrypt(String message) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            int index = rotors[2].indexOf(c);
            char middleChar = rotors[1].charAt(index);
            index = rotors[1].indexOf(middleChar);
            char decryptedChar = rotors[0].charAt(index);

            decryptedMessage.append(decryptedChar);
            rotateRotors();
        }
        return decryptedMessage.toString();
    }

    private void rotateRotors() {
        if (rotors[0].rotate()) {
            if (rotors[1].rotate()) {
                rotors[2].rotate();
            }
        }
    }
}
