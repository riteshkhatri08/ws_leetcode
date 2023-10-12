class Q852_PeakIndexInaMountainArray {
    public static void main(String[] args) {
        System.out.println(
                "RESULT " + new Q852_PeakIndexInaMountainArray()
                        .peakIndexInMountainArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 3, 2, 1 }));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int peakIndex = peakSearch(arr);
        return peakIndex;
    }

    public int peakSearch(int[] marr) {

        int left = 0, right = marr.length - 1, mid;

        while (left <= right) {
            mid = left + ((right - left) / 2);
            mid = mid == 0 ? mid + 1 : mid;

            // System.out.println("left=" + left + ", right=" + right + ", mid=" + mid + ",
            // " + marr[mid]);
            if (mid > 0 && mid < marr.length - 1) {
                // If middle.left < middle and middle.right < middle , return middle
                if (marr[mid - 1] < marr[mid] && marr[mid + 1] < marr[mid])
                    return mid;

                // If mid.left > mid , peak is left array
                if (marr[mid - 1] > marr[mid]) {
                    right = mid - 1;
                    continue;
                }

                // If mid.right > mid , peak is in right array
                if (marr[mid + 1] > marr[mid]) {
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
