import java.util.HashMap;

public class Q1095_FindInMountainArray {
    public static void main(String[] args) {
        var obj = new Q1095_FindInMountainArray();
        MountainArray arr = obj.new MountainArray(new int[] { 1, 2, 3, 4, 5, 3, 1 });
        System.out.println(
                "RESULT " + obj.new Solution().findInMountainArray(3, arr));
    }

    class Solution {
        MountainArrayWrapper mountainArrayWrapper;

        public int findInMountainArray(int target, MountainArray mountainArr) {
            mountainArrayWrapper = new MountainArrayWrapper(mountainArr);
            int peakIndex = peakSearch(mountainArrayWrapper);

            int leftIndex = binarySearchAscending(target, mountainArrayWrapper, 0, peakIndex);
            if (leftIndex < Integer.MAX_VALUE) {
                return leftIndex;
            }
            int rightIndex = binarySearchDescending(target, mountainArrayWrapper, peakIndex, mountainArr.length() - 1);

            if (leftIndex == rightIndex && leftIndex == Integer.MAX_VALUE) {
                return -1;
            } else {
                return Math.min(leftIndex, rightIndex);
            }

        }

        private int binarySearchDescending(int target, MountainArrayWrapper mountainArray, int left, int right) {
            int mid;
            while (left <= right) {
                mid = left + ((right - left) / 2);

                if (mountainArray.get(mid) == target) {
                    return mid;
                }

                if (mountainArray.get(mid) < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

            return Integer.MAX_VALUE;
        }

        private int binarySearchAscending(int target, MountainArrayWrapper mountainArray, int left, int right) {
            int mid;
            while (left <= right) {
                mid = left + ((right - left) / 2);

                if (mountainArray.get(mid) == target) {
                    return mid;
                }

                if (mountainArray.get(mid) > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }

            return Integer.MAX_VALUE;
        }

        public int peakSearch(MountainArrayWrapper marr) {

            int left = 0, right = marr.length - 1, mid;

            while (left <= right) {
                mid = left + ((right - left) / 2);
                mid = mid == 0 ? mid + 1 : mid;

                // System.out.println("left=" + left + ", right=" + right + ", mid=" + mid + ",
                // " + marr.get(mid));
                if (mid > 0 && mid < marr.length - 1) {
                    // If middle.left < middle and middle.right < middle , return middle
                    if (marr.get(mid - 1) < marr.get(mid) && marr.get(mid + 1) < marr.get(mid))
                        return mid;

                    // If mid.left > mid , peak is left array
                    if (marr.get(mid - 1) > marr.get(mid)) {
                        right = mid - 1;
                        continue;
                    }

                    // If mid.right > mid , peak is in right array
                    if (marr.get(mid + 1) > marr.get(mid)) {
                        left = mid + 1;
                        continue;
                    }
                } else {
                    return -1;
                }

            }
            return -1;
        }
    }

    class MountainArrayWrapper {
        MountainArray mountainArray;
        HashMap<Integer, Integer> marrayData;
        int length;

        public MountainArrayWrapper(MountainArray mountainArray) {
            this.mountainArray = mountainArray;
            this.marrayData = new HashMap<Integer, Integer>();
            this.length = mountainArray.length();
        }

        public int get(int index) {
            if (!marrayData.containsKey(index)) {
                marrayData.put(index, mountainArray.get(index));
            }
            return marrayData.get(index);
        }

    }

    class MountainArray {
        private int[] array;

        public MountainArray(int[] array) {
            this.array = array;
        }

        public int get(int index) {
            return this.array[index];
        }

        public int length() {
            return this.array.length;
        }
    }

}
