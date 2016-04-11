package com.lgh.lixiang.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * ��Ŀ���ڵ� ���������Ŀ
 */
@XmlRootElement(name = "projectroot")
public class ProjectRoot {

	private List<Project> projects;


	public List<Project> getProjects() {
		return projects;
	}

	@XmlElementWrapper(name = "projects")
	@XmlElement(name = "project")
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
