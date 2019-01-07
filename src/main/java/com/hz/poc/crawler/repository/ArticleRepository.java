package com.hz.poc.crawler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hz.poc.crawler.model.Article;

/**
 * ArticleRepository implemnets JPA Crud
 * 
 * @author vadivel
 * @version 1.0
 * @since 07/01/2019
 *
 */
@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

	List<Article> findByAuthorName(String authorName);

	Article findByArticleTitle(String articleTitle);

	Article findByArticleDescription(String articleDescription);

}
