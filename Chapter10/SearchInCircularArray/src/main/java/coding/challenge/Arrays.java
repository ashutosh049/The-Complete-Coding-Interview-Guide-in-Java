package coding.challenge;

public final class Arrays {

    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int find(int[] m, int n) {

        if (m == null || m.length == 0) {
            return -1;
        }

        int left = 0;
        int right = m.length - 1;

        while (left <= right) {

            // half the search space
            int middle = (left + right) / 2;

            // we found the searched value right in the middle
            if (m[middle] == n) {
                return middle;
            }

            // check if the right-half is sorted (m[middle ... right])            
            if (m[middle] <= m[right]) {

                // check if n is in m[middle ... right]
                if (n > m[middle] && n <= m[right]) {
                    left = middle + 1;  // search in the right-half
                } else {
                    right = middle - 1;	// search in the left-half
                }
            } else { // we conclude that the left-half is sorted (A[left ... middle])
                // compare key with A[left] and A[mid] to know

                // check if n is in m[left ... middle]
                if (n >= m[left] && n < m[middle]) {
                    right = middle - 1; // search in the left-half
                } else {
                    left = middle + 1;	// search in the right-half
                }
            }
        }

        return -1;
    }
}
