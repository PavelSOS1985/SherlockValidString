import java.util.*;

public class Level1 {
    public static boolean SherlockValidString(String s) {
        List<Character> sToListChars = new ArrayList<>();
        List<Character> charsList = new ArrayList<>();
        List<Integer> countChars = new ArrayList<>();
        // исходная строка в sToListChars && добавляю в charsList неповторяющиеся символы
        for (int i = 0; i < s.length(); i++) {
            sToListChars.add(s.charAt(i));
            if (!charsList.contains(s.charAt(i))) {
                charsList.add(s.charAt(i));
            }
        }
        // считаю количество каждого символа
        for (Character x :
                charsList) {
            countChars.add(Collections.frequency(sToListChars, x));
        }
        // и тут вся логика
        int max = Collections.max(countChars);
        int min = Collections.min(countChars);
        int countMax = Collections.frequency(countChars, max);
        int countMin = Collections.frequency(countChars, min);
        if ((max - min) > 1) return false;
        if (max != min) {
            if (min == 1) {
                return countMin <= 1 || countMax <= 1;
            } else return countMax <= 1;
        }
        return true;
    }
}