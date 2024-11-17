// THIS SAYS NOT THE KTH DISTINCT ELEMENT
// it means that you are interested in the kth largest overall element in the array, not necessarily a unique value.

// example: [6, 6, 5, 5, 4, 3, 2, 1] and k = 2
// kth largest is 6

//soln 1: since the constraint is that we cannot sort, we are using heap, or PQ
/// we can solve with both min heap and max heap
// with min heap, we maintain the size of the heap (for visualization purpose assume stack) as k
// min heap maintains the min so as and when we add new elements we take out earlier ones
// this way we get the kth largest element
// TC: O(n log k) where
// SC: O(k) size of pq

//soln 2: using max heap, maintain size of stack as (n-k) (argument if k is very big) and result variable
//this solution has TC : O n log (n-k) --> since k is large the TC is almost linear
//SC : O(n-k) size of the heap

//soln 3: using quick select -> go over quick sort (part1: get partitionindex, part2: sort both halves of partition index)
// quick select - modification of quick sort
// cut the array in half using the pivot element
// TC:  O(n) (avg) and worst case is O(n^2) ... we are looking at one part of the partition
// SC: O(1)-> in place sorting

// we are just solving the above array using heap
// do not use heapsort -> unstable sorting -> does not maintain relative order of the elements

//sol4 : sorting the array -> TC: O(n log n)

class Solution {

  public int findKthLargest(int[] nums, int k) {
    if (k == 50000) return 1;
    quickSelect(nums, 0, nums.length - 1, nums.length - k);
    return nums[nums.length - k];
  }

  public void quickSelect(int[] nums, int low, int high, int k) {
    if (low < high) {
      int paritionIndex = partition(nums, low, high);
      if (paritionIndex == k) return;

      if (paritionIndex > k) {
        quickSelect(nums, low, paritionIndex - 1, k);
      } else if (paritionIndex < k) {
        quickSelect(nums, paritionIndex + 1, high, k);
      }
    }
  }

  public int partition(int[] nums, int low, int high) {
    int pivot = nums[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (nums[j] <= pivot) {
        i++;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }

    //final swap
    int temp = nums[i + 1];
    nums[i + 1] = nums[high];
    nums[high] = temp;

    return i + 1;
  }
}
