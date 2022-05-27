package functions;

import com.example.client.CallService;
import entity.Person;

import java.util.List;
import java.util.Locale;

public class CommandsFunction {

    public boolean loginTest(String[] allCommand, List<Person> persoane){
        for (Person pers : persoane) {
            if (allCommand.length > 1) {
                if (pers.getName().toLowerCase(Locale.ROOT).equals(allCommand[1].toLowerCase(Locale.ROOT))) {
                    CallService callService = new CallService();
                    return true;
                }
            }
        }
        return false;
    }

}
