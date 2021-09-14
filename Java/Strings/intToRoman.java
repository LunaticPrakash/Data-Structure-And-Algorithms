package Strings;

public class intToRoman {

    public static String value(int num) {
        switch (num) {
            case 1:
                return "I";
            case 5:
                return "V";
            case 10:
                return "X";
            case 50:
                return "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";
            default:
                return "Z";
        }
    }

    public static String toRoman(int num) {
        String res = "";
        int div = 10;
        while (num >= div)
            div = div * 10;
        div = div / 10;

        while (num > 0) {
            int sDigit = num / div;

            if (sDigit <= 3)
                res += value(div).repeat(sDigit);
            else if (sDigit == 4)
                res += value(div) + value(div * 5);
            else if (sDigit >= 5 && sDigit <= 8)
                res += value(div * 5) + value(div).repeat(sDigit - 5);
            else if (sDigit == 9)
                res += value(div) + value(div * 10);

            num = num % div;
            div = div / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(toRoman(3999));
        System.out.println(toRoman(99));
    }

}
