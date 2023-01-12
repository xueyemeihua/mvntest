package cn.ly.mvntest.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlUtil {

    //注意在定义map时确定泛型的编写,使用时可以避免转型
    //存储数据库连接信息
    public static Map<String, String> dataSourceMap = new HashMap<>();
    //存储Mapper sql 信息
    public static Map<String, MapperObject> mapperMap = new HashMap<>();
    //静态初始化块,当类被加载的时候自动执行一次
    static {
        try {
            parseDateSource();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    //初始化块,创建对象才会执行,会随着对象的创建而执行
    {

    }

    public static void parseMapperExcute() throws DocumentException {
        parseMapper("mydatasource.xml");
    }

    //解析mydatasource.xml
    public static void parseDateSource() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(XmlUtil.class.getClassLoader().getResourceAsStream("mydatasource.xml"));
        //获取根元素
        Element rootElement = document.getRootElement();
        String name = rootElement.elementTextTrim("name");
        String pwd = rootElement.elementTextTrim("pwd");
        String url = rootElement.elementTextTrim("url");
        String driver = rootElement.elementTextTrim("driver");

        //获取mapperlocations标签的内容
        Element mapperLocations = rootElement.element("mapperlocations");
        List<Element> locations = mapperLocations.elements("location");
        for (Element location : locations) {
            //遍历所有location并取值
            String loc = location.getText().trim();
            //System.out.println(loc);
            //解析location对应的xml
            parseMapper(loc);
        }
        dataSourceMap.put(Constants.NAME,name);
        dataSourceMap.put(Constants.PASSWORD,pwd);
        dataSourceMap.put(Constants.URL,url);
        dataSourceMap.put(Constants.DRIVER,driver);
    }

    public static void parseMapper(String file) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(XmlUtil.class.getClassLoader().getResourceAsStream(file));
        //获取根元素
        Element rootElement = document.getRootElement();
        String namespace = rootElement.attributeValue("namespace");
        List<Element> mappers = rootElement.elements("mapper");

        for (int i = 0; i < mappers.size(); i++) {
            Element mapper = mappers.get(i);
            String id = mapper.attribute("id").getValue();
            String returnType = mapper.attribute("returnType").getValue();
            String sql = mapper.getText().trim();
            MapperObject mapperObject = new MapperObject(id,returnType,sql);
            mapperMap.put(namespace+"."+id,mapperObject);
        }
    }
}
