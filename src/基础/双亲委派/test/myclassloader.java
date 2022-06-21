package 基础.双亲委派.test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author hujf
 * @Date 2022/6/21 16:26
 * @Description TODO
 */
public class myclassloader extends  ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        name.replace("/",".");
        String mypath = "file:/D:/java/workspace/test2x/out/production/test2x/MyClass/Demo.class";
        Path path;
        byte[] classbytes = null;
        try {
            URI uri = new URI(mypath);
            path = Paths.get(uri);
            classbytes = Files.readAllBytes(path);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        Class clazz = defineClass(name, classbytes, 0, classbytes.length);
        return clazz;
    }
}
