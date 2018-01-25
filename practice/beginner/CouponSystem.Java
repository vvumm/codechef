import java.util.Scanner;

/**
 * 
 *  Input
	
	The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
	The first line of each test case contains a single integer n denoting the number of coupons.
	Each of the next n lines contains three space-separated integers city c, level l and discount x applicable in the i-th coupon.

	1
	7
	2 1 10
	1 1 20
	3 2 100
	2 3 50
	2 2 100
	5 3 75
	100 3 75
	
	Output
	
	For each test case, output three lines. The first line should contain two space-separated integers: 
	maximum discount for level 1, and the city where you can avail this discount. In case of ties, 
	find the smallest numbered such city. Similarly, second and third line should contain similar info for second and third levels.
	
	20 1
	100 2
	75 5
 * 
 * 
 * @author Vinay Kumar
 *
 */
public class CouponSystem {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int numOfTcs = scr.nextInt();
		scr.nextLine();
		for(int i=0; i<numOfTcs; i++)
			findBestCouponsForCities(scr);
	}

	private static void findBestCouponsForCities(Scanner scr) {
		int numOfCoupons = scr.nextInt();
		int city1 = -1, city2 = -1, city3 = -1, disc1 = -1, disc2 = -1, disc3 = -1;
		scr.nextLine();
		for(int i=0; i<numOfCoupons; i++) {
			String lineStr = scr.nextLine();
			String[] line = lineStr.split(" ");
			if(Integer.valueOf(line[1])==1) {
				if(disc1 < Integer.valueOf(line[2])) {
					disc1 = Integer.valueOf(line[2]);
					city1 = Integer.valueOf(line[0]);
				}else if(disc1 == Integer.valueOf(line[2]) && Integer.valueOf(line[0]) < city1) {
					city1 = Integer.valueOf(line[0]);
				}
			}else if(Integer.valueOf(line[1])==2) {
				if(disc2 < Integer.valueOf(line[2])) {
					disc2 = Integer.valueOf(line[2]);
					city2 = Integer.valueOf(line[0]);
				}else if(disc2 == Integer.valueOf(line[2]) && Integer.valueOf(line[0]) < city2) {
					city2 = Integer.valueOf(line[0]);
				}
			}else if(Integer.valueOf(line[1])==3) {
				if(disc3 < Integer.valueOf(line[2])) {
					disc3 = Integer.valueOf(line[2]);
					city3 = Integer.valueOf(line[0]);
				}else if(disc3 == Integer.valueOf(line[2]) && Integer.valueOf(line[0]) < city3) {
					city3 = Integer.valueOf(line[0]);
				}
			}
		}
		System.out.println(disc1 + " " + city1);
		System.out.println(disc2 + " " + city2);
		System.out.println(disc3 + " " + city3);
	}
}
