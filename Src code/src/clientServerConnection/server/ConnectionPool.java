package clientServerConnection.server;

import clientServerConnection.shared.Request;
import clientServerConnection.shared.liveFeed.Post;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ConnectionPool {
    private ArrayList<ServerSocketHandler> conns;

    public ConnectionPool(){
        conns = new ArrayList<>();
    }
    public void addConnection(ServerSocketHandler conn)
    {
        conns.add(conn);
    }
    public ArrayList<ServerSocketHandler> getConnections()
    {
        return conns;
    }
    public void broadCastPost(Post post)
    {
        System.out.println("Broadcast to " + getConnections().size() + " clients");
        for(ServerSocketHandler sc: getConnections())
        {
            ObjectOutputStream outToClient = sc.getOutputStream();
            try
            {
                Request req = new Request(post, Request.TYPE.ADDPOST);
                outToClient.writeObject(req);

            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

}
