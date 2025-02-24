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
            // Pass character through rotors in order (inner → middle → outer)
            for (Rotor rotor : rotors) {
                c = rotor.charAt(rotor.indexOf(c));
            }

            // Append encrypted character
            encryptedMessage.append(c);

            // Rotate the rotors (cascade rotation like an odometer)
            rotate();
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
            // Pass character through rotors in reverse order (outer → middle → inner)
            for (int i = rotors.length - 1; i >= 0; i--) {
                c = rotors[i].charAt(rotors[i].indexOf(c));
            }

            // Append decrypted character
            decryptedMessage.append(c);

            // Rotate the rotors (same as encryption)
            rotate();
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
