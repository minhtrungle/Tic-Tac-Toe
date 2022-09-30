/*
 * Copyright(C) 2022 Luvina Software Company
 *
 * BoardPanel.java, Apr 14, 2022 lmtrung
 */

package ViewPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GameController.GameManager;
import GameModel.Square;
import GameView.CommonInterface;

/**
 * Tạo đối tượng bàn cờ là nơi chứa tất cả các ô cờ
 * @author lmtrung
 */
public class BoardPanel extends JPanel implements CommonInterface, MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	// Ma trận các ô cờ.
	private Square[][] boardArr;
	// Ô cờ được người chơi click vào.
	private Square currentSquare;
	// Đối tượng quản lý trò chơi.
	private GameManager gameManager;
	
	/**
	 * Tạo một thể hiện mặc định của bàn cờ.
	 * @param isOTurn Lượt chơi mặc định
	 */
	public BoardPanel(boolean isOvalTurn) {
		// Khởi tạo các đặc điểm của bàn cờ.
		initComp();
		// Thêm sự kiện cho bàn cờ.
		addEvent();
		// Thêm các thành phần khác vào bàn cờ.
		addCompos();
		// Khởi tạo đối tượng quản lý trò chơi.
		gameManager = new GameManager(boardArr, isOvalTurn);
		// Bắt đầu trò chới
		gameManager.startGame();
		// Vẽ lại bàn cờ sau khi bắt đầu.
		repaint();
	}
	
	/**
	 * Khởi tạo các đặc điểm của bàn cờ.
	 */
	@Override
	public void initComp() {
		// Thiết lập bố cục cho bàn cờ là dạng lưới 20x20
		setLayout(new GridLayout(20, 20));
		// Thiết lập kích thước thích hợp có chiều dài và chiều rộng đều là 1000.
		setPreferredSize(new Dimension(1000, 1000));
		// Thiết lập kích thước lớn nhất có chiều dài và chiều rộng đều là 1000.
		setMaximumSize(new Dimension(1000, 1000));
		// Thiết lập kích thước nhỏ nhất là kích thước thích hợp.
		setMinimumSize(this.getPreferredSize());
		// Thiết lập kích thước bình thường có chiều dài và chiều rộng là 1000.
		setSize(new Dimension(1000, 1000));
		
	}

	/**
	 * Thêm sự kiện cho bàn cờ.
	 */
	@Override
	public void addEvent() {
		// Thêm sự kiện khi người chơi có thao tác liên quan đến nhấn hoặc thả chuột.
		addMouseListener(this);
		// Thêm sự kiện khi người chơi di chuyển chuột.
		addMouseMotionListener(this);
	}

	/**
	 * Thêm các ô cờ vào bàn cờ.
	 */
	@Override
	public void addCompos() {
		// Tạo ma trận 20x20 các ô cờ.
		boardArr = new Square[20][20];
		
		// Duyệt theo từng hàng của ma trận.
		for (int y = 0; y < 20; y++) {
			// Duyệt theo từng ô trong ma trận để thiết lập ô cờ.
			for (int x = 0; x < 20; x++) {
				// Khởi tạo từng ô cờ.
				boardArr[y][x] = new Square(Square.NO_PIECE, x, y);
				// Thêm ô cờ vào bàn cờ.
				add(boardArr[y][x]);
			}
		}
		// Khởi tạo đối tương currentSquare.
		this.currentSquare = new Square();
	}

	/**
	 * Xử lý sự kiện sau khi người dùng click chuột vào bàn cờ.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Sau khi click vào một ô cờ, ta sẽ gọi phương thức manageGame() của đói tượng quản lý trò chơi
		// Khi này đối tượng quản lý trò chơi sẽ lấy nước đi của người chơi thêm vào bàn cờ và gọi đến người chơi máy để dánh.
		gameManager.manageGame(currentSquare);
		// Vẽ lại bàn cờ khi người dùng và máy đã chơi.
		repaint();
		
		// Nếu có quân giành chiến thắng
		if (gameManager.checkWin()) {
			// Hỏi người dùng có muốn chơi ván mới không.
			int result = JOptionPane.showConfirmDialog(BoardPanel.this, "Bạn có muốn chơi lại ván mới?", "Chơi Lại", JOptionPane.YES_NO_OPTION);
			// Nếu người dùng muốn chơi lại.
			if (result == JOptionPane.YES_OPTION) {
				// Khởi tạo lại trạng thái bàn cờ.
				gameManager.resetGame();
				// Vẽ lại bàn cờ.
				repaint();
			//Nếu người dùng không muốn chơi lại.
			} else {
				// Xóa các sự kiện liên quan dến nhấn hoặc thả chuột.
				removeMouseListener(this);
				// Xóa các sự kiên liên quan đến di chuyển chuột.
				removeMouseMotionListener(this);
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	/**
	 * Vẽ các thành phần của bàn cờ.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// Duyệt từng hàng trong ma trận bàn cờ.
		for (int y = 0; y < 20; y++) {
			// Duyệt từng ô trong hàng này.
			for (int x = 0; x < 20; x++) {
				// Vẽ ô cờ.
				boardArr[y][x].paintComponent(g);
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	/**
	 * Thêm sự kiện khi người dùng di chuyển chuột
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// Lấy Component từ MouseEvent 
		/*Dòng này sửa exception: java.lang.ClassCastException: class ViewPanel.BoardPanel cannot be cast to class GameModel.Square
        (ViewPanel.BoardPanel and GameModel.Square are in unnamed module of loader 'app')*/
		Component component = e.getComponent(); 
		// Lấy ra ô vuông khi người dùng di chuyển chuột vào ô này.
		Square newSquare = (Square) component.getComponentAt(e.getPoint());
		// Nếu ô vuông mới này khác với ô vuông trước đó.
		if (!newSquare.equals(this.currentSquare)) {
			// Đặt lại thuộc tính được chuột di vào là false.
			this.currentSquare.setChoose(false);
			// Ô cờ hiện tại được chuột di chuyển vào là ô mới.
			this.currentSquare = newSquare;
			// Đặt lại thuộc tính được chuột di vào là true cho ô mới.
			newSquare.setChoose(true);
		}
		// Vẽ lại bàn cờ.
		repaint();
	}
}
