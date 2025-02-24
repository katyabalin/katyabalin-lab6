public class Enigma {

    private final String[] rotorInit = {
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
        rotors[0] = new Rotor(rotorInit[id1 - 1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2 - 1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3 - 1], start.charAt(2));
    }

    /** Encrypts the given message */
    public String encrypt(String message) {
        System.out.println("\n[Encrypting Message] Input: " + message);
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            System.out.println("\nEncrypting: " + c);

            // Step 1: Inner rotor to middle rotor
            int index1 = rotors[0].indexOf(c);
            char step1 = rotors[1].charAt(index1);
            System.out.println("Step 1: " + c + " -> " + step1 + " (Index: " + index1 + ")");

            // Step 2: Middle rotor to outer rotor
            int index2 = rotors[1].indexOf(step1);
            char step2 = rotors[2].charAt(index2);
            System.out.println("Step 2: " + step1 + " -> " + step2 + " (Index: " + index2 + ")");

            result.append(step2);
            rotate();
        }

        System.out.println("\n[Encryption Complete] Output: " + result.toString());
        return result.toString();
    }

    /** Decrypts the given message */
    public String decrypt(String message) {
        System.out.println("\n[Decrypting Message] Input: " + message);
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            System.out.println("\nDecrypting: " + c);

            // Step 1: Outer rotor to middle rotor
            int index2 = rotors[2].indexOf(c);
            char step2 = rotors[1].charAt(index2);
            System.out.println("Step 1: " + c + " -> " + step2 + " (Index: " + index2 + ")");

            // Step 2: Middle rotor to inner rotor
            int index1 = rotors[1].indexOf(step2);
            char step1 = rotors[0].charAt(index1);
            System.out.println("Step 2: " + step2 + " -> " + step1 + " (Index: " + index1 + ")");

            result.append(step1);
            rotate();
        }

        System.out.println("\n[Decryption Complete] Output: " + result.toString());
        return result.toString();
    }

    /** Rotates the rotors */
    private void rotate() {
        System.out.println("\nBefore Rotation: " + rotors[0].currentChar() + " " +
            rotors[1].currentChar() + " " + rotors[2].currentChar());

        if (rotors[0].rotate()) {
            if (rotors[1].rotate()) {
                rotors[2].rotate();
            }
        }

        System.out.println("After Rotation: " + rotors[0].currentChar() + " " +
            rotors[1].currentChar() + " " + rotors[2].currentChar());
    }
}
