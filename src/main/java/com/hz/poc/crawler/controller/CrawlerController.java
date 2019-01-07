package com.hz.poc.crawler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hz.poc.crawler.model.Article;
import com.hz.poc.crawler.service.ArticleService;

/**
 * CrawlerController for CRUD
 * 
 * @author vadivel
 * @version 1.0
 * @since 07/01/2019
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CrawlerController {

	@Autowired
	private ArticleService articleService;

	@PostMapping("/addArticle")
	public void addArticle(Article article) {
		if (null != article)
			articleService.saveOrUpdate(article);
	}

	@GetMapping("/articleByAuthorName/{authorName}")
	public List<Article> getArticleByAuthorName(@PathVariable String authorName) throws Exception {
		List<Article> articles = articleService.getByAuthorName(authorName);
		if (articles.isEmpty())
			throw new Exception();
		return articles;
	}

	@GetMapping("/articleByArticleTitle/{articleTitle}")
	public Article getArticleByArticleTitle(@PathVariable String articleTitle) throws Exception {
		Article article = articleService.getByArticleTitle(articleTitle);
		if (article != null)
			throw new Exception();
		return article;
	}

	@GetMapping("/articleByAuthorName/{articleDescription}")
	public Article getArticleByArticleDescription(@PathVariable String articleDescription) throws Exception {
		Article article = articleService.getByArticleDescription(articleDescription);
		if (article != null)
			throw new Exception();
		return article;
	}
}