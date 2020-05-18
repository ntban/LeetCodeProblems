import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import minimum.array.ArrangeWord;
import minimum.array.PeopleIndexs;

public class Solution {
	public static void main1(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		ArrangeWord solution = new ArrangeWord();
		while (T-- > 0) {
			String text = sc.nextLine();
			System.out.println(solution.arrangeWords(text));
		}
	}
	
	static List<List<String>> favoriteCompanies(String [][]favoriteCompanies1){
		 List<List<String>> list = new ArrayList<>();
		 for(String [] arr:favoriteCompanies1) {
			 List<String> child = new ArrayList<>();
			 for(String s:arr)child.add(s);
			 list.add(child); 
		 }
		return list;
	}
	public static void main(String[] args) {
		String [][]favoriteCompanies1 = {{"leetcode","google","facebook"},{"google","microsoft"},{"google","facebook"},{"google"},{"amazon"}};
		String [][]favoriteCompanies2 = {{"leetcode","google","facebook"},{"leetcode","amazon"},{"facebook","google"}};
		String [][]favoriteCompanies3 = {{"leetcode"},{"google"},{"facebook"},{"amazon"}};
		String [][]favoriteCompanies4 ={{"arrtztkotazhufrsfczr","knzgidixqgtnahamebxf","zibvccaoayyihidztflj"},{"cffiqfviuwjowkppdajm","owqvnrhuzwqohquamvsz"},{"knzgidixqgtnahamebxf","owqvnrhuzwqohquamvsz","qzeqyrgnbplsrgqnplnl"},{"arrtztkotazhufrsfczr","cffiqfviuwjowkppdajm"},{"arrtztkotazhufrsfczr","knzgidixqgtnahamebxf","owqvnrhuzwqohquamvsz","qzeqyrgnbplsrgqnplnl","zibvccaoayyihidztflj"}};
		String [][]favoriteCompanies5 ={{"1","2","3"},
			{"6","4"},
			{"2","4","5"},
			{"1","6"},
			{"1","2","4","5","3"}};
		PeopleIndexs soIndexs = new PeopleIndexs();
		List<Integer> result = soIndexs.peopleIndexes(favoriteCompanies(favoriteCompanies4));
		for(Integer i:result)System.out.print(i+" ");
	}
}
