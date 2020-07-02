package clientServerConnection.client.viewmodel.liveFeedModel;


import clientServerConnection.client.model.LogInModel;
import clientServerConnection.client.view.ViewHandler;
import clientServerConnection.shared.liveFeed.Post;
import clientServerConnection.shared.userStuff.User;
import javafx.application.Platform;
import javafx.beans.property.*;



import java.beans.PropertyChangeEvent;

public class LiveFeedViewModel {

    private LogInModel model;
    private ViewHandler viewHandler;
    private StringProperty textArea;

    private StringProperty writingPoetryArea;
    private StringProperty poetryArea;
    private StringProperty userName;
    private StringProperty genre;




    public LiveFeedViewModel(LogInModel model, ViewHandler viewHandler){
        this.model = model;
        this.viewHandler = viewHandler;
        writingPoetryArea = new SimpleStringProperty();
        poetryArea = new SimpleStringProperty();
        userName = new SimpleStringProperty();
        genre = new SimpleStringProperty();
        textArea = new SimpleStringProperty();


        model.addPropertyChangeListener("postHasBeenAdded", this::receivePost);
        model.addPropertyChangeListener("userNameHasBeenStored", this::setUserName);



    }

    private void setUserName(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(()-> userName.setValue((String)propertyChangeEvent.getNewValue()));
    }

    private void receivePost(PropertyChangeEvent evt) {
        System.out.println("And now i am here");
        Post post = (Post)evt.getNewValue();
        Platform.runLater(() -> textArea.setValue(post.getPost()));
    }

    public StringProperty writingPoetryProperty() {
        return writingPoetryArea;
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void storePostAndSendItToClient() {
        Post post = new Post(writingPoetryArea.getValue(), userName.getValue(), genre.getValue());
        writingPoetryArea.setValue("");
        model.sendPostToClient(post);
    }

    public StringProperty poetryProperty() {
        return poetryArea;
    }

    public void openMyPageView() {
        User user = new User();
        user.setName(userName.getValue());
        model.needUserInfo(user);
        viewHandler.openMyPageView();
    }

    public StringProperty textFieldProperty() {
        return textArea;
    }

    public String getTextAreaAsString(){
        return textArea.getValue();
    }

}
