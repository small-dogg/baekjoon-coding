class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //두 배열의 중간 인덱스 찾기.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        //좌측에 중앙 값을 존재하도록 +1
        int leftCount = (m + n + 1) / 2;

        int low = 0;
        int high = m;

        while (low <= high) {
            int i = (low + high) /2;
            int j = leftCount - i;

            // 4개 경계값 구하기
            int nums1LeftMax  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int nums2LeftMax  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // 정답 지점 찾음
                if ( (m + n) % 2 == 1 ) {
                    // 전체 길이 홀수 → 왼쪽 최대가 중앙값
                    return Math.max(nums1LeftMax, nums2LeftMax);
                } else {
                    // 전체 길이 짝수 → 왼쪽 최대와 오른쪽 최소의 평균
                    int leftMax = Math.max(nums1LeftMax, nums2LeftMax);
                    int rightMin = Math.min(nums1RightMin, nums2RightMin);
                    return (leftMax + rightMin) / 2.0;
                }
            } else if (nums1LeftMax > nums2RightMin) {
                // nums1에서 너무 많이 가져왔다 → 왼쪽으로 줄이기
                high = i - 1;
            } else {
                // nums2LeftMax > nums1RightMin
                // nums1에서 너무 적게 가져왔다 → 오른쪽으로 늘리기
                low = i + 1;
            }
        }

        return 0.0;
    }
}