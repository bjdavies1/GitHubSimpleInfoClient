package com.github.bjdavies1.githubgistclient.controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.net.http.HttpClient;

public class MainController implements Initializable {

    private HttpClient client;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        client = HttpClient.newHttpClient();
    }
}