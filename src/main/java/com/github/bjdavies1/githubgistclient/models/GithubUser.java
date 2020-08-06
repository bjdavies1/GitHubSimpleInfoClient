package com.github.bjdavies1.githubgistclient.models;

public class GithubUser {
    private String company;
    private Integer public_repos;

    public String getCompany() {
        return company;
    }

    public Integer getPublic_repos() {
        return public_repos;
    }



    @Override
    public String toString() {
        return "GithubUser{\n" +
                "company='" + company + '\'' +
                ",\npublic_repos='" + public_repos +'\'' +
                '}';
    }
}
