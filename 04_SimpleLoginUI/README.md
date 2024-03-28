# 04. Login - Giao diện cơ bản nhất quả đất

What up!!! Lý thuyết vậy đủ rồi, bây giờ chúng ta hãy cùng nhau xây dựng một ứng dụng JavaFX cơ bản nhất là đó chính là Đăng nhập. Mình sẽ cố gắng đi một cách chi tiết nhất có thể và đôi chỗ có thể hơi dài dòng, nếu như bạn đã biết rồi thì có thể kéo xuống các phần quan trọng hơn nha.

## a) Thiết kế Figma và định hướng chức năng

Mình đặc biệt khuyến khích các bạn trước khi bắt tay vào thực hiện một ứng dụng JavaFX có phát triển giao diện thì phải thực hiện thiết kế trước trên Figma. Giúp cho việc code dẽ diễn ra một cách nhanh chóng và thuận lợi nhất có thể. Làm việc như vậy sẽ khoa học hơn, phân tách công đoạn thiết kế UX/UI và coding.

Link Figma: https://www.figma.com/

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/11d37f28-aaf1-48bd-8a86-1b73b728380f)

Đây là bản thiết kế Figma mình thiết kế sẵn phục vụ cho bài này. Các bạn hoàn toàn có thể tự làm một giao diện Đăng nhập đơn giản theo ý thích của bản thân nhé.

Những thông số cơ bản:
- Chiều cao Stage: 500px
- Chiều rộng Stage: 700px

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

Sau khi đã thiết kế 1 Scene login thành công, ta cần xem nó đã nhét vào đúng **Stage** và **Stage** chứa nó đã ổn chưa. Ta kiểm tra khai báo **Stage** ở file **index.java**. Ta kiểm tra xem ở biến **FXMLLoader** đã lấy đúng tên file **login-view.fxml** chưa. Và ở biến **Scene** đã định dạng đúng chiều cao (500px) và chiều rộng (700px) chưa.

Mã hoàn chỉnh:
~~~
package com.example.simpleloginui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class index extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(index.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
~~~

Ngang bước này, mọi người cần chạy thử xem chương trình java đã chạy đúng như ta mong muốn chưa, và sau này, sau khi hoàn thành bất cứ phần nào đó ta cần chạy thử chương trình.

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/bd8976f0-ffb6-4d50-a76f-aa6998204178)

Sau khi đã thấy thành công ta chuyển sang bước tiếp theo.

## c) Thêm các component khác cho Scene

### *Tạo khung, tiêu đề

Quay lại file **login-view.fxml** ở chế độ Scene Builder. 

Ta chọn 1 Page cho khung màu trắng và 1 Page cho khung màu nâu, rồi thêm vào các thông số như đã thiết kế ở figma.

- Ở khung màu trắng:
  + Heigh: 312px
  + Width: 274px
  
![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/d051850e-ca28-45d1-8d45-e1acb7e1e61f)

  + Nền: Trắng
  + Bo góc: 10px

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/80b0f0c8-0e32-4467-91ed-afd41078913e)

- Làm tương tự với với khung màu nâu:
  + Heigh: 58px
  + Width: 274px
  + Nền: #B9A082
  + Bo góc: 10px

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/14f6b089-017c-4bcb-97b0-671632cafbe0)

Để thêm tiêu đề, ta kéo một **Label** vào vị trí cần thiết và sửa lại các thống số:
- Text: **"ĐĂNG NHẬP"**
- Font: Size 20px, Style Bold;

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/79920b3c-3713-426c-a63b-7136195dcb44)

- Text Fill: #fff (WHITE)

Ta được chương trình ở chế độ **Text**:

~~~
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.image.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.text.*?>

<Pane maxHeight="500.0" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="500.0" prefWidth="700.0" xmlns="http://javafx.com/javafx/17.0.2-ea" xmlns:fx="http://javafx.com/fxml/1">
   <children>
      <ImageView fitWidth="700.0" layoutY="-423.0" pickOnBounds="true" preserveRatio="true">
         <image>
            <Image url="@image/background.jpg" />
         </image>
      </ImageView>
      <Pane layoutX="213.0" layoutY="84.0" prefHeight="321.0" prefWidth="274.0" style="-fx-background-color: white; -fx-background-radius: 10;">
         <children>
            <Pane layoutY="-26.0" prefHeight="58.0" prefWidth="274.0" style="-fx-background-color: #B9A082; -fx-background-radius: 10;">
               <children>
                  <Label layoutX="76.0" layoutY="14.0" text="ĐĂNG NHẬP" textFill="WHITE">
                     <font>
                        <Font name="System Bold" size="20.0" />
                     </font>
                  </Label>
               </children>
            </Pane>
         </children>
      </Pane>
   </children>
