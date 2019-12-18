package Registration;
import java.io.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.lang.Object;
public class user_info {

    String filePath_user_info = "/home/blackdracula/git/java-project/dracula_version/src/Resources/User_info";
    String filePath_user_subject = "/home/blackdracula/git/java-project/dracula_version/src/Resources/User_Subject";
    public List<String> allLines = Files.readAllLines(Paths.get(filePath_user_info));
    boolean search = false;
    public user_info() throws IOException {
    }

    public void insert_user_info(String Email, String Password,String Username) {
        String text = Email+"\t";
        text += Username+"\t";
        text += Password;

        File file = new File(filePath_user_info);
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

    public void insert_user_subject(String Email, String Subject_name) {
        String text = Email+"\t";
        text += Subject_name;

        File file = new File(filePath_user_subject);
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
    public  String getUser_subject(String Email, String Subject_Code) throws FileNotFoundException {
        Scanner read_file;
        String fileEmail,fileSubject_Code;
        read_file = new Scanner(new File(filePath_user_subject));
        while (true){
            fileEmail = read_file.next();
            fileSubject_Code = read_file.next();
            if(fileEmail.equals(Email)&&fileSubject_Code.equals(Subject_Code)){
            return "file Found"; }
        }
    }

    public boolean auth(String Username, String Password) throws FileNotFoundException {
        Scanner read_file;
        String fileUsername,filePassword;
        read_file = new Scanner(new File(filePath_user_info));
        while (read_file.hasNextLine()){
            fileUsername = read_file.next();
            filePassword = read_file.next();
            System.out.println(fileUsername);
            System.out.println(Username);
            System.out.println(filePassword);
            System.out.println(Password);

            if (fileUsername.equals(Username)&&filePassword.equals(Password)){
                return true;
            }
        }
        return  false;
    }
}
