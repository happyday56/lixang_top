package com.lgh.lixiang.model.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * ��������Ŀ����ַ
 */
public class Single_Url {
    private String href;

    public String getHref() {
        return href;
    }

    @XmlAttribute(name = "href")
    public void setHref(String href) {
        this.href = href;
    }
}
