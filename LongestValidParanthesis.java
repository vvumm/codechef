import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * 
 * 
Longest Parentheses Substring
You are given a string containing characters '(' and ')'. Print the length of longest valid parentheses substring.

ExampleExample:
Longest valid parentheses substring for "(()" is "()" which has length 2.
Longest valid parentheses substring for ")()())" is "()()" which has length 4.

Input:
The only line of input consists of a string containing parentheses.

Output:
Print the length of longest valid parentheses substring.

Constraints:
1≤length of string≤101≤length of string≤10

Sample Input
(((()))))

Sample Output
8

Explanation
Longest valid parentheses substring is “(((())))” which has length 8

 * @author vkumarv
 *
 */

public class LongestValidParanthesis {
	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		System.out.println(countLongestMatch(inputStr,0));
	}

	private static int countLongestMatch(String input, int start){
		if((input.length()-start)<=1)
			return 0;
		int longestLen = 0;
		int currentLen = 0;
		int count = 0;
		int prevStartIndex = 0;
		for(int i=start;i<input.length();i++){
			switch(input.charAt(i)){
			case '(': ++count;
			break;
			case ')': --count;
			break;
			default :
				continue;
			}
			++currentLen;
			if(count==0){
				longestLen = Math.max(currentLen, longestLen);
				prevStartIndex = i+1;
			} else if(count<0){
				currentLen = 0;
				count = 0;
				prevStartIndex = i+1;
			}
		}
		if(count ==0)
			longestLen = Math.max(currentLen, longestLen);
		else if(count > 0){
			int i=prevStartIndex;
			for(;i<input.length() && count >0; ++i){
				if(input.charAt(i) == '(')
					--count;
				else if(input.charAt(i) == ')')
					++count;
			}
			if(i<input.length()){
				longestLen = Math.max(longestLen, countLongestMatch(input,i));
			}
		}
		return longestLen;
	}
}
