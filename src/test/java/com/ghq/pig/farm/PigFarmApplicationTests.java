package com.ghq.pig.farm;

import java.io.IOException;
import java.time.LocalDateTime;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ghq.pig.farm.disease.entity.DiseaseNews;
import com.ghq.pig.farm.disease.service.IDiseaseNewsService;

@SpringBootTest
class PigFarmApplicationTests {

	@Autowired
	private IDiseaseNewsService diseaseNewsService;

	@Test
	void contextLoads() throws IOException {
		for (int i = 1; i < 12; i++) {
			String url = "http://www.zhujia120.com/zhuyao/list_" + i + ".html";
			Document doc = Jsoup.connect(url).ignoreContentType(true).get();
			Elements elements = doc.select("div.listc dd");
			for (Element element : elements) {
				String title = element.select("a").text();
				String href = element.select("a").attr("href");
				String summary = element.select("span").text();
				Document document = Jsoup.connect(href).ignoreContentType(true).get();
				String content = document.select("div.content table").text();

				DiseaseNews diseaseNews = new DiseaseNews();
				diseaseNews.setContent(content);
				diseaseNews.setCreateTime(LocalDateTime.now());
				diseaseNews.setSource(href);
				diseaseNews.setTitle(title);
				diseaseNews.setSummary(summary);
				diseaseNewsService.save(diseaseNews);
			}
		}
	}

}
