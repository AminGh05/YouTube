package org.project.youtube.Client.Controller;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import org.project.youtube.Client.Model.History;
import org.project.youtube.Client.Model.Network.Request;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

import static org.project.youtube.Client.Model.Network.Request.getChannel;

public class ShortPlayerController {
    @FXML
    private Button playBtn;

    @FXML
    private Button muteBtn;

    @FXML
    private Button subscribeBtn;

    @FXML
    private HBox muteBtnHBox;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Label handleLbl;

    @FXML
    private Label titleLbl;

    @FXML
    private Circle profileImage;

    @FXML
    private Slider shortSlider;

    @FXML
    private MediaView mediaView;


    private MediaPlayer mediaPlayer;
    private Media media;
    private Pane pane;
    private double lastVolume;
    private Slider volumeSlider;
    private String handle;
    private String path;
    private UUID shortID;

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public void setPath(String path, UUID shortID) {
        this.path = path;
        this.shortID = shortID;
        media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setStartTime(Duration.seconds(History.getHistory(shortID)));
    }

    public void initBindings() {
        mediaView.fitWidthProperty().bind(pane.widthProperty());
        mediaView.fitHeightProperty().bind(pane.heightProperty());

        borderPane.prefWidthProperty().bind(mediaView.fitWidthProperty());
        borderPane.prefHeightProperty().bind(mediaView.fitHeightProperty());

        mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> shortSlider.setValue(newValue.toSeconds()));

        lastVolume = 1.0;
    }

    public void setHandle(String handle) {
        handleLbl.setText("@" + handle);
        this.handle = handle;
    }
    public void setTitle(String text) {
        titleLbl.setText(text);
    }

    public void disableSubscribeBtn() {
        subscribeBtn.setText("Subscribed");
        subscribeBtn.setDisable(true);
    }

    public void setProfileImage(String handle) throws IOException {
        try {
            Image logo = new Image(new ByteArrayInputStream(getChannel(handle).getLogo()));
            profileImage.setFill(new ImagePattern(logo));
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
            profileImage.setFill(new ImagePattern(new Image("/org/project/youtube/Client/images/sample-profile.png")));
        }
    }

    private void playClickEffect(Button button) {
        // animation class
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(100));
        scaleTransition.setNode(button);

        // set scales
        scaleTransition.setByX(0.1);
        scaleTransition.setByY(0.1);
        scaleTransition.setAutoReverse(true);

        scaleTransition.setCycleCount(2);
        scaleTransition.play();
    }

    public void playBtnAction() {
        playClickEffect(playBtn);

        if (media == null || mediaPlayer == null) {
            setPath(path, shortID);
            initBindings();
        }

        if (!mediaPlayer.getStatus().equals(MediaPlayer.Status.READY) && !mediaPlayer.getStatus().equals(MediaPlayer.Status.STOPPED) && !mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
            setPath(path, shortID);
            initBindings();
        }

        if (mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
            playBtn.setStyle("-fx-shape : \"M 12,26 18.5,22 18.5,14 12,10 z M 18.5,22 25,18 25,18 18.5,14 z\"");
            mediaPlayer.pause();
        }
        else {
            playBtn.setStyle("-fx-shape : \"M 12,26 16,26 16,10 12,10 z M 21,26 25,26 25,10 21,10 z\"");
            mediaPlayer.play();
        }
    }

    public void playBtnMouseClicked() {
        playClickEffect(playBtn);

        if (media == null || mediaPlayer == null) {
            setPath(path, shortID);
            initBindings();
        }

        if (!mediaPlayer.getStatus().equals(MediaPlayer.Status.READY) && !mediaPlayer.getStatus().equals(MediaPlayer.Status.STOPPED) && !mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
            setPath(path, shortID);
            initBindings();
        }

        if (mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
            playBtn.setStyle("-fx-shape : \"M 12,26 18.5,22 18.5,14 12,10 z M 18.5,22 25,18 25,18 18.5,14 z\"");
            mediaPlayer.pause();
        }
        else {
            playBtn.setStyle("-fx-shape : \"M 12,26 16,26 16,10 12,10 z M 21,26 25,26 25,10 21,10 z\"");
            mediaPlayer.play();
        }
    }

    private void unMuteShape() {
        muteBtn.setStyle("-fx-shape: \"M8,21 L12,21 L17,26 L17,10 L12,15 L8,15 L8,21 Z M19,14 L19,22 C20.48,21.32 21.5,19.77 21.5,18 C21.5,16.26 20.48,14.74 19,14 ZM19,11.29 C21.89,12.15 24,14.83 24,18 C24,21.17 21.89,23.85 19,24.71 L19,26.77 C23.01,25.86 26,22.28 26,18 C26,13.72 23.01,10.14 19,9.23 L19,11.29 Z\"");
    }

    void muteShape() {
        muteBtn.setStyle("-fx-shape: \"m 21.48,17.98 c 0,-1.77 -1.02,-3.29 -2.5,-4.03 v 2.21 l 2.45,2.45 c .03,-0.2 .05,-0.41 .05,-0.63 z m 2.5,0 c 0,.94 -0.2,1.82 -0.54,2.64 l 1.51,1.51 c .66,-1.24 1.03,-2.65 1.03,-4.15 0,-4.28 -2.99,-7.86 -7,-8.76 v 2.05 c 2.89,.86 5,3.54 5,6.71 z M 9.25,8.98 l -1.27,1.26 4.72,4.73 H 7.98 v 6 H 11.98 l 5,5 v -6.73 l 4.25,4.25 c -0.67,.52 -1.42,.93 -2.25,1.18 v 2.06 c 1.38,-0.31 2.63,-0.95 3.69,-1.81 l 2.04,2.05 1.27,-1.27 -9,-9 -7.72,-7.72 z m 7.72,.99 -2.09,2.08 2.09,2.09 V 9.98 z\"");
    }

    public void muteBtnAction() {
        playClickEffect(muteBtn);
        if (mediaPlayer.getVolume() > 0) {
            lastVolume = mediaPlayer.getVolume();
            mediaPlayer.setVolume(0);
            if (volumeSlider != null) {
                volumeSlider.setValue(0);
            }
            muteShape();
        }
        else {
            mediaPlayer.setVolume(lastVolume);
            if (volumeSlider != null) {
                volumeSlider.setValue(lastVolume);
            }
            unMuteShape();
        }
    }

    private void createVolumeSlider() {
        Slider slider = new Slider();
        slider.setPrefWidth(75);
        slider.setMin(0);
        slider.setMax(1);
        slider.setValue(mediaPlayer.getVolume());
        slider.setBlockIncrement(0.1);
        slider.setMajorTickUnit(0.2);
        slider.setMinorTickCount(1);

        this.volumeSlider = slider;

        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double newVal = (double)newValue;
            double oldVal = (double)oldValue;
            mediaPlayer.setVolume(newVal);
            if (newVal == 0.0) {
                muteShape();
            }
            else if (oldVal == 0.0) {
                unMuteShape();
            }
        });

        muteBtnHBox.getChildren().add(slider);
    }

    public void muteBtnHBoxEnter() {
        createVolumeSlider();
    }

    public void muteBtnHBoxExit() {
        muteBtnHBox.getChildren().remove(1);
        volumeSlider = null;
    }

    public void seekShort() {
        mediaPlayer.seek(Duration.seconds(shortSlider.getValue()));
    }

    public void subscribeBtnAction() throws IOException {
        Request.subscribe(Request.getChannel(handle), MainController.user);
    }
}