package clientServerConnection.client;

import clientServerConnection.client.model.DataModelImpl;
import clientServerConnection.client.model.LogInModel;
import clientServerConnection.client.networking.Client;
import clientServerConnection.client.networking.SocketClient;
import clientServerConnection.client.view.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.text.View;

public class ForumApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        LogInModel model = new DataModelImpl();
        Client client = new SocketClient(model);
        ViewHandler vh = new ViewHandler(stage, model);
        vh.start();
    }

}
