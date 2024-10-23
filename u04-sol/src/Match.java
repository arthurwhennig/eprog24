public class Match {

    /**
     * Finds the position of the 3-digit number M in the number A.
     * 
     * @param A is the number in which to search for the 3-digit number M.
     * @param M is a non-negative 3-digit number (M = M2 M1 M0).
     * @return The smallest index j such that A[j] = M0, A[j+1] = M1, and A[j+2] = M2,
     *         or -1 if no such j exists.
     */
    public static int matchNumber(long A, int M) {
        // Step 1: Convert M and the absolute value of A to strings.
        String mString = "" + M; // Convert M to string.
        String aString = "" + Math.abs(A); // Convert absolute A to string.

        // Step 2: Pad M with leading zeros to ensure it's 3 digits.
        while (mString.length() < 3) {
            mString = "0" + mString; // Add leading zeros if necessary.
        }

        // Step 3: Reverse the digits of M.
        String reversedM = "";
        for (int i = mString.length() - 1; i >= 0; i--) {
            reversedM += mString.charAt(i); // Reverse M.
        }

        // Step 4: Reverse the digits of A and add trailing zeros.
        String reversedA = "";
        for (int i = aString.length() - 1; i >= 0; i--) {
            reversedA += aString.charAt(i); // Reverse A.
        }
        reversedA += "000"; // Append zeros to prevent out-of-bounds errors.

        // Step 5: Search for reversedM in reversedA.
        int mIndex = 0; // Tracks matched digits of M.
        for (int i = 0; i < reversedA.length(); i++) {
            if (reversedA.charAt(i) == reversedM.charAt(mIndex)) {
                mIndex++; // Move to the next digit of M.
                if (mIndex == 3) {
                    return i - 2; // Return match position adjusted for reversal.
                }
            } else {
                mIndex = 0; // Reset index for M if no match.
                if (reversedA.charAt(i) == reversedM.charAt(mIndex)) {
                    mIndex++; // Start matching again.
                }
            }
        }

        // Step 6: Return -1 if no match was found.
        return -1;
    }
}
