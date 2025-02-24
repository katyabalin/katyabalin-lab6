import java.util.ArrayList;
import java.util.List;

public class Enigma {
    private List<Rotor> rotors;

    // Constructor to initialize rotors based on given IDs and start positions
    public Enigma(int id1, int id2, int id3, String startPositions) {
        rotors = new ArrayList<>();

        // Hardcoded rotor configurations
        String[] rotorConfigs = {
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ#",  // Rotor 1
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ#",  // Rotor 2
            "AJDKSIRUXBLHWTMCQGZNPYFVOE#",  // Rotor 3
            "BDFHJLCPRTXVZNYEIWGAKMUSQO#",  // Rotor 4
            "ESOVPZJAYQUIRHXLNFTGKDCMWB#"   // Rotor 5
        };

        // Create rotors based on provided IDs (1-5) and starting positions
        rotors.add(new Rotor(rotorConfigs[id1 - 1], startPositions.charAt(0))); // Inner rotor
        rotors.add(new Rotor(rotorConfigs[id2 - 1], startPositions.charAt(1))); // Middle rotor
        rotors.add(new Rotor(rotorConfigs[id3 - 1], startPositions.charAt(2))); // Outer rotor
    }

    // Encrypts the input message
    public String encrypt(String input) {
        return process(input, true);
    }

    // Decrypts the input message
    public String decrypt(String input) {
        return process(input, false);
    }

    // Processes the input string, applying encryption or decryption
    private String process(String input, boolean encryptMode) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (encryptMode) {
                // Encrypt through the rotors in forward order
                for (Rotor rotor : rotors) {
                    c = rotor.charAt(rotor.indexOf(c));
                }
            } else {
                // Decrypt through the rotors in reverse order
                for (int i = rotors.size() - 1; i >= 0; i--) {
                    c = rotors.get(i).charAt(rotors.get(i).indexOf(c));
                }
            }

            result.append(c);

            // Rotate the first rotor and cascade if necessary
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

    // Debug method to print current rotor states
    public void printRotorState() {
        for (Rotor r : rotors) {
            System.out.println("Rotor: " + r);
        }
    }
}
