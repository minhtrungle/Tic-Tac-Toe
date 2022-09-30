/*
 * Copyright(C) 2022 Luvina Software Company
 *
 * Main.java, Apr 13, 2022 lmtrung
 */

package Main;

import GameView.GraphicalUserInterface;

/**
 * Run...
 * @author lmtrung
 */
public class Main {
	
	/**
	 * Phuong thuc chay va in ra ham main
	 * @param  args tham so truyen vao  
	 */ 
	public static void main(String[] args) {
		// Khởi tạo đối tượng của sổ trò chơi.
		GraphicalUserInterface graphicaluserinterface = new GraphicalUserInterface();
		// Đóng dói các thành phần vào cửa sổ.
		graphicaluserinterface.pack();
		// Hiển thị cửa sổ trên màn hình người dùng.
		graphicaluserinterface.setVisible(true);
	}
}