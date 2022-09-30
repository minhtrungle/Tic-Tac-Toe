# Tic-Tac-Toe

# Giải thích cách tạo ra file TheCo.txt

Nhóm thế cờ thứ nhất: Đi từ nước 4 lên nước 5
-	Mô tả: 
Trong thế cờ này, 1 đường thẳng (có thể là 1 cột hoặc 1 hàng hoặc đường chéo chính hoặc đường chéo phụ) đang có 4 quân cờ của máy , như vậy chỉ cần đánh vào 1 ô trống còn lại trong đường thẳng là thắng.
-	Số lượng thế cờ: 
Với mỗi một đường thẳng (có 4 quân  đang là quân của máy ) sẽ có 5 thế cờ được tạo ra. 
Trong ma trận 5x5, sẽ có 5 cột, 5 hàng, 1 đường chéo chinh và 1 đường chéo phụ. Tổng cộng có 12 đường thẳng. 
Vậy tổng số thế cờ được tạo ra sẽ là: 5 x 12 = 60 thế cờ.
-	Ví dụ: 
X	X	X	X	D
G	G	G	G	G
G	G	G	G	G
G	G	G	G	G
G	G	G	G	G

2.	Nhóm thế cờ thứ hai: chặn 4 quân cờ của người chơi.
-	Mô tả: 
Trong nhóm thế cờ này, một đường thằng (có: thể là 1 cột, 1 hàng, đường chéo chính, hoặc đường chéo phụ) của ma trận thế cờ đang có 4 quân cờ của người chơi, như vậy máy cần đánh vào ô còn trống trong đường thẳng đó để ngăn chặn người chới chiến thằng.
-	Số lượng thế cờ: 
Với mỗi đường thẳng như vậy có thể tạo 5 thế cờ. Một ma trận thế cờ 5x5 có 5 cột, 5 hàng, 1 đường chéo chính, 1 đường chéo phụ, tổng cả có 12 đường thẳng
Vậy tổng số thế cờ được tạo ra là: 5 x 12 = 60 thế cờ.
-	Ví dụ: 
G	G	G	G	D
G	G	G	O	G
G	G	O	G	G
G	O	G	G	G
O	G	G	G	G

3.	Nhóm thế cờ thứ 3: Nước đôi tạo ra 2 đường thẳng có 4 quân cờ.
-	Mô tả: 
Hai đường thẳng thuộc hai loại khác nhau (hàng với cột, hàng với đường chéo, cột với hàng, đường chéo chính với đường chéo phụ) hai đường thẳng này giao nhau tại 1 ô trống, mỗi đường thẳng đang có 3 quân cờ của máy và 1 ô trống còn lại.
-	Số thế cờ được tạo ra: 
•	Xét trường hợp ô cần đánh là giao nhau của hàng với cột:
Với mỗi ô giao nhau một đường thẳng sẽ có 4 thế cờ, do đó khi hai đường thẳng giao nhau sẽ có 4 x 4 = 16 trường hợp: Có 25 ô giao nhau như vậy => số thế cờ tạo ra trong trường hợp này là 25 x 16 = 400 thế cờ.
•	Xét trường 1 cột giao với đường chéo chính.
Với mỗi ô giao nhau như vậy sẽ có 16 thế cờ được tạo ra, có tổng cả 5 ô giao nhau => có 5 x 16 = 80 thế cờ.
•	Xét trường hợp 1 hàng giao với đường chéo chính:
Tương tự với trường hợp 1 cột giao với đường chéo chính thì sẽ có 80 thế cờ.
•	Tương tự khi giao đường 1 hàng hoặc 1 cột với đường chéo phụ sẽ tạo ra thêm 80 + 80 = 160 thế cờ.
Tóm lại, với nhóm thế cờ này sẽ tạo ra 400 + 160 x 2 = 720 thế cờ.
-	Ví dụ: 
D	X	T	X	X
X	G	G	G	G
T	G	G	G	G
X	G	G	G	G
X	G	G	G	G

4.	Nhóm thế cờ thứ 4: Chặn nước đối của đối thủ khi mỗi đường thẳng đang có 3 quân cờ và 1 ô trống.
-	Mô tả: Tương tự như trong nhóm thế cờ số 3, hai đường thẳng thuộc hai loại khác nhau giao nhau tại 1 ô trống, mỗi đường thẳng này đang có 3 quân cờ của máy và 1 ô trống.
-	Tương tự như với nhóm thế cờ số 3 thì trong trường hợp này sẽ có: 712 thế cờ
-	Ví dụ:
D	O	T	O	O
O	G	G	G	G
T	G	G	G	G
O	G	G	G	G
O	G	G	G	G


5.	Nhóm thế cò số 5: Nước 3 lên nước 4
-	Mô tả:  Trong 1 đường thẳng đang có 3 quân cờ của máy, 2 ô cờ đang trống
-	Tổng số thê cờ được tạo ra: 
Mỗi đường thẳng như vậy sẽ có 20 trường hợp 3 quân cờ của máy, 2 ô còn lại là trống  Mỗi ma trận 5 x 5 sẽ có 5 cột, 5 hàng, 1 đường chéo chính, 1 đường chéo phụ => có 12 đường thẳng. 
Vậy tổng cả có 20 x 12 = 320 thế cờ.
-	Ví dụ: 
X	X	T	X	T
G	G	G	G	G
G	G	G	G	G
G	G	G	G	G
G	G	G	G	G
6.	Nhóm thế cờ số 6: ngăn chặn đối thủ đi từ nước 3 lên nước 4
-	Mô tả: tương tự như nhóm thế cờ số 5, người chơi đang có 1 đường thẳng chưa 3 quân cờ của mình và 2 ô trống.
-	Tính toán như thế cờ số 5 thì nhóm thế cờ này sẽ có 320 thế cờ
-	Ví dụ: 
O	O	T	O	T
G	G	G	G	G
G	G	G	G	G
G	G	G	G	G
G	G	G	G	G

7.	Nhóm thê cờ số 7: Nước 2 lên nước 3
-	Mô tả: 
Máy đi vào ô mà tại đó nó sẽ tạo ra 1 cụm 3 ô liền nhau đều là quân của máy, 2 ô còn lại đều phải trống.
-	Số thế cờ được tạo ra: 
Mỗi đường thẳng có thể có 4 thế cờ, Một ma trận 5 x 5 sẽ có 5 hàng, 5 cột, 1 đường chéo chính, 1 đường chéo phụ. Như vậy tổng cả có 12 đường thẳng.
Vậy tất cả có 12 x 4 = 60 thế cờ.
-	Ví dụ: 
T	X	X	D	T
G	G	G	G	G
G	G	G	G	G
G	G	G	G	G
G	G	G	G	G

8.	Nhóm thế cờ số 8: chặn nước đi từ 2 lên 3 của đối thủ
-	Tương tự với nhóm thế cờ số 7: sẽ có tất cả 60 thế cờ trong nhóm thế cờ này.
-	Ví dụ: 
T	O	O	D	T
G	G	G	G	G
G	G	G	G	G
G	G	G	G	G
G	G	G	G	G
