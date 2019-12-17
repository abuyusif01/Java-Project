package Forgot_password;

import Registration.user_info;
import java.io.IOException;
import java.util.Scanner;

public class search_user {
    boolean flag = false;
    user_info Credentials = new user_info();

    public search_user() throws IOException {
    }

    public boolean search_user(String Email) throws IOException {
        for (String all:  Credentials.allLines) {
            Scanner input = new Scanner(all);
            input.useDelimiter(" +"); //delimitor is one or more spaces
            while (input.hasNext()) {
                if(input.next().equals(Email)){
                    return true;
                }
            }
        }
        return false;
    }
}
