package findMedianSortedArrays;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> num1List = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> num2List = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        List<Integer>  distinctSorted = Stream.concat(num1List.stream(), num2List.stream()).distinct().sorted().collect(Collectors.toList());
        if (distinctSorted.size() % 2 == 1) {
            return distinctSorted.get(distinctSorted.size()/2);
        }
        else {
            int above = (int)(Math.round(distinctSorted.size() / 2));
            return  (double)(distinctSorted.get(above) + distinctSorted.get(above-1)) / 2;
        }
    }
    public static void main(String[] args){
        log.info("{}", new Solution().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

}
