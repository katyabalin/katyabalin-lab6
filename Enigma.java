public class Enigma {
    private static final String[] ROTOR_PATTERNS = {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    private Rotor[] rotors;

    public Enigma(int id1, int id2, int id3, String start) {
        System.out.println("\n[Initializing Enigma]");
        System.out.println("Selected Rotors: " + id1 + ", " + id2 + ", " + id3);
        System.out.println("Start Positions: " + start);

        rotors = new Rotor[3];
        rotors[0] = new Rotor(ROTOR_PATTERNS[id1 - 1], start.charAt(0));
        rotors[1] = new Rotor(ROTOR_PATTERNS[id2 - 1], start.charAt(1));
        rotors[2] = new Rotor(ROTOR_PATTERNS[id3 - 1], start.charAt(2));
    }

    public String encrypt(String message) {
        System.out.println("\n[Encrypting Message] Input: " + message);
        StringBuilder result = new StringBuilder();
        
        for (char c : message.toCharArray()) {
            System.out.println("\nEncrypting: " + c);

            // Encoding through the rotors in order
            int index1 = rotors[0].indexOf(c);
            char step1 = rotors[1].charAt(index1);
            System.out.println("Step 1: " + c + " -> " + step1 + " (Index: " + index1 + ")");

            int index2 = rotors[1].indexOf(step1);
            char step2 = rotors[2].charAt(index2);
            System.out.println("Step 2: " + step1 + " -> " + step2 + " (Index: " + index2 + ")");

            int index3 = rotors[2].indexOf(step2);
            char step3 = rotors[2].charAt(index3);
            System.out.println("Final Encrypted Output: " + step3 + " (Index: " + index3 + ")");

            result.append(step3);
            rotate();
        }
        System.out.println("\n[Encryption Complete] Output: " + result.toString());
        return result.toString();
    }

    public String decrypt(String message) {
        System.out.println("\n[Decrypting Message] Input: " + message);
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            System.out.println("\nDecrypting: " + c);

            // Decoding through the rotors in reverse order
            int index3 = rotors[2].indexOf(c);
            char step3 = rotors[2].charAt(index3);
            System.out.println("Step 3: " + c + " -> " + step3 + " (Index: " + index3 + ")");

            int index2 = rotors[1].indexOf(step3);
            char step2 = rotors[1].charAt(index2);
            System.out.println("Step 2: " + step3 + " -> " + step2 + " (Index: " + index2 + ")");

            int index1 = rotors[0].indexOf(step2);
            char step1 = rotors[0].charAt(index1);
            System.out.println("Final Decrypted Output: " + step1 + " (Index: " + index1 + ")");

            result.append(step1);
            rotate();
        }
        System.out.println("\n[Decryption Complete] Output: " + result.toString());
        return result.toString();
    }

    private void rotate() {
        System.out.println("Before Rotation: " + rotors[0].charAt(0) + " " + rotors[1].charAt(0) + " " + rotors[2].charAt(0));
        
        boolean rotateNext = rotors[0].rotate();
        if (rotateNext) {
            rotateNext = rotors[1].rotate();
            if (rotateNext) {
                rotors[2].rotate();
            }
        }

        System.out.println("After Rotation: " + rotors[0].charAt(0) + " " + rotors[1].charAt(0) + " " + rotors[2].charAt(0));
    }
}
