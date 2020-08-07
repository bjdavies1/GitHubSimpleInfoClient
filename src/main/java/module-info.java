module GitHubSimpleInfoClient {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.net.http;
    requires com.google.gson;

    opens com.github.bjdavies1.githubsimpleinfo;
    opens com.github.bjdavies1.githubsimpleinfo.controllers;
}