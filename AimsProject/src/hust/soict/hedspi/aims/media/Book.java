package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens;
	private Map<String, Integer> wordFrequency = new HashMap<String, Integer>();
	
	
	public Book(String title) {
		super(title);
	}
	public Book(String title, String category) {
		super(title, category);
	}
	public Book(String title, String category, Float cost) {
		super(title, category);
		this.cost = cost;
	}
	public Book(String title, String category, List<String> authors) {
		super(title, category);
		this.authors = authors;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		processContent();
	}
	
	public void processContent() {
		this.contentTokens = Arrays.asList(this.content.split("[ .]+"));
		Collections.sort(this.contentTokens);
		for (String token : contentTokens) {
			String word = token.toLowerCase();
			if (wordFrequency.containsKey(word)) {
				int count = wordFrequency.get(word); 
			    wordFrequency.put(word, count + 1);
			} else {
			    wordFrequency.put(word, 1);
			}
		}
	}
	public void addAuthor(String authorName) {
		for (String str : authors) {
			if(str.equals(authorName)) return;
		}
		authors.add(authorName);
	}
	public void removeAuthor(String authorName) {
		for (String str : authors) {
			if(str.equals(authorName)) {
				authors.remove(authorName);
				break;
			}
		}
	}
	@Override
	public String toString() {
		TreeMap<String, Integer> newTreeMap = new TreeMap<String, Integer>();
		newTreeMap.putAll(this.wordFrequency);
		String str = "Book: " + this.getTitle() + "\nCategory: " + this.getCategory() + "\nCost: " + this.getCost() + "\nContent length: " + this.contentTokens.size() + "\nToken list:\n";
		for (Map.Entry<String, Integer> entry : newTreeMap.entrySet()) {
			str += " " + entry.getKey() + " : " + entry.getValue() + "\n";
		}
		return str;
	}
}
