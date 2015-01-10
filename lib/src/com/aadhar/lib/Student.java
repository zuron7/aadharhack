package com.aadhar.lib;

public class Student {

	public Student(String id,String name,String clas,String aadhaarId) {
		this.setAadhaarId(aadhaarId);
		this.setId(id);
		this.setName(name);
		this.setClas(clas);
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}

	private String id;
	private String name;
	private String clas;
	private String aadhaarId;
	
	public String toString() {
		return "DataObject [id=" + id + ", name=" + name + ", clas="
		+ clas + ", aadhaarId=" + aadhaarId +"]";
	}
	
	public String getAadhaarId() {
		return aadhaarId;
	}
	public void setAadhaarId(String aadhaarId) {
		this.aadhaarId = aadhaarId;
	}
	

}
