package solutions.euler23;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler23 {

    enum Type {
        Perfect,
        Deficient,
        Abundant;
    }

    public static void main( String... args ) {
     List<Record>  recs =  IntStream.range( 1,28123  ).parallel().mapToObj( n -> new Record( n ) ).collect( Collectors.toList() );
     System.out.println("All Perfect Numbers");
        recs.stream().filter( r -> r.getType()== Type.Perfect ).forEach(r-> System.out.print( r.getNumber() + ": " + prettyPrintFactors(r) +"\n") );

        List<Record> abundant = recs.stream().filter( r -> r.getType()== Type.Abundant ).collect( Collectors.toList() );
        List<Record> deficient = recs.stream().filter( r -> r.getType()== Type.Deficient ).collect( Collectors.toList() );
        List<Integer> cantSum = new ArrayList<>();

        IntStream.range(1,28123).parallel().forEach( i ->
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

                }
                                                   );

        System.out.println ("Sum of numbers: "+cantSum.stream().mapToInt( n -> n.intValue() ).sum());

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
                for ( int i = 2; i < number; i++ ) {
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
