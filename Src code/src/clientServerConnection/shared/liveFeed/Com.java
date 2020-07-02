package clientServerConnection.shared.liveFeed;

import java.io.Serializable;

public class Com implements Serializable {
    private String comment;

    public Com(String comment){
        this.comment = comment;
    }

    public String getComment(){
        return  comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
}
