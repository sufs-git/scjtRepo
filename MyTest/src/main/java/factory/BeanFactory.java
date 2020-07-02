package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 使用Bean.properties配置文件存储唯一标识=类的全限定名称,即key=value形式
 * 读取配置文件，使用反射创建对象
 */
public class BeanFactory {
    private static Properties props;
    /**定义一个Map容器，以唯一标识作为Key，以对象作为value*/
    private static Map<String,Object> maps;
    static{
        try {
            maps=new HashMap<>();
            props=new Properties();
            /**使用类加载器创建bean.properties文件的流*/
            InputStream in=BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            Enumeration en=props.keys();
            while(en.hasMoreElements()){
                try {
                    String key=en.nextElement().toString();
                    String pathName=props.getProperty(key);
                    Object value=Class.forName(pathName).newInstance();
                    maps.put(key,value);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object getBean(String beanName){
          return maps.get(beanName);
    }
    /*public static Object getBean(String beanName){
        try {
            return Class.forName(props.getProperty(beanName)).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
