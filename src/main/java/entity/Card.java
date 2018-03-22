package entity;

import java.io.Serializable;

public class Card  implements Serializable{
	private int id;
	private String name;
	private String sex;
	private int age;
	private String dept;
    private String job;
    private String from;
    private String to;
    private String jobId;
    private String idNo;
    private String cardId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", dept=" + dept + ", job=" + job
				+ ", from=" + from + ", to=" + to + ", jobId=" + jobId + ", idNo=" + idNo + ", cardId=" + cardId + "]";
	}
	
}
