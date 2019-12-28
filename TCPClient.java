实现2：客户端
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
TCP通信的客户端，向服务器发送连接请求给服务器发送数据
 */
/*
实现步骤：
1.创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
2.使用Socket对象中的getOutputStream()方法获取网络字节输出流OutputStream对象
3.使用网络字节输出流对象OutputStream对象中的方法write()，给服务器发送数据
4.使用Socket对象中的getInputStream()方法获取网络字节输出流InputStream对象
5.使用网络字节输出流对象InputStream对象中的方法read()，读取服务器发送的数据
6.释放资源
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建一个Socket并连接到指定的服务器端
        Socket socket =new Socket("127.0.0.1",8888);
        //2.使用Socket对象中的getOutputStream()方法获取网络字节输出流OutputStream对象
        OutputStream os=socket.getOutputStream();
        //3.使用网络字节输出流对象OutputStream对象中的方法write()，给服务器发送数据
        os.write("你好，服务器".getBytes());
        //4.使用Socket对象中的getInputStream()方法获取网络字节输出流InputStream对象
        InputStream is=socket.getInputStream();
        //5.使用网络字节输出流对象InputStream对象中的方法read()，读取服务器发送的数据
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //6.释放资源
        socket.close();
    }
}

