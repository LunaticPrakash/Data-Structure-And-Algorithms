public class cipher {

    public static String encrypt(String msg, int shift) {
        String result = "";
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            if (Character.isUpperCase(c))
                result += (char) (((int) c + shift - 65) % 26 + 65);
            else
                result += (char) (((int) c + shift - 97) % 26 + 97);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("fghij", -5));
    }

}
