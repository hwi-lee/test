package Ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234 {

	static int L, R, N, sum, cnt, ans, check;
	static int[][] map, copymap;
	static boolean[][] visited;
	static ArrayList<int[]> a;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { i, j });
		visited[i][j] = true;
		a.add(new int[] { i, j });
		sum = map[i][j];
		cnt = 1;
		while (!q.isEmpty()) {
			int p[] = q.poll();
			int r = p[0];
			int c = p[1];
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (!visited[nr][nc] && Math.abs(map[nr][nc] - map[r][c]) >= L
						&& Math.abs(map[nr][nc] - map[r][c]) <= R) {
					visited[nr][nc] = true;
					a.add(new int[] { nr, nc });
					q.offer(new int[] { nr, nc });
					sum += map[nr][nc];
					cnt++;
				}
			}

		}

	}

	public static void visit(int i, int j) {

		copymap[i][j] = sum / cnt;
		while (!a.isEmpty()) {
			int remove[] = a.remove(0);
			int r = remove[0];
			int c = remove[1];
			copymap[r][c] = sum / cnt;

		}

	}

	public static void function() {
		Queue<int[]> q = new LinkedList<int[]>();
		visited = new boolean[N][N];
		q.offer(new int[] { 0, 0 });
		check = 0;
		visited[0][0]=true;
		while (!q.isEmpty()) {
			int p[] = q.poll();
			int r = p[0];
			int c = p[1];
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
					if (Math.abs(map[nr][nc] - map[r][c]) >= L && Math.abs(map[nr][nc] - map[r][c]) <= R)
						check++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		copymap = new int[N][N];
		visited = new boolean[N][N];
		a = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copymap[i][j] = map[i][j];
			}
		}

		while (true) {
			//function();
			check=0;

			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
						if (a.size()>1) {
							visit(i, j);
							check++;
							}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = copymap[i][j];
				}
			}

		
			ans++;
			if (check == 0)
				break;
		}
		System.out.println(ans);
	}

}
