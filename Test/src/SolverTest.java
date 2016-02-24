import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolverTest {
	public Solver s = new Solver(); 
	
	@Test
	public void testReverseWords(){
		String correct = "My name is Chris";
		String answer = s.reverseWords("Chris is name My");
		assertEquals(correct, answer);
		
		correct = "";
		answer = s.reverseWords("");
		assertEquals(correct, answer);
		
		correct = "My";
		answer = s.reverseWords("My");
		assertEquals(correct, answer);
	}
	
	@Test 
	public void testAps(){ //how to test void method. 
		int[] arr = {1,4,3,5,6,7,8,9};
		int k = 6; 
		//s.aps(arr, k); 
	}
	
	@Test 
	public void testbalanceParen(){
		String s1 = "({})"; 
		String s2 = "({{)))";
		boolean test = s.balancedParen(s1);
		assertEquals(true, test);
		test = s.balancedParen(s2);
		assertEquals(false, test);
	}
	
	@Test 
	public void testStringCombine(){
		String str1 = "abc"; 
		String str2 = "def"; 
		String str3 = "abdefc"; 
		String str4 = "fdabce"; 
		boolean test = s.stringCombine(str1,str2,str3);
		assertEquals(true, test);
		test = s.stringCombine(str1,str2,str3);
		assertEquals(true,test);
	}

	
}
