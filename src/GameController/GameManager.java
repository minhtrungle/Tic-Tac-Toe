/*
 * Copyright(C) 2022 Luvina Software Company
 *
 * GameManager.java, Apr 14, 2022 lmtrung
 */

package GameController;

import java.awt.Point;

import GameDetector.GameDetector;
import GameModel.ComputerPlayer;
import GameModel.Square;

/**
 * Điều khiển chương trình
 * @author lmtrung
 */
public class GameManager {

	// Lượt đi của quân tròn hay quân x, true nếu là lượt đi của quân tròn.
	private boolean isOvalTurn;
	
	// Lưu lại giá trị các ô cờ.
	private Square[][] currBoard;
	
	// Trạng thái các ô cờ hiện tại dưới dạng logic
	private char[][] stateBoard;
	
	// Người chơi là máy tính.
	private ComputerPlayer computerPlayer;
	
	// Xác định đã kết thức game hay chưa.
	private GameDetector gameDetector;
	
	// Xác định đã có quân giành chiến thắng.
	private boolean checkWin;

	
	/**
	 * Khởi tạo một đối tượng GameManager
	 */
	public GameManager() {
	}
	
	/**
	 * Khởi tạo một đối tượng GameManager với trạng thái bàn cờ đã cho, lượt đi của quân 
	 * tròn đầu tiên
	 * @param currBoard	Mảng lưu lại trạng thái của ô cờ.
	 * @param isOvalTurn Lượt chơi đã cho.
	 */
	public GameManager(Square[][] currBoard, boolean isOvalTurn) {
		// Đặt trạng thái của bàn cờ là giá trị đã cho.
		this.currBoard = currBoard;
		// Đặt giá trị cho isOverTurn là true, quân tròn đi trước.
		this.isOvalTurn = isOvalTurn;
		// Đặt giá trị cho checkWin là false, quân chưa giành chiến thắng.
		checkWin = false;
		// Khởi tạo biến lưu trạng thái bàn cờ hiện tại.
		stateBoard = new char[20][20];
		// Cập nhật trạng thái hiện tại cho stateBoard.
		this.update();
		// Khới tạo đối tượng người chơi máy.
		computerPlayer = new ComputerPlayer(stateBoard);
		// Khởi tạo đối tượng để kiểm tra chiến thắng.
		gameDetector = new GameDetector(stateBoard);
	}
	
	/**
	 * Bắt đầu trò chơi.
	 */
	public void startGame() {
		// Nếu lượt chơi của máy.
		if (isOvalTurn == false) {
			// Đặt mặc định quân của máy vào ô có tọa độ (10, 10) trong bàn cờ.
			currBoard[10][10].setcurrentPiece(Square.X_PIECE);
			isOvalTurn = true;
		}
	}
	
	/**
	 * Điều khiển lượt chơi cho các quân cờ.
	 * @param square Ô vuông mà người chơi click vào.
	 */
	public void manageGame(Square square) {
		
		// Nếu ô vuông mà người chơi click vào không có quân nào trống.
		if (square.getcurrentPiece() == Square.NO_PIECE) {
			// Nếu đến lượt của quân tròn (Quân của người chơi).
			if (isOvalTurn == true) {
				// Đặt quân cờ cho người chơi tại ô vuông mà người chơi click.
				square.setcurrentPiece(Square.O_PIECE);
				// Cập nhật trạng thái của trò chơi.
				this.update();
				// Khởi tạo đối tương ghi lại tọa độ người dùng đã click.
				Point humanClick = new Point(square.getcolumn(), square.getrow());
				// Thiết lập thược tính curPoint cho đối tượng gameDetecter.
				gameDetector.setCurrPoint(humanClick);
				// Nếu người chơi giành chiến thắng.
				if (((GameDetector) gameDetector).checkWin()) {
					// Cập nhất giá trị cho biến checklWin là true.
					checkWin = true;
					// Rời khỏi phương thức.
					return;
				}
				// Đổi lượt chơi.
				isOvalTurn = !isOvalTurn;
			}
			
			// Nếu đến lượt của máy tính.
			if (isOvalTurn == false) {
				// Máy tính xác định tọa độ ô vuông cần đánh.
				Point computerPoint = computerPlayer.determinePosition();
				// Lấy tọa độ ô vuông cần đánh theo trục dọc.
				int colmn = (int) computerPoint.getY();
				// Lấy tọa độ ô vuông cần đánh theo trục ngang
				int row = (int) computerPoint.getX();
				
				// Thiết lập thuộc tính curPoint cho đối tượng gameDetector.
				gameDetector.setCurrPoint(computerPoint);
				// Đặt quân cờ vào ô vuông mà máy đã chọn.
				currBoard[colmn][row].setcurrentPiece(Square.X_PIECE);
				// Cập nhật trạng thái bàn cờ.
				this.update();
				// Nếu máy tính giành chiến thắng.
				if (gameDetector.checkWin()) {
					// Đặt giá trị biến checkWin là true.
				checkWin = true;
					// Rời khỏi phương thức.
					return;
				}
				// Đổi phương thức.
				isOvalTurn = !isOvalTurn;
			}
			
		}
	}
	
