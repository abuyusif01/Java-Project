package Registration;
import java.io.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class user_info {

    String filePath = "/home/blackdracula/git/java-project/dracula_version/src/Resources/User_info";
    public List<String> allLines = Files.readAllLines(Paths.get(filePath));
    public user_info() throws IOException {
    }

    public void insert_user_info(String Email, String Password,String Username) {
        String text = Email+"\t";
        text += Username+"\t";
        text += Password;

        File file = new File(filePath);
        FileWriter fr = null;
        BufferedWriter br = null;
        PrintWriter pr = null;
        try {
            fr = new FileWriter(file, true);
            br = new BufferedWriter(fr);
            pr = new PrintWriter(br);
            pr.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //for searching purposes
    public int getUsersnum(){
        int i =0;
        for (String line : allLines) {
            i = line.length();
        }
        return i;
    }
}