</Pane>

~~~

Kết quả: 

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/0f2f2544-009a-4c72-a756-d44cde3987fa)

### *Tạo các trường TextField, PasswordField

Với trường tên đăng nhập ta dùng **TextField** và trường mật khẩu ta dùng **PasswordField** để kí tự khi nhập tự động chuyển thành kí tự "*". Ta kéo các component về vị trí thích hợp rồi điều chỉnh các thông số:
- Prompt Text: "Tên đăng nhập" (với trường **TextField**) và "Mật khẩu" (với trường **PasswordField**);
- Font Size: 18
- Width: 28
- Heigh: 46
- Nền: #d9d9d9
- Bo góc: 8

Dạng Text:
~~~
<TextField layoutX="23.0" layoutY="82.0" prefHeight="46.0" prefWidth="228.0" promptText="Tên đăng nhập" style="-fx-background-color: #d9d9d9; -fx-background-radius: 8;">
    <font>
        <Font size="18.0" />
    </font>
</TextField>
<PasswordField layoutX="23.0" layoutY="172.0" prefHeight="46.0" prefWidth="228.0" promptText="Mật khẩu" style="-fx-background-color: #d9d9d9; -fx-background-radius: 8;">
    <font>
        <Font size="18.0" />
    </font>
</PasswordField>
~~~

Kết quả khi nhập thử các trường:

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/1e005399-1497-4551-8c1b-3c142e8e5da0)

### *Thêm nút nhấn Đăng nhập

Ta thêm một **Button** ở phía dưới khung để tạo một nút nhấn. Rồi chỉnh sửa các thông số:
- Text: "ĐĂNG NHẬP"
- Font: Size 14, Style Bold
- Text Fill: #fff
- Width: 109
- Heigh: 35
- Nền: #B9A082
- Bo góc: 8

Dạng **Text**:
~~~
<Button layoutX="83.0" layoutY="256.0" mnemonicParsing="false" prefHeight="35.0" prefWidth="109.0" style="-fx-background-color: #B9A082; -fx-background-radius: 8;" text="ĐĂNG NHẬP" textFill="WHITE">
    <font>
        <Font name="System Bold" size="14.0" />
    </font>
</Button>
~~~

Kết quả chương trình:

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/2d58ce22-2914-4200-958a-6997870520af)

Như vậy ta đã hoàn tất thiết kế cho trang Login của chúng ta một cách hoàn chỉnh rồi. Đây là nhưng thông số cơ bản nhất mà mình áp dụng cho bài đầu tiên, mình khuyến khích các bạn nghiên cứu, tìm tòi, thử nghiệm các thông số khác, biết đâu mình được những điều hay ho.

Bước tiếp theo mình sẽ tạo những sự kiện.

## d) Tạo sự kiện cho nút nhấn Button

Những sự kiện cần tạo:
- Nhấn nút "Đăng nhập" để kiểm tra xem:
  + Có trường nào rỗng không
  + Có đúng với dữ liệu không
- Và thông báo lỗi lên màn hình
- Nếu đăng nhập thành công thì chuyển sang một Stage khác.

### *Sự kiện kiểm tra trường rỗng và báo lỗi

Để setup các sự kiện, trước tiên ta đặt tên (đặt ID) cho các thành phần mà ta cần gọi đến ở controller. Ở đây ta cần đặt ID cho 2 trường nhập **Tên đăng nhập**, **Mật khẩu** và nút nhấn **ĐĂNG NHẬP**. Lần lượt ta đặt ID là **tf_username**, **pf_password** và **bt_login**.

Có 2 cách đặt ID, 1 là nhập ở bảng chọn trong chế độ Scene Builder, 2 là nhập ngay ở phần thuộc tính chế độ Text;

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/e6433cc2-6386-430c-9f4f-b217730beec7)

