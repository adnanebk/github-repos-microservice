package com.adnanbk.githubrepos.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class GithubRepoList {


    private Set<GithubRepo> items=new HashSet<>();

    @JsonProperty("total_count")
    private long totalCount;


    public Set<GithubRepo> getItems() {
        return items;
    }

    public void setItems(Set<GithubRepo> items) {
        this.items = items;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
