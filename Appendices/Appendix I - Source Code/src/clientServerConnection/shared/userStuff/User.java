package clientServerConnection.shared.userStuff;

import javafx.scene.image.Image;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String DOB;
    private Image image;

    public User(){

    }

//    public User(String name, String password) {
//        this.name = name;
//        this.password = password;
//        image = new Image("Image/Temp_Person_Icon.jpg");
//    }

    public User(String name, String password, String email, String firstName, String lastName, String DOB) {
        this.name = name;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.DOB = DOB;
//        image = new Image("Image/Temp_Person_Icon.jpg");

    }

    public String getName() {
        return name;
    }

    public void setImage(Image newPicture){
        this.image = newPicture;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Image getImage() {
        return image;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return DOB;
    }
}