~~~
<TextField fx:id="tf_username" layoutX="23.0" layoutY="82.0" prefHeight="46.0" prefWidth="228.0" promptText="Tên đăng nhập" style="-fx-background-color: #d9d9d9; -fx-background-radius: 8;">
~~~

Để thông báo lỗi ta cần thêm một Label nữa. Kéo thả Label ấy vào vị trí mong muốn. Để có thiết kế, trước tiên ta nhập vào Text một đoạn thông tin trước. Sau khi thiết kế xong ta xóa đi trở lại trạng thái bình thường. Các thông số của **Lable**:
- fx:id: lb_error
- Font: Size 10, Style Bold Italic
- Text Fill: RED

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/30d458dd-0a61-42fa-89ab-927d091e8b82)

Bước tiếp theo ta tạo 1 sự kiện cho nút Button. Quay lại chế độ **Text**, ở phần thuộc tính của **Button** ta thêm *onAction="#onLoginClick"*. Trong đó **onLoginClick** chính là tên hàm mà ta sẽ định nghĩa ở Controllor.

Lưu ý: Ở một số phiên bản, khi tạo Pane mới thì sẽ mất đi thuộc tính kết nối Controllor ở cấp cao nhất. Ta cần thêm lại thuộc tính sau ở **Pane** cao nhất.
~~~
fx:controller="com.example.simpleloginui.controller.LoginController"
~~~

Chương trình sau khi thêm các thuộc tính và sự kiện:
~~~
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.image.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.text.*?>

<Pane maxHeight="500.0" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="500.0" prefWidth="700.0" xmlns="http://javafx.com/javafx/17.0.2-ea" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.simpleloginui.controller.LoginController">
   <children>
      <ImageView fitWidth="700.0" layoutY="-423.0" pickOnBounds="true" preserveRatio="true">
         <image>
            <Image url="@image/background.jpg" />
         </image>
      </ImageView>
      <Pane layoutX="213.0" layoutY="84.0" prefHeight="321.0" prefWidth="274.0" style="-fx-background-color: white; -fx-background-radius: 10;">
         <children>
            <Pane layoutY="-26.0" prefHeight="58.0" prefWidth="274.0" style="-fx-background-color: #B9A082; -fx-background-radius: 10;">
               <children>
                  <Label layoutX="76.0" layoutY="14.0" text="ĐĂNG NHẬP" textFill="WHITE">
                     <font>
                        <Font name="System Bold" size="20.0" />
                     </font>
                  </Label>
               </children>
            </Pane>
            <TextField fx:id="tf_username" layoutX="23.0" layoutY="82.0" prefHeight="46.0" prefWidth="228.0" promptText="Tên đăng nhập" style="-fx-background-color: #d9d9d9; -fx-background-radius: 8;">
               <font>
                  <Font size="18.0" />
               </font>
            </TextField>
            <PasswordField fx:id="pf_password" layoutX="23.0" layoutY="172.0" prefHeight="46.0" prefWidth="228.0" promptText="Mật khẩu" style="-fx-background-color: #d9d9d9; -fx-background-radius: 8;">
               <font>
                  <Font size="18.0" />
               </font>
            </PasswordField>
            <Button onAction="#onLoginClick" fx:id="bt_login" layoutX="83.0" layoutY="256.0" mnemonicParsing="false" prefHeight="35.0" prefWidth="109.0" style="-fx-background-color: #B9A082; -fx-background-radius: 8;" text="ĐĂNG NHẬP" textFill="WHITE">
               <font>
                  <Font name="System Bold" size="14.0" />
               </font>
            </Button>
            <Label fx:id="lb_error" layoutX="23.0" layoutY="231.0" text="Hãy nhập tên đăng nhập!" textFill="RED">
               <font>
                  <Font name="System Bold Italic" size="10.0" />
               </font>
            </Label>
         </children>
      </Pane>
   </children>
</Pane>
~~~

InteliJ IDEA hỗ trợ tự động tạo hàm khi ta rê vào sự kiện ta đã gắn cho Button. Ta nhấn vào, khi đó hàm **onLoginClick** sẽ được tạo tự động ở file **LoginController.java**.

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/964836f3-2ca6-4cff-b2c1-e3b39fc816ff)

Tiếp theo ta sẽ viết sự kiện nếu trường nào rỗng sẽ hiện thông tin lỗi trên **Label lb_error** ta đã tạo.

