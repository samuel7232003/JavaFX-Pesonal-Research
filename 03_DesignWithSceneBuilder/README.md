# 03. Kéo, thả và nhiều hơn thế với SceneBuilder

JavaFX hỗ trợ một công cụ vô cùng tuyệt vời đó chính là Scene Builder, nó cung cấp các gói components vô cùng thuận tiện giúp chúng ta có thể kéo, thả, thiết kế giao diện ứng dụng một cách tối ưu và hiệu quả. Với bài học này sẽ tập trung giới thiệu một các cơ bản nhất về các component và những điều khác Scene Buidler.

## a) Khởi chạy Scence Builder

Scence Builder là một công cụ đã được tích hợp sẵn trên InteliJ IDEA, phục vụ cho các sự án JavaFX. Nên các bạn không cần thiết phải cài đặt một phần mềm thứ 2 nào khác. Chúng ta chỉ cần import ngay trên IDE là có thể sử dụng được ngay.

Để cài đặt Scence Buidler, trước tiên ta cần mở file UI cần dùng:

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/afefea1e-ce3c-496d-910c-91586b85ea50)

Thanh thứ 2 từ dưới lên, ta thấy có 2 chế độ code mà IDE đẽ setup cho chúng ta. Hiện tại theo mặc định chúng sẽ ở chế độ **"Text"**. Ta nhấn sang chế độ **"Scence Builder"** để sử dụng.

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/f3cc4708-887b-46a4-8fc9-be1b1a0e1c14)

Sau khi nhấn, ta cần chọn **Download Scence Builder Kit** để tải bộ kit về. 

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/48f27a68-9192-4e71-ae05-8732bd22779c)

Đây chính là giao diện của bộ công cụ Scence Builder.

## b) Các components cơ bản

Ở giao diện Scence Builder, phía bên trái có một bảng menu chứa danh sách các component của JavaFX. Các bạn có thể thấy có rất nhiều sự lựa chọn với những mục đích thực hiện khác nhau. Khi cần sử dụng component nào thì chỉ cần kéo conponent đó vào vị trí mong muốn.

Phía bên phải là một bảng chọn chứa tất cả các properties của đối tượng mà mình muốn chỉnh sửa. Các bạn hoàn toàn có thể chỉnh sửa màu sắc, cỡ chứ, khung viền, căn chỉnh,... hầu như là tất cả những điều chỉnh cần thiết để thiết kế một giao diện xinh đẹp theo ý thích. 

Mình khuyến thích các bạn dã thử trải nghiệm càng nhiều càng tốt biết đâu đó lại lụm được vài điều lí thú cho chiếc app của mình. Dưới đây mình sẽ giới thiệu sơ qua về công dụng một vài component cơ bản và thường sử dụng nhất.

### *Label, Button

Công dụng chức năng của các component này tương tự như Java Swing.
- **Label:** dùng để chứa một dòng đoạn text.
- **Button:** dạng một nút nhấn, phù hợp bắt các sự kiện.

### *TextArea, TextField, PasswordField

Đối với một giao diện cơ bản thì chắc chắn phải có phần nhập text.
- **TextArea:** ô nhập văn bản lớn, có thể nhập nhiều dòng, bạn hoàn toàn có thể chỉnh độ rộng bằng cách kéo thả.
- **TextField:** ô nhập văn bản 1 dòng, tương tự như TextArea, bạn có thể chỉnh độ dài tùy ý.
- **PasswordField:** ô nhập văn bản dạng mật khẩu. Ở đây khi nhập, mọi kí tự sẽ tự động trở thành "*".

### *ImageView

Đây là một component cũng khá quan trọng giúp cho ứng dụng được trực quan hơn. Nhưng nó lại khá phiền toái trong một số trường hợp, mình sẽ giải thích nhé.

