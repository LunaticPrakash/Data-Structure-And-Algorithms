import java.util.Arrays;

public class _44MinimumPlatforms {

    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 0;
        int maxOverlap = 0;
        int i=0, j=0;

        while(i < n){
            if(arr[i] <= dep[j]){
                count++;
                maxOverlap = Math.max(maxOverlap, count);
                i++;
            }
            else if(arr[i] > dep[j]){
                count--;
                j++;
            }
        }
        return maxOverlap;
    }

    public static void main(String[] args) {

    }
}
