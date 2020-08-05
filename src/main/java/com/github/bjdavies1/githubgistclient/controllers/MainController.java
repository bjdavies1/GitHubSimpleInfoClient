package com.github.bjdavies1.githubgistclient.controllers;

import com.github.bjdavies1.githubgistclient.models.GithubUser;
import com.github.bjdavies1.githubgistclient.models.RepoInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.github.bjdavies1.githubgistclient.caller.APICaller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainController /**implements Initializable**/ {

    @FXML
    private TextField userNameArea;
    @FXML
    private Label NameField;
    @FXML
    private Label PublicRepositoriesField;

    private String userName;
    APICaller caller = new APICaller();

    public void getUserInfo(ActionEvent actionEvent) {
//        System.out.println(userNameArea.getText());
        userName = userNameArea.getText().toString();
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

    public void getPublicRepos(ActionEvent actionEvent) {
        userName = userNameArea.getText().toString();
        caller.setURI("users/" + userName + "/repos");
        try {
            var response = caller.doGet();
            var statusCode = response.statusCode();
            if(statusCode == 200){
                Gson gson = new GsonBuilder().create();
                var repo = gson.fromJson(response.body(), RepoInfo.class);
                displayRepoInfo(repo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayRepoInfo(RepoInfo repo) {

    }

//    private HttpClient client;
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        client = HttpClient.newHttpClient();
//    }

}