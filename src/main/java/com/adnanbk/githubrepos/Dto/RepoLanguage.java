package com.adnanbk.githubrepos.Dto;

import java.util.HashSet;
import java.util.Set;

public class RepoLanguage {


  private long numberOfRepos;
  private String name;
  private Set<GithubRepo> listOfRepos=new HashSet<>();

    public RepoLanguage(String name) {
        this.name = name;
    }

    public RepoLanguage(String name, long numberOfRepos, Set<GithubRepo> listOfRepos) {
        this.numberOfRepos = numberOfRepos;
        this.name = name;
        this.listOfRepos = listOfRepos;
    }

    public long getNumberOfRepos() {
        return numberOfRepos;
    }

    public void setNumberOfRepos(long numberOfRepos) {
        this.numberOfRepos = numberOfRepos;
    }

    public Set<GithubRepo> getListOfRepos() {
        return listOfRepos;
    }

    public void setListOfRepos(Set<GithubRepo> listOfRepos) {
        this.listOfRepos = listOfRepos;
    }

    public RepoLanguage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
