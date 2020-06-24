package clientServerConnection.client.view;

import clientServerConnection.client.model.LogInModel;
import clientServerConnection.client.view.createAccountView.CreateAccountView;
import clientServerConnection.client.view.livefeedView.LiveFeedView;
import clientServerConnection.client.view.loginView.LogInView;
import clientServerConnection.client.view.myPageView.MyPageView;
import clientServerConnection.client.viewmodel.ViewModelProvider;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private ViewModelProvider viewModelProvider;
    private Stage mainStage;

    public ViewHandler(Stage stage, LogInModel model){
        viewModelProvider = new ViewModelProvider(model,this);
        mainStage = stage;
    }

    public void start(){
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("loginView/Login.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogInView view = loader.getController();
        view.init(viewModelProvider.getLogInViewModel());
        mainStage.setTitle("Log in");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void openCreateAccountView() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("createAccountView/createAccount.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CreateAccountView view = loader.getController();
        view.init(viewModelProvider.getCreateAccountViewModel());
        mainStage.setTitle("Create Account");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();

    }

    private Scene sceneLFV;
    public void openLiveFeedView() {
        System.out.println("print osmething");
        if(sceneLFV == null) {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("liveFeedView/liveFeed.fxml"));

            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            LiveFeedView view = loader.getController();
            view.init(viewModelProvider.getLiveFeedViewModel());
            sceneLFV = new Scene(root);
        }
        mainStage.setTitle("Live feed");
        mainStage.setScene(sceneLFV);
        mainStage.show();

    }

    public void openMyPageView() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("myPageView/myPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyPageView view = loader.getController();
        view.init(viewModelProvider.getMyPageViewModel());
        mainStage.setTitle("My Profile");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
