/**
 * FileName: ReadxmlBySAX
 * Author:   13235
 * Date:     2019/3/30 19:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/30
 * @since 1.0.0
 */
public class ReadxmlBySAX {

    private static SAXParserFactory factory;
    private static SAXParser saxParser;
    static {
        try {
            factory = SAXParserFactory.newInstance();
            saxParser=factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static  void  parse(String fileName, DefaultHandler handler) {
        try {
            saxParser.parse(fileName,handler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String fileName = "C:\\Users\\13235\\Desktop\\my-demo\\web-service\\api-service\\src\\main\\resources\\book.xml";
        SAXParseHandler handler = new SAXParseHandler();
        ReadxmlBySAX.parse(fileName,handler);
        handler.getBooks().stream().forEach(a ->
                System.out.println(a.toString()));
    }






}
