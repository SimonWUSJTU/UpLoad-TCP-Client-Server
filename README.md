# UpLoad-TCP-Client-Server
you can use the code to let Client communicate to server, using yourself laptop as a server 127.0.0.1. 
## 关于这个文档
通过客户端和服务器之间的通信，完成上传文档的工作。
## TCPClient类
    1，表示是客户端类，建立客户端对象，固服务器的IP和post
    2，首先创造本地输入流，读取本地的文件
    3，创造用于网络通信的Socket类，从中间获得网络输出流
    4，一读一些，把文件的信息就装在了网络输出流中。
    5，关闭资源
**注意把其中的网络输出流要关闭，应为read读不到-1，-1传输不到网络输出流中**  socket.shutdownOutput();
## TCPServer类
    1，建立服务器对象，定义对接的端口
    2，用server.accept();去响应服务器的请求
    3，用 socket中提供的网络输入流，创建网络输入流
    4，创建本地输出流，用于把网络输入流的文件写在当地的硬盘中
    5，一读一些
    6，完成后利用socket中的输出流向客户端发送信息
    7，客户端获取网络输入流的信息，做出改变。
**注意，用while(true)使得网络常开；使用新的线程，可以多线程操作；抛出的IO异常必须要用try catch抓住了**
