package com.lgh.lixiang.model.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * ����������յ���ҳ���� ������target�������ã����Ĵ���
 */
public class Process {
    /**
     * ���������� true ��һ������ʹ�ô˻�������ݣ������ݲ��ô������ݿ� ���ȡ����div�е�����
     */
    private Boolean flow;
    /**
     * ��ʱ����
     */
    private String table;
    /**
     *  ����ֶ� ���ݴ��ֶδ������� title content key description
     */
    private String field;

    /**
     * ͨ����ǩ��ʽ���� �� idΪconent��ȡ����
     */
    private Process_Tag_Filter process_tag_filter;


    /**
     * ͨ������ʽ����
     */
    private String process_regex_filter;



    /**
     * �������������Ҫ������ �����ڴ������ݺ���
     */
    private List<Clean_Tag> process_clean;

    public Boolean getFlow() {
        return flow;
    }

    @XmlAttribute(name = "flow")
    public void setFlow(Boolean flow) {
        this.flow = flow;
    }

    public String getTable() {
        return table;
    }

    @XmlAttribute(name = "table")
    public void setTable(String table) {
        this.table = table;
    }

    public String getField() {
        return field;
    }

    @XmlAttribute(name = "field")
    public void setField(String field) {
        this.field = field;
    }


    public Process_Tag_Filter getProcess_tag_filter() {
        return process_tag_filter;
    }

    public void setProcess_tag_filter(Process_Tag_Filter process_tag_filter) {
        this.process_tag_filter = process_tag_filter;
    }


    public String getProcess_regex_filter() {
        return process_regex_filter;
    }

    public void setProcess_regex_filter(String process_regex_filter) {
        this.process_regex_filter = process_regex_filter;
    }

    public List<Clean_Tag> getProcess_clean() {
        return process_clean;
    }

    @XmlElementWrapper(name = "process_clean")
    @XmlElement(name = "clean_tag")
    public void setProcess_clean(List<Clean_Tag> process_clean) {
        this.process_clean = process_clean;
    }
}
