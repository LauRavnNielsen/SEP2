package clientServerConnection.client.view.loginView;

import clientServerConnection.client.viewmodel.LoginView.LogInViewModel;
import clientServerConnection.client.viewmodel.createAccountViewModel.CreateAccountViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class LogInView {

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField passwordTextField;

    private LogInViewModel logInViewModel;

    public void init(LogInViewModel _logInViewModel) {
        this.logInViewModel = _logInViewModel;
        logInViewModel.userNameProperty().bindBidirectional(userNameTextField.textProperty());
        logInViewModel.passwordProperty().bindBidirectional(passwordTextField.textProperty());

    }

    public void onLoginAction(ActionEvent actionEvent) {
        logInViewModel.logInAction();
    }

    public void onCreateAccountAction(ActionEvent actionEvent) {
        logInViewModel.openCreateAccountView();
    }

}
