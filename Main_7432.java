
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7432 {

	static int N, cnt;
	static TriNode root;
	static StringBuffer sb = new StringBuffer();

	static class TriNode {
		TriNode[] children;
		boolean isNumber;
		int cnt;

		public TriNode() {
			this.children = new TriNode[52];// 26+10+16
			this.isNumber = false;
			this.cnt = 1;
		}
	}

//!#$%&'()-@^_`{}~
	static int initidx(char c) {
		if(c=='!')
			return 36;
		if(c=='#')
			return 36;
		if(c=='$')
			return 36;
		if(c=='%')
			return 36;
		if(c=='&')
			return 36;
		if(c==39)
			return 36;
		if(c=='(')
			return 36;
		if(c==')')
			return 36;
		if(c=='-')
			return 36;
		if(c=='@')
			return 36;
		if(c=='^')
			return 36;
		if(c=='_')
			return 36;
		if(c=='`')
			return 36;
		if(c=='{')
			return 36;
		if(c=='}')
			return 36;
		if(c=='~')
			return 36;
		return 0;
		
	}

	static void Insert(String str) {
		TriNode cur = root;

		for (int i = 0; i < str.length(); i++) {
			int idx = 0;
			if ((int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90)
				idx = str.charAt(i) - 'A';
			else if ((int) str.charAt(i) >= 48 && (int) str.charAt(i) <= 57)
				idx = 26 + str.charAt(i) - '0';
			else if ((int) str.charAt(i) >= 48 && (int) str.charAt(i) <= 57)
				idx = 26 + str.charAt(i) - '0';
			else
				idx=initidx(str.charAt(i));
			
			if (cur.children[idx] == null) {
				cur.children[idx] = new TriNode();

				// cur = cur.children[idx];
			}
			cur = cur.children[idx];
		}
		cur.isNumber = true;
	}

	static boolean find(String str) {
		TriNode cur = root;

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'a';

			if (cur.children[idx] == null) {
				sb.append(str.charAt(i));
				return false;
			}
			sb.append(str.charAt(i));
			count++;
			cur = cur.children[idx];
		}
		if (count == str.length() && cur.isNumber == true) {
			sb.append(Integer.toString(cur.cnt + 1));
			cur.cnt++;
			return true;
		} else
			return false;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		root = new TriNode();
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			find(s);
			Insert(s);
			System.out.println(sb);
			sb.setLength(0);
		}

	}

}
