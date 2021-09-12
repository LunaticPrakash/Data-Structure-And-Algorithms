package Strings;

public class timeConversion {
    public static String timeConverter(String s) {
        // Write your code here
        String[] time = s.split(":");
        int hour = Integer.parseInt(time[0]);
        String rest = s.substring(2, 8);
        String dn = s.substring(8);
        String newHour = time[0];

        if (dn.equals("AM") && hour == 12) {
            newHour = "00";
        } else if (dn.equals("PM") && hour != 12) {
            newHour = String.valueOf(hour + 12);
            if (newHour.equals("24"))
                newHour = "00";
        }
        String newTime = newHour + rest;
        return newTime;
    }

    public static void main(String[] args) {
        System.out.println(timeConverter("06:40:03AM"));
    }
}
