package clientServerConnection.client.viewmodel.myPageViewModel;

import clientServerConnection.client.model.LogInModel;
import clientServerConnection.client.view.ViewHandler;
import clientServerConnection.shared.userStuff.User;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class MyPageViewModel {

    private StringProperty userName;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty email;
    private StringProperty DOB;

    private LogInModel model;
    private ViewHandler viewHandler;

    public MyPageViewModel(LogInModel _model, ViewHandler _viewHandler){
        model = _model;
        viewHandler = _viewHandler;
        userName = new SimpleStringProperty();
        firstName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
        email = new SimpleStringProperty();
        DOB = new SimpleStringProperty();


        model.addPropertyChangeListener("userFound", this::receiveUserInfo);

    }

    private void receiveUserInfo(PropertyChangeEvent propertyChangeEvent) {
        User user = (User)propertyChangeEvent.getNewValue();
        Platform.runLater(()-> userName.setValue(user.getName()));
        Platform.runLater(()-> firstName.setValue(user.getFirstName()));
        Platform.runLater(()-> lastName.setValue(user.getLastName()));
        Platform.runLater(()-> email.setValue(user.getEmail()));
        Platform.runLater(()-> DOB.setValue(user.getDob()));
    }



    public StringProperty userNameProperty() {
        return userName;
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void returnToLiveFeedView() {
        viewHandler.openLiveFeedView();
    }

    public StringProperty dobProperty() {
        return DOB;
    }
}
