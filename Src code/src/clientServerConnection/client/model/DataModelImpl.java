package clientServerConnection.client.model;

import clientServerConnection.client.networking.Client;
import clientServerConnection.shared.liveFeed.Post;
import clientServerConnection.shared.userStuff.User;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class DataModelImpl implements LogInModel {

    private Client client;
    private String userName;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);


    public DataModelImpl(){
    }

    @Override
    public void verifyAccount(String password, String accountName) {
        client.verifyAccount(password, accountName);
    }

    @Override
    public void addAccount(User user) {
            client.addUserToServer(user);
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void sendPostToClient(Post post) {
        client.sendPostToServer(post);
    }

    @Override
    public void addPostToLiveFeed(Post post) {
       support.firePropertyChange("postHasBeenAdded", null, post);
    }

    @Override
    public void passwordIsCorrect(){
        support.firePropertyChange("passwordCorrect", false, true);

    }
    @Override
    public void passwordIsWrong(){
        support.firePropertyChange("passwordWrong", true, false);
    }

    @Override
    public void needUserInfo(User userName){
        client.needUserInfo(userName);
    }

    @Override
    public void receiveUserInfo(User user) {

        support.firePropertyChange("userNameFound", null, user.getName());
        support.firePropertyChange("firstNameFound", null, user.getFirstName());
        support.firePropertyChange("lastNameFound", null, user.getLastName());
        support.firePropertyChange("emailFound", null, user.getEmail());
        support.firePropertyChange("dobFound", null, user.getDob());
    }

    @Override
    public void setUserName(String value) {
       // client.setUserName(value);
    }

    @Override
    public void displayUserInfo(User argument) {
        support.firePropertyChange("userFound", null, argument);

    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void storeUsernameTemporarily(String txt) {
        userName = txt;
        support.firePropertyChange("userNameHasBeenStored", null, txt);
    }


}
