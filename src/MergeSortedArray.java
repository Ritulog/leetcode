public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m=3, n=3;
        mergeArrays(nums1,nums2, m, n);
        for(int i=0; i<m+n; i++){
            System.out.print(nums1[i]+ " ");
        }

    }

    public static void mergeArrays(int[] nums1, int[] nums2, int m, int n){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(j>=0){
            if(i>=0 && nums1[i]>nums2[j]){
              nums1[k] = nums1[i];
              k--;
              i--;
            }
            else{
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }

    public static void merge(int[] nums1, int[] nums2, int m,int n) {
        int p1 = m-1, p2= n-1, i = m+n-1;
        while(p2>=0){
            if(p1>=0 && nums1[p1]  > nums2[p2]){
                nums1[i--] = nums1[p1--];
            }
            else{
                nums1[i--] = nums2[p2--];
            }
        }
    }
}
