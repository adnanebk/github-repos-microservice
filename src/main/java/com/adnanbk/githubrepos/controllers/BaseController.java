package com.adnanbk.githubrepos.controllers;

import com.adnanbk.githubrepos.RootApi;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class BaseController {


    @GetMapping(value ="/api", produces = { "application/hal+json" })
    public ResponseEntity<RootApi> getBaseApi(){
        Link languagesOfTrendingRepos = linkTo(methodOn(GithubRepoController.class).getLanguagesOfTrendingRepos())
                .withRel("LanguagesOfTrendingRepos");
        RootApi rootApi =new RootApi();
        rootApi.add(languagesOfTrendingRepos);
        return ResponseEntity.ok(rootApi);
    }
    @GetMapping
    public void redirectToBaseApi(HttpServletResponse response) throws IOException {
        response.sendRedirect("/api");
    }
}
