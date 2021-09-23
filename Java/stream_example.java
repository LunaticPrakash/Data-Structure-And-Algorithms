import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class stream_example {

    public static boolean isEven(int n) {
        if (n % 2 == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);

        // map
        List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
        // collect(Collectors.toList()); => toList() also works
        System.out.println(square);

        // filter
        List<Integer> even = number.stream().filter(x -> isEven(x)).collect(Collectors.toList());
        System.out.println(even);

        // using with arrays
        int[] arr = {1,2,3,4,5};
        int[] temp = Arrays.stream(arr).map(x-> x*x).toArray();
        for(int i=0; i<arr.length; i++)
            System.out.print(temp[i] + " ");

        //foreach
        System.out.println();
        number.stream().forEach(x -> System.out.print(x*x*x + " "));

        //reduce
        System.out.println();
        int sum = Arrays.stream(arr).reduce(0,(acc,i) -> acc+i);
        System.out.println(sum);

    }
}
