package org.project.youtube.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.project.youtube.Client.Controller.MainController;
import org.project.youtube.Client.Model.History;
import org.project.youtube.Client.Model.Network.Client;
import org.project.youtube.Client.Model.Network.Request;

import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Main extends Application {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 5431;
    private static final int SERVER_FILE_TRANSFER_PORT = 5430;
    public static final String CASH_PATH = "C:/YouTube";
    public static MainController mainController;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/org/project/youtube/Client/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1500, 800);
        mainController = fxmlLoader.getController();
        stage.setTitle("YouTube");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/org/project/youtube/Client/images/icon.png"))));
        stage.setResizable(false);
        stage.show();
    }


    @Override
    public void init() throws IOException {
        Client.setSocket(new Socket(SERVER_IP, SERVER_PORT));
        Client.setFileTransferSocket(new Socket(SERVER_IP, SERVER_FILE_TRANSFER_PORT));
        Client.run();

        Files.createDirectories(Paths.get(CASH_PATH));
        //Files.createDirectories(Paths.get("%localAppData%/YouTube"));
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() throws Exception {
        History.serializeHistory();
        Request.logout();
        Client.close();
    }
}