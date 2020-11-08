package com.adnanbk.githubrepos.Dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubRepo{

	@JsonProperty("html_url")
	private String htmlUrl;

	private String language;

	private String name;

	public void setHtmlUrl(String htmlUrl){
		this.htmlUrl = htmlUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}


	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}