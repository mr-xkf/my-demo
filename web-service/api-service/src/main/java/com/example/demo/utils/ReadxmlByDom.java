/**
 * FileName: ReadxmlByDom
 * Author:   13235
 * Date:     2019/3/30 18:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import com.example.demo.domain.Book;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/30
 * @since 1.0.0
 */
public class ReadxmlByDom {
    private static DocumentBuilderFactory documentBuilderFactory;
    private static DocumentBuilder documentBuilder;
    private static Document document;
    private static List<Book> books;

    static {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> getBooks(String fileName) throws IOException, SAXException {
         books = new ArrayList<>();
        document = documentBuilder.parse(fileName);
        NodeList book = document.getElementsByTagName("book");
        for (int i = 0; i < book.getLength(); i++) {
            Book b = new Book();
            //获取i个book节点
            Node item = book.item(i);
            //获取第i个book的所有属性
            NamedNodeMap attributes = item.getAttributes();
            //获取已知的属性值
            String id = attributes.getNamedItem("id").getTextContent();
            b.setId(Integer.parseInt(id));
            //获取book节点的子节点,包含了Text类型的换行
            NodeList childNodes = item.getChildNodes();
            System.out.println("长度:" + childNodes.getLength());
            //将一个book里面的属性加入数组
            List<String> contents = new ArrayList<>();
            for (int j = 1; j < childNodes.getLength(); j += 2) {
                Node item1 = childNodes.item(j);
                String textContent = item1.getFirstChild().getTextContent();
                System.out.println(textContent);
                contents.add(textContent);
            }
            b.setName(contents.get(0));
            b.setAuthor(contents.get(1));
            b.setYear(Integer.parseInt(contents.get(2)));
            b.setPrice(Double.parseDouble(contents.get(3)));
            books.add(b);
        }
        return books;
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\13235\\Desktop\\my-demo\\web-service\\api-service\\src\\main\\resources\\book.xml";
        try {
            List<Book> books = ReadxmlByDom.getBooks(fileName);
            books.stream().forEach(a->{
                a.toString();
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

}
