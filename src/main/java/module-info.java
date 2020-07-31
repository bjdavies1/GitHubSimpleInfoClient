module GitHubSimpleInfoClient {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens com.github.bjdavies1.githubgistclient;
    opens com.github.bjdavies1.githubgistclient.controllers;
}