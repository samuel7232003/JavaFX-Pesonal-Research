# 02. Cấu trúc chương trình JavaFX có gì?

Chúng ta đã có được một chương trình JavaFX đầu tiên khởi chạy ở phần 1, với cấu trúc như sau:
<br><br>
![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/2cf5bdd4-6ea1-44bf-97c4-3dfe22dd87c2)
<br><br>
Để có thể bắt đầu bắt tay vào build một dự án cho riêng mình, trước tiên cùng phải hiểu cơ chế hoạt động của một chương trinh JavaFX như thế nào đã nhé! Khác với một dự án Java được tạo bằng các IDE khác như Eclipse (thường được giảng dạy trên lớp), InteliJ IDEA đã khởi tạo sẵn, setup sẵn tất cả những thứ cần thiết. Việc của chúng ta là đắp thịt vào bộ khung đã có sẵn này thôi.

## a) src/main/java/...

Đây là phần chứa toàn bộ nội dung các thuật toán của chương trình. Nếu như mọi người đã có những thực hành nhất định với lập trình java trước đây với mô mình MVC thì đây chính là nơi chứa các phần Controller và Model, hay theo mô hình kết nối CSDL thì ở có thể chứa các file Bean, Dao.


![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/16bdafd9-e1ef-480e-b2cb-fe8b01c364e3)


Trên đây là một cấu trúc chương trình tương đối hoàn chỉnh và đầy đủ đối với một ứng dụng lớn. Các bạn hoàn toàn có thể cấu trúc chương trình của mình theo một mô hình bất kì nào mà các bạn thành thạo, miễn sao nó dễ sử dụng, dễ code và dễ hiệu chỉnh sau này là được.

Cơ bản gồm các phần chính:
- File **module-info.java**: đây là một file vô cùng quan trọng, giúp có thể add các thư viện, kết nối controller và view (ở thư mục **main/resources**) lại với nhau.
- Directory **com.example.[tên dự án]**:
  + File chứ hàm **main()**
  + Các file và các directory chứa chương trình chính.
 
***Về file module-info:**
- Đây là file với mục đích add các thư viện và kết nối controller và view lại với nhau. Nên nếu như bạn xây dựng chương trình với câu trúc phức tạp hơn, bạn cần thay đổi nội dung file này sao cho phù hợp với chương trình.

***Về Directory com.example.[tên sự án]:**
- File chứa hàm **main()** nên được đặt ở phía bên ngoài cấp cao nhất, ngang bằng với các file **.fxml** ở trong thư mục **resources**. Điều này giúp thuận tiện hơn trong việc gọi các UI và kết nối với các thư viện cần thiết cho thiết kế giao diện.

## b) src/main/resources/...

Đây là phần chứa các file IU .fxml của ứng dụng. Ngoài ra, để thuận tiện hơn trọng việc xuất các icon, image, chúng ta cũng nên để chúng ở thư mục này.


![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/40c97a74-a52d-4691-a72e-67645d3a9ef3)


Trên đây là một cấu trúc chương trình tương đối đầy đủ các phần mà các bạn có thể tham khảo đối với một dự án JavaFX lớn. 

Tương tự như ở phần trên, các bạn hoàn toàn có thể tái cấu trúc nó theo một mô hình mà các bạn dễ thực hiện hơn. Nhưng hãy lưu ý một số vấn đề sau để chương trình có thể hoạt động được nhé:
- Các file .fxml nên được đặt ngay ở bên ngoài (con trực tiếp của thư mục [tên dự án]). Nếu đặt ở bên trong một thư mục nào đó thì chương trình sẽ gặp lỗi:
  > "Exception in Application start method"
- Hiện tại thì mình vẫn chưa biết cách nào để fix lỗi này, nên tạm thời các view chúng ta cứ ném hết ở đây, thường số lượng các view cũng không quá nhiều (nào mình fix được mình sẽ update).
- 
## c) External Libraries

Ở đây giúp chúng ta quản lí các thư viện được add vào dự án. Các thư viện về JavaFX đã được add sẵn, nên không cần thiết phải add thêm gì. Nhưng khi thực hiện dự án cần thiết phải add thêm một số thư viện khác, ta có thể thêm ở đây (sẽ có hướng dẫn ở bài sau).

## d) Cách hoạt động của chương trình JavaFX

Chương trình JavaFX sẽ hoạt động theo mô hình Controller-View: Đối với mỗi **View** sẽ có ít nhất một **Controller** kiểm soát hoạt động của nó.

Khác với chương trình Java Swing, view và controllor view được build ngay trong cùng file. Nhưng với JavaFX, 2 file này được tách riêng biệt và không thể thiếu. View muốn hoạt động phải có Controller để kiểm soát nó.

Quay lại chương trình mẫu ta đã khởi tạo:

### File chứa hàm main() - HelloApplication.java
~~~
package com.example.demo6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
~~~

Cách hoạt động của nó cũng khá đơn giản. Như mọi chương trình ta đã được học sẽ luôn gọi hàm **main()** trước, khi đó chương trình sẽ tự đồng tìm kiếm hàm **start()** để khởi chạy một ứng dụng: 