Ta vào file **LoginControllor.java**.

Bước đầu tiên ta cần khai báo các biến component ta cần dùng, lưu ý đặt đúng tên theo ID và thêm các thẻ "@FXML".

~~~
    @FXML
    TextField tf_username;
    @FXML
    PasswordField pf_password;
    @FXML
    Label lb_error;
~~~

Trong hàm **onLoginClick()**, ta dùng hàm **getText()** để lấy dữ liệu nhập từ các trường nhập và gán vào các biến String.

~~~
String username = tf_username.getText();
String password = pf_password.getText();
~~~

Để kiểm tra xem nó có rỗng không ta cần dùng hàm **trim()** để xóa dấu khoảng trắng 2 đầu (nếu như nhập kí tự trắng cũng tính là rỗng). Sau đó dùng hàm **equals()** để so sánh chuỗi với chuỗi rỗng.

~~~
username.trim().equals("")
~~~

Nếu như trả về **true** thì dùng hàm **setText()** lên lb_error báo lỗi.

Ta có đoạn mã hoàn chỉnh như sau:

~~~
public class LoginController {
    @FXML
    TextField tf_username;
    @FXML
    PasswordField pf_password;
    @FXML
    Label lb_error;
    public void onLoginClick(ActionEvent actionEvent) {
        String username = tf_username.getText();
        String password = pf_password.getText();
        if(username.trim().equals("")){
            lb_error.setText("Hãy nhập tên đăng nhập!");
            return;
        }
        if(password.trim().equals("")){
            lb_error.setText("Hãy nhập mật khẩu!");
            return;
        }
    }
}
~~~

Kết quả:

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/24aecea4-c034-48a9-9f50-d41a83f484ec)

Vậy là ta đã bắt được sự kiện khi nhấn nút Button và báo được lỗi rỗng.

### *Kiểm tra xem có đúng với dữ liệu model hay không

Vì bài viết này tập trung vào việc xây dựng giao diện bằng JavaFX nên mình đi khá chi tiết về việc xây dựng giao diện trước. Theo nguyên tắc thông thường ta cần xây dựng các **model** trước, rồi viết các **dao** nếu cần lấy dữ liệu từ cơ sở dữ liệu rồi mới đến xây dựng **view**. Ở đây mình mong muốn giúp các bạn có được thực hành y như thực tế nên mình sẽ tạo model **user** rồi sẽ kiểm tra với dữ liệu model có đúng không.

Mình tạo một Pakage **model** trong phần **java.com.example.simpleloginiu**, sau đó tạo một class **User.java**

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/4530d211-f2c2-4f32-a49e-1781fd9d451d)

Mình định nghĩa các thuộc tính, constructor, getter, setter như sau:

~~~
package com.example.simpleloginui.model;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}
~~~

Tùy thuộc vào dự án bạn thiết kế thuyền nhận dữ liệu như thế nào. Ở đây, mình sẽ thiết kế, ở mỗi **Scene**, ngày khi được khởi tạo nó sẽ lấy các dữ liệu cần thiết để xử lí. Như vậy, ta cần một hàm mà nó được thực hiện ngay khi khởi tạo **Scene** đó. JavaFX cung cấp một hàm để làm việc đó.

Trước tiên ta cần cho class chính kế thừa Interface Initializable.
~~~
public class LoginController implements Initializable
~~~

Khi đó chương trình sẽ gợi ý thiết lập một hàm:

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/7e79200a-ea67-4fe0-b27d-1dc094916213)

Hàm này sẽ được ngày 1 lần ngay khi khởi tạo **Scene**. Ở đây tạm thời ta dán dữ liệu mẫu cho model **User** (đối với các chương trình có kết nối cơ sở dữ liệu ở đây ta viết các lệnh lấy dữ liệu).

~~~
ArrayList<User> listUser;

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    listUser = new ArrayList<>();
    listUser.add(new User("levietthanh", "123456"));
}
~~~

Trong hàm kiểm tra **onLoginClick()**, ta tiếp tục dùng các hàm **equas()** để kiểm tra. Mình sẽ kiểm tra tên đăng nhập trước rồi kiểm tra password sau. Đồng thời nếu sai tên đăng nhập thì sẽ reset lại các trường, tối ưu trải nghiệm.

