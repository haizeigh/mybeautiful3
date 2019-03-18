package com.company.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by muzhe-wang on 16/7/1.
 */
public class XmlReaders {

    private  DocumentBuilder builder;

     {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//            documentBuilderFactory.setExpandEntityReferences(false);
//            String FEATURE = "http://xml.org/sax/features/external-general-entities";
//            documentBuilderFactory.setFeature(FEATURE, false);
//            FEATURE = "http://xml.org/sax/features/external-parameter-entities";
//            documentBuilderFactory.setFeature(FEATURE, false);

            //关闭外部实体解析修补xxe 方法
            String FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
            documentBuilderFactory.setFeature(FEATURE, true);


            builder = documentBuilderFactory.newDocumentBuilder();
//            builder =  DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("init xml failed");
        }
    }

    private Document document;

    private XmlReaders(){}

    public static XmlReaders create(String xml){
        try {
            return create(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException("xml file get UTF-8 Bytes fail,xml is :"+xml, e);
        }
    }

    public static XmlReaders create(InputStream inputStream){
        XmlReaders readers = new XmlReaders();
        try {
            readers.document = readers.builder.parse(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Xmls create fail", e);
        }
        return readers;
    }

    public Node getNode(String tagName){
        NodeList nodes = document.getElementsByTagName(tagName);
        if (nodes.getLength() <= 0){
            return null;
        }
        return nodes.item(0);
    }

    public NodeList getNodes(String tagName){
        NodeList nodes = document.getElementsByTagName(tagName);
        if (nodes.getLength() <= 0){
            return null;
        }
        return nodes;
    }

    /**
     * 获取某个节点的文本内容，若有多个该节点，只会返回第一个
     * @param tagName 标签名
     * @return 文本内容，或NULL
     */
    public String getNodeStr(String tagName){
        Node node = getNode(tagName);
        return node == null ? null : node.getTextContent();
    }

    /**
     * 获取某个节点的Integer，若有多个该节点，只会返回第一个
     * @param tagName 标签名
     * @return Integer值，或NULL
     */
    public Integer getNodeInt(String tagName){
        String nodeContent = getNodeStr(tagName);
        return nodeContent == null ? null : Integer.valueOf(nodeContent);
    }

    /**
     * 获取某个节点的Long值，若有多个该节点，只会返回第一个
     * @param tagName 标签名
     * @return Long值，或NULL
     */
    public Long getNodeLong(String tagName){
        String nodeContent = getNodeStr(tagName);
        return nodeContent == null ? null : Long.valueOf(nodeContent);
    }

    /**
     * 获取某个节点的Float，若有多个该节点，只会返回第一个
     * @param tagName 标签名
     * @return Float值，或NULL
     */
    public Float getNodeFloat(String tagName){
        String nodeContent = getNodeStr(tagName);
        return nodeContent == null ? null : Float.valueOf(nodeContent);
    }
}
