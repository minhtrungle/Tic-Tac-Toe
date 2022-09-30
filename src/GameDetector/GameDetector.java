/*
 * Copyright(C) 2022 Luvina Software Company
 *
 * GameDetector.java, Apr 14, 2022 lmtrung
 */

package GameDetector;

import java.awt.Point;

/**
 * Đối tượng của lớp GameDetector dùng để kiểm tra xem đã có quân cờ nào thắng hay chưa.
 * @author lmtrung
 */
public class GameDetector {
	// Giá trị hằng số của quân cờ tròn.
	public static final char O_PLAYER = 'O';
	// Giá trị hằng số của quân cờ X.
	public static final char X_PLAYER = 'X';
	// Tọa độ mà người chơi chọn để đánh.
	private Point currPoint;
	// Trạng thái bàn cờ hiện tại.
	private char[][] stateBoard;
	
	/**
	 * Tạo ra một thể hiện của lớp GameDetector với trạng thái bàn cờ đã cho.
	 * @param stateBoard
	 */
	public GameDetector(char[][] stateBoard) {
		this.stateBoard = stateBoard;
	}
	
	/**
	 * Kiểm tra trong ma trận 5x5 đã có hàng nào đủ 5 quân cờ cùng 1 loại hay chưa.
	 * @param startRow Vị trí theo hàng của ô bắt đầu của ma trận 5x5 trong bàn cờ
	 * @param startCol Ví trí theo cột của ô bắt đầu của ma trận 5x5 trong bàn cờ.
	 * @param player Người chơi cần xác định.
	 * @return true nếu quân cờ của người chơi có 5 ô trong cùng 1 hàng có cùng loại,
	 *         false nếu không có hàng nào thỏa mãn.
	 */
	public boolean checkRowLine(int startRow, int startCol, char player) {
		// Khởi tạo biến ghi nhận kết quả.
		boolean status = false;
			// Duyệt qua các hàng của ma trận 5x5.
			for (int i = startRow; i < startRow + 5; i++) { //Cứ một ma trận 5x5 đang duyệt ta xét trong hàng lần lượt từ trái qua phải
				// Lấy giá trị cột của ô đầu tiên.
				int j = startCol;
				// Nếu trong hàng này, cả 5 ô đều chứa quân cờ cùng 1 loại.
				if ((stateBoard[i][j] == player) && (stateBoard[i][j+1] == player) && (stateBoard[i][j+2] == player) 
						&& (stateBoard[i][j+3] == player) && (stateBoard[i][j+4] == player)) {
					// Kết quả bằng true.
					status = true;
					// Thoát khỏi vòng lặp.
					break;
				}
			}
		
		// Trả về kết quả.
		return status;
	}
	
	/**
	 * Kiểm tra trong ma trận 5x5 đã có cột nào đủ 5 quân cờ cùng 1 loại hay chưa.
	 * @param startRow Vị trí theo hàng của ô bắt đầu của ma trận 5x5 trong bàn cờ.
	 * @param startCol Ví trí theo cột của ô bắt đầu của ma trận 5x5 trong bàn cờ.
	 * @param player Người chơi cần xác định.
	 * @return true nếu quân cờ của người chơi có 5 ô trong cùng 1 cột có cùng loại,
	 *         false nếu không có cột nào thỏa mãn.
	 */
	public boolean checkColLine(int startRow, int startCol, char player) {
		// Khởi tạo biến ghi nhận kết quả.
		boolean status = false;
		// Duyệt qua các cột của ma trận 5x5.
			for (int j = startCol; j < startCol + 5; j++) { //Cứ một ma trận 5x5 đang duyệt ta xét trong cột lần lượt từ trên xuống dưới
				// Lấy giá trị hàng của ô đầu tiên.
				int i = startRow;
				// Nếu trong cột này, cả 5 ô đều chứa quân cờ cùng 1 loại.
				if ((stateBoard[i][j] == player) && (stateBoard[i+1][j] == player) && (stateBoard[i+2][j] == player)
						&& (stateBoard[i+3][j] == player) && (stateBoard[i+4][j] == player)) {
					// Kết quả bằng true.
					status = true;
					// Thoát khỏi vòng lặp.
					break;
				}
			}
		
		// Trả về kết quả.
		return status;
	}
	
