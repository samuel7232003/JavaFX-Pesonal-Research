# 01. Giới thiệu về JavaFX và những cài đặt cần thiết
## a) Giới thiệu về JavaFX
Như mình đã viết ở phần đầu, ít có một tài liệu nào chính thức về JavaFX nên chúng ta sẽ bắt đầu tìm hiểu từ đầu nhé. Đối với bạn nào muốn bắt đầu xây dựng một chương trinh JavaFX luôn thì có thể bỏ qua phần này.

> JavaFX is a Java library used to develop Desktop applications as well as Rich Internet Applications (RIA). The applications built in JavaFX, can run on multiple platforms including Web, Mobile and Desktops.
> 
> JavaFX is intended to replace swing in Java applications as a GUI framework. However, It provides more functionalities than swing. Like Swing, JavaFX also provides its own components and doesn't depend upon the operating system. It is lightweight and hardware accelerated. It supports various operating systems including Windows, Linux and Mac OS.
>
> (javatpoint.com)

Theo như trích dẫn trong toturial trên, có thể hiểu đơn giản JavaFX chính là một thư viện giúp xây dựng giao diện cho một ứng dụng Java. Nó được ra đời để thay thế cho một công cụ đã cũ như Java Swing. 

JavaFX có một bộ components giúp hỗ trợ tối đa cho việc kéo thả những chức năng quan trọng như Label, ImageView,... Nó có nhiều chức năng hơn Swing, giúp tối hưu hóa, văn minh hóa hơn quá trình thiết kế giao diện, tăng trải nghiệm người dùng hơn với ứng dụng Java của bạn.

Nếu bạn cần thành thạo và muốn sử dụng ngôn ngữ Java để xây dựng một ứng dụng, thì JavaFX chính là một công cụ tối ưu đáng để nghiên cứu.

## b) Những cài đặt cần thiết để bắt đầu một chương trình JavaFX

***Cài đặt IDE InteliJ IDEA**

Link download: https://www.jetbrains.com/idea/download/?section=windows

Cần đăng kí tài khoản edu để sử dụng.

***Tạo một project mới**
<br>
<br>
![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/779f9464-b455-42c8-b217-44f3fcce1633)
<br>
<br>
Các bạn cần đợi 1 thời gian để chương trình khởi tạo và download các công cụ JDK, ...

Sau khi tạo xong ta sẽ có 1 chương trình mẫu mà InteliJ đã khởi tạo sẵn, có cấu trúc như sau:
<br><br>
![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/6bc83cc0-baa2-4756-bb3b-3384f00e9070)

***Chạy chương trình mẫu**
<br> <br>
![image](https://github.com/samuel7232003/JavaFX-Pesonal-Research/assets/115569080/38ab993a-da4d-4d9d-9f8c-c135d85dde0d)
<br>
Nếu kết quả như hình trên thì chúc mừng. Bạn đã có một chương trình java thành công đầu tiên.

****Những lưu ý:***

- Khi chưa hiểu rõ những chức năng về công cụ IDE thì các bạn không nên nhấn chọn những nút không cần thiết. Chỉ bần nhấn các nút "Next", "Create" theo hướng dẫn cho chương trình đầu tiên khi khởi tạo (dễ gặp lỗi khi không tim thấy thư viện của chúng).
  
- Thường thì sẽ thành công luôn ngay khi tạo chương trình đầu tiên. Nếu như bạn gặp lỗi khi biên dịch sẽ có 2 trường hợp: 1 là do IDE chưa khởi tạo xong các công cụ cần thiết, hay import các thư viện cần thiết. Lúc này, bn chỉ cần đợi một thời gian nữa (để ý thanh trạng thái ở dưới cùng) khi load xong thử chạy lại chương trình. Trường hợp 2 là do lỗi project, có thể trong lúc tạo bạn đã chọn nhầm hoặc không đúng mục nào đó, hãy tạo lại một project mới nhé.
