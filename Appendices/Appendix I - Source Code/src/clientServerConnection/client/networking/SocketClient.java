package clientServerConnection.client.networking;

import clientServerConnection.client.model.LogInModel;
import clientServerConnection.shared.liveFeed.Post;
import clientServerConnection.shared.Request;
import clientServerConnection.shared.userStuff.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class SocketClient implements Client {

    LogInModel model;
    ClientSocketHandler clientSocketHandler;


    public SocketClient(LogInModel _model) {
        model = _model;
        model.setClient(this);
        try {

            Socket socket = new Socket("localHost", 2910);

            clientSocketHandler = new ClientSocketHandler(
                    new ObjectOutputStream(socket.getOutputStream()),
                    new ObjectInputStream(socket.getInputStream()), this);
            Thread thread = new Thread(clientSocketHandler);
            thread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUserToServer(User user) {
        Request req = new Request(user, Request.TYPE.ADDUSER);
        clientSocketHandler.sendRequestToServer(req);
    }

    @Override
    public void sendPostToServer(Post post) {
        Request req = new Request(post, Request.TYPE.ADDPOST);
        clientSocketHandler.sendRequestToServer(req);
    }

    @Override
    public void addPostToClientModel(Post post) {
        model.addPostToLiveFeed(post);
    }

    @Override
    public void verifyAccount(String password, String accountName) {
        User user = new User();
        user.setName(accountName);
        user.setPassword(password);
        Request req = new Request(user, Request.TYPE.VERIFY);
        clientSocketHandler.sendRequestToServer(req);
    }

    @Override
    public void passWordMatchesOpenLiveFeed() {
        model.passwordIsCorrect();
    }

    @Override
    public void wrongPasswordNotify() {
        model.passwordIsWrong();
    }

    @Override
    public void needUserInfo(User userName) {
        Request req = new Request(userName, Request.TYPE.USERINFO);
        clientSocketHandler.sendRequestToServer(req);
    }

    @Override
    public void displayUserInfo(User argument) {
        model.displayUserInfo(argument);
    }


}
