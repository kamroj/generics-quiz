package workshop;


/**
 * Bounded Parameters!
 * <p>
 * Let's say we have 3 classes: Person, Singer and ElvisPresley
 * Some people say, that Elvis is still alive, because he was cloned. Fair enough.
 * Our Elvis also will be cloneable.
 * <p>
 *
 * Important note:
 *      Please do not modify any internal classes/interfaces unless I ask You to do so.
 *
 * Below you will find method 'cloneSinger'
 * Implement it ;)
 *
 * @author Wojciech Makiela
 */
public class Task4 {

    interface Cloneable<T> {
        T createClone();
    }
    static class Singer {
    }
    static class ElvisPresley extends Singer implements Cloneable<ElvisPresley> {

        @Override
        public ElvisPresley createClone() {
            return new ElvisPresley();
        }
    }

    public static void main(String[] args) {
        // Use main method for tests
        cloneSinger(new ElvisPresley());
    }

    private static Cloneable cloneSinger(Cloneable cloneable) {
        return (Cloneable) cloneable.createClone();
        /*
        Look at that ugly cast! Why is it here?
        Delete '(Cloneable)' and read error description.

        'createClone' method returns Object, not Cloneable. And it makes sense.
        If you take a look at our Cloneable interface declaration, you can see that 'T' might be anything.
        And since (almost) everything in Java is an Object, T is considered one as well.
        Elvis can implement Cloneable<String> and would still work
        You can fix that by using 'extends' keyword!

        If you define Cloneable as 'Cloneable<T extends Cloneable>, You will be sure that createClone method
        won't return anything that is not Cloneable.
        This is the moment when You can modify interface Cloneable ;)

        It makes sense to think, that if You createClone something, then createClone itself should be cloneable, doesn't it?
            // This sentence is kinda complex. Feel free to read it again ;P

        Once You update Cloneable, this ugly cast won't be necessary... but we are not done here yet!
        Below you can see an example of parametrized method (returnT(T t)).
        You do that by defining new type (T) before return type.
        Now. Once you know how to define type in method, and how to use extends keyword with generics
        fix 'cloneSinger' method.
        'cloneSinger' should accept only parameters that are subtype of 'Singer',
        and that implement 'Cloneable' interface (with generics, we use 'extends' keyword
        for both classes and interfaces).

        REMINDER: Do not modify classes/interface. Just 'cloneSinger' method.

        
        HINT: Your generic type can extend more that one class. To do that, use '&' ;)


        // Bonus: check if you can call 'createClone' method multiple times:
            return cloneable.createClone().createClone().createClone().createClone();
           if (youCan) {
                System.out.println("Great!");
           } else {
                System.out.println("Try to fix that");
           }
        */
    }

    private static <T> T returnT(T t) {
        // T type is available only in this method
        System.out.println(t);
        return t;
    }
}