	/**
	 * Tạo ra một ván cờ mới.
	 */
	public void resetGame() {
		// Thiết lập trạng thái bàn cờ đều là không có quân cờ.
		// Duyệt tất cả các ô cờ.
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				// Thiết lập các ô vuông không chứa quân cờ nào cả.
				this.currBoard[i][j].setcurrentPiece(Square.NO_PIECE);
			}
		}
		// Cập nhật lại trạng thái bàn cờ.
		this.update();
		// Thiết lập lượt chơi mới.
		this.isOvalTurn = true;
		// Thiết lập giá trị kiểm tra quân tròn thắng chưa.
		this.checkWin = false;
	}
	
	/**
	 * Cập nhật trạng thái hiện tại của bàn cờ.
	 */
	private void update() {
		// Duyệt theo từng hàng.
		for (int i = 0; i < 20; i++) {
			// Duyệt từng ô của từng hàng.
			for (int j = 0; j < 20; j++) {
				// Nếu ô vuông hiện tại không có quân cờ nào.
				if (currBoard[i][j].getcurrentPiece() == Square.NO_PIECE) {
					// Đặt trạng thái của ô cờ này là 'T'
					stateBoard[i][j] = 'T';
					// Nếu ô vuông hiện tại có chưa quân tròn.
				} else if (currBoard[i][j].getcurrentPiece() == Square.O_PIECE) {
					// Đặt trạng thái của ô cờ này là 'O'
					stateBoard[i][j] = 'O';
					// Nếu ô vuông hiện tại có chứa quân X
				} else {
					// Đặt trạng thái của ô cờ này là 'X'
					stateBoard[i][j] = 'X';
				}
			}
		}
	}
	
	/**
	 * Lấy giá trị lượt chơi hiện tại.
	 * @return true Nếu là lượt chơi của quân tròn, false nếu là lượt chơi của quân X.
	 */
	public boolean isOvalTurn() {
		return isOvalTurn;
	}

	/**
	 * Thiết lập giá trị lượt chơi hiện tại.
	 * @param isOvalTurn Giá trị lượt chơi cần thiết lập.
	 */
	public void setOvalTurn(boolean isOvalTurn) {
		this.isOvalTurn = isOvalTurn;
	}

	/**
	 * Lấy trạng thái hiện tại của bàn cờ.
	 * @return Trạng thái hiện tại của bàn cờ.
	 */
	public Square[][] getCurrBoard() {
		return currBoard;
	}

	/**
	 * Thiết lập trạng thái cho bàn cờ.
	 * @param currBoard	Trạng thái bán cờ cần thiết lập.
	 */
	public void setCurrBoard(Square[][] currBoard) {
		this.currBoard = currBoard;
	}

	/**
	 * Lấy giá trị của biến isOvalWin.
	 * @return Giá trị của biến isOvalWin.
	 */
	public boolean checkWin() {
		return checkWin;
	}

	/**
	 * Thiết lập giá trị cho biến checklWin.
	 * @param checkWin Giá trị cần thiết lập.
	 */
	public void setcheckWin(boolean checkWin) {
		this.checkWin = checkWin;
	}
}
	