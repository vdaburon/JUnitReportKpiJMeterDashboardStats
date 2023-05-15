package io.github.vdaburon.jmeter.utils.jsonkpi;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Utility Class to create a JUnit DOM, add testcase and write JUnit XML file
 */

public class UtilsJUnitXml {
    /**
     * Create the DOM for a JUnit XML file
     * @return the DOM with testsuite root element
     * @throws ParserConfigurationException error creating XML DOM
     */
    public static Document createJUnitRootDocument() throws ParserConfigurationException {
/*
<testsuite errors="0"
        failures="2"
        name="JUnit Report From JMeter Report Csv"
        skipped="0"
        tests="3">
 */
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();

        Element root = document.createElement("testsuite");
        document.appendChild(root);
        Attr attr1 = document.createAttribute("errors");
        attr1.setValue("0");
        root.setAttributeNode(attr1);

        Attr attr2 = document.createAttribute("failures");
        attr2.setValue("0");
        root.setAttributeNode(attr2);

        Attr attr3 = document.createAttribute("name");
        attr3.setValue("JUnit Report From JMeter Report Csv");
        root.setAttributeNode(attr3);

        Attr attr4 = document.createAttribute("skipped");
        attr4.setValue("0");
        root.setAttributeNode(attr4);

        Attr attr5 = document.createAttribute("tests");
        attr5.setValue("0");
        root.setAttributeNode(attr5);


        return document;
    }

    /**
     * increment attribute in testsuite (number of tests and number of failures)
     * @param document the JUnit DOM
     * @param attribute the attribute name to find and increment current value
     * @return the value incremented
     */
    public static int incrementTestsuiteAttribute(Document document, String attribute) {
        Element testSuiteElt = document.getDocumentElement();
        String sValueAttribute = testSuiteElt.getAttributes().getNamedItem(attribute).getTextContent();
        int iValueAttribute = Integer.parseInt(sValueAttribute);
        iValueAttribute++;
        testSuiteElt.getAttributes().getNamedItem(attribute).setTextContent("" + iValueAttribute);
        return iValueAttribute;
    }

    /**
     * Add a Test Case OK
     * @param document the JUnit DOM
     * @param classname the name_kpi
     * @param name the kpi rule + label_regex + comparator + threshold
     */
    public static void addTestCaseOk(Document document,  String classname, String name) {
/*
<testcase classname="Error_rate" name="Error % (SC.*) &lt; 0.02"/>
 */
        Element testcase = document.createElement("testcase");
        Element testSuiteElt = document.getDocumentElement();
        testSuiteElt.appendChild(testcase);

        Attr attr1 = document.createAttribute("classname");
        attr1.setValue(classname);
        testcase.setAttributeNode(attr1);

        Attr attr2 = document.createAttribute("name");
        attr2.setValue(name);
        testcase.setAttributeNode(attr2);

        incrementTestsuiteAttribute(document,"tests");

    }

    /**
     * Add a Test Case Failure
     * @param document the JUnit DOM
     * @param classname  the name_kpi
     * @param name the kpi rule + label_regex + comparator + threshold
     * @param failureMessage the message explains kpi failure
     */
    public static void addTestCaseFailure(Document document,  String classname, String name, String failureMessage) {
/*
  <testcase classname="Percentiles_90" name="90% Line (SC\d+_P.*) &lt;= 30">
      <failure message="">Actual value 3068,200000 exceeds threshold 3000,000000 for samples matching "@SC.*"</failure>
   </testcase>
 */
        Element testcase = document.createElement("testcase");
        Element testSuiteElt = document.getDocumentElement();
        testSuiteElt.appendChild(testcase);

        Attr attr1 = document.createAttribute("classname");
        attr1.setValue(classname);
        testcase.setAttributeNode(attr1);

        Attr attr2 = document.createAttribute("name");
        attr2.setValue(name);
        testcase.setAttributeNode(attr2);

        Element failure = document.createElement("failure");
        Attr attrFailure = document.createAttribute("message");
        attrFailure.setValue("");
        failure.setAttributeNode(attrFailure);

        testcase.appendChild(failure);
        failure.appendChild(document.createTextNode(failureMessage));

        incrementTestsuiteAttribute(document,"tests");
        incrementTestsuiteAttribute(document,"failures");
    }

    /**
     * Save the JUnit DOM in a XML file
     * @param document JUnit DOM
     * @param junitXmlFileOut XML file to write
     * @throws TransformerException error when write XML file
     */
    public static void saveXmlInFile(Document document, String junitXmlFileOut) throws TransformerException {
        // create the xml file
        //transform the DOM Object to an XML File
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number", 3);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(junitXmlFileOut));
        transformer.transform(domSource, streamResult);
    }
}
