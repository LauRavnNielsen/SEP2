package clientServerConnection.client.viewmodel.LoginView;

import clientServerConnection.client.model.LogInModel;
import clientServerConnection.client.view.ViewHandler;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class LogInViewModel {

    private StringProperty userName;
    private StringProperty password;

    private LogInModel model;
    private ViewHandler viewHandler;

    public LogInViewModel(LogInModel model, ViewHandler viewHandler){
        this.model = model;
        this.viewHandler = viewHandler;
        userName = new SimpleStringProperty();
        password = new SimpleStringProperty();

        model.addPropertyChangeListener("passwordCorrect", this::passwordCorrect);
        model.addPropertyChangeListener("wrongPassword", this::wrongPassword);

    }

    private void wrongPassword(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> password.setValue("WRONG PASSWORD"));
    }

    private void passwordCorrect(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> viewHandler.openLiveFeedView());
    }

    public void logInAction() {
        model.storeUsernameTemporarily(userName.getValue());
        model.verifyAccount(password.getValue(), userName.getValue());
    }

    public void openCreateAccountView() {
        viewHandler.openCreateAccountView();
    }
    public StringProperty userNameProperty(){
        return userName;
    }
    public StringProperty passwordProperty(){
        return  password;
    }
}
