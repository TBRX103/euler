package solutions.euler63;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Euler63 {

    static int count = 0;

    public static void main( String... args ) {
        IntStream.range( 1, 10 ).forEach( x -> IntStream.range( 1, 22 ).forEach( y -> {
            BigInteger bi = new BigInteger( String.valueOf( x ) ).pow( y );
            String num = bi.toString();
            if ( num.length() == y ) {
                System.out.println( x + "^" + y + ": " + num );
                updateCount();
            }
        } ) );
        System.out.println( "Total:" + count );
    }

    private static void updateCount() {
        count++;
    }
}
