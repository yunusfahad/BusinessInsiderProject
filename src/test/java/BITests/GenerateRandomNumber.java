package BITests;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Fahad on 1/21/19.
 */
public class GenerateRandomNumber {

    public static void main(String[] args){
        //using array list to set integer value
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        //random function to get random numbers
        Random rand = new Random();

        //looping through 500 times to generate 500 random integers
        for(int i=0; i<500;i++){
            int rand_int = rand.nextInt(500);
            numbers.add(rand_int);
        }

        System.out.println("All number is array list - " + numbers);

        //sorting the numbers added in array list from minimum to maximum
        Collections.sort(numbers);
        System.out.println("Sorted numbers in ascending order - " + numbers);

        System.out.println("Lowest number is " + numbers.get(0));

    }
}
