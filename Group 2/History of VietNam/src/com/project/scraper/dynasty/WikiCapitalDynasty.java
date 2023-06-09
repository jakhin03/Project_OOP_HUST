package com.project.scraper.dynasty;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.project.scraper.AScraper;
import com.project.scraper.IScraper;


public class WikiCapitalDynasty extends AScraper implements IScraper {
	private String capital;
	private String tenTrieuDai;

	public WikiCapitalDynasty(String tenTrieuDai) {
		this.tenTrieuDai = tenTrieuDai;
		String url = "https://vi.wikipedia.org/wiki/Th%E1%BB%A7_%C4%91%C3%B4_Vi%E1%BB%87t_Nam";
		setUrl(url);
		connectToUrl();
	}
	
	public String getCapital() {
		return capital;
	}

	@Override
	public void scrape() {
		Elements capitals = this.getDoc()
				.select("#mw-content-text > div.mw-parser-output > table.wikitable > tbody > tr");
		if (this.tenTrieuDai.contains("Bắc thuộc") || this.tenTrieuDai.equals("Tự chủ")) {
			this.capital = "Không";
			System.out.println(this.tenTrieuDai + "-" + this.capital);
		} else if (this.tenTrieuDai.equals("Nhà Tiền Lê") || this.tenTrieuDai.equals("Nhà Lý")) {
			this.capital = "Hoa Lư";
			System.out.println(this.tenTrieuDai + "-" + this.capital);
		} else if (this.tenTrieuDai.equals("Nhà Trần")) {
			this.capital = "Thăng Long";
			System.out.println(this.tenTrieuDai + "-" + this.capital);
		} else if (this.tenTrieuDai.equals("Nhà Lê sơ") || this.tenTrieuDai.equals("Nhà Mạc")
				|| this.tenTrieuDai.equals("Nhà Lê trung hưng") || this.tenTrieuDai.equals("Chúa Trịnh")) {
			this.capital = "Đông Kinh";
			System.out.println(this.tenTrieuDai + "-" + this.capital);
		} else if (this.tenTrieuDai.equals("Quốc gia Việt Nam") || this.tenTrieuDai.equals("Việt Nam Cộng hòa")) {
			this.capital = "Sài Gòn";
			System.out.println(this.tenTrieuDai + "-" + this.capital);
		} else if (this.tenTrieuDai.equals("Thời tiền sử")) {
			this.capital = "Không";
			System.out.println(this.tenTrieuDai + "-" + this.capital);
		} else {
			for (Element e : capitals) {
				String name0 = e.select("td:nth-child(3)  a:nth-child(1)").text();
				String name1 = e.select("td:nth-child(3)  a:nth-child(2)").text();
				String name2 = e.select("td:nth-child(2)  a:nth-child(1)").text();
				String name3 = e.select("td:nth-child(2)  a:nth-child(2)").text();
				if (name0.toUpperCase().equals(this.tenTrieuDai.toUpperCase())) {

					this.capital = e.select("td:nth-child(1) a:nth-child(1)").text();
					System.out.println(name0 + "-" + this.capital);
					break;
				}
				if (name1.toUpperCase().equals(this.tenTrieuDai.toUpperCase())) {
					this.capital = e.select("td:nth-child(1) a:nth-child(1)").text();
					System.out.println(name1 + "-" + this.capital);
					break;
				}
				if (name2.toUpperCase().equals(this.tenTrieuDai.toUpperCase())) {

					this.capital = e.select("td:nth-child(1) a:nth-child(1)").text();
					System.out.println(name2 + "-" + this.capital);
					break;
				}
				if (name3.toUpperCase().equals(this.tenTrieuDai.toUpperCase())) {
					this.capital = e.select("td:nth-child(1) a:nth-child(1)").text();
					System.out.println(name3 + "-" + this.capital);
					break;
				}
			}
		}
	}
}