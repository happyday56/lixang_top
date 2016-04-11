package com.lgh.lixiang.model.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Ŀ���б���ַ�Ĵ������
 */
public class Target_Regex {
	/**
	 *�����ȡ����ַֻ����Ե�ַ ������վ��ַ
	 */
	private String root;
	/**
	 * ��������
	 */
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRoot() {
		return root;
	}

	@XmlAttribute(name = "root")
	public void setRoot(String root) {
		this.root = root;
	}
}
