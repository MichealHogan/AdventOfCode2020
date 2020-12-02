import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class puzzle1part2 {
    public static void main(String[] args){
        List<Integer> inputs = loadWordsFromFile("input.txt");
        for(int i = 0; i < inputs.size(); i++){
            int first = inputs.get(i);
            for(int j = i + 1; j < inputs.size(); j++){
                int second = inputs.get(j);
                for(int w = j + 1; w < inputs.size(); w++){
                    int third = inputs.get(w);
                    if(first + second + third == 2020){
                        System.out.println("Answer to the puzzle is " + first * second * third);
                    }
                }
            }
        }
    }

    private static List<Integer> loadWordsFromFile(String filename) {
        try {
            FileReader aFileReader = new FileReader(filename);
            BufferedReader aBufferReader = new BufferedReader(aFileReader);
            List<Integer> numbers = new ArrayList<Integer>();
            String aNumber;
            aNumber = aBufferReader.readLine() ;

            while (aNumber != null) {
                int result = Integer.parseInt(aNumber);
                numbers.add(result);
                aNumber = aBufferReader.readLine() ;
            }

            aBufferReader.close();
            aFileReader.close();
            return numbers ;
        }
        catch(IOException x) {
            return null ;
        }
    }
}
