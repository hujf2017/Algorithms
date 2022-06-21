package 基础.双亲委派;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author hujf
 * @Date 2022/6/21 16:14
 * @Description TODO
 */
public class MyClassLoader extends ClassLoader {

    private SocketAddress sa;

    public MyClassLoader(SocketAddress sa) {
        this.sa = sa;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, InvocationTargetException {

        MyClassLoader classLoader = new MyClassLoader(new InetSocketAddress(InetAddress.getLocalHost(),8080));
        while (true){
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if( "STOP".equals(line) ){
                break;
            }
            String[] commands = line.split(" ");
            System.out.println("waiting...");
            if( "send".equals(commands[0]) ){
                Class clazz = classLoader.findClass(commands[1]);
                Method ms = clazz.getDeclaredMethod("say");
                Object instance = clazz.newInstance();
                ms.invoke(instance);
            }
            System.out.println( "load finish." );
        }
    }


    private Map cache = new ConcurrentHashMap<>();

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = (Class) cache.get(name);
        if (clazz != null) {
            System.out.println("从缓存中加载");
            return clazz;
        } else {
            System.out.println("从远程服务器加载。");
            Socket socket = new Socket();
            try {
                socket.connect(sa);
                OutputStream out = socket.getOutputStream();
                out.write(name.getBytes(Charset.forName("utf-8")));
                out.flush();
                socket.shutdownOutput();
                InputStream in = socket.getInputStream();
                ByteArrayOutputStream bot = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                for (int len = 0; (len = in.read(buffer)) != -1; ) {
                    bot.write(buffer, 0, len);
                }
                byte[] bytes = bot.toByteArray();


                Class cls = this.defineClass(name, bytes, 0, bytes.length);
                cache.putIfAbsent(name, cls);
                socket.close();
                return cls;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