~~~
for(int i = 0; i < listUser.size(); i++){
    User user = listUser.get(i);
    if(!username.equals(user.getUsername())){
        lb_error.setText("Tên đăng nhập không tồn tại!");
        pf_password.setText("");
        return;
    }
    else if (!password.equals(user.getPassword())){
        lb_error.setText("Nhập sai mật khẩu!");
        pf_password.setText("");
        return;
    }
    else{
        lb_error.setText("Đăng nhập thành công!");
        return;
     }
}
~~~

Thử chạy chương trình và sửa lỗi.

### *Nếu như thành công thì chuyển sang một Scene khác

Ở phần này mình sẽ hướng dẫn, di chuyển sang một **Scene** khác mà không cần thay đổi **Stage** hiện tại.

Trước tiền mình cần tạo một file **home-view.fxml** hiện kết quả sau khi đăng nhập thành công.

~~~
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>


<AnchorPane prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/17.0.2-ea" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.simpleloginui.controller.HomeController">
   <children>
      <Label layoutX="239.0" layoutY="191.0" text="Đăng nhập thành công" />
   </children>
</AnchorPane>
~~~

Ở file **LoginController.java** mình sửa đoạn thêm đoạn mã tạo mới, khởi chạy y như ở file **index.java**

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/7599f44b-3fda-4bc8-9286-7f830a5f5c5f)

Nhưng ở đây ta thấy biến **Stage** không được khởi tạo sẵn. Ta có thể khởi tạo bằng cách:

~~~
Stage stage = new Stage();
~~~

Rồi sửa các tên file để hiện scene **home-view.fxml**. Cách làm này cũng cho ra được kết quả, nhưng nó lại bật lên một **Stage** khác, **Stage** cũ lại vẫn tồn tại ở đó mà không bị mất đi, điều này gây trải nghiệm kém cho người dùng. JavaFX cung cấp một số hàm giúp lấy được **Stage** hiện tại thông qua **event**, cụ thể:

~~~
Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
~~~

Ở đây, **actionEvent** chính là biến khởi tạo mặc định của hàm bắt sự kiện **onLoginClick()** ta tạo ở trên. Hàm này giúp lấy được **Stage** mà sự kiện click chuột nhấn vào ở **Button**, như vậy ta lấy được **Stage** hiện tại, mà không cần phải khởi tạo một **Stage** mới.

~~~
Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
FXMLLoader fxmlLoader = new FXMLLoader(index.class.getResource("home-view.fxml"));
Scene scene = new Scene(fxmlLoader.load(), 700, 500);
stage.setTitle("Home");
stage.setScene(scene);
stage.show();
~~~

Bây giờ hãy chạy thử chương trình nào! Nếu như không có lỗi gì, vậy là chúng ta đã thực hiện xong tất cả các yêu cầu rồi!!!

## e) TỔNG KẾT

> Tips nè:
>
> - Dù có hơi phiền lúc đầu nhưng ngay từ những file đầu tiên các bạn nên bố trí nó theo một cấu trúc, để có thể dễ dàng scale lên một project lớn để không bị rối. Trong bài này mình luôn tuân thủ nguyên tắc đó, dù chỉ có 3 file những mình vẫn chia thành các mục nhỏ.
> - Bên cạnh đó còn quy tắc đặt tên, các bạn nên cố gắng thống nhất cách đặt tên cho toàn chương trình, nếu được thì có thể dùng cách mà "người ta" thường dùng nhất. Ở đây mình đặt các class theo nguyên tắc viết hoa mỗi chữ cái đầu (User.java, HomeController.java), còn các biến thì cũng theo nguyên tắc đó những lại không viết hoa chữ cái đầu (user, password, listUser,...), đối với file view thì viết thường và dung dấu gạch ngang (login-view.fxml),...

Ya!!! Bài này khá là dài, mình đã cố gắng mô tả chi tiết nhất có thể các bước thực hiện, những điều cần làm để có thể có cái nhìn rõ ràng nhất, dễ hiểu nhất cho các bạn. Với chương trình này mình đã chọn những cách làm đơn giản nhất nhưng mang lại hiệu quả, hy vọng các bạn có thể tạo được project đầu tiên cho mình qua bài viết này.

Cảm ơn các bạn!!!
