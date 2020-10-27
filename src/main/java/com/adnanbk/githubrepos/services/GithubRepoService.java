package com.adnanbk.githubrepos.services;


import com.adnanbk.githubrepos.Dto.GithubRepo;
import com.adnanbk.githubrepos.Dto.GithubRepoList;
import com.adnanbk.githubrepos.Dto.RepoLanguage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class GithubRepoService {

    private final RestTemplate restTemplate;

    @Value("${github.api.search.repos}")
    private String githubSearchRepoApi;

    public GithubRepoService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }


    private GithubRepoList getGithubRepos(String url){
        GithubRepoList githubRepoList=new GithubRepoList();

        try {
            githubRepoList =restTemplate.getForObject(url,GithubRepoList.class);
    }catch(HttpClientErrorException ex){
        System.out.printf("ex"+ex.getMessage());
    }
        return githubRepoList;

    }

    @Async
    public CompletableFuture<Set<RepoLanguage>> getLanguagesOfTrendingRepos(){
        LocalDate localDate = LocalDate.now().minusDays(30);
        String url = String.format("%s?q=created:>%s&sort=stars&order=desc&per_page=100",
                                     githubSearchRepoApi,localDate);

        var trendingRepos = getGithubRepos(url).getItems();

        Set<RepoLanguage> repoLanguages =new HashSet<>();
        trendingRepos.stream().filter(repo -> Objects.nonNull(repo.getLanguage()))
                .collect(Collectors.groupingBy(GithubRepo::getLanguage))
                .forEach((language, githubRepos) ->
                 repoLanguages.add(new RepoLanguage(language, githubRepos.size(), githubRepos)));
        return  CompletableFuture.completedFuture(repoLanguages);

    }

}
