package lesson_2;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by selenium on 13.07.2015.
 */
public class PrimeTest {

    @Test
    public void isPrimeNumberTest(){
        Assert.assertTrue(isPrime(4));
    }

    public boolean isPrime(int num){
       int div=0;
       for (int i=1;i<Integer.MAX_VALUE;i++){
           if (num%i==0){
                div++;
           }
           if (div>2) break;
       }
        return (div<3) ? true : false;
    }
}
