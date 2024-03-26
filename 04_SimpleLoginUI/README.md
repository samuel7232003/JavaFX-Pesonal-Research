# 04. Login - Giao diện cơ bản nhất quả đất

What up!!! Lý thuyết vậy đủ rồi, bây giờ chúng ta hãy cùng nhau xây dựng một ứng dụng JavaFX cơ bản nhất là đó chính là Đăng nhập. Mình sẽ cố gắng đi một cách chi tiết nhất có thể và đôi chỗ có thể hơi dài dòng, nếu như bạn đã biết rồi thì có thể kéo xuống các phần quan trọng hơn nha.

## a) Thiết kế Figma và định hướng chức năng

Mình đặc biệt khuyến khích các bạn trước khi bắt tay vào thực hiện một ứng dụng JavaFX có phát triển giao diện thì phải thực hiện thiết kế trước trên Figma. Giúp cho việc code dẽ diễn ra một cách nhanh chóng và thuận lợi nhất có thể. Làm việc như vậy sẽ khoa học hơn, phân tách công đoạn thiết kế UX/UI và coding.

Link Figma: https://www.figma.com/

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/11d37f28-aaf1-48bd-8a86-1b73b728380f)

Đây là bản thiết kế Figma mình thiết kế sẵn phục vụ cho bài này. Các bạn hoàn toàn có thể tự làm một giao diện Đăng nhập đơn giản theo ý thích của bản thân nhé.

Những thông số cơ bản:
- Chiều cao Stage: 500px
- Chiều rộng Stage:

Các chức năng cần có:
- Nhập được tên đăng nhập và mật khẩu
- Mật khẩu có định dạng kí tự là "*";
- Nhấn nút "Đăng nhập" để kiểm tra xem:
  + Có trường nào rỗng không
  + Có đúng với dữ liệu không
- Và thông báo lỗi lên màn hình
- Nếu đăng nhập thành công thì chuyển sang một Stage khác.

Ok! Chúng ta cùng bắt tay thực hiện.

## b) Tạo một project JavaFX, đặt một hình ảnh làm background

### *Setup project JavaFX

Bước đầu tiên chúng ta cần tạo một project JavaFX như đã hướng dẫn ở Bài số 1. Sau đó cần thiết phải chạy thử chương tình xem JavaFX có hoạt động tốt không, nếu được thì tiếp tục thực hiện.

Sau đó, chúng ta cần build một câu trúc chương trình đơn giản, phù hợp theo dự án của mình. Mình sẽ tiến hành xóa những đoạn mã không cần thiết.

Chi tiết các công việc như sau:
- Xóa file **HelloCotroller.java**;
- Đổi tên file **hello-view.fxml** thành **login-view.fxml** (click phải vào file, chọn **Refactor**, chọn **Rename...**);
- Đổi tên file **HelloApplication.java** thành **index.java**
- Tạo một Package có tên là **Controller**, tạo một class **LoginController.java** trong package đó.

Khi đó ta có cấu trúc chương trình như sau:

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/0575b77a-bdb7-4da0-8794-61d954e8baa4)

Ở file login-view.fxml ta thấy có lỗi:

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/9c7ed363-2909-4145-b0fd-3edb3e58971d)

Ở dòng 15:
~~~
<Button text="Hello!" onAction="#onHelloButtonClick"/>
~~~
Đây là lỗi sự kiện chưa được định nghĩa, ta tạm thời bỏ sự kiện đi.
~~~
<Button text="Hello!"/>
~~~
Ở dòng 9:
~~~
fx:controller="com.example.simpleloginui.HelloController">
~~~
Đây là lỗi không tìm thấy file **HelloController**, ta cần nhập lại file controller cho đúng.
~~~
> fx:controller="com.example.simpleloginui.controller.LoginController">
~~~

Lúc này, ta thấy chương trình không còn lỗi nữa, nhưng khi chạy file **index.fxml**, chương trình sẽ báo lỗi.
> Exception in Application start method

Lỗi này mình đã nhắc ở bài số 2. Khi ta chưa sửa nội dung file **module-info.java** khiến cho Controller chưa thể kết nối được với View.

Ta cần bổ xung đoạn mã sau vào **module-info.java**:
~~~
opens com.example.simpleloginui.controller to javafx.fxml;
exports com.example.simpleloginui.controller;
~~~

Mã hoàn chỉnh: 
~~~
module com.example.simpleloginui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simpleloginui to javafx.fxml;
    exports com.example.simpleloginui;

    opens com.example.simpleloginui.controller to javafx.fxml;
    exports com.example.simpleloginui.controller;
}
~~~

Sau đó hãy quay lại file **index.fxml** và khởi chạy chương trình. Ta thấy giao diện đã trởi chạy thành công.

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/16cc0d52-47fa-4f0d-addc-d401647c04fd)

Như vậy ta đã setup thành công một cấu trúc chương trình JavaFX tiêu chuẩn. Bước đầu có thể sẽ hơi khó khăn, nhưng đã khi thành thạo ta sẽ quen dần với các thao tác.

### *Đặt background là một hình ảnh

Trước tiên, ta cần tải mình ảnh muốn đặt background về và cho vào dự án. Tạo một Directory ở trong **resources**, đặt tên là **image**, rồi thả ảnh vào đó.

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/e90e1d27-deec-46bc-a3f5-38cb278c7fd7)

Sau đó mở file **login-view.fxml** và chuyển sang chế độ **Scene Builder**.

Xóa đi **VBox** mặc định, thay thế bằng **Pane**. Kiểu containers **Pane** sẽ là kiểu cơ bản nhất giúp ta dễ dàng xây dựng các thành phần bên trong nó.

Chỉnh thông số chiều cao, rộng cho **Pane** ở bảng chọn bên phải, mục Layout, phần Size:

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/a9a738b3-6cae-4ce9-8570-5042dbcafa9b)

Sau đó tạo 1 **ImageView**, tải ảnh vào **ImageView** (như mình đã hướng dẫn ở bài số 3). Và căn chỉnh hình ảnh sao chơ hợp lí.

Ở đây, ta thấy nếu hình ảnh tràn ra khỏi **Pane** nó che luôn cả đường bao của **Pane**, mặc dù lúc khởi chạy chương trình ta chỉ thấy vùng Pane thôi. Nhưng nếu để như vậy sẽ khó khăn trong việc thiết kế. Vì vậy mình thường cắt hình ảnh theo tỉ lệ phù hợp trước rồi mới bỏ vào dự án.

Ta có đoạn mã của file **login-view.fxml** như sau:

~~~
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.image.*?>
<?import javafx.scene.layout.*?>


<Pane maxHeight="500.0" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="500.0" prefWidth="700.0" xmlns="http://javafx.com/javafx/17.0.2-ea" xmlns:fx="http://javafx.com/fxml/1">
   <children>
      <ImageView fitWidth="700.0" layoutY="-423.0" pickOnBounds="true" preserveRatio="true">
         <image>
            <Image url="@image/background.jpg" />
         </image>
      </ImageView>
   </children>
</Pane>
~~~

### *Tạo khung, tiêu đề
(còn tiếp)
