package com.adnanbk.githubrepos.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class GithubRepoList {


    private Set<GithubRepo> items=new HashSet<>();

    public Set<GithubRepo> getItems() {
        return items;
    }

    public void setItems(Set<GithubRepo> items) {
        this.items = items;
    }

}
