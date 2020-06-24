package clientServerConnection.client.view.livefeedView;

import clientServerConnection.client.viewmodel.liveFeedModel.LiveFeedViewModel;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;


public class LiveFeedView {


    @FXML
    private JFXListView listView;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextArea writingPoetryArea;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Label userNameLabel;

    @FXML
    private TextArea textField;


    private LiveFeedViewModel liveFeedViewModel;



    public void init(LiveFeedViewModel liveFeedViewModel){
        this.liveFeedViewModel = liveFeedViewModel;
        liveFeedViewModel.writingPoetryProperty().bindBidirectional(writingPoetryArea.textProperty());
        userNameLabel.textProperty().bind(liveFeedViewModel.userNameProperty());
        liveFeedViewModel.textFieldProperty().bindBidirectional(textField.textProperty());
        scrollPane = new ScrollPane();

        textField.textProperty().addListener((observable, oldValue, newValue) -> createNewPostBox());
    }

    @FXML
    void onCommentAction(ActionEvent event) {

    }

    @FXML
    void onLikeAction(ActionEvent event) {

    }

    @FXML
    void onMyPageAction(ActionEvent event){
        liveFeedViewModel.openMyPageView();
    }

    @FXML
    void onPostAction(ActionEvent event) {
        liveFeedViewModel.storePostAndSendItToClient();
    }

    public void createNewPostBox(){
        try {

            textField = new TextArea();
            textField.setText(liveFeedViewModel.getTextAreaAsString());
            textField.setEditable(false);
            AnchorPane postBox = FXMLLoader.load(getClass().getResource
                    ("/clientServerConnection/client/view/livefeedView/post.fxml"));
            postBox.getChildren().set(2, textField);

            listView.getItems().add(0, postBox);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
