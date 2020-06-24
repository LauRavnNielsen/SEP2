package clientServerConnection.client.networking;

import clientServerConnection.shared.liveFeed.Post;
import clientServerConnection.shared.userStuff.User;

public interface Client {
    void addUserToServer(User user);
    void sendPostToServer(Post post);
    void addPostToClientModel(Post post);
    void verifyAccount(String password, String accountName);
    void passWordMatchesOpenLiveFeed();
    void wrongPasswordNotify();
    void needUserInfo(User userName);
    void displayUserInfo(User argument);
}
