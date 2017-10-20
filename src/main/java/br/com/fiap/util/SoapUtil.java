package br.com.fiap.util;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.w3c.dom.Element;

public class SoapUtil {
	
	public static String valueFromHeader(SoapMessage message, String tagName) {
		List<Header> headers = message.getHeaders();
		
		for (Header header : headers) {
			Element element = (Element) header.getObject();
			if (element.getLocalName().equals(tagName)) {
				return element.getTextContent();
			}
		}
		
		return null;
	}
}
