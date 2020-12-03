import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class puzzle2part1 {
    public static void main(String[] args){

        int validPasswords = 0;
        List<String> inputs = loadWordsFromFile("input.txt");
        for(int i = 0; i < inputs.size(); i++){

          String[] password = inputs.get(i).split(" ", 3);

          String[] password1 = password[0].split("-",2);
          int minimum = Integer.parseInt(password1[0]);
          int maximum = Integer.parseInt(password1[1]);

          String[] password2 = password[1].split(":",1);
          char character = password2[0].charAt(0);

          String[] password3 = password[2].split(" ");
          String passwordCode = password3[0];

          int counter = 0;

          for(int j = 0; j < passwordCode.length(); j++){
              if(passwordCode.charAt(j) == character){
                    counter++;
              }
          }
          if(counter >= minimum && counter <= maximum){
              validPasswords++;
          }

        }
        System.out.println("Number of valid password = " + validPasswords);

    }

    private static List<String> loadWordsFromFile(String filename) {

        try {
            FileReader aFileReader = new FileReader(filename);
            BufferedReader aBufferReader = new BufferedReader(aFileReader);
            ArrayList<String> words = new ArrayList<String>();
            String aWord;
            aWord = aBufferReader.readLine() ;

            while (aWord != null) {

                words.add(aWord.toUpperCase());
                aWord = aBufferReader.readLine() ;
            }
            aBufferReader.close();
            aFileReader.close();
            return words ;
        }
        catch(IOException x) {
            return null ;
        }
    }
}
