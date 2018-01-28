import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * 
Modify the Array
-----------------
Given an array and two integers II and JJ, modify the array such that you retain II nodes, then delete JJ nodes. 
Do this till end of the array. See the sample input and output for clarity.

Input:
First line consists of comma separated values of integers.
Second line contains the value of II.
Third line contains the value of JJ.

Output:
SIngle line containing comma separated values of integers.

Constraints:
1≤integer value≤101≤integer value≤10
1≤I≤101≤I≤10
1≤J≤101≤J≤10

Sample Input
1,2,3,4,5,6,10,8
3
1

Sample Output
1,2,3,5,6,10

Explanation
We retain 1,2,3; then delete 4. Then we retain 5,6,10 and delete 8.

 * 
 * 
 * @author vkumarv
 *
 */
public class ModifyArray {

	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int i = Integer.parseInt(br.readLine());
		int j = Integer.parseInt(br.readLine());
		String[] inputStrArry = input.split(",");
		StringBuffer sb = new StringBuffer();
		int tempI = i;
		int tempJ = j;
		for(int currIndex=0; currIndex+i<input.length();){
			if(tempI<=0)
				tempI = i;
			while(tempI>0 && currIndex<inputStrArry.length){
				sb.append(inputStrArry[currIndex]+",");
				tempI--;
				currIndex++;
			}
			if(tempJ>0 && currIndex+tempJ<input.length()){
				currIndex = currIndex+tempJ;
			}
		}

		System.out.println(sb.substring(0, sb.length()-1));
	}
}
