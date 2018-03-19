package com.submission.entity;

public class Magazine {
	int id;
	String name;
	String summary;
	String author;
	String state;
	String address;
	String subject;
	String submission_time;
	String review_time;
	String reject_time;
	String pubish_time;
	String editor;
	String expert;
	String editor_advise;
	String expert_advise;
	int periodical_id;
	
	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Magazine(int id, String name, String summary, String author, String state, String address, String subject,
			String submission_time, String review_time, String reject_time, String pubish_time, String editor,
			String expert, String editor_advise, String expert_advise, int periodical_id) {
		super();
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.author = author;
		this.state = state;
		this.address = address;
		this.subject = subject;
		this.submission_time = submission_time;
		this.review_time = review_time;
		this.reject_time = reject_time;
		this.pubish_time = pubish_time;
		this.editor = editor;
		this.expert = expert;
		this.editor_advise = editor_advise;
		this.expert_advise = expert_advise;
		this.periodical_id = periodical_id;
	}

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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubmission_time() {
		return submission_time;
	}

	public void setSubmission_time(String submission_time) {
		this.submission_time = submission_time;
	}

	public String getReview_time() {
		return review_time;
	}

	public void setReview_time(String review_time) {
		this.review_time = review_time;
	}

	public String getReject_time() {
		return reject_time;
	}

	public void setReject_time(String reject_time) {
		this.reject_time = reject_time;
	}

	public String getPubish_time() {
		return pubish_time;
	}

	public void setPubish_time(String pubish_time) {
		this.pubish_time = pubish_time;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getExpert() {
		return expert;
	}

	public void setExpert(String expert) {
		this.expert = expert;
	}

	public String getEditor_advise() {
		return editor_advise;
	}

	public void setEditor_advise(String editor_advise) {
		this.editor_advise = editor_advise;
	}

	public String getExpert_advise() {
		return expert_advise;
	}

	public void setExpert_advise(String expert_advise) {
		this.expert_advise = expert_advise;
	}

	public int getPeriodical_id() {
		return periodical_id;
	}

	public void setPeriodical_id(int periodical_id) {
		this.periodical_id = periodical_id;
	}

	@Override
	public String toString() {
		return "Magazine [id=" + id + ", name=" + name + ", summary=" + summary + ", author=" + author + ", state="
				+ state + ", address=" + address + ", subject=" + subject + ", submission_time=" + submission_time
				+ ", review_time=" + review_time + ", reject_time=" + reject_time + ", pubish_time=" + pubish_time
				+ ", editor=" + editor + ", expert=" + expert + ", editor_advise=" + editor_advise + ", expert_advise="
				+ expert_advise + ", periodical_id=" + periodical_id + "]";
	}

}