- Hàm **start()** truyền vào một tham số mặc định **stage** với kiểu **Stage**. Nói đơn giản đây chính là cửa sổ sẽ chứa các màn hình - các **Scene** để show ra được màn hình máy tính. Mỗi ứng dụng muốn show được, ít nhất phải có một **Stage** đang hoạt động.

- **FXMLLoader** mà một biến tạm với mục đích gọi được UI mình muốn khởi chạy. Bạn cần truyền đúng tên file UI vào đây.

- Sau đó, cần khởi tạo một **Scene** với biến **fxmlLoader** ta lấy ở trên. Biến **Scene** có thể hiểu đơn giản chính là giao diện cửa sổ **Stage**. Mỗi **Stage** cần ít nhất nhất một **Scene** để hoạt động. Công dụng chính của nó chính là khi ta cần thay đổi các màn hình UI, ta chỉ cần thay đổi biến **Scene** mà không cần phải tắt cửa sổ **Stage**, giúp trải nghiệm người dùng mượt mà hơn rất nhiều, tránh phiền toái tắt mở cửa sổ liên tục khi thay đổi các chức năng.

- Sau đó đặt title cho **Scene**, gắn **Scene** cho **Stage** và cuối cùng là chạy **Stage** thoai.

### File UI - hello-view.fxml
~~~
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.layout.VBox?>

<?import javafx.scene.control.Button?>
<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.example.demo6.HelloController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
    </padding>

    <Label fx:id="welcomeText"/>
    <Button text="Hello!" onAction="#onHelloButtonClick"/>
</VBox>
~~~

Ở đây các bạn cần tập làm quen với ngôn ngữ mới, gần tương tự như cấu trúc của html, có các thẻ component, thẻ đóng, thẻ mở, các thuộc tính của nó. Chúng ta sẽ làm quen với nó ở bài sau, bây giờ đi tiếp về phần hoạt động.

Cần để ý đến dòng này:

~~~
fx:controller="com.example.demo6.HelloController">
~~~

Đây chính là thuộc tính giúp cho View được kết nối với trình điều kiển Controllor của chính nó. Đường dẫn chính là địa chỉ dần đến phần điều kiển ở phía trên.

Với ví dụ này ta thấy có một **Label** và một **Button** được khởi tạo. **Label** được đặt id, và **Button** được gán một sự kiện (Lưu ý: để gắn sự kiện thì trước tên cần 1 dấu **#**). 

### File controller-view - HelloController.java
~~~
package com.example.demo6;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
~~~

Đây chính là file controller điều kiển view nhắc đến ở phía trên. Khi ở chạy một UI chương trình sẽ bắt đầu chuyển sang chế độ show Stage và lắng nghe sự kiện. Mọi hoạt động mà ta muốn thức hiện điều phải thông qua gắn và bắt sự kiện. 

>*Lưu ý:
>
>- Các phần tử được xây dựng ở file UI, nếu muốn được gọi ở Controller cần phải được đặt ID và khi gọi ở Controllor cần đặt một annotation - **@FXML** phía trước các định nghĩa, hàm.
>  
>- Cần phải gọi lại đúng chính xác kiểu phần tử (Label, Button,...), ID và tên sự kiện muốn gọi. 

Ở file **hello-view.fxml** chúng ta đã gán một sự kiện cho nút **Button**. Thì ở file này, ta tiến hành định nghĩa cho sự kiện đó. Ta thấy, tên sự hàm được viết giống như đã gắn ở file UI. 

Trong ví dụ này, ta mong muốn khi nhấn vào nút **Button** thì nội dung **Label** được thay đổi. Ta sử dụng hàm **setText()** lên phần tử **welcomeText** (ID của **Label**) ta gọi ở trên.

Như vậy chương trình đã chạy thành công như ta mong muốn.

### File module-info.java
~~~
module com.example.demo6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo6 to javafx.fxml;
    exports com.example.demo6;
}
~~~

File này chỉ là set up ban đầu cho dự án, không tác động trong qua trình khởi chạy. Với ví dụ trên ta cần kết nối file Controller và View đặt ngay ở phía ngoài. Nên chỉ cần viết như vậy. Nhưng với những mô hình lớn hơn cần phân nhiều cấp hơn ta cần phải chỉnh sửa lại nội dung của nó.

~~~
module com.example.server_chatapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.server_chatapp to javafx.fxml;
    exports com.example.server_chatapp;

    exports com.example.server_chatapp.controller;
    opens com.example.server_chatapp.controller to javafx.fxml;
}
~~~

Ví dụ ở đoạn mã này và một chương trình khác cần add thêm thư viện sql và kết nối thêm Controller-View được đặt ở directory Controllor.

## f) TỔNG KẾT

Ở nội dung bài này, chúng ta cần hiểu được cách hoạt động của một chương trình JavaFX cơ bản nhất. Đây chính là nền tảng để giúp bạn có thể xây dựng một chương trình JavaFX cho riêng mình. Chúng ta cần phải nghiên cứu và thử nhiều hơn nữa để có thể hiểu được hết những hoạt động của nó. 

Bài viết trên vẫn còn sơ sài, các nhận định, các định nghĩa, các giải thích trên hoàn toàn là sưu tầm và hiểu theo kiến thức cá nhân mình, nên hoàn toàn có thể có những sai sót nhất định. Hy vọng nó giúp cho bạn được điều gì đó. Mình sẽ cố gắng cập nhật bài tiếp theo. <3
