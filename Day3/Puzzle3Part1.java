import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Puzzle3Part1 {
    public static void main(String[] args) {
    int trees = 0, counter = 0, space = 0;
    ArrayList<String> map = loadWordsFromFile("input.txt");
        for (String s : map) {
            if (counter > 30) {
                counter -= 31;
            }
            if ((s.charAt(counter)) == '#') {
                trees++;
            } else {
                space++;
            }
            counter += 3;
        }
        System.out.println("Trees: " + trees);
    }
    private static ArrayList<String> loadWordsFromFile(String filename) {

        try {
            FileReader aFileReader = new FileReader(filename);
            BufferedReader aBufferReader = new BufferedReader(aFileReader);
            ArrayList<String> words = new ArrayList<String>();
            String aWord;
            aWord = aBufferReader.readLine() ;

            while (aWord != null) {

                words.add(aWord);
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
