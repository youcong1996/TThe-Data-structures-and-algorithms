package cn.solution.quesion.example;

import java.util.Random;

//字谜问题 参考:https://www.cnblogs.com/zuoxiaolong/archive/2013/09/18/algorithm1.html
public class PuzzleExample {

	public static final Random RANDOM = new Random(47);
	
	public static final String[] WORDS = new String[] {"ynz","yzgm","oqz","owznt","z"};
	
   
	public static void findWord(char[][] chars) {
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < chars.length; i++) {
			
			for (int j = 0; j < chars.length; j++) {
				
				
				for (int k = 0; k < chars.length; k++) {
				
					for (int l = 0; l < chars.length; l++) {
						
						if(i == k && j == l) {
							
							printWord(String.valueOf(chars[i][j]), i, j, k, l);
							
							continue;
						}
						
						
						if(k!=i && j !=l && (k-i)!=(j-l)&& (k-i)!=(l-j)) {
							continue;
						
						}
			
					
						StringBuffer stringBuffer = new StringBuffer();
						
						if(i==k) {
							
							if(j>l) {
								for (int m = j; m >=l; m--) {
									
									stringBuffer.append(chars[i][m]);
								}
								
							}else {
								for (int m = j; m <=1; m++) {
									stringBuffer.append(chars[i][m]);
								}
							}
						}
						
						if(j==l) {
							
							if(i>k) {
								for (int m = i; m >=k; m--) {
								
									stringBuffer.append(chars[m][j]);
								}
								
							}else {
								for (int m = i; m <=k; m++) {
									stringBuffer.append(chars[m][j]);
								}
							}
						}
						
						if((k-i) == (j-l)) {
							
							if(i>k) {
								for (int m = i,n=j; m >=k && n <= 1; m--,n++) {
									stringBuffer.append(chars[m][n]);
									
								}
							}else {
								for (int m = i,n = j; m <= k && n >= l; m++,n--) {
									stringBuffer.append(chars[m][n]);
								}
							}
						}
						
						if((k-i) == (l-j)) {
							if(i>k) {
								for (int m = i,n = j; m >= k && n >= l; m--,n--) {
									stringBuffer.append(chars[m][n]);
									
								}
							}else {
								
								for (int m = i,n=j; m <= k && n <=1 ;m++,n++) {
									stringBuffer.append(chars[m][n]);
									
								}
							}
						}
						printWord(stringBuffer.toString(), i, j, k, l);
					}
					
				}
			}
		}
		
		System.out.println("------------------------------");
		System.out.println("cost time:"+(System.currentTimeMillis()-start)+"ms");
	}
	
	//判断是否是既定的一个单词(或字符串)并打印
	public static void printWord(String word,int i,int j,int k,int l) {
		for (int m = 0; m < WORDS.length; m++) {
			
			if(word.equals(WORDS[m])) {
				
				System.out.println("find word:"+WORDS[m]);
				System.out.println("scalar:"+"["+(i+1)+","+(j+1)+"]->"+(k+1)+","+(l+1)+"]");
			}
		}
	}
	
	
	//创建随机字符二维数组
	public static char[][] createTable(int length){
		
		char[][] chars = new char[length][length];
		
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chars.length; j++) {
				chars[i][j] = (char)(97+RANDOM.nextInt(26));
				
			}
		}
		
		return chars;
	}
	
	
	//打印二维数组
	public static void printTable(char[][] chars) {
		System.out.println("-------------");
		for (int i = 0; i < chars.length; i++) {
			System.out.println("\t"+(i+1));	
		}
		
		System.out.println();
		
		for (int i = 0; i < chars.length; i++) {
			System.out.println((i+1));
			for (int j = 0; j < chars.length; j++) {
				System.out.println("\t"+chars[i][j]);
			
			}
			System.out.println();
		}
	System.err.println("----------------------------------------");
	}
	
	
	public static void main(String[] args) {
		char[][] chars = createTable(5);
		printTable(chars);
		findWord(chars);
	}
	
}

