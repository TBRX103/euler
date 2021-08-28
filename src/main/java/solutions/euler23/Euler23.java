package solutions.euler23;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler23 {

    public static final int LIMIT = 28123;
static
    enum Type {
        Perfect,
        Deficient,
        Abundant;
    }

    public static void main( String... args ) {
        boolean[] isAbundant = new boolean[LIMIT+1];
     List<Record>  recs =  IntStream.range( 2,LIMIT+1  ).parallel().mapToObj( n -> new Record( n ) ).collect( Collectors.toList() );
     System.out.println("All Perfect Numbers");
        recs.stream().filter( r -> r.getType()== Type.Perfect ).forEach(r-> System.out.print( r.getNumber() + ": " + prettyPrintFactors(r) +"\n") );

        List<Record> abundant = recs.stream().filter( r -> r.getType()== Type.Abundant ).collect( Collectors.toList() );
        List<Integer> abundantIntegers = abundant.parallelStream().map( i -> i.getNumber() ).collect( Collectors.toList() );
        for (int i =1; i<=LIMIT;i++) {
            isAbundant[i] = abundantIntegers.contains(i);
        }

        List<Integer> cantSum = new ArrayList<>();
        AtomicInteger ati = new AtomicInteger(0);
        IntStream.range(1,LIMIT+1).parallel().forEach( i ->
//                                                     {
//                                                         for (int i2 =0; i2<= i; i2++) {
//                                                             if (isAbundant[i] && isAbundant[i-i2] ) {
//                                                                 return;
//                                                             }
//                                                         }
//                                                        ati.addAndGet( i );
//                                                     }
                {
                       for (Record ab1 : abundant.stream().collect( Collectors.toList() )) {
                           if (ab1.getNumber() > i ) {
                               continue;
                           }
                           for (Record ab2: abundant.stream().collect( Collectors.toList() )) {
                               if (ab1.getNumber() == ab2.getNumber() || ab2.getNumber()>i) {
                                   continue;
                               }
                               if (ab1.getNumber() + ab2.getNumber() == i) {
                                   return;
                               }

                           }
                       }
                       cantSum.add( i );
                    ati.addAndGet( i );
                }
                                                   );

        System.out.println ("Sum of numbers: " + ati.get());

    }

    private static String prettyPrintFactors( Record r ) {
        StringBuilder sb = new StringBuilder();
        return r.getProperDivisors().stream().map( i ->(String.valueOf( i )) ).collect( Collectors.joining(", ") );
    }



    static class Record {

        Type type = null;
        List<Integer> properDivisors;
        int number;

        public Record( int number ) {
            this.number = number;
            getProperDivisors();
            getType();
        }
        public int getNumber() {
            return number;
        }

        List<Integer> getFactors() {
            List<Integer> li = new ArrayList( getProperDivisors() );
            li.add( number );
            return li;
        }

        synchronized List<Integer> getProperDivisors() {

            if ( properDivisors == null ) {
                properDivisors = new ArrayList<>();
                for ( int i = 1; i < number; i++ ) {
                    if ( number % i == 0 ) {
                        properDivisors.add( i );
                    }
                }
            }

            return properDivisors;
        }

        synchronized Type getType() {
            if ( type == null ) {
                int total = getProperDivisors().stream().mapToInt( n -> n.intValue() ).sum();
                if ( total == number ) {
                    type= Type.Perfect;
                }
              else   if (total > number) {
                    type = Type.Abundant;
                }
              else {
                  type = Type.Deficient;
                }
            }
            return type;
        }
    }
}
