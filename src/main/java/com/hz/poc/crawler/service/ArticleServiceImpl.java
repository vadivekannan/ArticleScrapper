package com.hz.poc.crawler.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hz.poc.crawler.model.Article;
import com.hz.poc.crawler.repository.ArticleRepository;

/**
 * ArticleServiceImpl class to hold the service implementations
 * 
 * @author vadivel
 * @version 1.0
 * @since 08/01/2019
 *
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public List<Article> listAll() {
		List<Article> articles = new ArrayList<Article>();
		try {
			articleRepository.findAll().forEach(articles::add);
		} catch (NullPointerException npe) {
			logger.error(npe.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}

	@Override
	public Article getById(Long id) {
		return articleRepository.findById(id).orElse(null);
	}

	@Override
	public Article saveOrUpdate(Article article) {
		articleRepository.save(article);
		return article;
	}

	@Override
	public void delete(Long id) {
		articleRepository.deleteById(id);
	}

	@Override
	public void saveAll(List<Article> articles) {
		articleRepository.saveAll(articles);
	}

	@Override
	public List<Article> getByAuthorName(String authorName) {
		return articleRepository.findByAuthorName(authorName);
	}

	@Override
	public Article getByArticleTitle(String articleTitle) {
		return articleRepository.findByArticleTitle(articleTitle);
	}

	@Override
	public Article getByArticleDescription(String articleDescription) {
		return articleRepository.findByArticleDescription(articleDescription);
	}

}
