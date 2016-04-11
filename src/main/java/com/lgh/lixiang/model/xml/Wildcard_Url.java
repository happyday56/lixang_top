package com.lgh.lixiang.model.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * ͨ�����ַ (Ŀ���Ӧ����ַ����������ҳ���б��) ��Multi_Url�ɶ�ѡ��һ
 */
public class Wildcard_Url {
    /**
     * ͨ�����ַ����
     */
    private String href;
    /**
     * ��ʼ ���ԱȽ�����С
     */
    private int startpos;
    /**
     * ����
     */
    private Integer endpos;

    public String getHref() {
        return href;
    }

    @XmlAttribute(name = "href")
    public void setHref(String href) {
        this.href = href;
    }

    public Integer getStartpos() {
        return startpos;
    }

    @XmlAttribute(name = "startpos")
    public void setStartpos(Integer startpos) {
        this.startpos = startpos;
    }

    public Integer getEndpos() {
        return endpos;
    }

    @XmlAttribute(name = "endpos")
    public void setEndpos(Integer endpos) {
        this.endpos = endpos;
    }
}
