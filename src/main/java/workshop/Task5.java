package workshop;


import java.util.Arrays;
import java.util.List;

/**
 * Generic Inheritance!
 * <p>
 * Now. We have army of Singers!
 * Lets find out what we can do with them!
 * <p>
 *
 * @author Wojciech Makiela
 */
public class Task5 {

    // Yeah. I know. Copy-paste development.
    // BUT! New methods are were introduced! Take a look
    static class Singer {
        private String genre;

        Singer(String genre) {
            this.genre = genre;
        }

        @Override
        public String toString() {
            return "Singer{" +
                    "genre='" + genre + '\'' +
                    '}';
        }
    }
    static class ElvisPresley extends Singer {

        ElvisPresley(String genre) {
            super(genre);
        }
    }

    private static void workWithSingers(List<Singer> singers) {
        for (Singer singer : singers) {
            System.out.println(singer);
        }
    }

    public static void main(String[] args) {
        // Take a look at workWithSingers method. Uncomment lines 54 and 55 - see what happens
        List<Singer> singers = Arrays.asList(new Singer("Rock"), new Singer("Blues"));
        workWithSingers(singers);
        List<ElvisPresley> presleyList = Arrays.asList(new ElvisPresley("Rock'n'Roll"));
//        workWithSingers(presleyList);

        /*
        Done? Great! Compile error! My favourite!
        So... Even though Elvis is a Singer, you cannot pass List<ElvisPresley> to workWithSingers method.
        It's because List<Elvis> is NOT a subtype of List<Singer>. Why? Consider following code

            List<Integer> ints = Arrays.asList(1, 2);
            List<Number> nums = ints; // this is where compile error would happen, but keep lets going
            nums.add(3.14);
            ints.toString().equals("1, 2, 3.14"); // whoops! A double in our its list! o.O

        Assigning list of ints to List<Number> variable will cause CompileError, because this might lead to
        breaking initial list -> list of ints having double in it.
        After all, you can add a Double to list of Numbers.
        In that example, List<Number> extends Object, and List<Integer> extends Object,
        thus our lists do not have parent-child relation - they are siblings.
        And as You already know, You can not assign variable of type A, to variable of type B
        unless A extends B.

        Same goes with List<ElvisPresley>. We don't want Lady Gaga in that list.

        Since You already know that inheritance in generics is not that easy, let's fix our 'workWithSingers'
        method, so it accepts any list of singers.
        To do that, you will use something called "wildcard". Start with changing declaration of our method to:

            private static void workWithSingers(List<?> singers)

        I know that it looks weir, but it is valid java syntax
        Copy-paste and see.
        A wildcard type represents an unknown type.
        Here, we are specifying a list which could be of any type.

        Not quite what we wanted. 'workWithSingers' should accept only Singers, and now you can pass
        any list and it will work. But now you can fix it easily, can't you?
        HINT: extends keyword might be useful
         */
    }
}
