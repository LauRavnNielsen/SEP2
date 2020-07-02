package clientServerConnection.client.view.myPageView;

import clientServerConnection.client.viewmodel.myPageViewModel.MyPageViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class MyPageView {
    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField dobTextField;

    private MyPageViewModel model;

    public void init(MyPageViewModel _model){
        model = _model;
        model.userNameProperty().bindBidirectional(userNameTextField.textProperty());
        model.firstNameProperty().bindBidirectional(firstNameTextField.textProperty());
        model.lastNameProperty().bindBidirectional(lastNameTextField.textProperty());
        model.emailProperty().bindBidirectional(emailTextField.textProperty());
        model.dobProperty().bindBidirectional(dobTextField.textProperty());
    }



    @FXML
    void onChangeAction(ActionEvent event) {

    }

    @FXML
    void onBackAction(ActionEvent evt){
        model.returnToLiveFeedView();

    }
}
