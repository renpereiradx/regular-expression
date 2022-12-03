import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_regex {
    public static void main(String[] args) {
        String file = "./results.csv";
        // 1877-03-05,Wales,Scotland,0,2,Friendly,Wrexham,Wales,FALSE
        Pattern pat = Pattern.
            compile("^(18\\d\\d\\-.*),(.*),(.*),(\\d+),(\\d+),([\\w\\s]+),.*$");
              //Se usa doble diagonal para escaparla del string.
        try{
          BufferedReader br = new BufferedReader(new FileReader(file));
          String line;
          while((line = br.readLine()) != null){
            Matcher matcher = pat.matcher(line);
            if(matcher.find()){
              System.out.println("Fecha: " + matcher.group(1));
              System.out.println(matcher.group(2) + " (" + matcher.group(4)+" - "
                              + matcher.group(5)
                              + ") " + matcher.group(3) );
              System.out.println("Torneo: " + matcher.group(6));
              System.out.println("-------------------------------------------------------------\n");
            }
          }
        }catch(Exception e){
          System.out.println("Error");
        }
    }
}