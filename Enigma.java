import java.util.Arrays;

public class Enigma {
    private Rotor[] rotors;

    public Enigma(String rotor1, String rotor2, String rotor3, char start1, char start2, char start3) {
        rotors = new Rotor[]{
            new Rotor(rotor1, start1),
            new Rotor(rotor2, start2),
            new Rotor(rotor3, start3)
        };
    }

    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            System.out.println("\n🔹 Encrypting '" + c + "'");

            int index = rotors[0].indexOf(c);
            System.out.println("  🌀 Step 1: Inner rotor mapped '" + c + "' → index [" + index + "]");

            char step1 = rotors[1].charAt(index);
            System.out.println("  🌀 Step 2: Middle rotor mapped index [" + index + "] → '" + step1 + "'");

            int index2 = rotors[1].indexOf(step1);
            System.out.println("  🌀 Step 3: Outer rotor mapped '" + step1 + "' → index [" + index2 + "]");

            char step2 = rotors[2].charAt(index2);
            System.out.println("  🌀 Final Encryption: '" + step1 + "' → '" + step2 + "'");

            encryptedMessage.append(step2);
            rotate();
        }
        return encryptedMessage.toString();
    }

    public String decrypt(String message) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            System.out.println("\n🔹 Decrypting '" + c + "'");

            int index2 = rotors[2].indexOf(c);
            System.out.println("  🔄 Step 1: Outer rotor mapped '" + c + "' → index [" + index2 + "]");

            char step2 = rotors[1].charAt(index2);
            System.out.println("  🔄 Step 2: Middle rotor mapped index [" + index2 + "] → '" + step2 + "'");

            int index1 = rotors[1].indexOf(step2);
            System.out.println("  🔄 Step 3: Inner rotor mapped '" + step2 + "' → index [" + index1 + "]");

            char step1 = rotors[0].charAt(index1);
            System.out.println("  🔄 Final Decryption: '" + step2 + "' → '" + step1 + "'");

            decryptedMessage.append(step1);
            rotate();
        }
        return decryptedMessage.toString();
    }

    private void rotate() {
        System.out.println("\n🔄 Rotating rotors...");
        if (rotors[0].rotate()) { // If inner rotor completes full cycle
            if (rotors[1].rotate()) { // If middle rotor completes full cycle
                rotors[2].rotate(); // Rotate the outer rotor
            }
        }
    }
}
