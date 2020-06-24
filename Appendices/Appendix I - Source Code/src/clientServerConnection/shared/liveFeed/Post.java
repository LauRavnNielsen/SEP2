package clientServerConnection.shared.liveFeed;

import java.io.Serializable;

public class Post implements Serializable {
    private String post;
    private String userName;
    private String genre;

    public Post(String post, String userName, String genre){
        this.post = post;
        this.userName = userName;
        this.genre = genre;
    }

    public String getPost() {
        return post;
    }

    public String getUserName() {
        return userName;
    }

    public String getGenre(){
        return genre;
    }
    public void setPoetry(String txt){
        post = txt;
    }




    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

}
