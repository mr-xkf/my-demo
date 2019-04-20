/**
 * FileName: ReadxmlByJDom
 * Author:   13235
 * Date:     2019/3/30 19:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import com.example.demo.domain.Book;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
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
public class ReadxmlByJDom {

    private List<Book> books = null;

    private Book book = null;

    public List<Book> getBooks(String fileName) {

        SAXBuilder saxBuilder = new SAXBuilder();

        try {
            Document document = saxBuilder.build(new FileInputStream(fileName));

            //获取根节点
            Element rootElement = document.getRootElement();

            List<Element> children = rootElement.getChildren();

            if (CollectionUtils.isEmpty(children)) {
                return null;
            }

            books = new ArrayList<Book>(children.size());

            for (Element child : children) {
                book = new Book();
                List<Attribute> attributes = child.getAttributes();
                for (Attribute attribute : attributes) {
                    if ("id".equals(attribute.getName())) {
                        String id = attribute.getValue();
                        book.setId(Integer.parseInt(id));
                    }
                }
                //获取bookElement的子节点
                List<Element> children1 = child.getChildren();
                for (Element element : children1) {
                    if (element.getName().equals("name")) {
                        String name = element.getValue();//System.out.println(name);
                        book.setName(name);
                    } else if (element.getName().equals("author")) {
                        String author = element.getValue();
                        book.setAuthor(author);//System.out.println(author);
                    } else if (element.getName().equals("year")) {
                        String year = element.getValue();
                        book.setYear(Integer.parseInt(year));
                    } else if (element.getName().equals("price")) {
                        String price = element.getValue();
                        book.setPrice(Double.parseDouble(price));
                    }
                }
                books.add(book);
                book = null;
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\13235\\Desktop\\my-demo\\web-service\\api-service\\src\\main\\resources\\book.xml";
        ReadxmlByJDom rdb = new ReadxmlByJDom();
        List<Book> books = rdb.getBooks(fileName);
        books.stream().forEach(s -> System.out.println(s));

    }

}
