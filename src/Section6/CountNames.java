package Section6;

import acm.program.ConsoleProgram;

import java.util.HashMap;

/**
 * Created by Michael on 11/17/2016.
 */
public class CountNames extends ConsoleProgram {

    private HashMap<String, Integer> nameCounts;

    public void run() {
        nameCounts = new HashMap<>();
        String name;
        while(true) {
            name = readLine("Enter name: ");
            if(name.equals("")) break;
            if(nameCounts.containsKey(name)) {
                nameCounts.put(name, nameCounts.get(name) + 1);
            } else {
                nameCounts.put(name, 1);
            }
        }
        for(String n : nameCounts.keySet()) {
            println("Entry " + n + " has count " + nameCounts.get(n));
        }
    }


}
