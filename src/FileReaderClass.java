import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileReaderClass {

    //Havde planer om at man også skulle kunne få printet et haiku digt efter hvilket ID du indtastede men løb tør for tid desværre.
    public static String[] getHaikuFromCsvFile(int haikuPoemNr) {
        int haikuLines = 1;
        String line = "";
        String[] haikuPoem = {};
        
        try {
            File wordFile = new File("resources/haiku_poem.csv");
            Scanner scanner = new Scanner(wordFile);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (haikuLines == haikuPoemNr){
                    haikuPoem = line.split(",");
                }
                haikuLines++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        }
        return haikuPoem;
    }

    //Denne metode er hvor jeg printer haiku digtet og forfatter navn og id in i CSV filen.
    public static void addHaikuToCsvFile(String authorName, int authorID, String firstHaiku, String secondHaiku, String thirdHaiku){
        try {
            FileWriter writer = new FileWriter("resources/haiku_poem.csv", true);

                writer.append(authorID + "," + authorName + "," + firstHaiku + "," + secondHaiku + "," + thirdHaiku);
                writer.append("\n");

            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Denne metode giver mig et nyt ID til forfatterne. Den tæller linjerne og retunere den værdig. Men fordi den starter på 1 så er værdien en større end mængden af linjer.
    public static int getNewAuthorID(){
        int haikuNr = 1;
        String line = "";
        try{
            File wordFile = new File("resources/haiku_poem.csv");
            Scanner scanner = new Scanner(wordFile);

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                haikuNr++;
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return haikuNr;
    }
}
