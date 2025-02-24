public class Enigma {

    private String rotorInit[] = {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    private Rotor rotors[];

    public Enigma(int id1, int id2, int id3, String start) {
        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1 - 1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2 - 1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3 - 1], start.charAt(2));

        System.out.println("🚀 Enigma Machine Initialized:");
        System.out.println("Rotor 1: " + rotorInit[id1 - 1] + " Start: " + start.charAt(0));
        System.out.println("Rotor 2: " + rotorInit[id2 - 1] + " Start: " + start.charAt(1));
        System.out.println("Rotor 3: " + rotorInit[id3 - 1] + " Start: " + start.charAt(2));
    }

    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        System.out.println("\n🔐 Encrypting Message: " + message);

        for (char ch : message.toCharArray()) {
            if (ch == '#') {  
                encryptedMessage.append('#');
                rotate();
                continue;
            }

            System.out.print("\nStep: '" + ch + "' → ");

            int idx1 = rotors[0].indexOf(ch);
            char char2 = rotors[1].charAt(idx1);
            int idx2 = rotors[1].indexOf(char2);
            char finalChar = rotors[2].charAt(idx2);

            System.out.println("'" + ch + "' → '" + char2 + "' → '" + finalChar + "'");

            encryptedMessage.append(finalChar);
            rotate();
        }
        System.out.println("🔒 Encrypted Output: " + encryptedMessage.toString());
        return encryptedMessage.toString();
    }

    public String decrypt(String message) {
        StringBuilder decryptedMessage = new StringBuilder();
        System.out.println("\n🔓 Decrypting Message: " + message);

        for (char ch : message.toCharArray()) {
            if (ch == '#') {  
                decryptedMessage.append('#');
                rotate();
                continue;
            }

            System.out.print("\nStep: '" + ch + "' → ");

            int idx2 = rotors[2].indexOf(ch);
            char char1 = rotors[1].charAt(idx2);
            int idx1 = rotors[1].indexOf(char1);
            char finalChar = rotors[0].charAt(idx1);

            System.out.println("'" + ch + "' → '" + char1 + "' → '" + finalChar + "'");

            decryptedMessage.append(finalChar);
            rotate();
        }
        System.out.println("🔓 Decrypted Output: " + decryptedMessage.toString());
        return decryptedMessage.toString();
    }

    private void rotate() {
        boolean r1 = rotors[0].rotate();
        boolean r2 = false;
        boolean r3 = false;

        if (r1) r2 = rotors[1].rotate();
        if (r2) r3 = rotors[2].rotate();

        System.out.println("\n🔄 Rotors Rotated: [" + r1 + ", " + r2 + ", " + r3 + "]");
    }
}
