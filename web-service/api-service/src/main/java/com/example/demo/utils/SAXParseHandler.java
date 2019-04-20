/**
 * FileName: SAXParseHandler
 * Author:   13235
 * Date:     2019/3/30 19:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import com.example.demo.domain.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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
public class SAXParseHandler extends DefaultHandler {

    private List<Book> list=new ArrayList<>();

    private Book book;

    private String content;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析。。。。");


    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("uri:" + uri);
        System.out.println("localName:" + localName);
        System.out.println("qName:" + qName);
        if ("book".equals(qName)) {
            book = new Book();
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                String qName1 = attributes.getQName(i);
                String value = attributes.getValue(i);
                System.out.println("qName:" + qName1);
                System.out.println("value:" + value);
                if ("id".equals(qName1)) {
                    book.setId(Integer.parseInt(value));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("end uri:" + uri);
        System.out.println("end localName:" + localName);
        System.out.println("end qName:" + qName);
        if ("book".equals(qName)) {
            list.add(book);
            book = null;
        } else if ("name".equals(qName)) {
            book.setName(content);
        } else if ("year".equals(qName)) {
            book.setYear(Integer.parseInt(content));
        } else if ("price".equals(qName)) {
            book.setPrice(Double.parseDouble(content));
        } else if ("author".equals(qName)) {
            book.setAuthor(content);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = new String(ch, start, length);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析完毕。。。。。。");
    }

    public List<Book> getBooks() {
        return list;
    }

}
