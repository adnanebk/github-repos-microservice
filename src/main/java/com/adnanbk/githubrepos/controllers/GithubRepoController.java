package com.adnanbk.githubrepos.controllers;


import com.adnanbk.githubrepos.Dto.RepoLanguage;
import com.adnanbk.githubrepos.services.GithubRepoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/")
public class GithubRepoController {

    private final GithubRepoService githubRepoService;


    public GithubRepoController(GithubRepoService githubRepoService) {
        this.githubRepoService = githubRepoService;
    }




   @GetMapping("/github/repositories/languages")
    public CompletableFuture<ResponseEntity<Set<RepoLanguage>>> getLanguagesOfTrendingRepos(){
        return  githubRepoService.getLanguagesOfTrendingRepos().thenApplyAsync(e->ResponseEntity.ok().body(e));
    }


}
