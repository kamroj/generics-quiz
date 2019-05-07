package workshop;

/**
 * Generics!1!!
 * <p>
 * Below you have Task2 class. Make it Generic.
 * I want it to store 2 types. 'T' and 'S', that I can declare however I want.
 * Currently it accepts only T. Fix that!
 *
 * You can put extra types in same angle brackets ('<>'), by separating them with a comma
 *
 * @author Wojciech Makiela
 */
public class Task2<T> {

    // TODO - T and S fields
    private final T myFieldOfTypeT;


    // TODO - fix constructor - accept 2 variables - T and S

    public Task2(T varOfTypeT) {
        // TODO - assign variables passed to constructor to fields
        this.myFieldOfTypeT = varOfTypeT;
    }

    /*
    So what the function happened here?
    Right now you should have a class Task2 that accepts two custom parameters of types <T, S>
    You have created 2 fields of types T and S, and initialized them in constructor.
    This allows us to store pair of any objects.

    When to use that?
    Let's say you are creating Tic-tac-toe game (for example).
    In that game you might find pairing 'Player' and 'Symbol' objects very useful.
    To do that, you create new class PlayerSymbolPair.
    But then you think that you also want to have pairs of type 'Players' and 'TTTGame'.
    To do that, you create new class PlayersTttGamePair.
    But then you think that... you get the point.

    Creating multiple classes with basically same functionality, but with different types of fields leads
    to dirty and buggy code.

    Luckily, with the power of generics you can create single class Pair<T, S> that will help you out!
    What a time to be alive!

    If something will require changing its type, generify it!

    Next task for you:
    Create new class called 'Bundle'
    It should store 3 different values! 2 of which should be generic;
    Third element should be ALWAYS of type List<String>! (Don't try to generify it (yet). Just hardcode its type)

    Once you're done, test your implementation:
    List<String> strings = Arrays.asList("a", "b", "c");
    Bundle<String, Integer> b = new Bundle("first", 2, strings);
    assert b.getFirst().equals("first");
    assert b.getSecond() == 2;
    assert strings == b.getStrings();


    New task! Yey!
    Now something tricky. I want Task2 class to store an array of T's

        T[] ts = new T[10];

    Copy-paste that line to constructor. Once you see that it doesn't work, delete it and continue reading ;)

    Each object in Java has a "class" which can be retrieved at runtime,
    using the .getClass() method. Arrays of different component types correspond
    to different array classes. So .getClass() called on an int array will
    return a different thing than .getClass() called on a String array.

    How does an object know its class? That's because it was provided
    when the object was created. The same applies for array objects.
    When you create an array, you must(!) specify the type of array, including
    an explicit component type. However, when you have a type variable like T,
    code that uses that type cannot know what type T is; and in fact,
    the point is that the code must work with any type in the place of T.
    That is why the class or method is said to be "generic".
    Thus you cannot create an array of T since you cannot provide the component
    type needed to create the array.

    Whoa. That's a lot of knowledge. You're doing great! (I hope)
    Last one thing before we leave generic arrays alone. Even though you cannot
    create array of generic type, you can create array of Objects, and cast it.
    T[] ts = (T[]) new Object[10];
    It's shady, but it works!... Still. Do not do that.


    Interesting fact:
    Generics have naming convention!
        E - Element (used extensively by the Java Collections Framework)
        K - Key
        N - Number
        T - Type
        V - Value
        S,U,V etc. - 2nd, 3rd, 4th types after T is used


     */
}
