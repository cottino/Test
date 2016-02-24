import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;

public class Solver {
	public static void main(String[] args) {
		Solver b = new Solver();
		// b.aps();
		// String str1 = "abc";
		// String str2 = "def";
		// //SHuffles
		// String str3 = "dabecf";
		// String str4 = "fedcba";
		// System.out.println(str3.substring(1));
		// boolean me = b.stringCombine(str1,str2,str3);
		// if(me == true) System.out.println("Fuck ya");
		// else
		// System.out.println("nope");
		//
		// boolean me2 = b.stringCombine(str1,str2,str4);
		// if(me2 == true) System.out.println("Fuck ya");
		// else
		// System.out.println("nope");
		//
		// b.findSingle();
		// int[] ar = {1,2,3};
		// boolean y = b.binarySearch(ar, 3);
		// if (y) {
		// System.out.println("contains");
		// } else {
		// System.out.println("does not contain");
		// }
		// int[] ar1 = {1,2,3,4};
		// int[] ar2 = {1,3,4};
		// int y = b.findMissingXOR(ar1,ar2);
		// System.out.println(y);
		String s = "my name is chrisyn"; 
		b.findUnique(s);
	}

	// Reverse the words in a string (could place words on stack then pop off to
	// reverse.
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder(s.length() + 1);
		String[] words = s.split(" ");
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i]).append(' ');
		}
		sb.setLength(sb.length() - 1);

		return sb.toString();
	}

	// Some Basic Interview Questions.
	// Given an integer array, output all pairs that sum up to a specific value
	// k.
	public void aps(int[] arr, int k) {
		//int[] arr = {1, 4, 3, 5, 6, 7, 8, 9};
		//int k = 6;
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int curr = arr[left] + arr[right];
			if (curr == k) {
				System.out.println(arr[left] + " " + arr[right]);
				left++;
			} else if (curr < k)
				left++;
			else if (curr > k)
				right--;
		}
	}

	/*
	 * We are given 3 strings: str1, str2, and str3. Str3 is said to be a
	 * shuffle of str1 and str2 if it can be formed by interleaving the
	 * characters of str1 and str2 in a way that maintains the left to right
	 * ordering of the characters from each string. For example, given
	 * str1=”abc” and str2=”def”, str3=”dabecf”
	 */
	public boolean stringCombine(String str1, String str2, String str3) {
		if (str1.length() + str2.length() != str3.length()) {
			return false;
		}

		if (str1.length() == 0 || str2.length() == 0) {
			if ((str1 + str2).equals(str3))
				return true;
			else
				return false;
		}

		if (str1.charAt(0) != str3.charAt(0) && str2.charAt(0) != str3.charAt(0)) {
			return false;
		}

		if (str1.charAt(0) == str3.charAt(0) && stringCombine(str1.substring(1), str2, str3.substring(1))) {
			return true;
		}

		if (str2.charAt(0) == str3.charAt(0) && stringCombine(str1, str2.substring(1), str3.substring(1))) {
			return true;
		}

		return false;

	}

	/*
	 * Check to see whether or not tree is binary search tree. Alternative to
	 * this would be a DFS in-order which would lead to a sorted list of the
	 * values if it was a binary tree.
	 */
	// private boolean isBST(Node root, int minVal, int maxVal){
	// if(root == null)
	// return true;
	//
	// if((minVal <= root.data) || (root.data <= maxVal))
	// return false;
	//
	// return isBST(root.left, minVal,root.data) && isBST(root.right, root.data,
	// maxVal);
	// }

	/*
	 * Find a single number in an array while the others are all duplicates
	 */
	private void findSingle() {
		int arr[] = { 3, 2, 5, 2, 1, 5, 3 };
		int num = 0;
		for (int i = 0; i < 7; i++) {
			num ^= arr[i];
		}
		System.out.println(num);
	}

	// Basic implementation of a binary search.
	private boolean binarySearch(int[] ar, int findMe) {
		if (ar == null || ar.length == 0) {
			return false;
		}

		Arrays.sort(ar);
		if (ar[ar.length - 1] == findMe)
			return true;

		if (ar.length > 1) {
			int index = (int) Math.floor(ar.length / 2);
			return (ar[index] > findMe) ? binarySearch(Arrays.copyOfRange(ar, 0, index), findMe)
					: binarySearch(Arrays.copyOfRange(ar, index, ar.length), findMe);

		}
		return false;
	}

	// Given 2 arrays where ar1 is an int[] and ar2 is ar1 but with one number
	// missing return the missing number.
	// I think that this could be problematic if the arrays are too large or
	// number surpasses MAX_INT
	public int findMissing(int[] ar1, int[] ar2) {
		int sum1 = IntStream.of(ar1).sum();
		int sum2 = IntStream.of(ar2).sum();
		return (sum1 == sum2 && ar1.length > ar2.length) ? 0 : sum1 - sum2;
	}

	// XORing two numbers together will result in zero.
	public int findMissingXOR(int[] ar1, int[] ar2) {
		int result = 0;
		int[] both = (int[]) ArrayUtils.addAll(ar1, ar2);
		for (int n : both) {
			result ^= n;
		}

		return result;
	}

	// return the kth element with the list in sorted order. There is a better
	// solution using a quicksort like algorithm called the median of medians.
	private int kthLargest(int[] ar, int k) {
		if (ar == null || ar.length - 1 > k) {
			return 0; // just a default.
		}
		Arrays.sort(ar);
		return ar[k];
	}

	// Find all the possible permutations of a string.
	// private ArrayList<String> permutations(String s){
	//
	// return null;
	// }
	//
	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
	}
	
	//There is another way to do this that uses a stack where we push the first half to a stack. 
	//Then if when we see closed parens we pop the stack and if no match return false. 
	public boolean balancedParen(String s){
		if(s.length() % 2 != 0)
			return false; 
		HashMap<Character,Character> matches = new HashMap<Character,Character>();
		matches.put(new Character('('),new Character(')'));
		matches.put(new Character('['),new Character(']'));
		matches.put(new Character('{'),new Character('}'));

		for(int i=0, j=s.length()-1; i<s.length()/2; i++, j--){
			System.out.println("s is: "+ s.charAt(i) + " j is:"+s.charAt(j));
			if(matches.get(s.charAt(i)) != s.charAt(j))
				return false; 
		}
		return true; 
	}
	
	/*
	 * Finding the median in a variatic stream of numbers. 
	 * 1. We will use min_heap and max_heap for optimal efficiency. Binary Searching
	 * is possible but will take a long time. 
	 * Rules: 
	 * 1. Max heap will contain smallest half and min heap largest half. 
	 * 2. The number of elements in max-heap is either equal to or 1 more then the #
	 * in min-heap. 
	 * 3.If # is odd median is root of max heap, if even then the average of both roots. 
	 * I am not sure if java has heaps built in so maybe take time and implement this. 
	 */
	
	/*
	 * Find the first non repeated character in the string. 
	 */
	public void findUnique(String s){
		HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
		//Get all the letters mapped to a count. 
		for(int i=0; i<s.length(); i++){
			if(counts.containsKey(s.charAt(i)) ){
				char c = s.charAt(i);
				int n = counts.get(s.charAt(i)) + 1; 
				counts.put(c, n);  
			}else{
				counts.put(s.charAt(i), 1); 
			}
		}
		
		for(Map.Entry<Character, Integer> entry : counts.entrySet()){
			if(entry.getValue() == 1){
				System.out.println( entry.getKey()); 
				return; 
			}
		}
		
	}
	
	/*
	 * For anagrams just count all letters in first string then go through second and decrement. 
	 * if a letter reaches negative or the letter doesn't exist they are not anagrams. 
	 */
	
	
	/*
	 * Return index (if exists) in an array of unknown length. 
	 */
	public int findIndexUnknownLength(int[] ar, int findMe){
		boolean notFound = true; 
		int i = 0; 
		while(notFound){
			try{
				int cur = ar[i];
				if(cur == findMe ){
					return i; 
				}
				i++; 
			}catch(NullPointerException e){
				return -1; 
			}
		}
		
		return 0; 
	}
	
	
	
	
	
	
}
