package htmlparser;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class WordParser {

	
	public static ArrayList<String> getWords() throws IOException {
		
		ArrayList<String> words = new ArrayList<String>();
	
		Document doc = Jsoup.connect("http://nskhuman.ru/unislov/suschestv.php") 								//подключаемся к сайту
              .userAgent("Chrome/4.0.249.0 Safari/532.5")
              .referrer("http://www.google.com")
              .get();
		Elements charMenu = doc.getElementsByAttributeValueMatching("href", ".+php.nlet1=.+"); 					//получаем список букв
		for(Element character: charMenu) {																		//перебираем все буквы
			Document charDoc = Jsoup.connect("http://nskhuman.ru/unislov/" + character.attr("href"))
		              .userAgent("Chrome/4.0.249.0 Safari/532.5")
		              .referrer("http://www.google.com")
		              .get();
			Elements bigAList = charDoc.select("a");															//получаем все ссылки на странице
			Elements smallAList = new Elements();
			for(Element el:bigAList) {
				if((el.attr("href").matches("suschestv.php.nlet\\d{1,2}=\\d{1,2}.*")) & 
						!(el.attr("href").matches("suschestv.php.nlet\\d{1,2}=\\d{1,2}"))) {
					smallAList.add(el);																			//выбираем ссылки на слова по первым буквам
				}
				if(el.attr("href").matches("slovar.php.nslovo.*")) words.add(el.text());						//добавляем слова с первой страницы буквы
			}
			if(smallAList.size() > 0) {
					for(Element el:smallAList) {																//перебираем ссылки на слова по первым буквам
						Document charMinDoc = Jsoup.connect("http://nskhuman.ru/unislov/" + el.attr("href"))
					              .userAgent("Chrome/4.0.249.0 Safari/532.5")
					              .referrer("http://www.google.com")
					              .get();
						Elements wordList = charMinDoc.select("a");
						for(Element word:wordList) {															//перебираем слова на каждой странице и добавляем в коллекцию
							if(word.attr("href").matches("slovar.php.nslovo.*")) words.add(word.text());
						}
					}
			}
			
			System.out.println(words.size());
		}
		words.add(null);
		return words;
	}
	    
	
}
