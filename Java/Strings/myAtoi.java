package Strings;

public class myAtoi {
    public static int atoi(String s) {
        s = s.trim();
        int n = s.length();
        long output = 0;
        String number = "";
        boolean isNeg = false;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i == 0 && c == '-')
                isNeg = true;
            else if (i == 0 && c == '+')
                isNeg = false;
            else if (Character.isDigit(c))
                number += c;
            else
                break;
        }

        if (number.isEmpty())
            return 0;
        try {
            output = Long.parseLong(number);
        } catch (NumberFormatException e) {
            if (isNeg == true)
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }

        if(isNeg == true)
            output = -output;
        if(output > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(output < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int)output;
    }

    public static void main(String[] args) {
        System.out.println(atoi("283682 hello 828"));
        System.out.println(atoi("-00022221"));
        System.out.println(atoi("          24444444442323213-2323"));
    }
}
