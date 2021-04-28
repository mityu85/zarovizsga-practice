package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        Set<String> numbers = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (isChar(s, i)) continue;
            numbers.add(s.substring(i, i+1));
        }
        return numbers.size();
    }

    private boolean isChar(String s, int i) {
        try {
            Integer.parseInt(s.substring(i, i +1));
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
}
