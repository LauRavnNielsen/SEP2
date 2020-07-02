package clientServerConnection.client.model;

import clientServerConnection.client.networking.Client;
import clientServerConnection.shared.liveFeed.Post;
import clientServerConnection.shared.userStuff.User;

import java.beans.PropertyChangeListener;

public interface LogInModel {
    void addAccount(User user);

    void setClient(Client client);
    void addPropertyChangeListener(String eventName, PropertyChangeListener listener);


    void sendPostToClient(Post post);
    void addPostToLiveFeed(Post post);
    void passwordIsCorrect();
    void passwordIsWrong();
    void needUserInfo(User user);

    void verifyAccount(String password, String accountName);
    void receiveUserInfo(User user);
    void setUserName(String value);
    void displayUserInfo(User argument);
    String getUserName();
    void storeUsernameTemporarily(String txt);



}
