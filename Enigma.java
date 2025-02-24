public class Enigma {

    private String rotorInit[] = {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    private Rotor rotors[];
    private static final int DEBUG_LIMIT = 5; // Limit debug output to 5 characters

    public Enigma(int id1, int id2, int id3, String start) {
        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1 - 1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2 - 1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3 - 1], start.charAt(2));

        System.out.println("Initialized Enigma Machine:");
        System.out.println("Rotor 1: " + rotorInit[id1 - 1]);
        System.out.println("Rotor 2: " + rotorInit[id2 - 1]);
        System.out.println("Rotor 3: " + rotorInit[id3 - 1]);
        System.out.println("----------------------------------");
    }

    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        System.out.println("\n🔐 Encrypting Message: " + message);
        System.out.println("----------------------------------");

        for (int i = 0; i < message.length(); i++) {
            if (i >= DEBUG_LIMIT) break;  // Limit debug output to 5 characters

            char ch = message.charAt(i);
            if (ch == '#') {
                encryptedMessage.append('#');
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

            System.out.printf("Step %d: '%c' → '%c' → '%c' → '%c'\n", i + 1, ch, char2, finalChar, finalChar);
            encryptedMessage.append(finalChar);

            rotate();
        }

        return encryptedMessage.toString();
    }

    public String decrypt(String message) {
        StringBuilder decryptedMessage = new StringBuilder();

        System.out.println("\n🔓 Decrypting Message: " + message);
        System.out.println("----------------------------------");

        for (int i = 0; i < message.length(); i++) {
            if (i >= DEBUG_LIMIT) break;  // Limit debug output to 5 characters

            char ch = message.charAt(i);
            if (ch == '#') {
                decryptedMessage.append('#');
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

            System.out.printf("Step %d: '%c' → '%c' → '%c' → '%c'\n", i + 1, ch, char1, finalChar, finalChar);
            decryptedMessage.append(finalChar);

            rotate();
        }

        return decryptedMessage.toString();
    }

    private void rotate() {
        boolean r1 = rotors[0].rotate();
        boolean r2 = r1 && rotors[1].rotate();
        boolean r3 = r2 && rotors[2].rotate();

        System.out.printf("Rotors rotated: [%b, %b, %b]\n", r1, r2, r3);
    }
}
