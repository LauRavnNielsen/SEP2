package clientServerConnection.client.viewmodel.createAccountViewModel;

import clientServerConnection.client.model.LogInModel;
import clientServerConnection.client.view.ViewHandler;
import clientServerConnection.client.view.createAccountView.CreateAccountView;
import clientServerConnection.shared.userStuff.User;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreateAccountViewModel {

    private StringProperty userName;
    private StringProperty password;
    private StringProperty scndPassword;
    private StringProperty  email;
    private StringProperty lastName;
    private StringProperty firstName;
    private StringProperty dob;


    private LogInModel model;
    private ViewHandler viewHandler;


    public CreateAccountViewModel(LogInModel model, ViewHandler viewHandler){
        this.model = model;
        this.viewHandler = viewHandler;
        userName = new SimpleStringProperty();
        password = new SimpleStringProperty();
        scndPassword = new SimpleStringProperty();
        email = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
        firstName = new SimpleStringProperty();
        dob = new SimpleStringProperty();
    }

    public void saveAndAddNewUser() {
        User user = new User(userName.getValue(), password.getValue(),
                email.getValue(), firstName.getValue(), lastName.getValue(), dob.getValue());

        model.addAccount(user);
        userName.setValue("");
        password.setValue("");
        scndPassword.setValue("");
        email.setValue("");
        lastName.setValue("");
        firstName.setValue("");
        dob.setValue("");

    }

    public StringProperty userNameProperty(){
        return userName;
    }
    public StringProperty passwordProperty(){
        return password;
    }



    public boolean verifyIfPasswordsAreEqual() {
        if(password.getValue().equals(scndPassword.getValue())){
            return true;
        }else {
            return false;
        }


    }

    public StringProperty repeatPasswordProperty() {
        return scndPassword;
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

    public StringProperty dobProperty() {
        return dob;
    }

    public void goBack() {
        viewHandler.start();
    }
}
