/*
 * Copyright(C) 2022 Luvina Software Company
 *
 * GraphicalUserInterface.java, Apr 12, 2022 lmtrung
 */

package GameView;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GameView.GraphicalUserInterface;
import ViewPanel.BoardPanel;




/**
 * Tạo giao diện cho trò chơi.
 * @author lmtrung
 */
public class GraphicalUserInterface extends JFrame implements CommonInterface {
	private static final long serialVersionUID = 1L;
	// Tiêu đề của của sổ trò chơi.
	private static String FRAME_TITLE = "Cờ Caro";

	/**
	 * Tạo ra một thể hiện của lớp cửa sổ.
	 */
	public GraphicalUserInterface() {
		// Khởi tạo các thuộc tính của cửa sổ.
		initComp();
		// Thêm sự kiện của cửa sổ.
		addEvent();
		// Thêm các thành phần khác.
		addCompos();
	}

	/**
	 * Khởi tạo các thuộc tính của sổ.
	 */
	@Override
	public void initComp() {
		// Đặt tiêu đè của sổ.
		setTitle(FRAME_TITLE);
		// Thiết lập bố cục cho của sổ.
		setLayout(new CardLayout());
		// Thiết lập size nhỏ nhất theo kích thước phù hợp.
		setMinimumSize(this.getPreferredSize());
		// Thiết lập kích thước theo kích thước phù hợp.
		setSize(this.getPreferredSize());
		// Không thể thay đổi kích thước của cửa sổ.
		setResizable(false);
		// Khi đóng của sổ thì không thực hiện gì cả.
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	/**
	 * Thêm sự kiện cho của sổ.
	 */
	@Override
	public void addEvent() {
		// Tạo đối tượng để lăng nghe sự kiên trên sự kiện.
		WindowListener listener = new WindowAdapter() {
			/**
			 * Xử lý sự kiện khi của sổ đóng.
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				
				// Khi người dùng đóng cửa sổ, hiển thị xác nhận cho người dùng có muốn thoát mhay không
				int result = JOptionPane.showConfirmDialog(GraphicalUserInterface.this, "Bạn có muốn thoát trò chơi", "Thoát Trò Chơi", JOptionPane.YES_NO_OPTION);

				// Nếu người dùng xác nhận đóng cửa sổ.
				if (result == JOptionPane.YES_OPTION) {
					// Đóng cửa sổ lại.
					dispose();
				}
			}
		};
		// Thêm sự kiện đóng cửa sổ vào.
		addWindowListener(listener);
	}

	/**
	 * Thêm các thành phần khác vào cửa sổ trò chơi.
	 */
	@Override
	public void addCompos() {
		// Tạo đối tượng bảng chứa các ô cờ.
		int result = JOptionPane.showConfirmDialog(GraphicalUserInterface.this, "Bạn có muốn chơi trước!", "Người trước/Máy trước", JOptionPane.YES_NO_OPTION);
		// Nếu người dùng chọn không.
		if (result == JOptionPane.NO_OPTION) {
			// Tạo đối tượng bàn cờ với lượt chơi đầu tiên là cho quân của máy
			BoardPanel boardPanel = new BoardPanel(false);
			// Thêm đối tượng bảng chứa các ô cờ này vào.
			add(boardPanel);
		} 
		if (result == JOptionPane.YES_OPTION) {
			// Tạo đối tượng bàn cờ với lượt chơi đầu tiên là cho quân của người chơi.
			BoardPanel boardPanel = new BoardPanel(true);
			// Thêm đối tượng bảng chứa các ô cờ này vào.
			add(boardPanel);
		}
	}
}
