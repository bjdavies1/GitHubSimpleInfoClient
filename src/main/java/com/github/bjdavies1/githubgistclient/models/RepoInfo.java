package com.github.bjdavies1.githubgistclient.models;

public class RepoInfo {

    private String html_url;

    public String getHtml_url() {
        return html_url;
    }

        @Override
        public String toString() {
            return "html: " + html_url;
        }


}

