import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    List<String> lista = null;

    @Test
    void every_statement() {
        RuntimeException ex;
        User user=new User(null, "tea", null);

        ex = assertThrows(RuntimeException.class,()-> SILab2.function(null, lista));
        assertTrue(ex.getMessage().contains("The user is not instantiated"));

        ex = assertThrows(RuntimeException.class,()-> SILab2.function(user, lista));
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));

        user.username="tea";

        assertTrue(user.password.contains(user.username));

        assertTrue(user.password.length() < 8);

        user.password="Tea136()*";
        Function<String, Boolean> hasUpperCase = s -> s.chars().filter(c -> Character.isUpperCase(c)).count() > 0;
        assertTrue(user.password.matches(".*\\d.*") && user.password.matches(".*[!@#$%^&*].*")
        && hasUpperCase.apply(user.password));

        user.password="tea136()*";
        assertTrue(!user.password.matches(".*\\d.*") || !user.password.matches(".*[!@#$%^&*].*")
                || !hasUpperCase.apply(user.password));


    }

    @Test
    void multipleConditionsTest()
    {
        //1) user.getUsername()==null || user.getPassword()==null
        RuntimeException ex;
        User user=new User(null, null, null);
        //T-x
        ex = assertThrows(RuntimeException.class,()-> SILab2.function(user, lista));
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));
        //F-T
        user.username="tea";
        ex = assertThrows(RuntimeException.class,()-> SILab2.function(user, lista));
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));
        //F-F
        user.password="password";
        assertTrue(user.username!=null && user.password!=null);

        //2) !digit || !upper || !special
        Function<String, Boolean> hasUpperCase = s -> s.chars().filter(c -> Character.isUpperCase(c)).count() > 0;
        //T-x-x
        user.password="Tea()*";
        assertTrue(!user.password.matches(".*\\d.*"));
        //F-T-x
        user.password="tea136()*";
        assertTrue(user.password.matches(".*\\d.*") && !hasUpperCase.apply(user.password));
        //F-F-T
        user.password="Tea136";
        assertTrue(user.password.matches(".*\\d.*") && !user.password.matches(".*[!@#$%^&*].*")
                && hasUpperCase.apply(user.password));
        //F-F-F
        user.password="Tea136()*";
        assertTrue(user.password.matches(".*\\d.*") && user.password.matches(".*[!@#$%^&*].*")
                && hasUpperCase.apply(user.password));






    }

}