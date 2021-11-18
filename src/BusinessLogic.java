import java.util.ArrayList;

public class BusinessLogic {

    public static boolean checkForSyllables(String firstHaiku,String secondHaiku, String thirdHaiku){
        boolean haikuPoemChecker = false;

        ArrayList<Character> vowels = getVowelArray();

        firstHaiku = makeStringUpperCase(firstHaiku);
        secondHaiku = makeStringUpperCase(secondHaiku);
        thirdHaiku = makeStringUpperCase(thirdHaiku);

        ArrayList<Character> firstHaikuArray = makeStringAnCharArrayOne(firstHaiku);
        ArrayList<Character> secondHaikuArray = makeStringAnCharArrayTwo(secondHaiku);
        ArrayList<Character> thirdHaikuArray = makeStringAnCharArrayThree(thirdHaiku);

        if ((checkFirstHaiku(vowels, firstHaikuArray)) && (checkSecondHaiku(vowels, secondHaikuArray)) && (checkThirdHaiku(vowels, thirdHaikuArray))){
            haikuPoemChecker = true;
        }
        return haikuPoemChecker;
    }

    //Denne metode checker om char i thirdHaikuArray er lig med de vowals jeg har sat, hvis ja går min timer op
    public static boolean checkThirdHaiku(ArrayList<Character> vowels, ArrayList<Character> thirdHaikuArray){
        int timer = 0;
        boolean validChecker = true;

        for (int i = 0; i < thirdHaikuArray.size(); i++) {
            for (int j = 0; j < vowels.size(); j++) {
                if (thirdHaikuArray.get(i).equals(vowels.get(j))){
                    timer++;
                }
            }
        }
        //Hvis timeren ikke er 5 så er haiku digtet ikke godkendt.
        if (timer == 5){
        } else {
            validChecker = false;
        }
        return validChecker;
    }

    public static boolean checkSecondHaiku(ArrayList<Character> vowels, ArrayList<Character> secondHaikuArray){
        int timer = 0;
        boolean validChecker = true;

        for (int i = 0; i < secondHaikuArray.size(); i++) {
            for (int j = 0; j < vowels.size(); j++) {
                if (secondHaikuArray.get(i).equals(vowels.get(j))){
                    timer++;
                }
            }
        }
        //Her er det så 7 istedet for siden anden del a digtet skulle bestå af 7 syllables.
        if (timer == 7){
        } else {
            validChecker = false;
        }
        return validChecker;
    }

    public static boolean checkFirstHaiku(ArrayList<Character> vowels, ArrayList<Character> firstHaikuArray){
        int timer = 0;
        boolean validChecker = true;

        for (int i = 0; i < firstHaikuArray.size(); i++) {
            for (int j = 0; j < vowels.size(); j++) {
                if (firstHaikuArray.get(i).equals(vowels.get(j))){
                    timer++;
                }
            }
        }
        if (timer == 5){
        } else {
            validChecker = false;
        }
        return validChecker;
    }
    //Her laver jeg en string til en char array
    public static ArrayList<Character> makeStringAnCharArrayOne(String firstHaiku){
        ArrayList<Character> firstHaikuArray = new ArrayList<>();

        for (int i = 0; i < firstHaiku.length(); i++) {
            firstHaikuArray.add(firstHaiku.charAt(i));
        }
        return firstHaikuArray;
    }

    public static ArrayList<Character> makeStringAnCharArrayTwo(String secondHaiku){
        ArrayList<Character> secondHaikuArray = new ArrayList<>();

        for (int i = 0; i < secondHaiku.length(); i++) {
            secondHaikuArray.add(secondHaiku.charAt(i));
        }
        return secondHaikuArray;
    }

    public static ArrayList<Character> makeStringAnCharArrayThree(String thirdHaiku){
        ArrayList<Character> thirdHaikuArray = new ArrayList<>();

        for (int i = 0; i < thirdHaiku.length(); i++) {
            thirdHaikuArray.add(thirdHaiku.charAt(i));
        }
        return thirdHaikuArray;
    }

    public static ArrayList<Character> getVowelArray(){
        ArrayList<Character> vowels = new ArrayList<>();
        String allVowels = "AEIOUYÆØÅ";

        for(int i = 0; i<allVowels.length(); i++){
            vowels.add(allVowels.charAt(i));
        }
        return vowels;
    }

    public static String makeStringUpperCase(String firstHaiku){
        return firstHaiku.toUpperCase();
    }

}
