package clientServerConnection.client.networking;

import clientServerConnection.shared.Request;
import clientServerConnection.shared.liveFeed.Post;
import clientServerConnection.shared.userStuff.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientSocketHandler implements Runnable {

    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private SocketClient client;

    public ClientSocketHandler(ObjectOutputStream outToServer, ObjectInputStream inFromServer, SocketClient _client){
        client = _client;
        outputStream = outToServer;
        inputStream = inFromServer;
    }

    @Override
    public void run() {
            try{
                while(true){
                    Request req = (Request)inputStream.readObject();
                    if(req.reqType == Request.TYPE.ADDPOST){
                        client.addPostToClientModel((Post)req.argument);
                    }
                    else if(req.reqType == Request.TYPE.ALLCLEAR){
                        client.passWordMatchesOpenLiveFeed();
                    }
                    else if(req.reqType == Request.TYPE.WRONGPASSWORD){
                        client.wrongPasswordNotify();
                    }
                    else if(req.reqType == Request.TYPE.USERINFO){
                        client.displayUserInfo((User)req.argument);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

    }

    public void sendRequestToServer(Request req){
        try{
            outputStream.writeObject(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public void receivePost(Post post) {
        try{
            inputStream.readObject(post);
        }catch(IOException e){
            e.printStackTrace();
        }
    }*/
}
