import java.util.ArrayList;
import java.util.List;

public class Enigma {
    private List<Rotor> rotors;

    /**
     * Constructs an Enigma machine with three rotors.
     * @param id1 Index of the inner rotor (1-5).
     * @param id2 Index of the middle rotor (1-5).
     * @param id3 Index of the outer rotor (1-5).
     * @param startPositions The starting characters for the three rotors.
     */
    public Enigma(int id1, int id2, int id3, String startPositions) {
        rotors = new ArrayList<>();

        // Predefined rotor configurations (1-based index)
        String[] rotorConfigs = {
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ#",  // Rotor 1
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ#",  // Rotor 2
            "AJDKSIRUXBLHWTMCQGZNPYFVOE#",  // Rotor 3
            "BDFHJLCPRTXVZNYEIWGAKMUSQO#",  // Rotor 4
            "ESOVPZJAYQUIRHXLNFTGKDCMWB#"   // Rotor 5
        };

        // Initialize rotors with specified configurations and starting positions
        rotors.add(new Rotor(rotorConfigs[id1 - 1], startPositions.charAt(0))); // Inner rotor
        rotors.add(new Rotor(rotorConfigs[id2 - 1], startPositions.charAt(1))); // Middle rotor
        rotors.add(new Rotor(rotorConfigs[id3 - 1], startPositions.charAt(2))); // Outer rotor
    }

    /**
     * Encrypts the given input string.
     * @param input The plaintext to encrypt.
     * @return The encrypted string.
     */
    public String encrypt(String input) {
        return process(input, true);
    }

    /**
     * Decrypts the given input string.
     * @param input The ciphertext to decrypt.
     * @return The decrypted string.
     */
    public String decrypt(String input) {
        return process(input, false);
    }

    /**
     * Processes input through rotors (either encryption or decryption).
     * @param input The input text.
     * @param encryptMode True for encryption, false for decryption.
     * @return Transformed string.
     */
    private String process(String input, boolean encryptMode) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (encryptMode) {
                // Encrypt: Pass through rotors in sequence (inner → middle → outer)
                for (Rotor rotor : rotors) {
                    c = rotor.charAt(rotor.indexOf(c));
                }
            } else {
                // Decrypt: Pass through rotors in **reverse** sequence (outer → middle → inner)
                for (int i = rotors.size() - 1; i >= 0; i--) {
                    c = rotors.get(i).charAt(rotors.get(i).indexOf(c));
                }
            }

            result.append(c);

            // Rotate rotors (like an odometer)
            boolean fullRotation = rotors.get(0).rotate();
            if (fullRotation) {
                fullRotation = rotors.get(1).rotate();
                if (fullRotation) {
                    rotors.get(2).rotate();
                }
            }
        }

        return result.toString();
    }

    /**
     * Prints the current rotor state (for debugging).
     */
    public void printRotorState() {
        for (Rotor r : rotors) {
            r.printRotorState();
        }
    }
}
