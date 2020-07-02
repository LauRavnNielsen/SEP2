package clientServerConnection.server;

import clientServerConnection.server.mediator.Account;
import clientServerConnection.server.mediator.PostInter;
import clientServerConnection.shared.Request;
import clientServerConnection.shared.liveFeed.Post;
import clientServerConnection.shared.userStuff.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {

    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private ConnectionPool connectionPool;
    private Socket socket;
    private Account account;
    private PostInter post;

    public ServerSocketHandler(Socket socket, Account account, ConnectionPool cp, PostInter post){
        this.post = post;
        connectionPool = cp;
        this.socket = socket;
        this.account = account;
        post = null;
        try{
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                inputStream = new ObjectInputStream(socket.getInputStream());
        }catch(IOException e){
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        try{
            while(true){
                Request req = (Request)inputStream.readObject();
                if(req.reqType == Request.TYPE.ADDUSER){
                    account.createAccount((User)req.argument);
                }else if(req.reqType == Request.TYPE.USERINFO){
                    User userName = (User)req.argument;
                    User temp2 = account.getAccount(userName);
                    if(userName.getName().equals(temp2.getName())){
                        sendUserInfo((User)temp2);
                    }
                }/*else if (req.type == Request.TYPE.REMOVE){
                    model.removeUser(req.user);
                }*/else if(req.reqType == Request.TYPE.ADDPOST){
                    post.createPost((Post)req.argument);
                    System.out.println("Creating post in database");
                    connectionPool.broadCastPost((Post)req.argument);
                    System.out.println("BroadCasting post");

                }else if(req.reqType == Request.TYPE.VERIFY){
                    User temp = (User)req.argument;
                    User temp2 = account.getAccountByPasswordAndName(temp.getPassword(), temp.getName());
                        if(temp2.getPassword().equals(temp.getPassword())){
                            System.out.println("Password is CORRECT!");
                            allClear((User)req.argument);
                        }
                        else{
                            System.out.println("Password is WRONG!");
                            wrongPassword((User)req.argument);
                        }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void allClear(User user){
        Request req = new Request(user, Request.TYPE.ALLCLEAR);
        try {
            outputStream.writeObject(req);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendUserInfo(User user){
        Request req = new Request(user, Request.TYPE.USERINFO);
        try{
            outputStream.writeObject(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void wrongPassword(User user){
        Request req = new Request(user, Request.TYPE.WRONGPASSWORD);
        try{
            outputStream.writeObject(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ObjectOutputStream getOutputStream()
    {
        return outputStream;
    }

}
