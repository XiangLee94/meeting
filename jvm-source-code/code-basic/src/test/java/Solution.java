public class Solution {
    public static boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int low = -1,high = arr.length;
        boolean delete = false;
        while(++low < --high){
            if(arr[low] == arr[high]){
                continue;
            }else if(!delete){
                if(++low <= high && arr[low] == arr[high] || low <= --high && arr[low] == arr[high]){
                    delete = true;
                    continue;
                }
                return false;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga")
;    }
}
