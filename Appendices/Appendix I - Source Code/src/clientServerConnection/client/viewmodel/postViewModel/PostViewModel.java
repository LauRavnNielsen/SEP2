//package clientServerConnection.client.viewmodel.postViewModel;
//
//import clientServerConnection.client.model.LogInModel;
//
//import clientServerConnection.client.viewmodel.Queue;
//
//import clientServerConnection.shared.liveFeed.Post;
//import javafx.application.Platform;
//
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
//import java.beans.PropertyChangeEvent;
//
//public class PostViewModel {
//    private StringProperty postArea;
//
//    private LogInModel model;
//
//
//    public PostViewModel(LogInModel model){
//        this.model = model;
//        postArea = new SimpleStringProperty();
//
//
//        model.addPropertyChangeListener("postHasBeenAdded", this::receivePost);
//    }
//
//    private void receivePost(PropertyChangeEvent evt) {
//        Platform.runLater(() -> postArea.setValue((String) evt.getNewValue()));
//
//    }
//    public StringProperty postProperty() {
//        return postArea;
//    }
//}
