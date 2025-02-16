package Ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10597 {
	static int len,N;
	static int[] index;
	static boolean visited[];
	static StringBuilder sb;

	public static void combi(int index) {
		if(index>11*2-2) {
			System.out.println(sb);
			return;
			
			}
		
		
		for(int i=index;i<11-1;i++) {
			if(!visited[i]) {
				visited[i]=true;
				sb.insert(i, " ");
				System.out.println(sb);
				combi(i+2);
				visited[i]=false;
			}
		}
		
	}

	public static void check() {

	}

	public static void main(String[] args) throws IOException {

		// 4 1 1 1 1 0 9 8 7 6 5 3 2 ->13=len N=11  9+(len-9)/2=11+2
		// 4 1 1 1 1 0 9 8 7 65 32->8-10   8+(20-8)/2=14
		//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 len=23 N=9+(23-9)/2=  9+7=16
	    //1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 len=21 N=9+(21-9)/2=  9+6=15
		//		N=9+(len-8)/2
		// 공백이 최대12->N-1
		// index위치 1,3,5 ...N*2-2
		// 1-N N<10이면 경우의 수가 하나,
		// 공백의 개수 8~N-1 = 6-12
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String s = br.readLine();
		sb.append(s);

		//8+(N-8)/2-> 공백의 최대크기
		len = sb.length();
		
	
		index=new int[len-1];
		
		int k = 1;
		for (int i = 0; i < len - 1; i++) {
			index[i] = k;
			k += 2;
		}

		System.out.println(sb);
		for (int i = 0; i < N - 1; i++) {
			System.out.print(index[i] + " ");
		}

		
		//System.out.println(sb);
		combi(0);
		
		/*for (int i = len / 2; i <= len - 1; i++) {
			visited=new boolean[index.length];
			combi(0, 0, i);
		}*/

	}

}
