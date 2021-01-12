package BlackMa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8888);
while(true) {
    Socket socket = server.accept();//写个死循环就好了

    new Thread(new Runnable() {
        @Override
        public void run() {
            try{
                InputStream is = socket.getInputStream();


                File file = new File("d:\\upload");

                String fileName = "meinv" + System.currentTimeMillis() + new Random().nextInt(9999) + ".jpg";

                if (!file.exists()) {
                    file.mkdir();
                }

                FileOutputStream fos = new FileOutputStream(file + "\\" + fileName);

                int len = 0;
                byte[] bytes = new byte[1024];

                while ((len = is.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }

                socket.getOutputStream().write("上传成功".getBytes());

                socket.shutdownOutput();

                fos.close();
                socket.close();


                server.close();
            }catch (IOException e){
                System.out.println(e);
            };
        }
    }).start();


}
    }
}
