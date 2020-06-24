package clientServerConnection.shared;

import java.io.Serializable;

public class Request implements Serializable {

    public enum TYPE {
    ADDUSER,
        ADDPOST,
        VERIFY,
        ALLCLEAR,
        WRONGPASSWORD,
        USERINFO
        ;


    }



    public Object argument;
    public TYPE reqType;

    public Request(Object argument, TYPE adduser) {
        this.argument = argument;
        reqType = adduser;

    }
}