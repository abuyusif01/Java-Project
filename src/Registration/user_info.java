package Registration;

import javafx.scene.control.Alert;
import javafx.stage.Window;
import java.io.*;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;
import java.util.Scanner;
 public class user_info {

    String filePath_user_info = "/home/blackdracula/git/java-project/dracula_version/src/Resources/User_info";
    String User_info_path = "/home/blackdracula/git/java-project/dracula_version/src/Resources/Users/";
    String Sub_reg_path = "/home/blackdracula/git/java-project/dracula_version/src/Resources/Users/";
    static  String User_hash_dir_G; // i really hate java because you can't use any memory stuff
    public user_info() {
    }
    public void insert_user_info(String Username, String Password) {

        String text = Username+" ";
        text += Password;

        File file = new File(filePath_user_info);
        FileWriter fr;
        BufferedWriter br;
        PrintWriter pr;

        try {
            fr = new FileWriter(file, true);
            br = new BufferedWriter(fr);
            pr = new PrintWriter(br);
            pr.println(text);
            pr.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean auth(String Username, String Password) throws FileNotFoundException {

        Scanner read_file = new Scanner(new File(filePath_user_info));
        String fileUsername,filePassword;
        try {
            while (read_file.hasNextLine()) {
                fileUsername = read_file.next();
                filePassword = read_file.next();
                if (fileUsername.equals(Username) && filePassword.equals(Password)) return true;
            }
        }catch (NoSuchElementException e){
            return false;
        }
        return false;
    }

    public static String get_hash(String input) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            StringBuilder hashtext = new StringBuilder(no.toString(16));
            while (hashtext.length() < 32) {
                hashtext.insert(0, "0");
            }
            return hashtext.toString();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void Create_dir(String User_hash_dir, String Username, String Password, String Email, String Faculty, String Semester, String Credit) {
        String Dir = "/home/blackdracula/git/java-project/dracula_version/src/Resources/Users/";
        Dir += User_hash_dir;
        Path path = Paths.get(Dir);

        // this shit will create dir with the given hash code.
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        User_info_path += User_hash_dir;
        User_info_path += "/User_Info.txt";
        File User_info = new File(User_info_path);
        try {
            if (User_info.createNewFile()){
                FileWriter writer = new FileWriter(User_info);
                writer.write(Username+" "+Password+" "+ Email+" "+ Faculty+" "+Semester+" "+Credit);
                writer.close();
            }
        }
        catch (IOException e ){
            System.out.println("File already exists.");
        }
    }

    public void insert_user_subject(String UserName, String Subject_name, String Subject_code, String Credit, String Lecturer) {

        Sub_reg_path += UserName;
        Sub_reg_path += "/Sub_reg.txt";

        String text = Subject_name+" ";
        text += Subject_code+" ";
        text += Credit+" ";
        text += Lecturer;

        File file = new File(Sub_reg_path);
        FileWriter fr;
        BufferedWriter br;
        PrintWriter pr;
        try {
            fr = new FileWriter(file, true);
            br = new BufferedWriter(fr);
            pr = new PrintWriter(br);
            pr.println(text);
            pr.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Oh shit ma nibba subject exist");
        }
    }

    public boolean getUser_subject(String UserName)  {

        Sub_reg_path += UserName;
        Sub_reg_path += "/Sub_reg.txt";
        StringBuilder all= new StringBuilder();
        try {
            Scanner input = new Scanner(new File(Sub_reg_path));
            while (input.hasNextLine()) {
                all.append(input.nextLine());
                all.append("\n");
            }
            System.out.println(all);
            return  true;
        }catch (FileNotFoundException e){
            System.out.println("You Haven't register any shit yet!");
            return false;
        }
    }
     public boolean getUser_info(String UserName) {

         User_info_path += UserName;
         User_info_path += "/User_Info.txt";

         StringBuilder all= new StringBuilder();
         try {
             Scanner input = new Scanner(new File(User_info_path));
             while (input.hasNextLine()) {
                 all.append(input.nextLine());
                 all.append("\n");
             }
             System.out.println(all);
             return true;
         }catch (FileNotFoundException e){
             System.out.println("Damn, we're hacked!!!");
             return false;
         }
     }

 }
