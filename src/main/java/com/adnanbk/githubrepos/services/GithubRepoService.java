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
        var languagesNames = trendingRepos.stream().
                                           map(GithubRepo::getLanguage).distinct().
                                           filter(Objects::nonNull);

        Set<RepoLanguage> repoLanguages =new HashSet<>();
        languagesNames.forEach(lang->{

           var languageRepos = trendingRepos.stream().filter(
                   repo-> repo.getLanguage() !=null && repo.getLanguage().equals(lang)).collect(Collectors.toSet());
            RepoLanguage repoLanguage =  new RepoLanguage(lang,languageRepos.size(),languageRepos);
            repoLanguages.add(repoLanguage);
        });
        return  CompletableFuture.completedFuture(repoLanguages);

    }

}
