package com.github.bjdavies1.githubgistclient.controllers;

import com.github.bjdavies1.githubgistclient.models.GithubUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.github.bjdavies1.githubgistclient.caller.APICaller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GitHubInfoController {

    APICaller caller = new APICaller();

    @FXML
    private TextField UserNameArea;
    @FXML
    private Label NameField;
    @FXML
    private Label PublicRepositoriesField;

    private String userName;

    public void getInfo(ActionEvent actionEvent) {
        userName = UserNameArea.getText().toString();
        caller.setURI("users/" + userName);
        try {
            var response = caller.doGet();
            var statusCode = response.statusCode();
            if(statusCode == 200){
                Gson gson = new GsonBuilder().create();
                var user = gson.fromJson(response.body(), GithubUser.class);
                displayUserInfo(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayUserInfo(GithubUser user){
        NameField.setText(user.getName());
        PublicRepositoriesField.setText(user.getPublic_repos().toString());
    }
}
