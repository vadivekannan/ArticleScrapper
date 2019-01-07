package com.hz.poc.crawler.engine;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hz.poc.crawler.controller.CrawlerController;
import com.hz.poc.crawler.model.Article;

/**
 * CrawlerEngine class acts a core area to extract the html pages with links
 * 
 * @author vadivel
 * @version 1.0
 * @since 07/01/2019
 *
 */

@Service
public class CrawlerEngine extends Thread {
	private static final Logger logger = LoggerFactory.getLogger(CrawlerEngine.class);

	// CrawlerData Instance
	CrawlerData cd;

	// Number of connections to be established
	private final int limit = 10000;

	// URL
	public CrawlerEngine(CrawlerData crawlerData) {
		cd = crawlerData;
	}

	private Article article = new Article();

	public void run() {

		// Indexed URLS Counter
		int counter = 0;

		while ((cd.urlQueueSize() > 0) && counter < limit) {

			String activeURL = cd.getURL();
			try {
				// Fetch and parse HTML document
				Document document = Jsoup.connect(activeURL).userAgent(
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.124 Safari/537.36")
						.referrer("http://www.google.com").timeout(12000).followRedirects(true).get();
				if (activeURL.endsWith(".ece"))
					addArticles(document, activeURL);
				counter++;
				Elements links = document.select("a[href]"); // Relative URL
				// Add newly found links
				addLinksToQueue(links);
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("Error Data : " + activeURL);
			}

		}
	}

	public void addLinksToQueue(Elements links) {
		for (Element element : links) {

			String page = element.attr("abs:href");
			// Add the end hindu page url with ece extension
			if (page.startsWith("https") && !cd.existingLink(page) && page.endsWith(".ece")) {
				cd.addURL(page);
				logger.info(page);
				cd.addArchivedURL(page);
			}
		}
	}

	public void addArticles(Document doc, String link) {
		CrawlerController crawler = new CrawlerController();
		Elements metaTags = doc.getElementsByTag("meta");
		for (Element metaTag : metaTags) {
			if (metaTag.attr("name").equalsIgnoreCase("descritption"))
				article.setArticleDescription(metaTag.attr("content"));
			if (metaTag.attr("name").equalsIgnoreCase("publish-date"))
				article.setPublishDate(metaTag.attr("content"));
			if (metaTag.attr("name").equalsIgnoreCase("twitter:creator"))
				article.setAuthorName(metaTag.attr("content"));
			if (metaTag.attr("property").equalsIgnoreCase("article:section"))
				article.setArticleSection(metaTag.attr("content"));

		}
		article.setArticleTitle(doc.title());
		article.setArticleUrl(link); // article.setContent(content);
		// if(articleService != null)
		try {
			crawler.addArticle(article);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
