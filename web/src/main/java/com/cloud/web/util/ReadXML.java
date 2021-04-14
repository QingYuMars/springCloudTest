package com.cloud.web.util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {
    public static void printNode(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node n = nodeList.item(i);// 得到父节点
            if (n.hasChildNodes()) {
                NamedNodeMap attributes = n.getAttributes(); // 遍历节点所有属性
                for (int j = 0; j < attributes.getLength(); j++) {
                    Node attribute = attributes.item(j);
                    // 得到属性名
                    String attributeName = attribute.getNodeName();
                    if ("class".equals(attributeName)) {
                        String attributeValue = attribute.getNodeValue();
                        System.out.println(attributeName + "值:" + attributeValue);
                    }
                    if ("method".equals(attributeName)) {
                        // 得到属性值
                        String attributeValue = attribute.getNodeValue();
                        System.out.println(attributeName + "值:" + attributeValue);
                    }
                }// 打印出结果属性名
            }
            // 子节点
            NodeList childList = n.getChildNodes();
            for (int x = 0; x < childList.getLength(); x++) {
                Node childNode = childList.item(x);
                // 判断取出的值是否属于Element元素,目的是过滤掉
                if (childNode instanceof Element) {
                    // 得到子节点的名字
                    String childNodeName = childNode.getNodeName();
                    // 得到子节点的值
                    String childNodeValue = childNode.getTextContent().trim();
                    System.out.println(childNodeName + "值:" + childNodeValue);
                }
            }
            System.out.println("-------------------------");
            //printNode(n.getChildNodes());// 递归,可根据需求决定是否调用
        }
    }

    public static void main(String[] args) {
        Element element = null;
        File f = new File("C:\\Users\\aaa.xml");
        // documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
        DocumentBuilder db = null;
        DocumentBuilderFactory dbf = null;
        try {
            // 返回documentBuilderFactory对象
            dbf = DocumentBuilderFactory.newInstance();
            // 返回db对象用documentBuilderFatory对象获得返回documentBuildr对象
            db = dbf.newDocumentBuilder();
            // 得到一个DOM并返回给document对象
            Document dt = db.parse(f);
            // 得到一个elment根元素
            element = dt.getDocumentElement();
            // 获得根节点
            System.out.println("根元素：" + element.getNodeName());
            // 获得根元素下的子节点
            NodeList childNodes = element.getChildNodes();
            // 遍历这些子节点
            for (int i = 0; i < childNodes.getLength(); i++) {
                // 获得每个对应位置i的结点
                Node node1 = childNodes.item(i);
                if ("package".equals(node1.getNodeName())) {
                    NodeList nodeActionList = node1.getChildNodes();
                    printNode(nodeActionList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
