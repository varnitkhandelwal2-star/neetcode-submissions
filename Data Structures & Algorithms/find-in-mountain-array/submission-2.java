/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low = 0 ;
        int high = mountainArr.length() -1 ;
        int mid =0 ;
        while(low < high) {
    mid = (low + high) / 2 ;
    if(mountainArr.get(mid) < mountainArr.get(mid+1)) low = mid+1 ;
    else {
        high = mid ; 
        }
}
    int peak = low  ;
    low=0;
    high=peak ;
    while(low<=high){
    mid = (low+high)/2 ;
    if(mountainArr.get(mid) == target) return mid ;
    if(mountainArr.get(mid) < target) low = mid+1  ;
    if(mountainArr.get(mid) > target) high = mid-1 ;
    }
     low=peak ;
     high=mountainArr.length() -1 ;
    while(low<=high){
    mid = (low+high)/2 ;
    if(mountainArr.get(mid) == target) return mid ;
    if(mountainArr.get(mid) < target) high = mid-1  ;
    if(mountainArr.get(mid) > target) low = mid+1 ;
    }
    return -1 ;
    }
}