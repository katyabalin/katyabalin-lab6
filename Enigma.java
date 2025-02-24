public class Enigma {
    private Rotor[] rotors = new Rotor[3];

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    public Enigma(int innerIndex, int middleIndex, int outerIndex, String startPos) {
        rotors[0] = new Rotor(rotorInit[innerIndex - 1], startPos.charAt(0));
        rotors[1] = new Rotor(rotorInit[middleIndex - 1], startPos.charAt(1));
        rotors[2] = new Rotor(rotorInit[outerIndex - 1], startPos.charAt(2));
    }

    public String encrypt(String message) {
        char[] holding = new char[message.length()];

        for (int i = 0; i < message.length(); i++) { 
            int num1 = rotors[0].indexOf(message.charAt(i));
            char topRotorDraft1 = rotors[2].charAt(num1);

            int num2 = rotors[1].indexOf(topRotorDraft1);
            char topRotorFinal = rotors[2].charAt(num2);

            rotate();

            holding[i] = topRotorFinal;
        }

        return new String(holding);
    }

    public String decrypt(String message) {
        char[] holding = new char[message.length()];

        for (int i = 0; i < message.length(); i++) { 
            int num1 = rotors[2].indexOf(message.charAt(i));
            char middleRotorDraft = rotors[1].charAt(num1);

            int num2 = rotors[2].indexOf(middleRotorDraft);
            char finalChar = rotors[0].charAt(num2);

            rotate();

            holding[i] = finalChar;
        }

        return new String(holding);
    }

    private void rotate() {
        if (rotors[0].rotate()) {
            if (rotors[1].rotate()) {
                rotors[2].rotate();
            }
        }
    }
}
