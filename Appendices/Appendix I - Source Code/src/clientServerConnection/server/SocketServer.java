package clientServerConnection.server;

import clientServerConnection.server.mediator.Account;
import clientServerConnection.server.mediator.AccountImpl;
import clientServerConnection.server.mediator.PostImpl;
import clientServerConnection.server.mediator.PostInter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private Account account;
    private PostInter postInter;

    public SocketServer(Account _account, PostInter _postInter) {
        account = _account;
        postInter = _postInter;

    }

    public void runServer() throws IOException {

        ServerSocket welcomeSocket = new ServerSocket(2910);

        System.out.println("Server started..");
        ConnectionPool connPool = new ConnectionPool();
        while(true) {
            Socket socket = welcomeSocket.accept();

            ServerSocketHandler ssh = new ServerSocketHandler(socket, account, connPool, postInter);

            System.out.println("Client connected");
            connPool.addConnection(ssh);

            Thread t = new Thread(ssh);
            t.start();
        }
    }

    public static void main(String[] args) {


         Account account = new AccountImpl();
         PostInter postInter = new PostImpl();


        SocketServer server = new SocketServer(account, postInter);
        try {
            server.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
