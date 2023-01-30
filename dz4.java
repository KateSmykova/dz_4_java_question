import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class dz4{
    public static void main(String[] args) {
        
        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        String str = "";
        try {
        // FileWriter writer = new FileWriter("text.txt");
        // writer.append("привет!");
        // writer.flush();

        FileReader reader = new FileReader("text.txt");
            while (reader.ready()){
                str += (char)reader.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    
        String[] strings = str.split("\n");
        for (int i = 0; i < strings.length; i++) {
            String[] sb = strings[i].split(" ");
            family.add(sb[0]);
            name.add(sb[1].charAt(0) + ".");
            surname.add(sb[2].charAt(0) + ".");
            age.add(Integer.valueOf(sb[3]));
            gender.add(sb[4].equals("Ж") ? true : false);
            index.add(i);
        //System.out.println(sb[0]+ " " + sb[1].charAt(0)+ "." + sb[2].charAt(0)+ "." + " " + sb[3]+ " " + sb[4]);  
        } 
        
        index.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });

        List tmp = new ArrayList<Object>(age);
        Collections.sort(tmp);
        for (int i = 0; i < tmp.size(); i++) {
            int j = age.indexOf(tmp.get(i));
            index.set(i, j);
        }
        for (int i = 0; i < index.size(); i++) {
            System.out.printf(family.get(index.get(i))+ " ");
            System.out.printf(name.get(index.get(i))+ " ");
            System.out.printf(surname.get(index.get(i))+ " ");
            System.out.printf(age.get(index.get(i)).toString()+ " ");
            System.out.printf(gender.get(index.get(i)) ? "М":"Ж");
            System.out.println();
        }
    }
}