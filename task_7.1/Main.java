// ProxyChecker. Многопоточность. 1-й способ с записью рабочих прокси в файл

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
                    String port = proxy.split(":")[1];
                    CheckProxy checkProxy = new CheckProxy(ip, Integer.parseInt(port));
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

class CheckProxy extends Thread {
    private String ip;
    private int port;

    public CheckProxy(String ip, int port) {
        super();
        this.ip = ip;
        this.port = port;
    }
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
            System.out.println(result+":"+port+" - Ok");
            String goodProxy = ip+":"+port+"\n";

            FileOutputStream fos = new FileOutputStream("C://project/good_ip.txt", true);
            fos.write(goodProxy.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (IOException exception) {
            System.out.println(ip+":"+port+" - не работает! ["+ exception.getMessage()+"]");
        }
    }
}