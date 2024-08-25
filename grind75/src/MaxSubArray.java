public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        int n = nums.length;
        int sum = nums[0];
        for(int i = 0; i<n ;i++){
            if(sum < 0){
                sum = nums[i];
            }else{
                sum+= nums[i];
            }
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray solution = new MaxSubArray();
        System.out.println("Max subarray is "+solution.maxSubArray(nums));
    }
}
