package com.github.bjdavies1.githubgistclient.models;

public class GithubUser {
    private String name;
    private Integer public_repos;

    public String getName() {
        return name;
    }

    public Integer getPublic_repos() {
        return public_repos;
    }



    @Override
    public String toString() {
        return "GithubUser{\n" +
                "name='" + name + '\'' +
                ",\npublic_repos='" + public_repos +'\'' +
                '}';
    }
}
