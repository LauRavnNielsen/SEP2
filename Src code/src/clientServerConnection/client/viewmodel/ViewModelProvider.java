package clientServerConnection.client.viewmodel;


import clientServerConnection.client.model.LogInModel;
import clientServerConnection.client.view.ViewHandler;
import clientServerConnection.client.viewmodel.LoginView.LogInViewModel;
import clientServerConnection.client.viewmodel.createAccountViewModel.CreateAccountViewModel;
import clientServerConnection.client.viewmodel.liveFeedModel.LiveFeedViewModel;
import clientServerConnection.client.viewmodel.myPageViewModel.MyPageViewModel;
import clientServerConnection.shared.userStuff.User;

public class ViewModelProvider {

    private LiveFeedViewModel liveFeedViewModel;
    private LogInViewModel logInViewModel;
    private CreateAccountViewModel createAccountViewModel;
    private MyPageViewModel myPageViewModel;


    public ViewModelProvider(LogInModel model, ViewHandler vh){
            logInViewModel = new LogInViewModel(model, vh);
            createAccountViewModel = new CreateAccountViewModel(model, vh);
            liveFeedViewModel = new LiveFeedViewModel(model, vh);
            myPageViewModel = new MyPageViewModel(model, vh);
    }
    public LogInViewModel getLogInViewModel(){
        return logInViewModel;
    }
    public CreateAccountViewModel getCreateAccountViewModel(){
        return createAccountViewModel;
    }
    public LiveFeedViewModel getLiveFeedViewModel(){
        return liveFeedViewModel;
    }

    public MyPageViewModel getMyPageViewModel() {
        return myPageViewModel;
    }
}
