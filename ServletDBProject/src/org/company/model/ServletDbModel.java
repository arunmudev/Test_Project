package org.company.model;

public class ServletDbModel {

	private String title;
	private String author;
	private String price;

	/**
	 * Constructor
	 * @param title
	 */
	public ServletDbModel(String title,String author,String price) {
		this.title = title;
		this.author = author;
		this.price=price;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPrice() {
		return price;
	}	
}
