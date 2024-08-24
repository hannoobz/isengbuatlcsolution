class Solution {
	public String nearestPalindromic(String n) {
		Long num = Long.parseLong(n);
		if (num <= 10) {
			return (num - 1) + "";
		}

		if (n.charAt(0) == '1' && Long.parseLong(n.substring(1)) == 0) {
			return (num - 1) + "";
		}

		if (Long.parseLong(n.substring(1)) == 1 && n.charAt(0) == '1') {
			return (num - 2) + "";
		}

		if (String.valueOf(num + 1).charAt(0) == '1' && Long.parseLong(String.valueOf(num + 1).substring(1)) == 0) {
			return (num + 2) + "";
		}
		Long next = incrementPalindrome(Long.toString(num + 1), num + 1, false);
		Long prev = incrementPalindrome(Long.toString(num - 1), num - 1, true);

		if (!next.equals(num) && !prev.equals(num)) {
			return (Math.abs(next - num) < Math.abs(num - prev) && next != num) ? next.toString() : prev.toString();
		}
		if (next.equals(num)) {
			return prev.toString();
		}
		return next.toString();

	}

	public static Long incrementPalindrome(String n, Long num, Boolean prev) {
		Long nTemp = num;
		String sTemp = n;
		int left = 0;
		int right = sTemp.length() - 1;
		int multiplier = 1;
		while ((left < right)) {
			while (sTemp.charAt(left) != sTemp.charAt(right)) {
				if (prev) {
					nTemp = nTemp - 1 * multiplier;
				} else {
					nTemp = nTemp + 1 * multiplier;
				}
				sTemp = nTemp.toString();
			}
			multiplier *= 10;
			left++;
			right--;
		}
		return nTemp;
	}

	public static Boolean isPalindrome(String n) {
		int left = 0;
		int right = n.length() - 1;

		while (left < right) {
			if (n.charAt(left) != n.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
