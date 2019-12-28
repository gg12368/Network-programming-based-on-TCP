实现1：服务器端
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
TCP通信的服务器端：接收客户端的请求，读取服务器端发送的数据，给客户端写数据
 */
/*
明确：
必须使用accept()方法来获取请求的客户端对象socket
步骤：
1.创建服务器ServerSocket对象，和系统指定的端口号
2.使用ServerSocket对象中的accept()方法获取到请求的服务器端对象Socket
3.使用Socket对象中的getInputStream()方法获取网络字节输出流InputStream对象
4.使用网络字节输出流对象InputStream对象中的方法read()，读取客户端发送的数据
5.使用Socket对象中的getOutputStream()方法获取网络字节输出流OutputStream对象
6.使用网络字节输出流对象OutputStream对象中的方法write()，给客户端回写数据
7.释放资源Socket，ServerSocket
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1.创建服务器ServerSocket对象，和系统指定的端口号
        ServerSocket serverSocket=new ServerSocket(8888);
        while(true){
            //2.使用ServerSocket对象中的accept()方法获取到请求的服务器端对象Socket
            Socket socket=serverSocket.accept();
            int port=socket.getPort();
            System.out.println("与端口号为"+port+"客户端连接成功，开始进行数据交互");
            //3.使用Socket对象中的getInputStream()方法获取网络字节输出流InputStream对象
            InputStream is=socket.getInputStream();
            //4.使用网络字节输出流对象InputStream对象中的方法read()，读取客户端发送的数据
            byte[] bytes=new byte[1024];
            int len=is.read(bytes);
            System.out.println(new String(bytes,0,len));
            //5.使用Socket对象中的getOutputStream()方法获取网络字节输出流OutputStream对象
            OutputStream os=socket.getOutputStream();
            //6.使用网络字节输出流对象OutputStream对象中的方法write()，给客户端回写数据
            os.write("收到，谢谢".getBytes());
            //7.释放资源Socket，ServerSocket
            socket.close();
            serverSocket.close();
        }
    }
}
