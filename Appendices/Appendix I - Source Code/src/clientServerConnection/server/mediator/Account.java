package clientServerConnection.server.mediator;

import clientServerConnection.shared.userStuff.User;

public interface Account {



    User getAccount(String userName, String password, String emailAddress, String firstName, String lastName, String dob);
    boolean createAccount(User user);
    User getAccount(User argument);
    User getAccountByPasswordAndName(String password, String userName);
    User getAccountByUserName(String userName);
}