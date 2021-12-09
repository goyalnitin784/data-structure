package ds.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

  public int[] twoSum(int[] nums, int target) {

    if(nums==null || nums.length==0){
      return null;
    }
    int[] output = new int[2];
    Map<Integer,Integer> data = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if(data.containsKey(target-nums[i])){
        output[1]  = i;
        output[0] = data.get(target-nums[i]);
      }
      data.put(nums[i],i);
    }
    return output;
  }
}
