import java.util.Random;

/**
 * Created by yunong on 1/24/2015.
 */
abstract class SortEssentials {
    static void tester(){}

    public static int[] createRandArr(int size){
        int min = 0;
        int max = 100;
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = randInt(min, max);
        }
        return arr;
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
