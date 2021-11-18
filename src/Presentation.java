import java.util.Scanner;

public class Presentation {
    public static void getAWrittenHaiku(){
        FileReaderClass fileReader = new FileReaderClass();
        Scanner scanner = new Scanner(System.in);

        String firstHaiku = getHaikuPoemOne(scanner);
        String secondHaiku = getHaikuPoemTwo(scanner);
        String thirdHaiku = getHaikuPoemThree(scanner);

        boolean validHaikuPoem = BusinessLogic.checkForSyllables(firstHaiku, secondHaiku, thirdHaiku);

        //Her ser jeg om haiku digtende var godkendt eller ej. Hvis ikke kører jeg en metode der spørg og du vil prøve igen eller lukke programmet.
        //Hvis det var godkendt spørg jeg efter et navn og kører en metode der giver et ID.
        if (validHaikuPoem){
            System.out.println("Dit haiku digt er godkendt");
            String authorName = getAuthorName(scanner);
            int authorID = getAuthorID();
            FileReaderClass.addHaikuToCsvFile(authorName, authorID, firstHaiku, secondHaiku, thirdHaiku);
        } else {
            System.out.println("Dit haiku digt lever ikke op til kravende og er derfor blevet afvist.");
            askToTryAgain(scanner);
        }
    }
    //Denne metode kører getAWrittenHaiku igen eller slutter programmet.
    public static void askToTryAgain(Scanner scanner){
        System.out.println("Skiv 1 hvis du vil prøve igen, skriv 2 hvis du vil afslutte programmet");
        int number = scanner.nextInt();

        if (number == 1){
            getAWrittenHaiku();
        } else {
            System.out.println("Farvel");
        }
    }

    public static String getAuthorName(Scanner scanner){
        System.out.println("Vær sød at skrive dit navn");
        return scanner.nextLine();
    }

    public static int getAuthorID(){
        return FileReaderClass.getNewAuthorID();
    }

    public static String getHaikuPoemOne(Scanner scanner){
        System.out.println("Vær sød at skrive første del af dit haiku digt");
        System.out.println("Husk at første del skal være på 5 stavelser");

        return scanner.nextLine();
    }

    public static String getHaikuPoemTwo(Scanner scanner){
        System.out.println("Vær sød at skrive anden del af dit haiku digt");
        System.out.println("Husk at anden del skal være på 7 stavelser");

        return scanner.nextLine();
    }

    public static String getHaikuPoemThree(Scanner scanner){
        System.out.println("Vær sød at skrive tredje del af dit haiku digt");
        System.out.println("Husk at tredje del skal være på 5 stavelser");

        return scanner.nextLine();
    }
}
