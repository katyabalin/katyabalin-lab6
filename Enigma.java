import java.util.List;

public class Enigma {

    private List<Rotor> rotors;

    /**
     * Constructs an Enigma machine with a list of three rotors.
     * @param rotors The list of rotors used in encryption/decryption.
     */
    public Enigma(List<Rotor> rotors) {
        this.rotors = rotors;
    }

    /**
     * Encrypts or decrypts a given message.
     * @param input The message to process.
     * @param encryptMode True for encryption, False for decryption.
     * @return The processed string.
     */
    private String process(String input, boolean encryptMode) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            for (Rotor rotor : rotors) {
                c = encryptMode ? rotor.charAt(rotor.indexOf(c)) : rotor.indexOf(rotor.charAt(c));
            }
            result.append(c);

            // Rotate the first rotor and cascade rotation if necessary
            boolean fullRotation = rotors.get(0).rotate();
            for (int i = 1; i < rotors.size(); i++) {
                if (fullRotation) {
                    fullRotation = rotors.get(i).rotate();
                } else {
                    break;
                }
            }
        }

        return result.toString();
    }

    /**
     * Encrypts a given input string.
     * @param input The plaintext to encrypt.
     * @return The encrypted text.
     */
    public String encrypt(String input) {
        return process(input, true);
    }

    /**
     * Decrypts a given input string.
     * @param input The ciphertext to decrypt.
     * @return The decrypted text.
     */
    public String decrypt(String input) {
        return process(input, false);
    }

    /**
     * Debugging function to print the state of all rotors.
     */
    public void printRotorStates() {
        for (Rotor rotor : rotors) {
            rotor.printRotorState();
        }
    }
}
