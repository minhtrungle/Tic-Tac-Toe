/*
 * Copyright(C) 2022 Luvina Software Company
 *
 * ReadTheCo.java, Apr 13, 2022 lmtrung
 */

package GameModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Đọc file thế cờ, lưu danh sách các thế cờ vào mảng
 * @author lmtrung
 */
public class ReadTheCo {
	private static final String VALID_LINE = "[OXDGT]{5}";
	/**
	 * Đọc file, lưu dữ liệu file vào mảng.
	 * @return Danh sách các thế cờ có trong file.
	 */
	public List<char[][]> readFile() {
		List<char[][]> listTheCo = new ArrayList<>();

		// Lấy đường dẫn tương đối đến file.
		URL relativeURL = getClass().getResource("TheCo.txt");
		// Tạo đối tượng file.
		File file = new File(relativeURL.getPath());
		// Kiểm tra nếu file không tồn tại.
		if (!file.exists()) {
			System.out.println("File không tồn tại");
			// Trả về danh sách thế cờ rỗng.
			return listTheCo;
		}
		// Khai báo đối tượng đọc file.
		FileReader fileReader = null;
		BufferedReader buffReader = null;

		try {
			// Khởi tạo đối tượng đọc file.
			fileReader = new FileReader(file);
			buffReader = new BufferedReader(fileReader);

			// Khởi tạo biến dùng để từng dòng trong file.
			String line = new String();
			// Đọc file đến khi kết thúc file.
			while (line != null) {
				// Tạo một ma trận để lưu trữ thế cờ.
				char[][] theCo = new char[5][5];
				// Tạo một mảng các chuỗi đẻ lưu trữ các dòng liền kề nhau hợp lệ trong file.
				List<String> matrix = new ArrayList<>();
				
				// Thực hiện vòng lặp 
				while (true) {
					// Đọc từng dùng trong file.
					line = buffReader.readLine();
					
					// Khi gặp phải kết thúc file.
					if (line == null) {
						// Thoát ra khỏi vòng lắp.
						break;
					}
					// Nếu dòng này không có 5 kí tự nằm trong số kí tự O, X, D, G, T
					if (!line.matches(VALID_LINE)) {
						// Thoát ra khỏi vòng lặp.
						break;
						// Nếu thỏa mãn
					} else {
						// Thêm dòng này vào mảng matrix.
						matrix.add(line);
					}
				}
				// Nếu mảng các chuỗi có độ dài là 5
				if (matrix.size() == 5) {
					// Duyệt từng chuỗi trong mảng
					for (int i = 0; i < 5; i++) {
						// Lấy chuỗi của từng dòng ra.
						String str = matrix.get(i);
						// Duyệt qua các kí tự trong chuỗi.
						for (int j = 0; j < 5; j++) {
							// Them kí tự này vào ma trận thế cờ.
							theCo[i][j] = str.charAt(j);
						}
					}
					// Thêm thế cờ vào danh sách thế cờ.
					listTheCo.add(theCo);
				}
			}

			// Nếu có ngoại lệ ở chỗ đọc file
		} catch (IOException e) {
			// In ra màn hình lỗi đọc file
			System.out.println(e.getMessage());

			// Cuối cùng
		} finally {
			try {
				// Đóng các đối tượng đọc file
				buffReader.close();
				fileReader.close();
				// Nếu có ngoại lệ xảy ra.
			} catch (IOException e) {
				// In ra lỗi.
				e.printStackTrace();
			}
		}
		// Trả về danh sách thế cờ có trong file.
		return listTheCo;
	}
}