Để hiện một hình ảnh lên ứng dụng của mình. Đâu tiên bạn cần kéo component **ImageView** vào vị trí mình mong muốn. Khi đó, sẽ mặc định là một hình ảnh rỗng (màu xám). Muốn hiện hình ảnh hãy 
vào bảng chọn thuộc tính (cột bên phải) vào phần **Properties**. Ở mục đầu tiên Specific, Image, phía bên cạnh là dấu "...". 

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/33f08c75-7c07-404a-8529-8427b6553bd7)

Nhấn vào dấu "..." một cửa sổ chọn file hiện lên, bạn hãy chọn file ảnh mình mong muốn nhé.

> ***Lưu ý:**
>
> - Các bạn nên lưu sẵn hình ảnh ở mục **resources** trong dự án nhé. Điều đó giúp dự án của bạn được gói gọn, dữ liệu ảnh an toàn hơn, dễ làm việc nhóm hơn nếu làm trên git.
>
> - Việc lấy ảnh ở nơi lưu trữ project đối với người chưa làm quen cũng khá gian nan (hồi trước mình cũng vậy). Bạn cần tìm thư mục gốc chứa dự án của mình và chọn đúng nơi chứa ảnh của mình).

Ví dụ mình để ảnh tại **resources** như sau:

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/c5a84632-00d3-4e98-b94f-96278d639619)

Đây là đường dẫn đến file ảnh trên máy tính của mình:

> C:\Users\Admin\IdeaProjects\demo6\src\main\resources\com\example\demo6\anh2.jpg

Tùy thuộc vào nơi bạn đặt dự án của mình ở đấu trên máy tính, thì đường dẫn lại khác nhau. Sau đó, chương trình sẽ tính toán và đưa ra đường dẫn tương đối, nên bạn đừng lo, khi di chuyển file dự án đi nơi khác thì ảnh vẫn sẽ hiện như bình thường.

Chúng ta cùng đi sâu một tí nhé. Bây giờ hãy quay trở lại chế độ **Text** của file UI. Ta thấy các component dưới dạng code đã được sinh tự động ra.

~~~
<ImageView fitHeight="150.0" fitWidth="200.0" pickOnBounds="true" preserveRatio="true">
      <image>
         <Image url="@anh2.jpg" />
      </image>
   </ImageView>
~~~

Ở đây ta thấy **ImageView** thật ra không phải trực tiếp chứa ảnh. Nơi trực tiếp chứa ảnh là thẻ **Image** và còn được kẹp trong cặp thẻ **image,/image**. Điều nãy sẽ gây một số phiền toái nhất nhất định khi ta muốn tái sử dụng ảnh hay xử lí hình ảnh này. Khi cần lấy dữ liệu với kiểu **image** ở Controller ta cần đặt ID ở ngay thẻ con **Image**.

~~~
<Image fx:id="i_image" url="@anh2.jpg" />
~~~

Ta thấy thuộc tính url là **url="@anh2.jpg"**. Đây cũng là một cách khác để add hình ảnh một cách dễ dàng. Ví dụ hình ảnh được đặt ở trong thư mục tên là **Image**, thì đoạn code sẽ như sau:
~~~
<Image fx:id="i_image" url="@Image/anh2.jpg" />
~~~

### *Pane, HBox, VBox

Đây chính là các kiểu Containers, cơ bản nhất, phổ biến nhất nhưng lại vô cùng tối ưu. Bạn có thể tùy ý biến đổi điều chỉnh theo ý thích cho mọi yêu cầu mà ứng dụng của mình cần.

- **Pane:** đơn giản là một khung chứa nhiều component khác, công dụng tương tự như thẻ **div** trong html.
- **HBox, VBox:** đây là 2 khung chứa rất tiện dụng mà chắc chắn rất cần thiết cho ứng dụng của mình. Nó sẽ tự động chia khu vực của chính nó thành các ngăn chứa mỗi thành phần, theo chiều dọc (HBox) hay theo chiều ngang (VBox). Nếu các bạn kéo thả vào trong VBox/HBox càng nhiều component thì nó càng chia thành nhiều ngăn hơn. Việc này ứng dụng cho việc bố ý bố cục hoặc dạng dách sách,...

 ![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/f2087491-b7e1-4c85-a982-c57d0963e736)

 Ở ví dụ này mình nhét nhiều component vào một **VBox**, nó sẽ tự động chia vùng.

 > Tips: Ở bảng bên trái phía dưới có cây component, giúp cho bạn thuận tiện kiểm soát các thành phần trên view của mình.

