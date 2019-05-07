package workshop;


import java.util.ArrayList;
import java.util.List;

/**
 * Times before generics
 * <p>
 * 1. Create NEW project and run Java 4 (this repo has code written in Java8, so you
 * can't simply change version of this project)
 * 2. Copy and implement method workWithList()
 * 3. See that its bad
 * 4. Copy paste it back here - Java 8
 * 5. Make sure it still compiles
 * 6. Implement method workWithGenericList()
 * 7. Compare implementations
 * 8. Read summary below
 *
 * @author Wojciech Makiela
 */
public class Task1 {

    public static void main(String[] args) {
//        workWithList();
//        workWithGenericList();
    }

    static void workWithList() {
        // Create new list, and call it 'strings'

        // Add strings 'first' and 'second' to your list


        // Be a naughty boy/girl, and add an Integer '3'
        // Remember. Autoboxing (automatic converting primitives to corresponding Wrapper objects) was
        // introduced in Java5, so you must use 'new Integer(3)', not just '3'

        // I know it looks bad, but keep going
        // Get first element from your list, and assign it
        // to a variable of type String
        // In Java4 all lists were considered lists of objects
        // In order to assign element from collection to variable of type other than Object
        // you must use Casting
        String first; //{YourCode - get element 0 and cast it to (String)}

        // Do the same for last element
        String last; //{YourCode - get last element and cast it to (String)}

        // Run the method -> You should get ClassCastException
    }

    static void workWithGenericList() {
        // Create new list of type <String>, and call it 'strings'

        // Add strings 'first' and 'second' to your list


        // Be a naughty boy/girl, and add an Integer '3'

        // Hah! Compile error!
        // Comment that line so it compiles again

        // Get first element from your list, and assign it
        // to a variable of type String

        // Run the method
    }

    /**
     * SUMMARY:
     * Before you start reading, make sure you have finished first 7 steps listed above class declaration
     * <p>
     * Now you should have 2 similar implementations. One that uses Generics, and one that does not.
     * If you couldn't implement first method in plain Java4 style (because of reasons i guess),
     * then feel free to copy-paste it from 'java4Code.txt' file available in resources folder.
     * <p>
     * Quick info: I'll keep talking about lists only, but same rules apply to all collections in java.
     * <p>
     * As you already know - before Java 1.5 (in which generics were introduced)
     * all lists were lists of objects.
     * There was no type check at compile time, so you could add anything to any list.
     * When retrieving data from list you had to use casts that might fail.
     * <p>
     * Generics allow us to define type of elements stored in list. Information about type allows compiler
     * to do checks for us in compile, effectively reducing number of class cast exceptions.
     * <p>
     * How it works?
     */
    private static void howItWorks() {
        // <String> tells compiler that we want to store only Strings in given list
        List<String> strings = new ArrayList<>();

        // Having information about type, it checks variables that are being added to a list
        // and prevents adding anything of different type.
        strings.add("first");
//        strings.add(3); // Compiler error

        // Retrieving data before generics required manual casting
        // Now compiler knows type of variables in list, so it 'adds' casts in compile time
        // After all, cast still exists in bytecode, but it's not in source code
        // This makes code cleaner and easier to understand
        String first = strings.get(0);
    }
}