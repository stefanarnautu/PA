import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MockDictionary {

    Map<String, List<String>> dictionar = new HashMap<String, List<String>>();

    public boolean isWord(String wordSent) {
        if (!dictionar.containsKey(String.valueOf(wordSent.charAt(0)))) {
            return false;
        }else{
            for(String cuv : dictionar.get(String.valueOf(wordSent.charAt(0)))){
               if(cuv.compareTo(wordSent)==0){
                   return true;
               }
            }
        }
        return false;
    }
    public MockDictionary(){
        try {
            File myObj = new File("./target/words/words.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String cuvant = myReader.nextLine().toLowerCase();
                if (!dictionar.containsKey(String.valueOf(cuvant.charAt(0)))) {
                    dictionar.put(String.valueOf(cuvant.charAt(0)), new ArrayList<String>());
                }
                dictionar.get(String.valueOf(cuvant.charAt(0))).add(cuvant);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

     /*   for (char c = 'a'; c < 'z'; c++) {
            System.out.println(dictionar.get(String.valueOf(c)));
        }*/

    }
}
