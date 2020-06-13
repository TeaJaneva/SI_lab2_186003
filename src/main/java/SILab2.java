import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<String> allUsers) {  //1 ->2, 3
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        if (user==null) {
            throw new RuntimeException("The user is not instantiated"); //2 ->20
        }
        if (user.getUsername()==null || user.getPassword()==null) //3 -> 4, 5
            throw new RuntimeException("The user is missing some mandatory information"); //4 -> 20
        String password = user.getPassword(); //5 -> 6, 7
        String passwordLower = password.toLowerCase();
        if (passwordLower.contains(user.getUsername().toLowerCase())) {
            return false; //6 -> 20
        }
        else if (passwordLower.length()<8) //7 ->8, 9
            return false; //8 -> 20
        else { //9 ->10.1
            boolean digit = false, upper = false, special = false;
                //int i=0 -10.1 -> 10.2
                // i<password.length -10.2    -> 17, 11
                // i++ -10.3 ->10.2
            for (int i=0;i<password.length();i++) { //10.1, 10.2, 10.3
                if (Character.isDigit(password.charAt(i))) //11 ->12, 13
                    digit = true; //12->13
                if (Character.isUpperCase(password.charAt(i))) //13 -> 14, 15
                    upper = true;  //14-> 15
                if (specialCharacters.contains(String.valueOf(password.charAt(i))))  //15 -> 16, 10.3
                    special = true;  //16-> 10.3
            }//17 ->18, 19
            if (!digit || !upper || !special)
                return false;  //18 ->20
        } //19 ->20
        return true;
    } //20
}