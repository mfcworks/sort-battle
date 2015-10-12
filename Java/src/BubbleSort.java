import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class BubbleSort {
	public static final String FILE_NAME = "../randgen/random.txt";

	public static void bubbleSort(int[] x) {
		int n = x.length;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (x[j] > x[j+1]) {
					int tmp = x[j];
					x[j] = x[j+1];
					x[j+1] = tmp;
				}
			}
		}
	}

	public static boolean isSorted(int[] x) {
		for (int i = 0; i < x.length - 1; i++) {
			if (x[i] < x[i+1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] x = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

			int n = Integer.parseInt(br.readLine());
			x = new int[n];

			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(br.readLine());
			}

			br.close();

		} catch (IOException e) {
			System.out.println("ファイルが見つからないか、読み出し中に問題が発生しました。");
			System.exit(1);
		}

		long start = System.currentTimeMillis();
		bubbleSort(x);
		long end = System.currentTimeMillis();
		System.out.println("経過時間 " + (end - start) + "ms");
	}

}
