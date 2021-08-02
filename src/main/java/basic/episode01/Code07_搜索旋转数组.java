package basic.episode01;

/**
 * @Description TODO
 * @Date 2021/8/2 0:20
 * @Created by xiaofei
 */
public class Code07_搜索旋转数组 {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        int endNum = nums[nums.length-1];
        while(left<=right){
            int mid = left+((right-left)>>1);
            if(nums[mid]==target)return mid;
            else if(target>endNum && nums[mid]<endNum){
                right = mid-1;
            }else if(target<endNum && nums[mid]>endNum){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
