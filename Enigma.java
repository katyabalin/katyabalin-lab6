import java.util.ArrayList;
import java.util.List;

public class Enigma {
    private List<Rotor> rotors;

    // Constructor initializes rotors based on provided IDs and start positions
    public Enigma(int id1, int id2, int id3, String startPositions) {
        rotors = new ArrayList<>();

        // Predefined rotor configurations
        String[] rotorConfigs = {
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ#",  // Rotor 1
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ#",  // Rotor 2
            "AJDKSIRUXBLHWTMCQGZNPYFVOE#",  // Rotor 3
            "BDFHJLCPRTXVZNYEIWGAKMUSQO#",  // Rotor 4
            "ESOVPZJAYQUIRHXLNFTGKDCMWB#"   // Rotor 5
        };

        // Initialize rotors with the selected configurations
        rotors.add(new Rotor(rotorConfigs[id1 - 1], startPositions.charAt(0))); // Inner rotor
        rotors.add(new Rotor(rotorConfigs[id2 - 1], startPositions.charAt(1))); // Middle rotor
        rotors.add(new Rotor(rotorConfigs[id3 - 1], startPositions.charAt(2))); // Outer rotor
    }

    // Encrypt method
    public String encrypt(String input) {
        return process(input, true);
    }

    // Decrypt method
    public String decrypt(String input) {
        return process(input, false);
    }

    // Processing logic for encryption and decryption
    private String process(String input, boolean encryptMode) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (encryptMode) {
                // Encrypting: Pass character through rotors from inner to outer
                for (Rotor rotor : rotors) {
                    c = rotor.charAt(rotor.indexOf(c));
                }
            } else {
                // Decrypting: Pass character through rotors in reverse order
                for (int i = rotors.size() - 1; i >= 0; i--) {
                    c = rotors.get(i).charAt(rotors.get(i).indexOf(c));
                }
            }

            result.append(c);

            // Rotate first rotor every time, cascade rotation like an odometer
            boolean fullRotation = rotors.get(0).rotate();
            if (fullRotation) {
                fullRotation = rotors.get(1).rotate();
                if (fullRotation) {
                    rotors.get(2).rotate(); // Rotate outer rotor only if middle rotor completes a full cycle
                }
            }
        }

        return result.toString();
    }

    // Debug method to print rotor states
    public void printRotorState() {
        for (Rotor r : rotors) {
            System.out.println("Rotor: " + r);
        }
    }
}
