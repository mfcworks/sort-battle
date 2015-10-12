import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class RandomGenerator {
	public static final String FILE_NAME = "random.txt";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("要素数を入力してください: ");
		int n = sc.nextInt();

		try {
			@SuppressWarnings("resource")
			FileWriter fw = new FileWriter(FILE_NAME);

			Random random = new Random();

			// 改行文字
			String newLine = System.getProperty("line.separator");

			fw.write(Integer.toString(n) + newLine);

			for (int i = 0; i < n; i++) {
				fw.write(Integer.toString(random.nextInt(n * 2)) + newLine);
			}
		} catch (IOException e) {
			System.out.println("ファイルの書き込み中にエラーが発生しました。");
			System.exit(1);
		}

		System.out.println("ファイル " + FILE_NAME + " に保存しました。");
	}
}
