import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majorityElement = 0;
        int count = 0;

        for(int i = 0 ;i <=nums.length - 1 ;i++){
            if(count == 0){
                majorityElement = nums[i];
            }
            if (nums[i] == majorityElement) {
                count++;
            }else{
                count--;
            }
        }
        return majorityElement;
    }

    public int majorityElementV2(int[] nums) {
        Map<Integer,Integer> frequency = new HashMap<>();
        int n = nums.length;
        for(int i = 0 ;i <= n ;i++){
                frequency.put(nums[i],frequency.getOrDefault(nums[i],0) + 1);
        }

        n = n/2;

        for(Map.Entry<Integer,Integer> entry : frequency.entrySet()){
            if(entry.getValue() > n){
                return entry.getValue();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElement solution = new MajorityElement();
        System.out.println("Majority element is "+solution.majorityElement(nums));
    }
}
