package homework4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Headline {
	private static final DateFormat myDateFormat = new SimpleDateFormat("[yyyy.MM.dd]");
	private static final String PATH_HEADLINES_FILE = "headlines.txt";
	

	public static void main(String[] args) throws IOException {
		List<String> urlsFromWeb = getHeadlineUrlsFromTheWeb();
		List<String> urlsFromFile = getHeadlineUrlsFromFile();
		urlsFromWeb.removeAll(urlsFromFile);
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(new File(PATH_HEADLINES_FILE), true)));
		for (String url : urlsFromWeb) {
			System.out.println(url);
			String line = myDateFormat.format(new Date()) + " " + url;
			writer.println(line);
		}
		writer.close();
	}
	
	private static List<String> getHeadlineUrlsFromFile() throws IOException {
		List<String> urls = new ArrayList<String>();
		File file = new File(PATH_HEADLINES_FILE);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null) {
			String url = line.substring(line.indexOf("]") + 2, line.length());
			urls.add(url.trim());
		}
		return urls;
	}
	
	private static List<String> getHeadlineUrlsFromTheWeb() throws IOException {
		List<String> urls = new ArrayList<String>();
		Document document = Jsoup.connect("http://www.thehackernews.com").get();
		Elements headlines = document.select("a.entry-title");
		for (Element headline : headlines) urls.add(headline.attr("href").trim());
		return urls;
	}

}
