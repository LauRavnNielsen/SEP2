package clientServerConnection.client.view.createAccountView;

import clientServerConnection.client.viewmodel.createAccountViewModel.CreateAccountViewModel;
import clientServerConnection.shared.userStuff.User;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import javax.imageio.ImageIO;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class CreateAccountView {

    @FXML
    private TextField userNameTextField, passwordTextField;

    @FXML
    private TextField repeatPasswordTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private ImageView photo1;

    @FXML
    private ImageView greenCheckPhoto;

    @FXML
    private ImageView redCheckPhoto;

    @FXML
    private TextField DOB;


    private Image greenImg;
    private Image redImg;
    private Image defaultProfileImg;


    private User selectedUser;

    private FileChooser fileChooser;
    private File filePath;


    private CreateAccountViewModel createAccountViewModel;

    public void init(CreateAccountViewModel createAccountViewModel) {
        this.createAccountViewModel = createAccountViewModel;
        createAccountViewModel.userNameProperty().bindBidirectional(userNameTextField.textProperty());
        createAccountViewModel.passwordProperty().bindBidirectional(passwordTextField.textProperty());
        createAccountViewModel.repeatPasswordProperty().bindBidirectional(repeatPasswordTextField.textProperty());
        createAccountViewModel.firstNameProperty().bindBidirectional(firstNameTextField.textProperty());
        createAccountViewModel.lastNameProperty().bindBidirectional(lastNameTextField.textProperty());
        createAccountViewModel.emailProperty().bindBidirectional(emailTextField.textProperty());
        createAccountViewModel.dobProperty().bindBidirectional(DOB.textProperty());
        selectedUser = new User();

        try {
            greenImg = new Image(new FileInputStream("Images/green_check.png"));
            redImg = new Image(new FileInputStream("Images/red_error.png"));
            defaultProfileImg = new Image(new FileInputStream("Images/Temp_Person_Icon.jpg"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        photo1.setImage(defaultProfileImg);
        greenCheckPhoto.setImage(greenImg);
        redCheckPhoto.setImage(redImg);



    }

    public void onSaveAction(ActionEvent actionEvent) {
        createAccountViewModel.saveAndAddNewUser();
    }

    @FXML
    void onVerifyAction(ActionEvent event) {
        createAccountViewModel.verifyIfPasswordsAreEqual();
        if(createAccountViewModel.verifyIfPasswordsAreEqual() == true){
            greenCheckPhoto.setVisible(true);
            redCheckPhoto.setVisible(false);
        }else
        {
            greenCheckPhoto.setVisible(false);
            redCheckPhoto.setVisible(true);
        }
    }
    @FXML
    void onBackAction(ActionEvent evt){
        createAccountViewModel.goBack();
    }

    /**
     * This method will allow the user to change the image on screen
     */
    public void onChooseImageAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open image");
        //Set to user's directory or go to the default C drive if cannot access
        String userDirectoryString = System.getProperty("user.home") + "\\Pictures";
        File userDirectory = new File(userDirectoryString);

        if (!userDirectory.canRead()) {
            userDirectory = new File("c:/");
        }

        fileChooser.setInitialDirectory(userDirectory);
        this.filePath = fileChooser.showOpenDialog(stage);

        //Try to update the image by loading new image
        try {
            BufferedImage bufferedImage = ImageIO.read(filePath);
            Image image = (Image) SwingFXUtils.toFXImage(bufferedImage, null);
            selectedUser.setImage(image);
            photo1.setImage(selectedUser.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
