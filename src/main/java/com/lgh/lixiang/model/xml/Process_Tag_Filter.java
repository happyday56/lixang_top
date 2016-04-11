package com.lgh.lixiang.model.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * ͨ����ǩ��ʽ���� �� idΪconent��ȡ����
 */
public class Process_Tag_Filter {
    /**
     * ��ȡ��ǩ��λ�� Ĭ��Ϊ1 ��һ��
     */
    private Integer pos = 1;
    /**
     * ��ǩ������ ���� id,class,name��(width��href��targetҲ֧��)
     */
    private String key;
    /**
     * ���Ե�ֵ
     */
    private String value;

    public Integer getPos() {
        return pos;
    }

    @XmlAttribute(name = "pos")
    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public String getKey() {
        return key;
    }

    @XmlAttribute(name = "key")
    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    @XmlAttribute(name = "value")
    public void setValue(String value) {
        this.value = value;
    }


}
