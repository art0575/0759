// ProxyChecker. Многопоточность. 3-й способ
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C://project/ip.txt");
            int i;
            String proxy = "";
            while((i=fis.read()) != -1){
                if(i==13) continue;
                else if(i==10){
                    String ip = proxy.split(":")[0];
                    int port = Integer.parseInt(proxy.split(":")[1]);
                    Thread checkProxy = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip,port));
                                URL url = new URL("https://vozhzhaev.ru/test.php");
                                URLConnection urlConnection = url.openConnection(proxy);
                                urlConnection.setConnectTimeout(3000); // 3 seconds
                                InputStream is = urlConnection.getInputStream();
                                InputStreamReader reader = new InputStreamReader(is);
                                int i;
                                StringBuilder result = new StringBuilder();
                                while ((i=reader.read()) != -1){
                                    result.append((char)i);
                                }
                                System.out.println(result+":"+port+" - работает");
                                // добавим найденный адрес в файл
                                String goodProxy = ip+":"+port+"\n";
                                    FileOutputStream fos = new FileOutputStream ("C://project/good_ip.txt", true);
                                        fos.write (goodProxy.getBytes (StandardCharsets.UTF_8));
                                        fos.close ( );
                            } catch (IOException exception) {
                                System.out.println("\u001B[31m"+ip+":"+port+" - не работает"+"\u001B[0m");
                            }
                        }
                    });
                    checkProxy.start();
                    proxy = "";
                }else if(i!=9){
                    proxy += (char) i;
                }else{
                    proxy += ":";
                }
            }
        } catch (IOException  e) {
            System.out.println("Файл не найден!");
        }
    }
}