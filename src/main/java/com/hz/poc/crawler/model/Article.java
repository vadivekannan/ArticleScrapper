package com.hz.poc.crawler.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Article Model class to persist the crawled data
 * 
 * @author vadivel
 * @version 1.0
 * @since 07/01/2019
 *
 */

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String authorName;
	@Column
	private String articleTitle;
	@Column
	private String articleDescription;
	@Column
	private String publishDate;
	@Column
	private String content;
	@Column
	private String articleSection;
	@Column
	private String articleUrl;

	@Column
	private Date createdOn;
	@Column
	private Date createdBy;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getArticleSection() {
		return articleSection;
	}

	public void setArticleSection(String articleSection) {
		this.articleSection = articleSection;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", authorName=" + authorName + ", articleTitle=" + articleTitle
				+ ", articleDescription=" + articleDescription + ", publishDate=" + publishDate + ", content=" + content
				+ ", articleSection=" + articleSection + ", articleUrl=" + articleUrl + "]";
	}

}
