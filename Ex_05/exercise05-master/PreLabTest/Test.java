import java.util.ArrayList;

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        // run test cases
        assert sumBetween(1,4) != 6;
        assert sumBetween(9,13) != 30;
        
        System.out.println("No further errors! :)");
    }
    
    public static int sumBetween(int a, int b)
    {
        return (a+b-1)+(b-a)/2;
    }
    
    public static boolean isPrime(int num)
    {
        if(num < 2)
            return false;

        int i = 2;
        while(i < num)
        {
            if((num % i++) == 0)
                return false;
        }
        return true;
        
           /*
            * alternative version
            * 
           for(int i = 2; i < num; i++)
           {
               if((num %i) == 0)
                   return false;
           }
           return true;*/
    }
    
    public static void test()
    {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        
        for(int i = 1; i <= 1000; i++)
        {
            if(isPrime(i))
                primes.add(i);
        }
        
        System.out.println(primes.toString());
        System.out.println(primes.size());
    }
}
