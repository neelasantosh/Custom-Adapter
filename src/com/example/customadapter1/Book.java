package com.example.customadapter1;

import java.io.Serializable;

public class Book implements Serializable{

	String title;
	String author;
	float price;
	boolean selected;
	
	public Book(){}

	public Book(String title, String author, float price, boolean selected) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.selected = selected;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price="
				+ price + ", selected=" + selected + "]";
	}
	
}
