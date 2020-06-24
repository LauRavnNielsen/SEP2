package clientServerConnection.client.view.livefeedView;


import clientServerConnection.client.model.LogInModel;
import clientServerConnection.client.viewmodel.LoginView.LogInViewModel;
import clientServerConnection.client.viewmodel.liveFeedModel.LiveFeedViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PostView {

    @FXML
    private AnchorPane pane;

    @FXML
    private VBox postBox;

    @FXML
    private Label userNameLabel;

    @FXML
    private TextArea poetryTextArea;

    private LiveFeedViewModel model;

    public void init(LiveFeedViewModel model){
        this.model = model;
        model.poetryProperty().bindBidirectional(poetryTextArea.textProperty());

    }

    public void setPoetry(String txt){
        poetryTextArea.setText(txt);
    }

    @FXML
    void onCommentAction(ActionEvent event) {

    }

    @FXML
    void onLikeAction(ActionEvent event) {

    }
    @FXML
    void onRateAction(ActionEvent event){

    }
}