### *ScrollPane

Tương tự như Pane , HBox, VBox, **ScrollPane** cũng là 1 Containers có thể chứa các component. Nhưng với những kiểu trên, nếu như dữ liệu tràn ra khỏi kích thước mặc định, nó sẽ tràn ra ngoài **Scene** nà mất đi. Để giải quyết vấn đề đó **ScrollPane** giúp tự động tạo các Scroll ngang hoặc dọc nếu như bị tràn theo chiều đó. 

Ta hoàn toàn có thể ẩn các thanh srcoll mặc định đi để đảm bảo thẩm mĩ và còn nhiều những tính năng khắc.

> Tips: Để hiện 1 danh sách mình thường nhét **VBox/HBox** vào 1 **ScrollPane**, khi đó **VBox/HBox** sẽ được mở rộng theo độ dài content, **ScrollPane** sẽ được cố định độ rộng tối đa theo Scene. Khi đó, khi **VBox/HBox** tràn lớn hơn **ScrollPane** nó sẽ tự động tạo scroll.
Đây chỉ cái tips nhỏ của mình, ví dụ cụ thể mình sẽ làm ở bài sau.

## c) Một số mẹo giúp bạn code nhanh hơn

### Tips 1

Ở file UI, chế độ **Text** hay chế độ **Scene builder** chỉ là 2 chế độ xem của một file .fxml duy nhất. Nên khi bạn có bất cứ những điều chỉnh gì ở một chế độ nó sẽ tự động điều chỉnh ở ở chế độ còn lại. Nhưng cái gốc vẫn chính là ở chế độ **Text**. 

Đôi khi có những chỗ chúng ta không thể kéo thả được, thì ta hoàn toàn có thể gõ code text cho nó. Nếu như thành thạo cú pháp ta hoàn toàn có thể tạo một trang UI hoàn chỉnh và không cần Scence Builder, tất nhiên SB vẫn giúp chúng ta có cái nhìn trực quan hơn với file UI của mình.

InteliJ IDEA có chứng năng gợi ý code, tự động sử lỗi, nên các bạn cứ mạnh dạn thử nghiệm nhiều thứ nhé.

### Tips 2

Ở bảng chọn phía bên phải trong phần Properties, trong mục JavaFX CSS. Ở phần **Style**, ta có thể thêm các thuộc tính CSS có sẵn của JavaFX, như sau:

![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/4260d20f-f99e-4bea-b21e-157298ae12cb)

Ở đây các thuộc tính này nên gõ theo gợi ý của hệ thống, nó dễ dàng nhận kết quả hơn, vì nếu sai, nó cũng sẽ không thông báo, nên nếu như component của bạn chưa nhận được sự thay đổi thì có nghĩa bạn đã gõ sai cú pháp rồi.

*Nếu có tips gì hay mình sẽ tiếp tục update ở đây nha.*

## d) TỔNG KẾT

Trong bài viết này, giới thiệu cho các bạn cơ bản về các component mình hay sử dụng. Với các component này chúng ta hoàn toàn có thể build một dự án hoàn chỉnh rồi. Phụ thuộc vào cách sử dụng chúng có thành thạo hay không. Điều này cần sự thực hành và nghiên cứu nhiều hơn.

Ngoài ra trong bảng chọn còn rất nhiều những component khác, hãy tiếp tục tìm hiểu và thử sử dụng, đâu đó sẽ giúp tối ưu hơn ứng dụng của bạn.

Đây là những lý thuyết khá cơ bản, ở bài sau chúng ta sẽ bắt đầu thực hành tạo ra một trang UI hoàn chỉnh như thế nào nhé.
