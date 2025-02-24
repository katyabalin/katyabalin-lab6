public class Comms {
    public static String run(String[] args) {
        boolean encrypt = args[4].equals("encrypt");

        int id1 = Integer.parseInt(args[0]);
        int id2 = Integer.parseInt(args[1]);
        int id3 = Integer.parseInt(args[2]);

        String message = args[5];

        Enigma enigma = new Enigma(id1, id2, id3, args[3]);

        if (encrypt)
            return enigma.encrypt(message);
        else
            return enigma.decrypt(message);
    }

    // Add this main method for manual testing
    public static void main(String[] args) {
        if (args.length < 6) {
            System.out.println("Usage: java Comms <id1> <id2> <id3> <start> <encrypt|decrypt> <message>");
            return;
        }

        String result = run(args);
        System.out.println("\n[Result]: " + result);
    }
}
