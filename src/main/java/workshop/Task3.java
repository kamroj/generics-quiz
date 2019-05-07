package workshop;

/**
 * Task 1 summary:
 *
 * As You have seen, by using generics we have a compile type check which prevents ClassCastExceptions
 * and removes the need for casting.
 *
 * The other advantage is to avoid code duplication.
 * Without generics, we have to copy and paste the same code but for different types.
 * With generics, we do not have to do this. We can even implement algorithms which apply to generic types.
 * Think about collections - having specific ArrayLists for Strings, ints ect. would be... problematic
 *
 * Task 2 summary:
 *
 * In second task You've created generic class! Yey!
 * Also, You have learned that you can't instantiate array of generic type, because
 * it's type is unknown at runtime... but why? Why is it unknown?
 *
 * Let's talk about Type Erasure
 *
 * @author Wojciech Makiela
 */
public class Task3 {

    public static void main(String[] args) {
        /*
        In task 1 you've created code in 'java 4 style'
        and project still compiles
        Its because java is backwards compatible

        IMPORTANT: I have no coding for you in this section.
        If you want, feel free to use 'javap -c' on your classes, in order to see java bytecode
        Bytecode should be the same, or just slightly of (depends on your implementation).

        Why?

        It’s important to realize that generic type information is only available to the compiler, not the JVM.
        In other words, 'type erasure' means that generic type information is not available to the JVM at runtime,
        because during compilation all information about generics is removed.

        for all You nerds out there:

            if (currentTime.isCompileTime) {
                generics.setAvailable(true);
            } else if (currentTime.isRunTime) {
                generics.setAvailable(false);
            }

        The reasoning behind erasure is simple:
        preserving backward compatibility with older versions of Java.
        When a generic code is compiled into bytecode, it will be as if the generic type never existed.
        This means that compilation will:

            Replace generic types with objects
            Replace bounded types (More on these in a later sections) with the first bound class
            Insert the equivalent of casts when retrieving generic objects.

        Or to put it in simpler way.
            List l = new ArrayList();
            List<String> l = new ArrayList<String>();
        No matter which line you use, your bytecode will stay the same.


        One last thing:

            List l = new ArrayList();

        Despite being able to compile, it’s still likely that there will be a warning from the compiler.
        This is because we are losing the extra compile time check that we get from using generics.

        The point to remember is that while backward compatibility and type erasure
        make it possible to omit generic types, it is bad practice.

        */
    }
}
