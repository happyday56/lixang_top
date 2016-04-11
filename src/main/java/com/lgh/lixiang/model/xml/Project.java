package com.lgh.lixiang.model.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * ����ץȡ����վ��Ŀ
 */
public class Project {

    /**
     * �Ƿ����� false������ ��ʱ���������
     */
    private boolean enabled;

    /**
     * �������� ��Ҫ�� �������ݿ�ʱʹ��
     */
    private Long category;
    /**
     * ��Ŀ����
     */
    private String name;
    /**
     * ��Ŀ��Ŀ�궨��
     */
    private Target target;

    /**
     * ��Ŀ�Ĵ���ʽ����
     */
    private List<Process> processes;


    public boolean getEnabled() {
        return enabled;
    }

    @XmlAttribute(name = "enabled")
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getCategory() {
        return category;
    }

    @XmlAttribute(name = "category")
    public void setCategory(Long category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    @XmlElementWrapper(name = "processes")
    @XmlElement(name = "process")
    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }


}
