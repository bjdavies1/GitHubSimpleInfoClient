package com.github.bjdavies1.githubgistclient.controllers;

import com.github.bjdavies1.githubgistclient.models.GithubUser;
import com.github.bjdavies1.githubgistclient.models.RepoInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.github.bjdavies1.githubgistclient.caller.APICaller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainController /**implements Initializable**/ {

    @FXML
    private TextField userNameArea;
    @FXML
    private Label companyField;
    @FXML
    private Label publicRepositoriesField;
    @FXML
    private TextArea repoArea;
    @FXML
    private AnchorPane pane;

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
        if(user.getCompany() == null){
            companyField.setText("They have no company listed");
        } else {
            companyField.setText(user.getCompany());
        }
        publicRepositoriesField.setText(user.getPublic_repos().toString());
    }

    public void getPublicRepos(ActionEvent actionEvent) {
        userName = userNameArea.getText().toString();
        caller.setURI("users/" + userName + "/repos");
        try {
            var response = caller.doGet();
            var statusCode = response.statusCode();
            if(statusCode == 200){
                Gson gson = new GsonBuilder().create();
                RepoInfo[] repoArray = gson.fromJson(response.body(), RepoInfo[].class);
                List<RepoInfo> repoList = new ArrayList<>(Arrays.asList(repoArray));
                displayRepoInfo(repoList);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayRepoInfo(List repoList) {
        String repoString = (String) repoList.stream().
                map(e -> e.toString()).collect(Collectors.joining("\n"));
        repoArea.setText(repoString);
    }

//    private HttpClient client;
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        client = HttpClient.newHttpClient();
//    }

}