	/**
	 * Kiểm tra 1 trong 2 đường chéo của ma trận 5x5 đã có đường nào có đủ 5 quân cờ cùng loại hay chưa.
	 * @param startRow Vị trí theo hàng của ô bắt đầu của ma trận 5x5 trong bàn cờ.
	 * @param startCol Vị trí theo cột của ô bắt đầu của ma trận 5x5 trong bàn cờ.
	 * @param player Người chơi cần xác định.
	 * @return true nếu quân cờ của người chơi có 5 ô trong cùng 1 đường chéo có cùng loại,
	 *         false nếu không có đường chéo nào thỏa mãn.
	 */
	public boolean checkDiagonalLine(int startRow, int startCol, char player) {
		// Khởi tạo biến ghi nhận kết quả.
		boolean status = false;
		// Lấy giá trị hàng của ô đầu tiên.
		int i = startRow;
		// Lấy giá trị cột của ô đầu tiên.
		int j = startCol;
			// Duyệt đường chéo chính, nếu cả 5 quần cờ của đường chéo chính đều cùng 1 loại.
			if ((stateBoard[i][j] == player) && (stateBoard[i+1][j+1] == player) && (stateBoard[i+2][j+2] == player)
					&& (stateBoard[i+3][j+3] == player) && (stateBoard[i+4][j+4] == player)) {
				// Kết quả là true.
				status = true;
			} 
			
			// Duyệt đường chéo phụ, nếu cả 5 quần cờ của đường chéo phụ đều cùng 1 loại.
			if ((stateBoard[i][j+4] == player) && (stateBoard[i+1][j+3] == player) && (stateBoard[i+2][j+2] == player)
					&& (stateBoard[i+3][j+1] == player) && (stateBoard[i+4][j] == player)) {
				// Kết quả là true.
				status = true;
			} 
		
		// Trả về kết quả.
		return status;
	}
	
	
	/**
	 * Kiểm tra xem có quân tròn hay x đã giành chiến thắng hay chưa.
	 * @return true nếu giành chiến thắng, false nếu quân tròn chưa giành chiến thấng.
	 */
	public boolean checkWin() {
		// Khởi tạo biến ghi nhận kết quả.
		boolean status = false;
		// Lấy tọa độ của điểm mà người chơi đã chọn.
		int currRow = (int) currPoint.getY();   // Tọa độ của hàng chọn trong bàn cờ là tọa độ Y 
		int currColmn = (int) currPoint.getX(); // Tọa độ của cột chọn trong bàn cờ là tọa độ X 
		
		// Duyệt tất cả ma trận 5x5 có chứa ô vừa được chọn
		outerloop:
		// Duyệt các ma trận với ô bắt đầu ở hàng i từ trái qua phải
		/*currRow max là 19 (tọa độ trong ma trận 20x20) ô đầu tiên currRow = 8, currColmn = 5
		thì ta xét từ các ma trận 5x5 từ hàng 4 đến hàng 12 cột 1 đến cột 9*/
		for (int i = currRow - 4; i <= currRow + 4; i++) { 
			// Duyệt các ma trận với ô bắt đầu ở cột j từ trên xuống dưới
			for (int j = currColmn - 4; j <= currColmn + 4; j++) { // currColmn max là 19 (tọa dộ trong ma trận 20x20)
				// Nếu ma trận 5x5 này nằm trong bàn cờ. 
				if ((i >= 0 && i <= 15) && (j >= 0 && j <= 15)) {
					// Kiểm tra theo hàng của ma trận này, nếu có hàng nào thỏa mãn
					if (checkRowLine(i, j, O_PLAYER)) {
						// Ghi nhận kết quả là true.
						status = true;
						// Thoát ra khỏi vòng lặp.
						break outerloop;
					} else {
						if (checkRowLine(i, j, X_PLAYER)) {
							// Ghi nhận kết quả là true.
							status = true;
							// Thoát ra khỏi vòng lặp.
							break outerloop;
						}
					}
					// Kiểm tra theo cột của ma trận này, nếu có cột nào thỏa mãn
					if (checkColLine(i, j, O_PLAYER)) {
						// Ghi nhận kết quả là true.
						status = true;
						// Thoát ra khỏi vòng lặp.
						break outerloop;
					} else {
						if (checkColLine(i, j, X_PLAYER)) {
							// Ghi nhận kết quả là true.
							status = true;
							// Thoát ra khỏi vòng lặp.
							break outerloop;
						}
					}
					// Kiểm tra theo đường chéo cột của ma trận này, nếu có đường chéo nào thỏa mãn
					if (checkDiagonalLine(i, j, O_PLAYER)) {
						// Ghi nhận kết quả là true
						status = true;
						// Thoát ra khỏi vòng lặp.
						break outerloop;
					} else {
						if (checkDiagonalLine(i, j, X_PLAYER)) {
							// Ghi nhận kết quả là true.
							status = true;
							// Thoát ra khỏi vòng lặp.
							break outerloop;
						}
					}
				}
			}
		}
		
		// Trả về kết quả.
		return status;
	}
	/**
	 * Thiết lập giá trị thuộc tính currPoint cho lớp.
	 * @param currPoint Giá trị thuộc tính currPoint cho trước.
	 */
	public void setCurrPoint(Point currPoint) {
		this.currPoint = currPoint;
	}
}