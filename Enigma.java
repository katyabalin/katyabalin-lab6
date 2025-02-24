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

            // Step through rotors in sequence (inner → middle → outer)
            for (Rotor rotor : rotors) {
                int index = rotor.indexOf(c);  // Find the index of 'c' in current rotor
                c = rotors[rotors.length - 1].charAt(index); // Get mapped character
            }

            encryptedMessage.append(c);
            rotate(); // Rotate after each character

            // Debugging output:
            System.out.println("Encrypting '" + original + "' → '" + c + "'");
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

            // Step through rotors in reverse order (outer → middle → inner)
            for (int i = rotors.length - 1; i >= 0; i--) {
                int index = rotors[i].indexOf(c); // Find the index in rotor
                c = rotors[i].charAt(index);      // Get mapped character
            }

            decryptedMessage.append(c);
            rotate(); // Rotate after each character

            // Debugging output:
            System.out.println("Decrypting '" + original + "' → '" + c + "'");
        }

        return decryptedMessage.toString();
    }

    /**
     * Rotates the rotors like an odometer.
     */
    private void rotate() {
        if (rotors[0].rotate()) {
            if (rotors[1].rotate()) {
                rotors[2].rotate();
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
