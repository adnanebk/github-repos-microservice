package com.adnanbk.githubrepos.Dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class RepoLanguage {


  private long numberOfRepos;
  private String name;
  private List<GithubRepo> listOfRepos=new ArrayList<>();

    public RepoLanguage() {
    }

    public RepoLanguage(String name, long numberOfRepos, List<GithubRepo> listOfRepos) {
        this.numberOfRepos = numberOfRepos;
        this.name = name;
        this.listOfRepos = listOfRepos;
    }




}
