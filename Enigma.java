public class Enigma {

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};

    private Rotor rotors[];

    public Enigma(int id1, int id2, int id3, String start) {
        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
    }

    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (ch == '#') {
                encryptedMessage.append('#'); // Keep '#' unchanged
                rotate();
                continue;
            }

            int idx1 = rotors[0].indexOf(ch);
            if (idx1 == -1) {
                encryptedMessage.append(ch);
                rotate();
                continue;
            }

            char char2 = rotors[1].charAt(idx1);
            int idx2 = rotors[1].indexOf(char2);
            char finalChar = rotors[2].charAt(idx2);

            encryptedMessage.append(finalChar);
            rotate(); // Rotate the rotors after each character
        }

        return encryptedMessage.toString();
    }

    public String decrypt(String message) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (ch == '#') {
                decryptedMessage.append('#'); // Keep '#' unchanged
                rotate();
                continue;
            }

            int idx2 = rotors[2].indexOf(ch);
            if (idx2 == -1) {
                decryptedMessage.append(ch);
                rotate();
                continue;
            }

            char char1 = rotors[1].charAt(idx2);
            int idx1 = rotors[1].indexOf(char1);
            char finalChar = rotors[0].charAt(idx1);

            decryptedMessage.append(finalChar);
            rotate(); // Rotate the rotors after each character
        }

        return decryptedMessage.toString();
    }

    private void rotate() {
        if (rotors[0].rotate()) {
            if (rotors[1].rotate()) {
                rotors[2].rotate();
            }
        }
    }
}
