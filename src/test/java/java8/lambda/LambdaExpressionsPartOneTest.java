package java8.lambda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
/*
 * Solutions to Lambda Expressions Part 1 Exercises
 * 
 * http://www.java-programming.info/tutorial/pdf/java/exercises/exercises-lambdas-1.pdf
 *
 */
public class LambdaExpressionsPartOneTest {

	@Test
	public void testSortByLength() {
		String[] r = { "foooo", "barr", "baz" };
		Arrays.sort(r, (String a, String b) -> {return a.length() - b.length();});
		assertTrue(Arrays.equals(new String[]{"baz", "barr", "foooo"}, r));
	}

	@Test
	public void testSortByReverseLength() {
		String[] r = { "foooo", "barr", "baz" };
		Arrays.sort(r, (String a, String b) -> {return -1 * (a.length() - b.length());});
		assertTrue(Arrays.equals(new String[]{"foooo", "barr", "baz"}, r));
	}

	
	@Test
	public void testSortAlphabetcially() {
		String[] r = { "foooo", "barr", "caz" };
		Arrays.sort(r, (String a, String b) -> {return a.charAt(0) - b.charAt(0);});
		System.out.println(Arrays.toString(r));
	}

	@Test
	public void testSortStringsThatContainE() {
		String[] r = { "foooo", "barr", "caez" };
		Arrays.sort(r, (String a, String b) -> {		int compareFlag = 0;
        if(a.contains("e") && !b.contains("e")) {
            compareFlag = -1;
          } else if(a.contains("e") && !b.contains("e")) {
            compareFlag = 1;
          }
          return(compareFlag);});
		
		
		assertTrue(Arrays.equals(new String[]{"caez", "foooo", "barr"}, r));
	}
	
	@Test
	public void testBetterString() {
		String a = "apple";
		String b = "orange";

		assertEquals(a, betterString(a, b, (x, y) -> x.charAt(0) < y.charAt(0)));
		assertEquals(b, betterString(a, b, (x, y) -> x.length() > y.length()));
	}

	private String betterString(String a, String b, TwoStringPredicate<String> p) {
		return p.apply(a, b) ? a : b;
	}

	@FunctionalInterface
	public interface TwoStringPredicate<T> {
		public boolean apply(T a, T b);
	}
}