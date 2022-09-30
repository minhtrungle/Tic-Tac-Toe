/*
 * Copyright(C) 2022 Luvina Software Company
 *
 * Square.java, Apr 13, 2022 lmtrung
 */

package GameModel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Định nghĩa đối tượng ô vuông, đây là từng ô chứa quân cờ trong ma trận
 * @author lmtrung
 */
public class Square extends JComponent{

	private static final long serialVersionUID = 1L;
	// Hằng số ghi nhận trạng thái không có quân cờ nào.
	public static final int NO_PIECE = 0; 
	// Hàng số ghi nhận trạng thái ô vuông đang có quân tròn.
	public static final int O_PIECE = 1;
	// Hàng số ghi nhận trạng thái ô vuông đang có quân X.
	public static final int X_PIECE = -1;
	
	// Quân cờ hiện tại.
	private int currentPiece;
	// Tọa độ ô vuông trong bàn cờ theo cột.
	private int column;
	// Tọa độ ô vuông trong bàn cờ theo hàng.
	private int row;
	// Ghi nhận ô vuông có được di chuột vào hay không.
	private boolean squareChoose;
	
	/**
	 * Tạo một thể hiện của lớp Square, mặc định không có quân cờ nào.
	 */
	public Square() {
		// Không có quân cờ hiện tại.
		this.currentPiece = NO_PIECE;
		// Chưa được di chuột vào.
		this.squareChoose = false;
	}
	
	/**
	 * Tạo một thuộc thể hiện cho lớp Square với giá trị ô cờ, tọa độ của ô cờ đã cho.
	 * @param currentPiece Giá trị ô cờ.
	 * @param column Tọa độ ô vuông theo cột.	
	 * @param row Tọa độ ô vuoog theo hàng.
	 */
	public Square(int currentPiece, int column, int row) {
		// Thiết lập quân cờ hiện tại.
		this.currentPiece = currentPiece;
		// Thiết lập tọa độ ô vuông theo cột.
		this.column = column;
		// Thiết lập tọa độ ô vuoog theo hàng.
		this.row = row;
		// Chưa được di chuột vào. 
		this.squareChoose = false;
	}

	/**
	 * Thiết lập quân cờ cho ô vuống này.
	 * @param currentPiece Giá trị quân cờ cần thiết lập.
	 */
	public void setcurrentPiece(int currentPiece) {
		this.currentPiece = currentPiece;
	}
	
	/**
	 * Lấy giá trị của quân cờ hiện tại.
	 * @return Giá trị của quân cờ hiện tại.
	 */
	public int getcurrentPiece() {
		return this.currentPiece;
	}

	/**
	 * Lấy tọa độ theo cột của ô vuông trong bàn cờ.
	 * @return Tọa độ theo cột của ô vuông này.
	 */
	public int getcolumn() {
		return column;
	}

	/**
	 * Lấy tọa độ theo hàng của ô vuông trong bàn cờ.
	 * @return Tọa độ theo hàng của ô vuông này.
	 */
	public int getrow() {
		return row;
	}
	
	/**
	 * Lấy giá trị thuộc tính squareChoose.
	 * @return Giá trị thuộc tính squareChoose.
	 */
	public boolean squareChoose() {
		return squareChoose;
	}

	/**
	 * Thiết lập giá trị thuộc tính squareChoose
	 * @param squareChoose Giá trị thiết lập cho sẵn.
	 */
	public void setChoose(boolean squareChoose) {
		this.squareChoose = squareChoose;
	}

	/**
	 * Hiển thị ô vuông trên màn hình người dùng.
	 */
	public void paintComponent(Graphics g) {
		// Nếu đã ô vuông được chuột di vào
		if (this.squareChoose) {
			// Thiết lập background có màu xám.
			g.setColor(Color.YELLOW);
		
		// Nếu ô vuông không được di chuột vào thì
		} else {
			// Thiết lập background có màu trắng.
			g.setColor(Color.WHITE);
		}
		// Thiết lập background cho ô vuông
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
		// Chuyển về đối tượng của Graphics2D để tăng độ dày của nét vẽ.
		Graphics2D g2 = (Graphics2D) g;
		// Thiết lập độ dày cho nét vẽ
		g2.setStroke(new BasicStroke(1));
		// Thiết lập màu đen để vẽ.
		g2.setColor(Color.BLACK);
		// Vẽ đường viền xung quanh ô vuông.
		g2.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
		// Nếu ô vuông đang có quân tròn.
		if (this.currentPiece == O_PIECE) {
			// Thiết lập màu đổ để vẽ.
			g2.setColor(Color.RED);
			// THiết lập độ dày cho nét vẽ.
			g2.setStroke(new BasicStroke(5));
			// Vẽ quân cờ là hình tròn.
			g2.drawOval(this.getX() + 10, this.getY() + 10, this.getWidth() - 20, this.getWidth() - 20);
		}
		
		// Nếu ô vuông đang có quân X
		if (this.currentPiece == X_PIECE) {
			// Thiết lập độ dày cho nét vẽ.
			g2.setStroke(new BasicStroke(5));
			// Thiết lập màu xanh để vẽ.
			g2.setColor(Color.BLUE);
			// Vẽ đường chéo chính.
			g2.drawLine(this.getX() + 10, this.getY() + 10, this.getX() + 40, this.getY() + 40);
			// Vẽ đường chéo phụ.
			g2.drawLine(this.getX() + 40, this.getY() + 10, this.getX() + 10, this.getY() + 40);
		}
		
	}
	
}
