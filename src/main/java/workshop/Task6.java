package workshop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Bounded Parameters! Part 2!
 * <p>
 * Now.
 * We have army of Singers!
 * We know how to use them!
 * <p>
 * Time to do something ;)
 *
 * @author Wojciech Makiela
 */
public class Task6 {

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

        ElvisPresley() {
            super("Rock n' Roll");
        }

    }

    private static void workWithSingers(List<? extends Singer> singers, Consumer<Singer> consumer) {
        for (Singer singer : singers) {
            consumer.accept(singer);
        }
    }

    public static void main(String[] args) {

        /*
        We already had method that accepts any type of Singer
        Now, lets update the way it behaves.
         */

        Consumer<Singer> convertToKPopStar = singer -> singer.genre = "KPop";
        List<Singer> singers = Arrays.asList(new ElvisPresley());
        workWithSingers(singers, convertToKPopStar);
        System.out.println(singers.get(0).genre); // Elvis is now KPop star! Oh no!

        /*
        Quick info about Consumer
        It accepts parameter of given type (Singer in this case), and processes it in one way or another
         */

        // But here's the problem
        Consumer<Object> print = System.out::println;
//        workWithSingers(singers, print); // Compile error! Uncomment to check it out!

        /*
            I know that Singer can be printed.
            You know that too.
            But the compiler does not.
            It expects Consumer of Singers, not a Consumer of Objects.
            What to do now? <T extends Singer>? Maybe <?>?.
            Damn it. It's not working! What to do, what to do...
            If we use 'extends', it's expecting a subclass of a Singer. But we don't need a subclass.
            We need a super class!


            For now, you were using 'extends' only - defining an "Upper Bound" of type parameter.
            Or in other words, You were defining the 'highest possible' class in inheritance/family tree

                Object
                   |
                Singer
                   |
              ElvisPresley

            But now we need something above Singer, not below. In order to define "Lower Bound"
            You must use 'super' keyword!
            Example:
            We have 'demo' method that accepts List<? super Integer>
            Let's break that down:
                List<?> - this will be a list of some type
                <? super Integer> - given type will be superclass of Integer
            As you can see below, 'demo' method accepts List<Integer>, List<Number> and List<Object>
            (Integer extends Number and Number extends Object)
         */

        List<Integer> integers = Arrays.asList(1,2,3,4,5);
//        demo(integers);

        List<Number> numbers = new ArrayList<>(integers);
        numbers.add(3.14);
//        demo(numbers);

        List<Object> objects = new ArrayList<>(numbers);
        objects.add(new Object());
//        demo(objects);


        // Once you analyze this example fix 'workWithSingers' method, so it accepts
        // both Consumer<Singer> and Consumer<Object>
    }

    private static void demo(List<? super Integer> list) {
        for (Object o : list) {
            System.out.print(o);
            System.out.print(", ");
        }
        System.out.println();
    }
}
