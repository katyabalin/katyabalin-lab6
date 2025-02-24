public class Enigma {
    private String rotorInit[] = {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT", // Rotor 1
        "#EJOTYCHMRWAFKPUZDINSXBGLQV", // Rotor 2
        "#BDFHJLNPRTVXZACEGIKMOQSUWY", // Rotor 3
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE", // Rotor 4
        "#TGOWHLIFMCSZYRVXQABUPEJKND"  // Rotor 5
    };

    private Rotor rotors[];

    /**
     * Constructs an Enigma machine with three rotors.
     * @param id1 Index of the inner rotor (1-5).
     * @param id2 Index of the middle rotor (1-5).
     * @param id3 Index of the outer rotor (1-5).
     * @param start Starting characters for each rotor.
     */
    public Enigma(int id1, int id2, int id3, String start) {
        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1 - 1], start.charAt(0)); // Inner rotor
        rotors[1] = new Rotor(rotorInit[id2 - 1], start.charAt(1)); // Middle rotor
        rotors[2] = new Rotor(rotorInit[id3 - 1], start.charAt(2)); // Outer rotor
    }

    /**
     * Encrypts the given message.
     * @param message The plaintext message.
     * @return The encrypted message.
     */
    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            char original = c;

            // Encrypt through each rotor
            int index = rotors[0].indexOf(c);
            char step1 = rotors[1].charAt(index);
            int index2 = rotors[1].indexOf(step1);
            char step2 = rotors[2].charAt(index2);

            encryptedMessage.append(step2);
            rotate(); // Rotate AFTER encryption

            // Debugging output:
            System.out.println("Encrypting '" + original + "' → '" + step2 + "'");
        }

        return encryptedMessage.toString();
    }

    /**
     * Decrypts the given message.
     * @param message The ciphertext message.
     * @return The decrypted message.
     */
    public String decrypt(String message) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            char original = c;

            // Decrypt through rotors in reverse order
            int index2 = rotors[2].indexOf(c);
            char step2 = rotors[1].charAt(index2);
            int index1 = rotors[1].indexOf(step2);
            char step1 = rotors[0].charAt(index1);

            decryptedMessage.append(step1);
            rotate(); // Rotate AFTER decryption

            // Debugging output:
            System.out.println("Decrypting '" + original + "' → '" + step1 + "'");
        }

        return decryptedMessage.toString();
    }

    /**
     * Rotates the rotors like an odometer.
     */
    private void rotate() {
        if (rotors[0].rotate()) { // If the inner rotor completes a full cycle
            if (rotors[1].rotate()) { // If the middle rotor also completes a full cycle
                rotors[2].rotate(); // Rotate the outer rotor
            }
        }
    }

    /**
     * Debugging method to print current rotor state.
     */
    public void printRotorState() {
        for (Rotor r : rotors) {
            r.printRotorState();
        }
    }
}
