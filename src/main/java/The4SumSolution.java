import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class The4SumSolution {

    public static void main(String[] rgs) {
        List<List<Integer>> result = fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        result.forEach(v -> System.out.println(Arrays.toString(v.toArray())));
    }

    private static int test() {
        Long no = Long.parseLong("23656533");
        return no.intValue();
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int j = i + 1;
            int k = j + 1;
            int z = k + 1;
            while (true) {
                int sum = nums[i] + nums[j] + nums[k] + nums[z];
                if (sum == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[z])));
                }
                if (z < nums.length - 1) {
                     z++;
                } else if (z == nums.length - 1 && k < z - 1) {
                    k++;;
                    z = k + 1;
                } else if (z == nums.length - 1 && k == nums.length - 2 && j < k - 1) {
                    j++;
                    k = j + 1;
                    z = k + 1;
                } else if (z == nums.length - 1 && k == nums.length - 2 && j == nums.length - 3) {
                    break;
                }
            }
        }
        return result;
    }
}
