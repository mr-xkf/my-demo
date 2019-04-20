/**
 * FileName: ReadxmlByDom4j
 * Author:   13235
 * Date:     2019/3/30 19:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import com.example.demo.domain.Book;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/30
 * @since 1.0.0
 */
public class ReadxmlByDom4j {

    private List<Book> bookList = new ArrayList<>();

    private Book book = null;

    public List<Book> getBooks(File file) {
        SAXReader reader = new SAXReader();
        try {
            Document read = reader.read(file);
            Element rootElement = read.getRootElement();
            Iterator<Element> bookElement = rootElement.elementIterator();
            while (bookElement.hasNext()) {
                Element next = bookElement.next();
                book = new Book();
                Iterator<Attribute> iterator = next.attributeIterator();
                while (iterator.hasNext()) {
                    Attribute attribute = iterator.next();
                    if ("id".equals(attribute.getName())) {
                        String value = attribute.getValue();
                        book.setId(Integer.parseInt(value));
                    }
                }
                //book元素的子元素数组
                Iterator<Element> elementIterator = next.elementIterator();
                while (elementIterator.hasNext()) {
                    Element element = elementIterator.next();
                    if ("name".equals(element.getName())) {
                        book.setName((String) element.getData());
                    } else if ("year".equals(element.getName())) {
                        book.setYear((Integer.parseInt((String) element.getData())));
                    } else if ("author".equals(element.getName())) {
                        book.setAuthor(((String) element.getData()));
                    } else if ("price".equals(element.getName())) {
                        book.setPrice((Double.parseDouble((String) element.getData())));
                    }
                }
                bookList.add(book);
                book = null;
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return bookList;
    }


    public static void main(String[] args) {
        String fileName = "C:\\Users\\13235\\Desktop\\my-demo\\web-service\\api-service\\src\\main\\resources\\book.xml";
        ReadxmlByDom4j rbd = new ReadxmlByDom4j();
        List<Book> books = rbd.getBooks(new File(fileName));
        books.stream().forEach(a -> {
            System.out.println(a.toString());
        });
    }


}
