/*
 * Copyright(C) 2022 Luvina Software Company
 *
 * CommonInterface.java, Apr 12, 2022 lmtrung
 */

package GameView;

/**
 * Khung giao diện chung của các thành phần view.
 * @author lmtrung
 */
public interface CommonInterface {
	
	/**
	 * Khởi tạo các đặc điểm của thành phần.
	 */
	public void initComp();
	
	/**
	 * Thêm sự kiện cho thành phần này.
	 */
	public void addEvent();
	
	/**
	 * Thêm các thành phần khác.
	 */
	public void addCompos();
}