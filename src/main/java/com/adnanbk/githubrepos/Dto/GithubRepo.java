package com.adnanbk.githubrepos.Dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubRepo{

	@JsonProperty("private")
	private boolean isPrivate;

	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("html_url")
	private String htmlUrl;

	private String language;

	private String name;

	private String description;

	private int id;

	@JsonProperty("node_id")
	private String nodeId;

	public void setJsonMemberPrivate(boolean jsonMemberPrivate){
		this.isPrivate = jsonMemberPrivate;
	}

	public boolean isJsonMemberPrivate(){
		return isPrivate;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

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

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setNodeId(String nodeId){
		this.nodeId = nodeId;
	}

	public String getNodeId(){
		return nodeId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}