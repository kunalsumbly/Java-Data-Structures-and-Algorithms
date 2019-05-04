package com.codeutils.ds;

public class QuickSortForSortingString {
	public static void main(String[] args) {
		// String[] str_array = { "8", "9", "3", "4", "-1", "0" };
		String[] str_array = { "8", "9", "3", "4", "-1", "0", "4", "7", "2", "1", "6", "5" };
		System.out.println("Sorted output:::::::");
		String[] quickSort = quickSort(str_array);
		for (String str : quickSort) {
			System.out.println(str);
		}

	}

	static String[] quickSort(String[] a) {
		String[] ret_arr = new String[0];
		String[] less_arr = new String[0];
		String[] greater_arr = new String[0];
		if (a.length < 2) { // base case 1
			return a;
		} else {
			// choose a pivot
			String pivot = a[0];
			if (a.length == 2) { // only 2 elements left in the array base case 2
				if (pivot == null) {
					return new String[0];
				}
				if (a[1] == null) {
					ret_arr = new String[1];
					ret_arr[0] = pivot;
					return ret_arr;
				}
				if (pivot.compareTo(a[1]) < 0) {
					less_arr = new String[1];
					less_arr[0] = a[0];

				}
				greater_arr = new String[1];
				greater_arr[0] = a[1];

				ret_arr = new String[2];
				if (less_arr.length > 0 && greater_arr.length > 0) {
					ret_arr[0] = less_arr[0];
					ret_arr[1] = greater_arr[0];
				} else if (less_arr.length > 0) {
					ret_arr[0] = less_arr[0];
				} else if (greater_arr.length > 0) {
					ret_arr[0] = greater_arr[0];
				}

				return ret_arr;

			} else {
				less_arr = new String[a.length - 2]; // also removing pivot from here
				greater_arr = new String[a.length - 2]; // also removing pivot from here

				// fill the less_arr
				int i = 0;

				for (String l_str : a) {
					if (l_str != null && pivot.compareTo(l_str) > 0) {
						less_arr[i] = l_str;
						i++;
					} else {
						continue;
					}
				}
				less_arr = quickSort(less_arr); // already the less array should be sorted by this point
				i = 0;
				// fill greater_arr
				for (String l_str : a) {
					if (l_str != null && pivot.compareTo(l_str) < 0) {
						greater_arr[i] = l_str;
						i++;
					}
				}
				greater_arr = quickSort(greater_arr); // already greater array should be sorted by this point
				ret_arr = new String[less_arr.length + greater_arr.length + 1];
			}

			for (int i = 0; i < less_arr.length; i++) {
				ret_arr[i] = less_arr[i];
			}
			ret_arr[less_arr.length] = pivot;
			for (int i = 0; i < greater_arr.length; i++) {

				ret_arr[less_arr.length + i + 1] = greater_arr[i];
			}

		}
		ret_arr = removeNullsFromArray(ret_arr);
		return ret_arr;
	}

	static String[] removeNullsFromArray(String[] a) {
		// first find the size of the array without nulls
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null) { // check all the not null elements
				count++;
			}
		}
		if (a.length <= 0 || count == 0) {
			return new String[0]; // if a is null the whole array is empty
		} else if (a.length == count) { // if a is not empty at all
			return a;
		}
		String[] finalArrayWithoutNulls = new String[count];
		count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null) {
				finalArrayWithoutNulls[count] = a[i];
				count++;
			}
		}

		return finalArrayWithoutNulls;
	}

}
