package com.lgh.lixiang.model.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * ����Ŀ�궨��
 *
 * @author Administrator
 */
public class Target {
    /**
     * ����Ŀ����� Ĭ��utf-8(��ʱû�� ���Կ��Ƿ���project)
     */
    private String encode = "utf-8";
    /**
     * ����ʱ�� Ĭ��8000(��ʱû�� ���Կ��Ƿ���project)
     */
    private Integer timeout = 8000;
    /**
     * ����б���ַ (Ŀ���Ӧ����ַ����������ҳ���б��) ��Wildcard_Url�ɶ�ѡ��һ,Ҳ�ɶ�������
     */
    private List<Single_Url> multi_url;
    /**
     * ͨ�����ַ (Ŀ���Ӧ����ַ����������ҳ���б��) ��Multi_Url�ɶ�ѡ��һ,Ҳ�ɶ�������
     */
    private Wildcard_Url wildcard_url;

    /**
     * ��ַ�������
     */
    private Target_Regex target_regex;

    public String getEncode() {
        return encode;
    }

    @XmlAttribute(name = "encode")
    public void setEncode(String encode) {
        this.encode = encode;
    }

    public Integer getTimeout() {
        return timeout;
    }

    @XmlAttribute(name = "timeout")
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public List<Single_Url> getMulti_url() {
        return multi_url;
    }

    @XmlElementWrapper(name = "multi_url")
    @XmlElement(name = "single_url")
    public void setMulti_url(List<Single_Url> multi_url) {
        this.multi_url = multi_url;
    }


    public Wildcard_Url getWildcard_url() {
        return wildcard_url;
    }

    public void setWildcard_url(Wildcard_Url wildcard_url) {
        this.wildcard_url = wildcard_url;
    }

    public Target_Regex getTarget_regex() {
        return target_regex;
    }

    public void setTarget_regex(Target_Regex target_regex) {
        this.target_regex = target_regex;
    }

}
