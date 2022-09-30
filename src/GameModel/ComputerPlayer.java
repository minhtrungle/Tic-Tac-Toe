/*
 * Copyright(C) 2022 Luvina Software Company
 *
 * ComputerPlayer.java, Apr 13, 2022 lmtrung
 */

package GameModel;

import java.awt.Point;
import java.util.List;
import java.util.Random;


/**
 * Tạo một đối tượng người chơi là máy tính
 * @author lmtrung
 */
public class ComputerPlayer {
	// Trạng thái hiện tại của bàn cờ.
	private char[][] stateBoard;
	// Danh sách các thế cờ đọc ra từ file.
	private List<char[][]> listTheCo;

	/**
	 * Phương thức thể hiện mặc định cho đối tượng người chơi máy.
	 */
	public ComputerPlayer() {
		
	}

	/**
	 * Phương thức thể hiện cho đối tượng máy chơi với trạng thái bàn cờ đã cho.
	 * @param stateBoard Trạng thái bàn cờ đã cho.
	 */
	public ComputerPlayer(char[][] stateBoard) {
		// Thiết lập trạng thái bàn cờ với giá trị đã cho.
		this.stateBoard = stateBoard;
		// Lấy danh sách thế cờ ra từ file.
		setListTheCo();
	}

	/**
	 * Xác định vị trí ô vuông cần đánh.
	 * @return Tọa độ ô vuông cần đánh.
	 */
	public Point determinePosition() {
		// Khởi tao đôi tượng để chọn.
		Point clickPoint = new Point();
		// Biến kiểm tra xem điểm đã được chọn hay chưa.
		boolean isChoose = false;

		// Duyệt theo từng thế cờ trong danh sách thế cờ.
		outerloop:
		for (char[][] theCo : listTheCo) {
			// Duyệt từng mảng 5x5 của bàn cờ.
			for (int i = 0; i < 16; i++) { // Vị trí hàng bắt đầu từ 0 đến 15, hàng cuối là 15 sẽ có ma trận 5x5 
				for (int j = 0; j < 16; j++) { // Vị trí cột bắt đầu từ 0 đến 15, cột cuối là 15 sẽ có ma trận 5x5 
					// Nếu có thế cờ trùng với mảng,
					if (isSameState(theCo, i, j)) { 
						// Xác định giá trị đã chọn được ô vuông.
						isChoose = true;
						// Lấy tọa độ ô vuông cần chọn
						clickPoint = getClickPoint(theCo, i, j);
						// Thoát ra khỏi vòng lặp.
						break outerloop;
					}
				}
			}
		}

		// Nếu không có thế cờ nào trùng khớp.
		if (!isChoose) {
			// Chọn ngẫu nhiên 1 ô vuông để đánh.
			clickPoint = getRandomPoint();
		}
		// Trả về ô vuông cần đánh.
		return clickPoint;
	}
	
	/**
	 * Chọn ngẫu nhiên 1 ô vuông trên bàn cờ mà không có quân cờ nào để đánh.
	 * @return Tọa độ ô vuông cần chọn.
	 */
	private Point getRandomPoint() {
		// Tạo một đối tượng ngẫu nhiên.
		Random random = new Random();
		// BIến dùng để lưu giá trị tọa độ ô vuông.
		int column, row; // hàng và cột
		while (true) {
			// Láy giá trị tọa độ ngẫu nhiên trong khoảng từ 0 đên 20
			column = random.nextInt(20);
			row = random.nextInt(20);

			// Nếu ô vuông đó đang không có quân cờ nào
			if (stateBoard[row][column] == 'T') {
				// thoát ra khỏi vòn lặp
				break;
			}
		}
		// Trả về tọa độ ô vuống với 2 giá trị đã lấy ngẫu nhiên.
		return new Point(column, row);
		
	}

	/**
	 * Lấy tọa độ ô vuông cần chọn từ ma trận thế cờ 5x5 xét trong ma trận cả bàn cờ.
	 * @param theCo	Thế cờ đã chọn.
	 * @param startRow Vị trí theo hàng của ô đầu tiên của ma trận 5x5 trong bàn cờ.
	 * @param startCol Vị trí theo cột của ô đầu tiên của ma trận 5x5 trong bàn cờ.
	 * @return Tọa độ ô vuông cần chọn trong ma trận cả bàn cờ.
	 */
	private Point getClickPoint(char[][] theCo, int startRow, int startCol) {
		// Khởi tạo biến để lưu tọa độ điểm cần chọn.
		Point clickPoint = new Point();

		// Duyệt qua các hàng trong ma trận thế cờ.
		for (int i = 0; i < 5; i++) {
			// Duyệt từng cột của trong hàng của mâ trận thế cờ.
			for (int j = 0; j < 5; j++) {
				// Nếu ô của ma trận thế cờ là 'D'
				if (theCo[i][j] == 'D') {
					// Thiết lập tọa độ cho điểm cần chọn.
					clickPoint.setLocation(j + startCol, i + startRow); // Tại ma trận 5x5 đang xét trên bàn cờ
																		// sẽ đánh vào các tọa độ hàng i và j của theCo cho bàn cờ
				}
			}
		}
		// Trả về kết quả.
		return clickPoint;
	}

	/**
	 * Kiểm tra thế cờ với ma trận 5x5 của thế cờ có giống nhau không.
	 * @param theCo	Thế cờ cần kiểm tra.
	 * @param startRow Vị trí theo hàng của ô đầu tiên của ma trận cần kiểm tra.
	 * @param startCol Vị trí theo cột của ô đầu tiên của ma trận cần kiểm tra.
	 * @return true nếu 2 ma trận giống nhau, false nếu không giống nhau
	 */
	private boolean isSameState(char[][] theCo, int startRow, int startCol) {
		// Duyệt qua các hàng của ma trận thế cờ.
		for (int i = 0; i < 5; i++) {
			// Duyệt qua tưng cột trong hàng này
			for (int j = 0; j < 5; j++) {
				// Trong trường hợp  giá trị ô này khác 'G'
				if (theCo[i][j] != 'G') {
					// Nếu giá trị ô này là 'D'
					if (theCo[i][j] == 'D') {
						// Nếu giá trị ô này khác'T';
						if (stateBoard[startRow + i][startCol + j] != 'T') {
							// trả về false
							return false;
						}
					// Ngược lại, trong trường hợp giá trị ô này khác 'D'
					} else {
						// Nếu giá trị o này khâc giá trị ô trên bàn cờ
						if (theCo[i][j] != stateBoard[startRow + i][startCol + j]) {
							// Trả về false
							return false;
						}
					}

				}

			}
		}
		// Trả về giá trị true.
		return true;
	}

	/**
	 * Đọc danh sách thế cờ từ file rồi ghi vào thuộc tính listTheCo
	 */
	private void setListTheCo() {		
		// Khởi tạo đối tượng đọc file.
		ReadTheCo reader = new ReadTheCo();
		// Lấy danh sách thế cờ từ file và lưu vào thuộc tính listTheCo.
		this.listTheCo = reader.readFile();
	}

}
