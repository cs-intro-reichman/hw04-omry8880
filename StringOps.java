import java.util.Arrays;

public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {

    }

    public static String capVowelsLowRest (String string) {
        String modified = "";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u') {
                modified += (char) ((int) string.charAt(i) - 32);
            }
            else if (string.charAt(i) > 'A' && string.charAt(i) <= 'Z' && string.charAt(i) != 'E' && string.charAt(i) != 'I' && string.charAt(i) != 'O' && string.charAt(i) != 'U') {
                modified += (char) ((int) string.charAt(i) + 32);
            }
            else {
                modified += string.charAt(i);
            }
        }
        return modified;
    }

    public static String camelCase (String string) { //  tWo    wordS
        String modified = "";
        String modifiedNoWhitespace = "";
        boolean firstWord = false;
        int index = 0;

        while (string.charAt(index) == ' ') {
            index++;
        }

        for (int i = index; i < string.length(); i++) {
            if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z' && !firstWord) {
                modified += (char) ((int) string.charAt(i) + 32);
            }
            else if (string.charAt(i) == ' ') {
                firstWord = true;
            }
            else if (i != 0 && string.charAt(i - 1) == ' ') {
                if (!(string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') && firstWord) {
                    modified += (char) ((int) string.charAt(i) - 32);
                }
                else {
                    modified += (char) ((int) string.charAt(i));
                }
            }
            else if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
                modified += (char) ((int) string.charAt(i) + 32);
            }
            else {
                modified += string.charAt(i);
            }
        }

        for (int i = 0; i < modified.length(); i++) {
            if (modified.charAt(i) != ' ') {
                modifiedNoWhitespace += modified.charAt(i);
            }
        }


        return modifiedNoWhitespace;
    }

    public static int[] allIndexOf (String string, char chr) {
        int counter = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                counter++;
            }
        }

        int[] arr = new int[counter];
        int secondCounter = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                arr[secondCounter] = i;
                secondCounter++;
            }
        }
        return arr;
    }
}
