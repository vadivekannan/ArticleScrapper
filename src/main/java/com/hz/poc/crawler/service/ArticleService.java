package com.hz.poc.crawler.service;

import java.util.List;

import com.hz.poc.crawler.model.Article;

/**
 * ArticleService defines the structure of crud
 * 
 * @author vadivel
 * @version 1.0
 * @since 07/01/2019
 *
 */
public interface ArticleService {

	List<Article> listAll();

	Article getById(Long id);

	Article saveOrUpdate(Article article);

	void delete(Long id);

	void saveAll(List<Article> articles);

	List<Article> getByAuthorName(String authorName);

	Article getByArticleTitle(String articleTitle);

	Article getByArticleDescription(String articleDescription);

}
