package com.codechef.practice.beginner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

public class CountryLeader {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vkumarv\\eclipse-workspace\\JavaProject\\src\\com\\codechef\\practice\\beginner\\CountryLeader-Small.in"))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				int numOfTcs = Integer.valueOf(sCurrentLine);
				for(int i=0; i<numOfTcs; i++) {
					String leaderName = findCountryLeader(br);
					System.out.println("Case #"+ (i+1) +": " + leaderName);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String findCountryLeader(BufferedReader br) {
		String finalLeader = "";
		try {
			String numOfContestents = br.readLine();
			for(int j=0; j<Integer.valueOf(numOfContestents); j++) {
				String leaderName = br.readLine();
				finalLeader = leaderName;
				int finalLeaderCount = 0;

				HashSet<Character> uniqChars =  new HashSet<>();
				for(int k = 0; k<leaderName.length(); k++) {
					uniqChars.add(leaderName.charAt(k));
				}
				if(uniqChars.size()>finalLeaderCount) {
					finalLeaderCount = uniqChars.size();
					finalLeader = leaderName;
				}else if(uniqChars.size() == finalLeaderCount) {
					TreeSet<String> namesMap = new TreeSet<>();
					namesMap.add(leaderName);
					namesMap.add(finalLeader);
				}
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return finalLeader;
	}

}
