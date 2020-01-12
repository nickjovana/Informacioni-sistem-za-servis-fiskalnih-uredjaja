
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class RegistrationFormApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FU Tech");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane, primaryStage);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        BackgroundImage myBI= new BackgroundImage(new Image("backg_h6.jpeg", width, height,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        gridPane.setBackground(new Background(myBI));
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, width, height);

        //primaryStage.setMaximized(true);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(20);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane, Stage primaryStage) {
        // Add Header
        Label headerLabel = new Label("REGISTRACIJA");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        HBox hb1 = new HBox();

        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setEffect(ds);
        headerLabel.setTextFill(Color.WHITE);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("KORISNIČKO IME: ");
        nameLabel.setEffect(ds);
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        nameLabel.setTextFill(Color.WHITE);
        //gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        nameField.setPrefWidth(500);
        nameField.setStyle("-fx-background-color:  dodgerblue; -fx-text-inner-color: white;");
        nameField.setAlignment(Pos.CENTER_RIGHT);
        nameField.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        //gridPane.add(nameField, 1,1);

        hb1.getChildren().addAll(nameLabel, nameField);
        hb1.setSpacing(60.0);
        hb1.setPrefWidth(1000);
        hb1.setAlignment(Pos.CENTER);

        gridPane.add(hb1, 0, 3, 2, 1);

        HBox hb2 = new HBox();

        Label passwordLabel = new Label("LOZINKA: ");
        passwordLabel.setEffect(ds);
        passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        passwordLabel.setTextFill(Color.WHITE);
        //gridPane.add(passwordLabel, 0, 3);

        // Add Email Text Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        passwordField.setPrefWidth(500);
        passwordField.setStyle("-fx-background-color:  dodgerblue; -fx-text-inner-color: white;");
        passwordField.setAlignment(Pos.CENTER_RIGHT);
        passwordField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //gridPane.add(passwordField, 1, 3);

        hb2.getChildren().addAll(passwordLabel, passwordField);
        hb2.setSpacing(130.0);
        hb2.setPrefWidth(1000);
        hb2.setPrefHeight(60);
        hb2.setAlignment(Pos.CENTER);

        gridPane.add(hb2, 0, 5, 2, 1);

        // Add Submit Button
        Button submitButton = new Button("REGISTRUJ SE");
        submitButton.setPrefHeight(50);
        //submitButton.setDefaultButton(true);
        submitButton.setStyle("-fx-background-color:  dodgerblue");
        submitButton.setPrefWidth(200);
        submitButton.setTextFill(Color.WHITE);
        submitButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        submitButton.setEffect(ds);
        gridPane.add(submitButton, 0, 7, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        BackgroundImage myBI = new BackgroundImage(new Image("Optimized-hardware3.jpg", width, height,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite svoje ime");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite lozinku");
                    return;
                }
                if(nameField.getText().equalsIgnoreCase("Slobodan Kesic")) {
                    prikaziInterfejsZaRukovodioca(ds, myBI, primaryStage);
                    primaryStage.close();
                } else if (nameField.getText().equalsIgnoreCase("Marko Tijanic")) {
                    prikaziInterfejsZaServisera(ds, myBI, primaryStage);
                    primaryStage.close();
                } else if (nameField.getText().equalsIgnoreCase("Snezana Nikolic")) {
                    prikaziInterfejsZaAdministratora(ds, myBI, primaryStage);
                    primaryStage.close();
                }

            }
        });

    }

    private void prikaziInterfejsZaServisera(DropShadow ds, BackgroundImage myBI, Stage registrationStage) {
        Stage serviserStage = new Stage();
        serviserStage.setTitle("Serviser");

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        VBox vbServ = new VBox();

        HBox hbTop = new HBox();

        MenuBar menuBar1 = new MenuBar();
        Menu m1 = new Menu("File");
        Menu m2 = new Menu("Edit");
        Menu m3 = new Menu("Help");

        hbTop.getChildren().add(menuBar1);
        hbTop.setPrefWidth(width);

        MenuBar menuBar2 = new MenuBar();
        Menu m4 = new Menu("Marko Tijanić");
        ImageView iv = new ImageView("profile-icon.png");
        iv.setFitWidth(25);
        iv.setFitHeight(25);

        m4.setGraphic(iv);

        menuBar1.getMenus().addAll(m1, m2, m3);
        menuBar1.setPrefHeight(20);
        menuBar1.setPrefWidth(width);

        menuBar2.getMenus().add(m4);
        menuBar2.setPrefWidth(200);
        menuBar2.setPrefHeight(100);

        HBox hbServ = new HBox();
        hbServ.setPrefHeight(20);
        hbServ.setPrefWidth(500);

        /*ImageView ivMailServ = new ImageView("mailicon.png");
        ivMailServ.setFitWidth(50);
        ivMailServ.setFitHeight(20);
        Button prijemnoSanduceServ = new Button("Primljeni nalozi");
        prijemnoSanduceServ.setLineSpacing(20);


        hbServ.getChildren().addAll(ivMailServ, prijemnoSanduceServ);*/

        Button home = new Button();
        home.setGraphic(new ImageView(new Image("Very-Basic-Home-icon.png")));

        home.setMaxHeight(20);
        home.setPrefWidth(100);
        home.setTextFill(Color.WHITE);
        home.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        home.setEffect(ds);
        home.setLayoutX(50);
        home.setLayoutY(50);

        Button returnBtn = new Button();
        returnBtn.setGraphic(new ImageView(new Image("Return-icon.png")));

        returnBtn.setMaxHeight(20);
        returnBtn.setPrefWidth(100);
        returnBtn.setTextFill(Color.WHITE);
        returnBtn.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        returnBtn.setEffect(ds);
        returnBtn.setLayoutX(50);
        returnBtn.setLayoutY(50);

        returnBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                serviserStage.close();
                registrationStage.show();
            }
        });

        Button posta = new Button();
        posta.setGraphic(new ImageView(new Image("Mail-icon1.png")));

        posta.setMaxHeight(20);
        posta.setPrefWidth(100);
        posta.setTextFill(Color.WHITE);
        posta.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        posta.setEffect(ds);
        posta.setLayoutX(50);
        posta.setLayoutY(50);

        HBox hbPomocni = new HBox();
        hbPomocni.getChildren().addAll(home, returnBtn, posta);

        menuBar2.setPrefHeight(100);
        hbServ.getChildren().addAll(hbPomocni, menuBar2);
        hbServ.setPrefWidth(width);
        hbServ.setSpacing(width-500);

        GridPane paneServ = new GridPane();
        paneServ.setPrefHeight(height);
        paneServ.setPrefWidth(width);

        paneServ.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        paneServ.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        paneServ.setHgap(40);

        // Set the vertical gap between rows
        paneServ.setVgap(10);

        Button fiskalizacija = new Button("FISKALIZACIJA");

        fiskalizacija.setPrefHeight(50);
        fiskalizacija.setPrefWidth(200);
        fiskalizacija.setTextFill(Color.LIGHTSLATEGREY);
        fiskalizacija.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        fiskalizacija.setEffect(ds);
        fiskalizacija.setLayoutX(50);
        fiskalizacija.setLayoutY(50);

        fiskalizacija.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                prikaziInterfejsZaFiskalizaciju();
            }
        });

        Button radniIzvestaj = new Button("RADNI IZVEŠTAJ");

        radniIzvestaj.setPrefHeight(50);
        radniIzvestaj.setPrefHeight(50);
        radniIzvestaj.setPrefWidth(200);
        radniIzvestaj.setTextFill(Color.LIGHTSLATEGREY);
        radniIzvestaj.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        radniIzvestaj.setEffect(ds);
        radniIzvestaj.setLayoutX(50);
        radniIzvestaj.setLayoutY(50);

        radniIzvestaj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                prikaziInterfejsZaPisanjeRadnogIzvestaja();
            }
        });

        paneServ.add(fiskalizacija, 0, 0, 2, 1);
        paneServ.add(radniIzvestaj, 2, 0, 2, 1);

        paneServ.setBackground(new Background(myBI));

        vbServ.getChildren().addAll(hbTop, hbServ, paneServ);

        Scene sceneServ = new Scene(vbServ, width, height);
        serviserStage.setScene(sceneServ);
        serviserStage.show();
    }

    private void prikaziInterfejsZaFiskalizaciju() {
        Stage stage = new Stage();

        stage.setTitle("Fiskalizacija");

        // Create the registration form grid pane
        GridPane gridPane = createFiscalisationFormPane(stage);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        BackgroundImage myBI= new BackgroundImage(new Image("b10.png", width, height,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        gridPane.setBackground(new Background(myBI));
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, width, height);

        //primaryStage.setMaximized(true);
        // Set the scene in primary stage
        stage.setScene(scene);

        stage.show();
    }

    private GridPane createFiscalisationFormPane(Stage stage) {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(20);

        // Set the vertical gap between rows
        gridPane.setVgap(20);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,100, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        // Add Header
        Label headerLabel = new Label("FISKALIZACIJA");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setEffect(ds);
        headerLabel.setTextFill(Color.WHITE);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        Label imePrezimeLabel = new Label("IME I PREZIME SERVISERA: ");
        imePrezimeLabel.setEffect(ds);
        imePrezimeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        imePrezimeLabel.setTextFill(Color.WHITE);
        imePrezimeLabel.setAlignment(Pos.CENTER_LEFT);

        // Add Email Text Field
        TextField imePrezimeField = new TextField();
        imePrezimeField.setPrefHeight(40);
        imePrezimeField.setPrefWidth(400);
        imePrezimeField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        imePrezimeField.setAlignment(Pos.CENTER_RIGHT);
        imePrezimeField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        imePrezimeField.setText("Marko Tijanić");
        //gridPane.add(sifraUredjajaField, 1, 1);

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(imePrezimeLabel, imePrezimeField);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(115);
        gridPane.add(hb1, 0, 1, 2, 1);

        Label sifraUredjajaLabel = new Label("ŠIFRA UREĐAJA: ");
        sifraUredjajaLabel.setEffect(ds);
        sifraUredjajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraUredjajaLabel.setTextFill(Color.WHITE);
        sifraUredjajaLabel.setAlignment(Pos.CENTER_LEFT);

        TextField sifraUredjajaField = new TextField();
        sifraUredjajaField.setPrefHeight(40);
        sifraUredjajaField.setPrefWidth(400);
        sifraUredjajaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        sifraUredjajaField.setAlignment(Pos.CENTER_RIGHT);
        sifraUredjajaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(sifraUredjajaLabel, sifraUredjajaField);
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(205);
        gridPane.add(hb2, 0, 2, 2, 1);

        Label datumFiskLabel = new Label("DATUM FISKALIZACIJE: ");
        datumFiskLabel.setEffect(ds);
        datumFiskLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        datumFiskLabel.setTextFill(Color.WHITE);
        datumFiskLabel.setAlignment(Pos.CENTER_LEFT);

        TextField datumFiskField = new TextField();
        datumFiskField.setPrefHeight(40);
        datumFiskField.setPrefWidth(400);
        datumFiskField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        datumFiskField.setAlignment(Pos.CENTER_RIGHT);
        datumFiskField.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(datumFiskLabel, datumFiskField);
        hb3.setAlignment(Pos.CENTER);
        hb3.setSpacing(150);
        gridPane.add(hb3, 0, 3, 2, 1);

        Label imePrezimeInspLabel = new Label("IME I PREZIME INSPEKTORA: ");
        imePrezimeInspLabel.setEffect(ds);
        imePrezimeInspLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        imePrezimeInspLabel.setTextFill(Color.WHITE);
        imePrezimeInspLabel.setAlignment(Pos.CENTER_LEFT);

        TextField imePrezimeInspField = new TextField();
        imePrezimeInspField.setPrefHeight(40);
        imePrezimeInspField.setPrefWidth(400);
        imePrezimeInspField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        imePrezimeInspField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        imePrezimeInspField.setAlignment(Pos.CENTER_RIGHT);

        HBox hb4 = new HBox();
        hb4.getChildren().addAll(imePrezimeInspLabel, imePrezimeInspField);
        hb4.setAlignment(Pos.CENTER);
        hb4.setSpacing(100);
        gridPane.add(hb4, 0, 4, 2, 1);

        // Add Submit Button
        Button submitButton = new Button("POTVRDI");
        submitButton.setPrefHeight(50);
        submitButton.setStyle("-fx-background-color:  navy;");
        submitButton.setTextFill(Color.WHITE);
        submitButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        submitButton.setEffect(ds);
        submitButton.setPrefWidth(200);
        gridPane.add(submitButton, 0, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        BackgroundImage myBI= new BackgroundImage(new Image("hardware3.jpg",800,460,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(sifraUredjajaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite šifru uređaja");
                    return;
                }
                if(datumFiskField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite datum fiskalizacije");
                    return;
                }
                if(imePrezimeInspField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite ime i prezime inspektora");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Uspešno dodat uređaj!");
                stage.close();
            }
        });

        return gridPane;
    }



    private void prikaziInterfejsZaPisanjeRadnogIzvestaja() {
        Stage stage = new Stage();

        stage.setTitle("Pisanje radnog izvestaja");

        // Create the registration form grid pane
        GridPane gridPane = createReportFormPane(stage);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        BackgroundImage myBI= new BackgroundImage(new Image("b10.png", width, height,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        gridPane.setBackground(new Background(myBI));
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, width, height);

        // Set the scene in primary stage
        stage.setScene(scene);

        stage.show();
    }

    private GridPane createReportFormPane(Stage stage) {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(20);

        // Set the vertical gap between rows
        gridPane.setVgap(20);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,100, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        // Add Header
        Label headerLabel = new Label("PISANJE RADNOG IZVEŠTAJA");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setEffect(ds);
        headerLabel.setTextFill(Color.WHITE);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        Label sifraRadnogIzvestajaLabel = new Label("ŠIFRA RADNOG IZVEŠTAJA: ");
        sifraRadnogIzvestajaLabel.setEffect(ds);
        sifraRadnogIzvestajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraRadnogIzvestajaLabel.setTextFill(Color.WHITE);
        sifraRadnogIzvestajaLabel.setAlignment(Pos.CENTER_LEFT);

        // Add Email Text Field
        TextField sifraRadnogIzvestajaField = new TextField();
        sifraRadnogIzvestajaField.setPrefHeight(40);
        sifraRadnogIzvestajaField.setPrefWidth(400);
        sifraRadnogIzvestajaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        sifraRadnogIzvestajaField.setAlignment(Pos.CENTER_RIGHT);
        sifraRadnogIzvestajaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                //gridPane.add(sifraUredjajaField, 1, 1);

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(sifraRadnogIzvestajaLabel, sifraRadnogIzvestajaField);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(80);
        gridPane.add(hb1, 0, 1, 2, 1);

        // Add Name Label
        Label sifraServiseraLabel = new Label("ŠIFRA SERVISERA: ");
        sifraServiseraLabel.setEffect(ds);
        sifraServiseraLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraServiseraLabel.setTextFill(Color.WHITE);
        sifraServiseraLabel.setAlignment(Pos.CENTER_LEFT);

        // Add Name Text Field
        TextField sifraServiseraField = new TextField();
        sifraServiseraField.setPrefHeight(40);
        sifraServiseraField.setPrefWidth(400);
        sifraServiseraField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        sifraServiseraField.setAlignment(Pos.CENTER_RIGHT);
        sifraServiseraField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraServiseraField.setText("MT123");
        sifraServiseraField.setEditable(false);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(sifraServiseraLabel, sifraServiseraField);
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(153);
        gridPane.add(hb2, 0, 2, 2, 1);

        Label sifraKorisnikaLabel = new Label("ŠIFRA KORISNIKA: ");
        sifraKorisnikaLabel.setEffect(ds);
        sifraKorisnikaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraKorisnikaLabel.setTextFill(Color.WHITE);
        sifraKorisnikaLabel.setAlignment(Pos.CENTER_LEFT);

        TextField sifraKorisnikaField = new TextField();
        sifraKorisnikaField.setPrefHeight(40);
        sifraKorisnikaField.setPrefWidth(400);
        sifraKorisnikaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        sifraKorisnikaField.setAlignment(Pos.CENTER_RIGHT);
        sifraKorisnikaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(sifraKorisnikaLabel, sifraKorisnikaField);
        hb3.setAlignment(Pos.CENTER);
        hb3.setSpacing(155);
        gridPane.add(hb3, 0, 3, 2, 1);

        Label imePrezimeLabel = new Label("IME I PREZIME KORISNIKA: ");
        imePrezimeLabel.setEffect(ds);
        imePrezimeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        imePrezimeLabel.setTextFill(Color.WHITE);
        imePrezimeLabel.setAlignment(Pos.CENTER_LEFT);

        TextField imePrezimeField = new TextField();
        imePrezimeField.setPrefHeight(40);
        imePrezimeField.setPrefWidth(400);
        imePrezimeField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        imePrezimeField.setAlignment(Pos.CENTER_RIGHT);
        imePrezimeField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb4 = new HBox();
        hb4.getChildren().addAll(imePrezimeLabel, imePrezimeField);
        hb4.setAlignment(Pos.CENTER);
        hb4.setSpacing(85);
        gridPane.add(hb4, 0, 4, 2, 1);

        Label aktivnostiLabel = new Label("IZVRŠENE AKTIVNOSTI: ");
        aktivnostiLabel.setEffect(ds);
        aktivnostiLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        aktivnostiLabel.setTextFill(Color.WHITE);
        aktivnostiLabel.setAlignment(Pos.CENTER_LEFT);

        /*TextField aktivnostiField = new TextField();
        aktivnostiField.setPrefHeight(40);
        aktivnostiField.setPrefWidth(400);
        aktivnostiField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        aktivnostiField.setAlignment(Pos.CENTER_RIGHT);
        aktivnostiField.setFont(Font.font("Arial", FontWeight.BOLD, 15)); */
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb51 = new HBox();
        RadioButton rb1 = new RadioButton("INSTALACIJA");
        rb1.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        rb1.setTextFill(Color.WHITE);

        RadioButton rb2 = new RadioButton("ODRZAVANJE");
        rb2.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        rb2.setTextFill(Color.WHITE);

        RadioButton rb3 = new RadioButton("POPRAVKA");
        rb3.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        rb3.setTextFill(Color.WHITE);

        hb51.getChildren().addAll(rb1, rb2, rb3);
        hb51.setAlignment(Pos.CENTER);
        hb51.setSpacing(30);

        HBox hb5 = new HBox();
        hb5.getChildren().addAll(aktivnostiLabel, hb51);
        hb5.setAlignment(Pos.CENTER);
        hb5.setSpacing(140);
        gridPane.add(hb5, 0, 5, 2, 1);

        Label sifraUredjajaLabel = new Label("ŠIFRA UREĐAJA: ");
        sifraUredjajaLabel.setEffect(ds);
        sifraUredjajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraUredjajaLabel.setTextFill(Color.WHITE);
        sifraUredjajaLabel.setAlignment(Pos.CENTER_LEFT);

        TextField sifraUredjajaField = new TextField();
        sifraUredjajaField.setPrefHeight(40);
        sifraUredjajaField.setPrefWidth(400);
        sifraUredjajaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        sifraUredjajaField.setAlignment(Pos.CENTER_RIGHT);
        sifraUredjajaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb6 = new HBox();
        hb6.getChildren().addAll(sifraUredjajaLabel, sifraUredjajaField);
        hb6.setAlignment(Pos.CENTER);
        hb6.setSpacing(178);
        gridPane.add(hb6, 0, 6, 2, 1);

        Label sifraRezervnogDelaLabel = new Label("ŠIFRA REZERVNOG DELA: ");
        sifraRezervnogDelaLabel.setEffect(ds);
        sifraRezervnogDelaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraRezervnogDelaLabel.setTextFill(Color.WHITE);
        sifraRezervnogDelaLabel.setAlignment(Pos.CENTER_LEFT);

        TextField sifraRezervnogDelaField = new TextField();
        sifraRezervnogDelaField.setPrefHeight(40);
        sifraRezervnogDelaField.setPrefWidth(400);
        sifraRezervnogDelaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        sifraRezervnogDelaField.setAlignment(Pos.CENTER_RIGHT);
        sifraRezervnogDelaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb7 = new HBox();
        hb7.getChildren().addAll(sifraRezervnogDelaLabel, sifraRezervnogDelaField);
        hb7.setAlignment(Pos.CENTER);
        hb7.setSpacing(100);
        gridPane.add(hb7, 0, 7, 2, 1);

        Label datumRealLabel = new Label("DATUM REALIZACIJE: ");
        datumRealLabel.setEffect(ds);
        datumRealLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        datumRealLabel.setTextFill(Color.WHITE);
        datumRealLabel.setAlignment(Pos.CENTER_LEFT);

        TextField datumRealField = new TextField();
        datumRealField.setPrefHeight(40);
        datumRealField.setPrefWidth(400);
        datumRealField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        datumRealField.setAlignment(Pos.CENTER_RIGHT);
        datumRealField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss");
        //System.out.println(formatter.format(date));

        datumRealField.setText(formatter.format(date));
        datumRealField.setEditable(false);

        HBox hb8 = new HBox();
        hb8.getChildren().addAll(datumRealLabel, datumRealField);
        hb8.setAlignment(Pos.CENTER);
        hb8.setSpacing(140);
        gridPane.add(hb8, 0, 8, 2, 1);

        // Add Submit Button
        Button submitButton = new Button("POTVRDI");
        submitButton.setPrefHeight(50);
        submitButton.setStyle("-fx-background-color:  navy;");
        submitButton.setTextFill(Color.WHITE);
        submitButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        submitButton.setEffect(ds);
        submitButton.setPrefWidth(200);
        gridPane.add(submitButton, 0, 10, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        BackgroundImage myBI= new BackgroundImage(new Image("hardware3.jpg",800,460,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(sifraRadnogIzvestajaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite šifru izveštaja");
                    return;
                }
                if(sifraKorisnikaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite šifru korisnika");
                    return;
                }
                if(imePrezimeField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite ime i prezime korisnika");
                    return;
                }
                if(!rb1.isSelected() && !rb2.isSelected() && !rb3.isSelected()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo izaberite izvršenu aktivnost");
                    return;
                }
                if(sifraUredjajaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite šifru uređaja");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Uspešno dodat uređaj!");
                stage.close();
            }
        });

        return gridPane;
    }

    private void prikaziInterfejsZaAdministratora(DropShadow ds, BackgroundImage myBI, Stage registrationStage) {
        Stage administratorStage = new Stage();
        administratorStage.setTitle("Administrator");

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        VBox vbAdm = new VBox();

        HBox hbTop = new HBox();

        MenuBar menuBar1 = new MenuBar();
        Menu m1 = new Menu("File");
        Menu m2 = new Menu("Edit");
        Menu m3 = new Menu("Help");

        MenuBar menuBar2 = new MenuBar();
        Menu m4 = new Menu("Snežana Nikolić");

        ImageView ivAdm = new ImageView("profile-icon.png");
        ivAdm.setFitWidth(25);
        ivAdm.setFitHeight(25);

        m4.setGraphic(ivAdm);
        //menuBarAdm.getMenus().add(fileMenuButton);

        menuBar1.getMenus().addAll(m1, m2, m3);
        menuBar1.setPrefHeight(25);
        menuBar1.setPrefWidth(width);

        menuBar2.getMenus().add(m4);
        menuBar2.setPrefHeight(25);
        menuBar2.setPrefWidth(200);

        hbTop.setAlignment(Pos.CENTER);
        hbTop.setSpacing(0);
        hbTop.setPrefWidth(width);
        hbTop.getChildren().addAll(menuBar1);

        HBox hbAdm = new HBox();
        hbAdm.setPrefHeight(100);

        Button home = new Button();
        home.setGraphic(new ImageView(new Image("Very-Basic-Home-icon.png")));

        home.setMaxHeight(20);
        home.setPrefWidth(100);
        home.setTextFill(Color.WHITE);
        home.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        home.setEffect(ds);
        home.setLayoutX(50);
        home.setLayoutY(50);

        Button returnBtn = new Button();
        returnBtn.setGraphic(new ImageView(new Image("Return-icon.png")));

        returnBtn.setMaxHeight(20);
        returnBtn.setPrefWidth(100);
        returnBtn.setTextFill(Color.WHITE);
        returnBtn.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        returnBtn.setEffect(ds);
        returnBtn.setLayoutX(50);
        returnBtn.setLayoutY(50);

        returnBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                administratorStage.close();
                registrationStage.show();
            }
        });

        Button posta = new Button();
        posta.setGraphic(new ImageView(new Image("Mail-icon1.png")));

        posta.setMaxHeight(20);
        posta.setPrefWidth(100);
        posta.setTextFill(Color.WHITE);
        posta.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        posta.setEffect(ds);
        posta.setLayoutX(50);
        posta.setLayoutY(50);

        HBox hbPomocni = new HBox();
        hbPomocni.getChildren().addAll(home, returnBtn, posta);

        menuBar2.setPrefHeight(100);
        hbAdm.getChildren().addAll(hbPomocni, menuBar2);
        hbAdm.setPrefWidth(width);
        hbAdm.setSpacing(width-500);

        GridPane paneAdm = new GridPane();
        paneAdm.setPrefHeight(height-40);
        paneAdm.setPrefWidth(width);

        paneAdm.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        paneAdm.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        paneAdm.setHgap(60);

        // Set the vertical gap between rows
        paneAdm.setVgap(25);

        Button dodajZaposlenog = new Button("NOVI ZAPOSLENI");

        dodajZaposlenog.setPrefHeight(50);
        dodajZaposlenog.setPrefWidth(250);
        dodajZaposlenog.setTextFill(Color.LIGHTSLATEGREY);
        dodajZaposlenog.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        dodajZaposlenog.setEffect(ds);
        dodajZaposlenog.setLayoutX(50);
        dodajZaposlenog.setLayoutY(50);

        dodajZaposlenog.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                prikaziStranicuZaDodavanjeNovogZaposlenog();
            }
        });

        Button dodajUredjaj = new Button("NOVI UREĐAJ");

        dodajUredjaj.setPrefHeight(50);
        dodajUredjaj.setPrefWidth(250);
        dodajUredjaj.setTextFill(Color.LIGHTSLATEGREY);
        dodajUredjaj.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        dodajUredjaj.setEffect(ds);
        dodajUredjaj.setLayoutX(50);
        dodajUredjaj.setLayoutY(50);

        dodajUredjaj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                prikaziStranicuZaDodavanjeNovogUredjaja();
            }
        });

        Button azurirajZaposlenog = new Button("AŽURIRAJ ZAPOSLENOG");

        azurirajZaposlenog.setPrefHeight(50);
        azurirajZaposlenog.setPrefWidth(250);
        azurirajZaposlenog.setTextFill(Color.LIGHTSLATEGREY);
        azurirajZaposlenog.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        azurirajZaposlenog.setEffect(ds);
        azurirajZaposlenog.setLayoutX(50);
        azurirajZaposlenog.setLayoutY(50);

        azurirajZaposlenog.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                prikaziStranicuZaAzuriranjeZaposlenog();
            }
        });

        Button azurirajUredjaj = new Button("AŽURIRAJ UREĐAJ");

        azurirajUredjaj.setPrefHeight(50);
        azurirajUredjaj.setPrefWidth(250);
        azurirajUredjaj.setTextFill(Color.LIGHTSLATEGREY);
        azurirajUredjaj.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        azurirajUredjaj.setEffect(ds);
        azurirajUredjaj.setLayoutX(50);
        azurirajUredjaj.setLayoutY(50);

        azurirajUredjaj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                prikaziStranicuZaAzuriranjeUredjaja();
            }
        });

        paneAdm.add(dodajUredjaj, 0, 0, 2, 1);
        paneAdm.add(dodajZaposlenog, 2, 0, 2, 1);
        paneAdm.add(azurirajUredjaj, 0, 2, 2, 1);
        paneAdm.add(azurirajZaposlenog, 2, 2, 2, 1);

        BackgroundImage myBI1 = new BackgroundImage(new Image("Optimized-b9.jpg", width, height, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        paneAdm.setBackground(new Background(myBI1));

        vbAdm.getChildren().addAll(hbTop, hbAdm, paneAdm);

        Scene sceneAdm = new Scene(vbAdm, width, height);
        administratorStage.setScene(sceneAdm);
        administratorStage.show();

    }

    private void prikaziInterfejsZaRukovodioca(DropShadow ds, BackgroundImage myBI, Stage registrationStage) {
        Stage rukovodilacStage = new Stage();
        rukovodilacStage.setTitle("Rukovodilac");

        VBox vbRuk = new VBox();

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        HBox hbTop = new HBox();

        MenuBar menuBar1 = new MenuBar();
        Menu m1 = new Menu("File");
        Menu m2 = new Menu("Edit");
        Menu m3 = new Menu("Help");

        hbTop.getChildren().add(menuBar1);
        hbTop.setPrefWidth(width);

        MenuBar menuBar2 = new MenuBar();
        Menu m4 = new Menu("Slobodan Kesić");
        ImageView iv = new ImageView("profile-icon.png");
        iv.setFitWidth(25);
        iv.setFitHeight(25);

        m4.setGraphic(iv);

        menuBar1.getMenus().addAll(m1, m2, m3);
        menuBar1.setPrefHeight(20);
        menuBar1.setPrefWidth(width);

        menuBar2.getMenus().add(m4);
        menuBar2.setPrefWidth(200);
        menuBar2.setPrefHeight(100);

        HBox hbRuk = new HBox();
        hbRuk.setPrefHeight(20);
        hbRuk.setPrefWidth(500);

        /*ImageView ivMailServ = new ImageView("mailicon.png");
        ivMailServ.setFitWidth(50);
        ivMailServ.setFitHeight(20);
        Button prijemnoSanduceServ = new Button("Primljeni nalozi");
        prijemnoSanduceServ.setLineSpacing(20);


        hbServ.getChildren().addAll(ivMailServ, prijemnoSanduceServ);*/

        Button home = new Button();
        home.setGraphic(new ImageView(new Image("Very-Basic-Home-icon.png")));

        home.setMaxHeight(20);
        home.setPrefWidth(100);
        home.setTextFill(Color.WHITE);
        home.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        home.setEffect(ds);
        home.setLayoutX(50);
        home.setLayoutY(50);

        Button returnBtn = new Button();
        returnBtn.setGraphic(new ImageView(new Image("Return-icon.png")));

        returnBtn.setMaxHeight(20);
        returnBtn.setPrefWidth(100);
        returnBtn.setTextFill(Color.WHITE);
        returnBtn.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        returnBtn.setEffect(ds);
        returnBtn.setLayoutX(50);
        returnBtn.setLayoutY(50);

        returnBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                rukovodilacStage.close();
                registrationStage.show();
            }
        });

        Button posta = new Button();
        posta.setGraphic(new ImageView(new Image("Mail-icon1.png")));

        posta.setMaxHeight(20);
        posta.setPrefWidth(100);
        posta.setTextFill(Color.WHITE);
        posta.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        posta.setEffect(ds);
        posta.setLayoutX(50);
        posta.setLayoutY(50);

        HBox hbPomocni = new HBox();
        hbPomocni.getChildren().addAll(home, returnBtn, posta);

        menuBar2.setPrefHeight(100);
        hbRuk.getChildren().addAll(hbPomocni, menuBar2);
        hbRuk.setPrefWidth(width);
        hbRuk.setSpacing(width-500);

        GridPane paneRuk = new GridPane();
        paneRuk.setPrefHeight(height);
        paneRuk.setPrefWidth(width);

        paneRuk.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        paneRuk.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        paneRuk.setHgap(60);

        // Set the vertical gap between rows
        paneRuk.setVgap(60);


        Button napisiNalog = new Button("NAPIŠI NALOG");

        napisiNalog.setPrefHeight(50);
        napisiNalog.setPrefWidth(200);
        napisiNalog.setTextFill(Color.NAVY);
        napisiNalog.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        napisiNalog.setStyle("-fx-background-color:  white");
        napisiNalog.setEffect(ds);
        napisiNalog.setLayoutX(50);
        napisiNalog.setLayoutY(50);

        napisiNalog.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                prikaziInterfejsZaPisanjeNalogaServiseru();
            }
        });

        Button uvidUStanje = new Button("STANJE SKLADIŠTA");

        uvidUStanje.setPrefHeight(50);
        uvidUStanje.setPrefWidth(200);
        uvidUStanje.setTextFill(Color.NAVY);
        uvidUStanje.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uvidUStanje.setStyle("-fx-background-color:  white");
        uvidUStanje.setEffect(ds);
        uvidUStanje.setLayoutX(50);
        uvidUStanje.setLayoutY(50);

        uvidUStanje.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                prikaziInterfejsZaStanjeSkladista();
            }
        });

        paneRuk.add(napisiNalog, 0, 0, 2, 1);
        paneRuk.add(uvidUStanje, 2, 0, 2, 1);
        //paneRuk.add(prodaja, 0, 2, 2, 1);
        //paneRuk.add(uvidUStanje, 2, 2, 2, 1);

        BackgroundImage myBI1 = new BackgroundImage(new Image("Optimized-backg_h1.jpg", width, height, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        paneRuk.setBackground(new Background(myBI1));

        vbRuk.getChildren().addAll(hbTop, hbRuk, paneRuk);

        Scene sceneRuk = new Scene(vbRuk, width, height);
        rukovodilacStage.setScene(sceneRuk);
        rukovodilacStage.show();
    }

    private void prikaziInterfejsZaStanjeSkladista() {
        Stage stage = new Stage();

        stage.setTitle("Stanje skladišta");

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        VBox vbGlavni = new VBox();

        BackgroundImage myBI = new BackgroundImage(new Image("b7.jpg", width, height,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        vbGlavni.setBackground(new Background(myBI));

        Label naslovLabel = new Label("STANJE SKLADIŠTA");
        naslovLabel.setAlignment(Pos.CENTER);

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        naslovLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        naslovLabel.setEffect(ds);
        naslovLabel.setTextFill(Color.WHITE);

        ScrollPane sp = new ScrollPane();
        sp.setPrefWidth(width-80);
        sp.setPrefHeight(600);

        HBox hb = new HBox();
        hb.setPrefWidth(width-100);
        hb.setPrefHeight(600-80);
        hb.setPadding(new Insets(40, 40, 40, 40));
        hb.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(250);

        // Set the vertical gap between rows
        gridPane.setVgap(30);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        //columnTwoConstrains.setHgrow(Priority.ALWAYS);

        ColumnConstraints columnThreeConstraints;
        columnThreeConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains, columnThreeConstraints);

        Label uredjaj = new Label("UREĐAJ");
        uredjaj.setEffect(ds);
        uredjaj.setPrefHeight(30);
        uredjaj.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj.setTextFill(Color.WHITE);
        uredjaj.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj, 0, 0, 1, 1);

        Label trenutnaKolicina = new Label("TRENUTNA KOLIČINA");
        trenutnaKolicina.setEffect(ds);
        trenutnaKolicina.setPrefHeight(30);
        trenutnaKolicina.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        trenutnaKolicina.setTextFill(Color.WHITE);
        trenutnaKolicina.setAlignment(Pos.CENTER);
        gridPane.add(trenutnaKolicina, 1, 0, 1, 1);

        Label minimalnaKolicina = new Label("MINIMALNA KOLIČINA");
        minimalnaKolicina.setEffect(ds);
        minimalnaKolicina.setPrefHeight(30);
        minimalnaKolicina.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        minimalnaKolicina.setTextFill(Color.WHITE);
        minimalnaKolicina.setAlignment(Pos.CENTER);
        gridPane.add(minimalnaKolicina, 2, 0, 1, 1);

        Label uredjaj100 = new Label("FU100");
        uredjaj100.setEffect(ds);
        uredjaj100.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj100.setTextFill(Color.RED);
        uredjaj100.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(uredjaj100, 0, 1, 1, 1);

        Label uredjaj105 = new Label("FU105");
        uredjaj105.setEffect(ds);
        uredjaj105.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj105.setTextFill(Color.RED);
        uredjaj105.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(uredjaj105, 0, 2, 1, 1);

        Label uredjaj105W = new Label("FU105W");
        uredjaj105W.setEffect(ds);
        uredjaj105W.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj105W.setTextFill(Color.RED);
        uredjaj105W.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(uredjaj105W, 0, 3, 1, 1);

        Label uredjaj120 = new Label("FU120");
        uredjaj120.setEffect(ds);
        uredjaj120.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj120.setTextFill(Color.RED);
        uredjaj120.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(uredjaj120, 0, 4, 1, 1);

        Label uredjaj123 = new Label("FU123");
        uredjaj123.setEffect(ds);
        uredjaj123.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj123.setTextFill(Color.WHITE);
        uredjaj123.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(uredjaj123, 0, 5, 1, 1);

        Label uredjaj125 = new Label("FU125");
        uredjaj125.setEffect(ds);
        uredjaj125.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj125.setTextFill(Color.WHITE);
        uredjaj125.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(uredjaj125, 0, 6, 1, 1);

        Label uredjaj140 = new Label("FU140");
        uredjaj140.setEffect(ds);
        uredjaj140.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj140.setTextFill(Color.WHITE);
        uredjaj140.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(uredjaj140, 0, 7, 1, 1);

        Label uredjaj256 = new Label("FU256");
        uredjaj256.setEffect(ds);
        uredjaj256.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj256.setTextFill(Color.WHITE);
        uredjaj256.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(uredjaj256, 0, 8, 1, 1);

        Label uredjaj456 = new Label("FU456");
        uredjaj456.setEffect(ds);
        uredjaj456.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj456.setTextFill(Color.WHITE);
        uredjaj456.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(uredjaj456, 0, 9, 1, 1);

        Label uredjaj789 = new Label("FU789");
        uredjaj789.setEffect(ds);
        uredjaj789.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj789.setTextFill(Color.WHITE);
        uredjaj789.setAlignment(Pos.CENTER_LEFT);
        gridPane.add(uredjaj789, 0, 10, 1, 1);

        TextField uredjaj100F = new TextField();
        uredjaj100F.setPrefWidth(30);
        uredjaj100F.setPrefHeight(30);
        uredjaj100F.setEditable(false);
        uredjaj100F.setText("1");
        uredjaj100F.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: red;");
        uredjaj100F.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj100F.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj100F, 1, 1, 1, 1);

        TextField uredjaj105F = new TextField();
        uredjaj105F.setPrefWidth(30);
        uredjaj105F.setEditable(false);
        uredjaj105F.setText("4");
        uredjaj105F.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: red;");
        uredjaj105F.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj105F.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj105F, 1, 2, 1, 1);

        TextField uredjaj105WF = new TextField();
        uredjaj105WF.setPrefWidth(30);
        uredjaj105WF.setEditable(false);
        uredjaj105WF.setText("7");
        uredjaj105WF.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: red;");
        uredjaj105WF.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj105WF.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj105WF, 1, 3, 1, 1);

        TextField uredjaj120F = new TextField();
        uredjaj120F.setPrefWidth(30);
        uredjaj120F.setEditable(false);
        uredjaj120F.setText("0");
        uredjaj120F.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: red;");
        uredjaj120F.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj120F.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj120F, 1, 4, 1, 1);

        TextField uredjaj125F = new TextField();
        uredjaj125F.setPrefWidth(30);
        uredjaj125F.setEditable(false);
        uredjaj125F.setText("8");
        uredjaj125F.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj125F.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj125F.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj125F, 1, 6, 1, 1);

        TextField uredjaj123F = new TextField();
        uredjaj123F.setPrefWidth(30);
        uredjaj123F.setEditable(false);
        uredjaj123F.setText("6");
        uredjaj123F.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj123F.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj123F.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj123F, 1, 5, 1, 1);

        TextField uredjaj140F = new TextField();
        uredjaj140F.setPrefWidth(30);
        uredjaj140F.setEditable(false);
        uredjaj140F.setText("11");
        uredjaj140F.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj140F.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj140F.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj140F, 1, 7, 1, 1);

        TextField uredjaj256F = new TextField();
        uredjaj256F.setPrefWidth(30);
        uredjaj256F.setEditable(false);
        uredjaj256F.setText("10");
        uredjaj256F.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj256F.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj256F.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj256F, 1, 8, 1, 1);

        TextField uredjaj456F = new TextField();
        uredjaj456F.setPrefWidth(30);
        uredjaj456F.setEditable(false);
        uredjaj456F.setText("18");
        uredjaj456F.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj456F.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj456F.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj456F, 1, 9, 1, 1);

        TextField uredjaj789F = new TextField();
        uredjaj789F.setPrefWidth(30);
        uredjaj789F.setEditable(false);
        uredjaj789F.setText("21");
        uredjaj789F.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj789F.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj789F.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj789F, 1, 10, 1, 1);

        TextField uredjaj100MKF = new TextField();
        uredjaj100MKF.setPrefWidth(30);
        uredjaj100MKF.setPrefHeight(30);
        uredjaj100MKF.setEditable(false);
        uredjaj100MKF.setText("5");
        uredjaj100MKF.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: red;");
        uredjaj100MKF.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj100MKF.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj100MKF, 2, 1, 1, 1);

        TextField uredjaj105MKF = new TextField();
        uredjaj105MKF.setPrefWidth(30);
        uredjaj105MKF.setEditable(false);
        uredjaj105MKF.setText("5");
        uredjaj105MKF.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: red;");
        uredjaj105MKF.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj105MKF.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj105MKF, 2, 2, 1, 1);

        TextField uredjaj105WMKF = new TextField();
        uredjaj105WMKF.setPrefWidth(30);
        uredjaj105WMKF.setEditable(false);
        uredjaj105WMKF.setText("10");
        uredjaj105WMKF.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: red;");
        uredjaj105WMKF.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj105WMKF.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj105WMKF, 2, 3, 1, 1);

        TextField uredjaj120MKF = new TextField();
        uredjaj120MKF.setPrefWidth(30);
        uredjaj120MKF.setEditable(false);
        uredjaj120MKF.setText("2");
        uredjaj120MKF.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: red;");
        uredjaj120MKF.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj120MKF.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj120MKF, 2, 4, 1, 1);

        TextField uredjaj125MKF = new TextField();
        uredjaj125MKF.setPrefWidth(30);
        uredjaj125MKF.setEditable(false);
        uredjaj125MKF.setText("5");
        uredjaj125MKF.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj125MKF.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj125MKF.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj125MKF, 2, 6, 1, 1);

        TextField uredjaj123MKF = new TextField();
        uredjaj123MKF.setPrefWidth(30);
        uredjaj123MKF.setEditable(false);
        uredjaj123MKF.setText("3");
        uredjaj123MKF.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj123MKF.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj123MKF.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj123MKF, 2, 5, 1, 1);

        TextField uredjaj140MKF = new TextField();
        uredjaj140MKF.setPrefWidth(30);
        uredjaj140MKF.setEditable(false);
        uredjaj140MKF.setText("10");
        uredjaj140MKF.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj140MKF.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj140MKF.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj140MKF, 2, 7, 1, 1);

        TextField uredjaj256MKF = new TextField();
        uredjaj256MKF.setPrefWidth(30);
        uredjaj256MKF.setEditable(false);
        uredjaj256MKF.setText("10");
        uredjaj256MKF.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj256MKF.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj256MKF.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj256MKF, 2, 8, 1, 1);

        TextField uredjaj456MKF = new TextField();
        uredjaj456MKF.setPrefWidth(30);
        uredjaj456MKF.setEditable(false);
        uredjaj456MKF.setText("10");
        uredjaj456MKF.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj456MKF.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj456MKF.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj456MKF, 2, 9, 1, 1);

        TextField uredjaj789MKF = new TextField();
        uredjaj789MKF.setPrefWidth(30);
        uredjaj789MKF.setEditable(false);
        uredjaj789MKF.setText("5");
        uredjaj789MKF.setStyle("-fx-background-color:  cornflowerblue; -fx-text-inner-color: white;");
        uredjaj789MKF.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        uredjaj789MKF.setAlignment(Pos.CENTER);
        gridPane.add(uredjaj789MKF, 2, 10, 1, 1);

        gridPane.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        gridPane.setPrefWidth(width-80);
        gridPane.setPrefHeight(600);

        sp.setContent(gridPane);

        vbGlavni.setSpacing(30);
        vbGlavni.setAlignment(Pos.CENTER);
        vbGlavni.setPadding(new Insets(40, 40, 40, 40));

        vbGlavni.getChildren().addAll(naslovLabel, sp);

        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(vbGlavni, width, height);

        // Set the scene in primary stage
        stage.setScene(scene);

        stage.show();
    }

    private void prikaziPostuRukovodioca(BackgroundImage myBI) {
        Stage postaRukStage = new Stage();
        postaRukStage.setTitle("Elektronska posta");

        VBox vbPostaRuk = new VBox();

        MenuBar menuBar = new MenuBar();
        Menu m1 = new Menu("File");
        Menu m2 = new Menu("Edit");
        Menu m3 = new Menu("Help");
        Menu m4 = new Menu("Slobodan");
        ImageView ivServ = new ImageView("profileee.jpeg");
        ivServ.setFitWidth(25);
        ivServ.setFitHeight(25);
        m4.setGraphic(ivServ);
        menuBar.getMenus().addAll(m1, m2, m3, m4);
        menuBar.setPrefHeight(20);
        menuBar.setPrefWidth(800);

        HBox hbPostaRuk = new HBox();
        hbPostaRuk.setPrefHeight(20);
        hbPostaRuk.setPrefWidth(500);

        Button primljenePoruke = new Button("Primljene poruke");
        Button poslatePoruke = new Button("Poslate poruke");
        Button vaznePoruke = new Button("Vazno");
        Button arhivaPoruke = new Button("Arhiva");

        //ObservableList<Image> podesavanjeIkona =
        // postaRukStage.getIcons().add(new Image(getClass().getResourceAsStream("settingsIcon.png")))


        hbPostaRuk.getChildren().addAll(primljenePoruke, poslatePoruke, vaznePoruke, arhivaPoruke);

        GridPane paneRuk = new GridPane();
        paneRuk.setPrefHeight(460);
        paneRuk.setPrefWidth(800);

        paneRuk.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        paneRuk.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        paneRuk.setHgap(10);

        // Set the vertical gap between rows
        paneRuk.setVgap(10);

        paneRuk.setBackground(new Background(myBI));

        ScrollPane mejlPane = new ScrollPane();
        mejlPane.setPrefHeight(300);
        mejlPane.setPrefWidth(650);

        paneRuk.getChildren().add(mejlPane);

        vbPostaRuk.getChildren().addAll(menuBar, hbPostaRuk, paneRuk);

        Scene sceneRuk = new Scene(vbPostaRuk, 800, 500);
        postaRukStage.setScene(sceneRuk);
        postaRukStage.show();
    }

    private void prikaziInterfejsZaPisanjeNalogaServiseru() {

        Stage pisanjeNaloga = new Stage();

        pisanjeNaloga.setTitle("Pisanje naloga");

        // Create the registration form grid pane
        //GridPane gridPane = createOrderFormPane(pisanjeNaloga);

        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(20);

        // Set the vertical gap between rows
        gridPane.setVgap(20);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,100, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        // Add Header
        Label headerLabel = new Label("PISANJE NALOGA SERVISERU");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setEffect(ds);
        headerLabel.setTextFill(Color.WHITE);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        // Add Name Label
        Label serviserLabel = new Label("SERVISER: ");
        serviserLabel.setEffect(ds);
        serviserLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        serviserLabel.setTextFill(Color.WHITE);
        //gridPane.add(tipUredjajaLabel, 0,2);

        // Add Name Text Field
        TextField serviserField = new TextField();
        serviserField.setPrefHeight(40);
        serviserField.setPrefWidth(400);
        serviserField.setStyle("-fx-background-color:  dodgerblue; -fx-text-inner-color: white;");
        serviserField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        serviserField.setAlignment(Pos.CENTER_RIGHT);
        //gridPane.add(tipUredjajaField, 1,2);

        //gridPane.add(sifraUredjajaField, 1, 1);

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(serviserLabel, serviserField);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(148);
        gridPane.add(hb1, 0, 1, 2, 1);

        Label sifraUredjajaLabel = new Label("ŠIFRA UREĐAJA: ");
        sifraUredjajaLabel.setEffect(ds);
        sifraUredjajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraUredjajaLabel.setTextFill(Color.WHITE);
        //gridPane.add(sifraUredjajaLabel, 0, 1);

        // Add Email Text Field
        TextField sifraUredjajaField = new TextField();
        sifraUredjajaField.setPrefHeight(40);
        sifraUredjajaField.setPrefWidth(400);
        sifraUredjajaField.setStyle("-fx-background-color:  dodgerblue; -fx-text-inner-color: white;");
        sifraUredjajaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraUredjajaField.setAlignment(Pos.CENTER_RIGHT);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(sifraUredjajaLabel, sifraUredjajaField);
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(100);
        gridPane.add(hb2, 0, 2, 2, 1);

        Label korisnikLabel = new Label("KORISNIK: ");
        korisnikLabel.setEffect(ds);
        korisnikLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        korisnikLabel.setTextFill(Color.WHITE);
        //gridPane.add(oznakaUredjajaLabel, 0, 3);

        // Add Email Text Field
        TextField korisnikField = new TextField();
        korisnikField.setPrefHeight(40);
        korisnikField.setPrefWidth(400);
        korisnikField.setStyle("-fx-background-color:  dodgerblue; -fx-text-inner-color: white;");
        korisnikField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        korisnikField.setAlignment(Pos.CENTER_RIGHT);

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(korisnikLabel, korisnikField);
        hb3.setAlignment(Pos.CENTER);
        hb3.setSpacing(151);
        gridPane.add(hb3, 0, 3, 2, 1);

        Label opisUslugeLabel = new Label("OPIS USLUGE: ");
        opisUslugeLabel.setEffect(ds);
        opisUslugeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        opisUslugeLabel.setTextFill(Color.WHITE);

        //korisnikField.setAlignment(Pos.CENTER_RIGHT);
        //gridPane.add(opisUslugeLabel, 0, 4);

        // Add Email Text Field
        TextArea opisUslugeArea = new TextArea();
        opisUslugeArea.setPrefHeight(120);
        opisUslugeArea.setPrefWidth(400);

        // Or you can set it by setStyle()
        //region.setStyle( "-fx-background-color: dodgerblue;" );

        opisUslugeArea.setStyle("-fx-text-inner-color: white;");
        opisUslugeArea.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //gridPane.add(opisUslugeArea, 1, 4);

        HBox hb4 = new HBox();
        hb4.getChildren().addAll(opisUslugeLabel, opisUslugeArea);
        hb4.setAlignment(Pos.CENTER);
        hb4.setSpacing(123);
        gridPane.add(hb4, 0, 4, 2, 1);

        // Add Submit Button
        Button submitButton = new Button("POŠALJI");
        submitButton.setPrefHeight(50);
        submitButton.setStyle("-fx-background-color:  dodgerblue");
        submitButton.setTextFill(Color.WHITE);
        submitButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        submitButton.setEffect(ds);
        submitButton.setPrefWidth(200);
        gridPane.add(submitButton, 0, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        BackgroundImage myBI= new BackgroundImage(new Image("hardware3.jpg",800,460,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(serviserField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite servisera");
                    return;
                }
                if(sifraUredjajaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite šifru uređaja");
                    return;
                }
                if(korisnikField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite korisnika");
                    return;
                }
                if(opisUslugeArea.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite opis usluge");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Uspešno dodat uređaj!");
                pisanjeNaloga.close();
            }
        });

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        BackgroundImage myBI1= new BackgroundImage(new Image("b7.jpg", width, height,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        gridPane.setBackground(new Background(myBI1));
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, width, height);

        //primaryStage.setMaximized(true);
        // Set the scene in primary stage
        pisanjeNaloga.setScene(scene);

        pisanjeNaloga.show();

        Region region = ( Region ) opisUslugeArea.lookup( ".content" );
        region.setBackground( new Background( new BackgroundFill( Color.DODGERBLUE, CornerRadii.EMPTY, Insets.EMPTY ) ) );

    }

   // private GridPane createOrderFormPane(Stage stage) {
        /*// Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(20);

        // Set the vertical gap between rows
        gridPane.setVgap(20);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,100, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        // Add Header
        Label headerLabel = new Label("Pisanje naloga");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setEffect(ds);
        headerLabel.setTextFill(Color.WHITE);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label serviserLabel = new Label("Serviser: ");
        serviserLabel.setEffect(ds);
        serviserLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        serviserLabel.setTextFill(Color.WHITE);
        gridPane.add(serviserLabel, 0,1);

        // Add Name Text Field
        TextField serviserField = new TextField();
        serviserField.setPrefHeight(40);
        serviserField.setPrefWidth(100);
        gridPane.add(serviserField, 1,1);

        Label sifraUredjajaLabel = new Label("Šifra uređaja: ");
        sifraUredjajaLabel.setEffect(ds);
        sifraUredjajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraUredjajaLabel.setTextFill(Color.WHITE);
        gridPane.add(sifraUredjajaLabel, 0, 2);

        // Add Email Text Field
        TextField sifraUredjajaField = new TextField();
        sifraUredjajaField.setPrefHeight(40);
        gridPane.add(sifraUredjajaField, 1, 2);

        Label korisnikLabel = new Label("Ime korisnika: ");
        korisnikLabel.setEffect(ds);
        korisnikLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        korisnikLabel.setTextFill(Color.WHITE);
        gridPane.add(korisnikLabel, 0, 3);

        // Add Email Text Field
        TextField korisnikField = new TextField();
        korisnikField.setPrefHeight(40);
        gridPane.add(korisnikField, 1, 3);


        Label opisUslugeLabel = new Label("Opis usluge: ");
        opisUslugeLabel.setEffect(ds);
        opisUslugeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        opisUslugeLabel.setTextFill(Color.WHITE);
        gridPane.add(opisUslugeLabel, 0, 4);

        // Add Email Text Field
        TextArea opisUslugeArea = new TextArea();
        opisUslugeArea.setPrefHeight(120);
        gridPane.add(opisUslugeArea, 1, 4);

        // Add Submit Button
        Button submitButton = new Button("POŠALJI");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(120);
        gridPane.add(submitButton, 0, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        BackgroundImage myBI= new BackgroundImage(new Image("hardware3.jpg",800,460,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(serviserField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite ime servisera");
                    return;
                }
                if(sifraUredjajaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite šifru uređaja");
                    return;
                }
                if(korisnikField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite ime korisnika");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Nalog uspešno prosleđen serviseru!");
                stage.close();
            }
        });

        return gridPane; */

        // Instantiate a new Grid Pane


    //}

    private void prikaziStranicuZaDodavanjeNovogUredjaja() {
        Stage stage = new Stage();

        stage.setTitle("Dodavanje novog uredjaja");

        // Create the registration form grid pane
        GridPane gridPane = createAddNewDeviceFormPane(stage);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        BackgroundImage myBI= new BackgroundImage(new Image("hardware3.jpg", width, height,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        gridPane.setBackground(new Background(myBI));
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, width, height);

        //primaryStage.setMaximized(true);
        // Set the scene in primary stage
        stage.setScene(scene);

        stage.show();
    }

    private GridPane createAddNewDeviceFormPane(Stage stage) {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(20);

        // Set the vertical gap between rows
        gridPane.setVgap(20);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,100, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        // Add Header
        Label headerLabel = new Label("DODAVANJE NOVOG UREĐAJA");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setEffect(ds);
        headerLabel.setTextFill(Color.WHITE);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        Label sifraUredjajaLabel = new Label("ŠIFRA UREĐAJA: ");
        sifraUredjajaLabel.setEffect(ds);
        sifraUredjajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraUredjajaLabel.setTextFill(Color.WHITE);
        //gridPane.add(sifraUredjajaLabel, 0, 1);

        // Add Email Text Field
        TextField sifraUredjajaField = new TextField();
        sifraUredjajaField.setPrefHeight(40);
        sifraUredjajaField.setPrefWidth(400);
        sifraUredjajaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        sifraUredjajaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraUredjajaField.setAlignment(Pos.CENTER_RIGHT);
        //gridPane.add(sifraUredjajaField, 1, 1);

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(sifraUredjajaLabel, sifraUredjajaField);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(127);
        gridPane.add(hb1, 0, 1, 2, 1);

        // Add Name Label
        Label tipUredjajaLabel = new Label("TIP UREĐAJA: ");
        tipUredjajaLabel.setEffect(ds);
        tipUredjajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        tipUredjajaLabel.setTextFill(Color.WHITE);
        //gridPane.add(tipUredjajaLabel, 0,2);

        // Add Name Text Field
        TextField tipUredjajaField = new TextField();
        tipUredjajaField.setPrefHeight(40);
        tipUredjajaField.setPrefWidth(400);
        tipUredjajaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        tipUredjajaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        tipUredjajaField.setAlignment(Pos.CENTER_RIGHT);
        //gridPane.add(tipUredjajaField, 1,2);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(tipUredjajaLabel, tipUredjajaField);
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(150);
        gridPane.add(hb2, 0, 2, 2, 1);

        Label oznakaUredjajaLabel = new Label("OZNAKA PROIZVOĐAČA: ");
        oznakaUredjajaLabel.setEffect(ds);
        oznakaUredjajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        oznakaUredjajaLabel.setTextFill(Color.WHITE);
        //gridPane.add(oznakaUredjajaLabel, 0, 3);

        // Add Email Text Field
        TextField oznakaUredjajaField = new TextField();
        oznakaUredjajaField.setPrefHeight(40);
        oznakaUredjajaField.setPrefWidth(400);
        oznakaUredjajaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        oznakaUredjajaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        oznakaUredjajaField.setAlignment(Pos.CENTER_RIGHT);

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(oznakaUredjajaLabel, oznakaUredjajaField);
        hb3.setAlignment(Pos.CENTER);
        hb3.setSpacing(60);
        gridPane.add(hb3, 0, 3, 2, 1);

        // Add Submit Button
        Button submitButton = new Button("POTVRDI");
        submitButton.setPrefHeight(50);
        submitButton.setStyle("-fx-background-color:  navy");
        submitButton.setTextFill(Color.WHITE);
        submitButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        submitButton.setEffect(ds);
        submitButton.setPrefWidth(200);
        gridPane.add(submitButton, 0, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        BackgroundImage myBI= new BackgroundImage(new Image("hardware3.jpg",800,460,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(sifraUredjajaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite šifru uređaja");
                    return;
                }
                if(tipUredjajaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite tip uređaja");
                    return;
                }
                if(oznakaUredjajaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite oznaku uređaja");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Uspešno dodat uređaj!");
                stage.close();
            }
        });

        return gridPane;
    }

    private void prikaziStranicuZaDodavanjeNovogZaposlenog() {
        Stage stage = new Stage();

        stage.setTitle("Dodavanje novog zaposlenog");

        // Create the registration form grid pane
        GridPane gridPane = createAddNewEmployeeFormPane(stage);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        BackgroundImage myBI= new BackgroundImage(new Image("b6.png", width, height,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        gridPane.setBackground(new Background(myBI));
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, width, height);

        //primaryStage.setMaximized(true);
        // Set the scene in primary stage
        stage.setScene(scene);

        stage.show();
    }

    GridPane createAddNewEmployeeFormPane(Stage stage) {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(20);

        // Set the vertical gap between rows
        gridPane.setVgap(20);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,100, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        // Add Header
        Label headerLabel = new Label("DODAVANJE NOVOG SERVISERA");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setEffect(ds);
        headerLabel.setTextFill(Color.WHITE);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        Label imeLabel = new Label("IME: ");
        imeLabel.setEffect(ds);
        imeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        imeLabel.setTextFill(Color.WHITE);
        imeLabel.setAlignment(Pos.CENTER_LEFT);

        // Add Email Text Field
        TextField imeField = new TextField();
        imeField.setPrefHeight(40);
        imeField.setPrefWidth(400);
        imeField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        imeField.setAlignment(Pos.CENTER_RIGHT);
        imeField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //gridPane.add(sifraUredjajaField, 1, 1);

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(imeLabel, imeField);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(210);
        gridPane.add(hb1, 0, 1, 2, 1);

        // Add Name Label
        Label prezimeLabel = new Label("PREZIME: ");
        prezimeLabel.setEffect(ds);
        prezimeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        prezimeLabel.setTextFill(Color.WHITE);
        prezimeLabel.setAlignment(Pos.CENTER_LEFT);

        // Add Name Text Field
        TextField prezimeField = new TextField();
        prezimeField.setPrefHeight(40);
        prezimeField.setPrefWidth(400);
        prezimeField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        prezimeField.setAlignment(Pos.CENTER_RIGHT);
        prezimeField.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(prezimeLabel, prezimeField);
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(170);
        gridPane.add(hb2, 0, 2, 2, 1);

        Label adresaLabel = new Label("ADRESA: ");
        adresaLabel.setEffect(ds);
        adresaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        adresaLabel.setTextFill(Color.WHITE);
        adresaLabel.setAlignment(Pos.CENTER_LEFT);

        TextField adresaField = new TextField();
        adresaField.setPrefHeight(40);
        adresaField.setPrefWidth(400);
        adresaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        adresaField.setAlignment(Pos.CENTER_RIGHT);
        adresaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(adresaLabel, adresaField);
        hb3.setAlignment(Pos.CENTER);
        hb3.setSpacing(175);
        gridPane.add(hb3, 0, 3, 2, 1);

        Label telefonLabel = new Label("TELEFON: ");
        telefonLabel.setEffect(ds);
        telefonLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        telefonLabel.setTextFill(Color.WHITE);
        telefonLabel.setAlignment(Pos.CENTER_LEFT);

        TextField telefonField = new TextField();
        telefonField.setPrefHeight(40);
        telefonField.setPrefWidth(400);
        telefonField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        telefonField.setAlignment(Pos.CENTER_RIGHT);
        telefonField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb4 = new HBox();
        hb4.getChildren().addAll(telefonLabel, telefonField);
        hb4.setAlignment(Pos.CENTER);
        hb4.setSpacing(170);
        gridPane.add(hb4, 0, 4, 2, 1);

        Label emailLabel = new Label("E-MAIL: ");
        emailLabel.setEffect(ds);
        emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        emailLabel.setTextFill(Color.WHITE);
        emailLabel.setAlignment(Pos.CENTER_LEFT);

        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        emailField.setPrefWidth(400);
        emailField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        emailField.setAlignment(Pos.CENTER_RIGHT);
        emailField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb5 = new HBox();
        hb5.getChildren().addAll(emailLabel, emailField);
        hb5.setAlignment(Pos.CENTER);
        hb5.setSpacing(190);
        gridPane.add(hb5, 0, 5, 2, 1);

        Label lozinkaLabel = new Label("LOZINKA: ");
        lozinkaLabel.setEffect(ds);
        lozinkaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        lozinkaLabel.setTextFill(Color.WHITE);
        lozinkaLabel.setAlignment(Pos.CENTER_LEFT);

        TextField lozinkaField = new TextField();
        lozinkaField.setPrefHeight(40);
        lozinkaField.setPrefWidth(400);
        lozinkaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        lozinkaField.setAlignment(Pos.CENTER_RIGHT);
        lozinkaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb6 = new HBox();
        hb6.getChildren().addAll(lozinkaLabel, lozinkaField);
        hb6.setAlignment(Pos.CENTER);
        hb6.setSpacing(175);
        gridPane.add(hb6, 0, 6, 2, 1);

        Label nivoObrLabel = new Label("NIVO OBRAZOVANJA: ");
        nivoObrLabel.setEffect(ds);
        nivoObrLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        nivoObrLabel.setTextFill(Color.WHITE);
        nivoObrLabel.setAlignment(Pos.CENTER_LEFT);

        TextField nivoObrField = new TextField();
        nivoObrField.setPrefHeight(40);
        nivoObrField.setPrefWidth(400);
        nivoObrField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        nivoObrField.setAlignment(Pos.CENTER_RIGHT);
        nivoObrField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb7 = new HBox();
        hb7.getChildren().addAll(nivoObrLabel, nivoObrField);
        hb7.setAlignment(Pos.CENTER);
        hb7.setSpacing(80);
        gridPane.add(hb7, 0, 7, 2, 1);

        Label datumZapLabel = new Label("DATUM ZAPOSLENJA: ");
        datumZapLabel.setEffect(ds);
        datumZapLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        datumZapLabel.setTextFill(Color.WHITE);
        datumZapLabel.setAlignment(Pos.CENTER_LEFT);

        TextField datumZapField = new TextField();
        datumZapField.setPrefHeight(40);
        datumZapField.setPrefWidth(400);
        datumZapField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
        datumZapField.setAlignment(Pos.CENTER_RIGHT);
        datumZapField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

        HBox hb8 = new HBox();
        hb8.getChildren().addAll(datumZapLabel, datumZapField);
        hb8.setAlignment(Pos.CENTER);
        hb8.setSpacing(80);
        gridPane.add(hb8, 0, 8, 2, 1);

        // Add Submit Button
        Button submitButton = new Button("POTVRDI");
        submitButton.setPrefHeight(50);
        submitButton.setStyle("-fx-background-color:  navy;");
        submitButton.setTextFill(Color.WHITE);
        submitButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        submitButton.setEffect(ds);
        submitButton.setPrefWidth(200);
        gridPane.add(submitButton, 0, 10, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(imeField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite ime zaposlenog");
                    return;
                }
                if(prezimeField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite prezime zaposlenog");
                    return;
                }
                if(adresaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite adresu zaposlenog");
                    return;
                }
                if(telefonField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite telefon zaposlenog");
                    return;
                }
                if(emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite e-mail zaposlenog");
                    return;
                }
                if(lozinkaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite lozinku zaposlenog");
                    return;
                }
                if(nivoObrField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite nivo obrazovanja zaposlenog");
                    return;
                }
                if(datumZapField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite datum zaposlenja");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Uspešno dodat zaposleni!");
                stage.close();
            }
        });

        return gridPane;
    }

    private void prikaziStranicuZaAzuriranjeUredjaja() {
        Stage stage = new Stage();

        stage.setTitle("Azuriraj uredjaj");

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        // Create the registration form grid pane
        GridPane gridPane = createUpdateDeviceFormPane(stage);
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);

        BackgroundImage myBI= new BackgroundImage(new Image("b9.jpg",width, height,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        gridPane.setBackground(new Background(myBI));

        /*VBox vb = new VBox();

        HBox hb = new HBox();

        Button izmeniBtn = new Button("IZMENI PODATKE");

        izmeniBtn.setPrefHeight(50);
        izmeniBtn.setPrefWidth(200);
        izmeniBtn.setTextFill(Color.WHITE);
        izmeniBtn.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //izmeniBtn.setEffect(ds);
        izmeniBtn.setLayoutX(50);
        izmeniBtn.setLayoutY(50);

        izmeniBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //gridPane = createUpdateDeviceFormPane(stage);
            }
        });

        Button obrisiBtn = new Button("OBRIŠI UREĐAJ");

        obrisiBtn.setPrefHeight(50);
        obrisiBtn.setPrefWidth(200);
        obrisiBtn.setTextFill(Color.WHITE);
        obrisiBtn.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        //obrisiBtn.setEffect(ds);
        obrisiBtn.setLayoutX(50);
        obrisiBtn.setLayoutY(50);

        hb.getChildren().addAll(izmeniBtn, obrisiBtn);

        // Create a scene with registration form grid pane as the root node

        vb.getChildren().addAll(hb, gridPane); */

        Scene scene = new Scene(gridPane, width, height);

        //primaryStage.setMaximized(true);
        // Set the scene in primary stage
        stage.setScene(scene);

        stage.show();
    }

    private GridPane createUpdateDeviceFormPane(Stage stage) {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(20);

        // Set the vertical gap between rows
        gridPane.setVgap(20);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,100, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        // Add Header
        Label headerLabel = new Label("Unesite šifru uređaja");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setEffect(ds);
        headerLabel.setTextFill(Color.WHITE);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        HBox hb1 = new HBox();

        Label sifraUredjajaLabel = new Label("ŠIFRA UREĐAJA: ");
        sifraUredjajaLabel.setEffect(ds);
        sifraUredjajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraUredjajaLabel.setTextFill(Color.WHITE);
        //gridPane.add(sifraUredjajaLabel, 0, 1);

        // Add Email Text Field
        TextField sifraUredjajaField = new TextField();
        sifraUredjajaField.setPrefHeight(40);
        sifraUredjajaField.setPrefWidth(400);
        sifraUredjajaField.setStyle("-fx-background-color:  skyblue; -fx-text-inner-color: white;");
        sifraUredjajaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        sifraUredjajaField.setAlignment(Pos.CENTER_RIGHT);
        //gridPane.add(sifraUredjajaField, 1, 1);

        hb1.getChildren().addAll(sifraUredjajaLabel, sifraUredjajaField);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(60);
        hb1.setPrefWidth(800);
        gridPane.add(hb1, 0, 1, 2, 1);

        HBox hb = new HBox();

        // Add Submit Button
        Button updateButton = new Button("IZMENA PODATAKA");
        updateButton.setPrefHeight(50);
        updateButton.setDefaultButton(true);
        updateButton.setPrefWidth(200);
        updateButton.setTextFill(Color.WHITE);
        updateButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        updateButton.setEffect(ds);
        //gridPane.add(updateButton, 0, 3, 1, 1);
        GridPane.setHalignment(updateButton, HPos.CENTER);
        GridPane.setMargin(updateButton, new Insets(20, 0,20,0));

        Button deleteButton = new Button("OBRIŠI UREĐAJ");
        deleteButton.setPrefHeight(50);
        deleteButton.setDefaultButton(true);
        deleteButton.setPrefWidth(200);
        deleteButton.setTextFill(Color.WHITE);
        deleteButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        deleteButton.setEffect(ds);
        //gridPane.add(deleteButton, 1, 3, 1, 1);
        GridPane.setHalignment(deleteButton, HPos.CENTER);
        GridPane.setMargin(deleteButton, new Insets(20, 0,20,0));

        hb.getChildren().addAll(updateButton, deleteButton);
        hb.setPrefWidth(500);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(100.0);

        gridPane.add(hb, 0, 4, 2, 1);

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(sifraUredjajaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite šifru uređaja");
                    return;
                }

                //showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Uspešno dodat uređaj!");

                String sifra = sifraUredjajaField.getText().toString();

                gridPane.getChildren().clear();

                // Add Header
                Label headerLabel = new Label("IZMENITE PODATKE O UREĐAJU");

                DropShadow ds = new DropShadow();
                ds.setOffsetY(3.0f);
                ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

                headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                headerLabel.setEffect(ds);
                headerLabel.setTextFill(Color.WHITE);
                gridPane.add(headerLabel, 0,0,2,1);
                GridPane.setHalignment(headerLabel, HPos.CENTER);
                GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

                Label sifraUredjajaLabel = new Label("ŠIFRA UREĐAJA: ");
                sifraUredjajaLabel.setEffect(ds);
                sifraUredjajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                sifraUredjajaLabel.setTextFill(Color.WHITE);
                //gridPane.add(sifraUredjajaLabel, 0, 1);

                // Add Email Text Field
                TextField sifraUredjajaField = new TextField();
                sifraUredjajaField.setPrefHeight(40);
                sifraUredjajaField.setPrefWidth(400);
                //gridPane.add(sifraUredjajaField, 1, 1);
                sifraUredjajaField.setText(sifra);
                sifraUredjajaField.setStyle("-fx-background-color:  skyblue; -fx-text-inner-color: white;");
                sifraUredjajaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                sifraUredjajaField.setAlignment(Pos.CENTER_RIGHT);

                HBox hb1 = new HBox();

                hb1.getChildren().addAll(sifraUredjajaLabel, sifraUredjajaField);
                hb1.setAlignment(Pos.CENTER);
                hb1.setSpacing(165);
                hb1.setPrefWidth(800);
                gridPane.add(hb1, 0, 1, 2, 1);

                String tip = "Nepoznati tip uredjaja";
                String oznaka = "Nepoznata oznaka proizvodjaca";
                if (sifra.equalsIgnoreCase("FU123")) {
                    tip = "Fp550";
                    oznaka = "Galeb";
                } else if (sifra.equalsIgnoreCase("FU456")) {
                    tip = "Fp200";
                    oznaka = "Geneko";
                } else if (sifra.equalsIgnoreCase("FU789")) {
                    tip = "Fp600";
                    oznaka = "Intraster";
                } else if (sifra.equalsIgnoreCase("FU256")) {
                    tip = "P2DS";
                    oznaka = "HCP";
                }

                // Add Name Label
                Label tipUredjajaLabel = new Label("TIP UREĐAJA: ");
                tipUredjajaLabel.setEffect(ds);
                tipUredjajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                tipUredjajaLabel.setTextFill(Color.WHITE);
                //gridPane.add(tipUredjajaLabel, 0,2);

                TextField tipUredjajaField = new TextField();
                tipUredjajaField.setPrefHeight(40);
                tipUredjajaField.setPrefWidth(400);
                //gridPane.add(tipUredjajaField, 1,2);
                tipUredjajaField.setText(tip);
                tipUredjajaField.setStyle("-fx-background-color:  skyblue; -fx-text-inner-color: white;");
                tipUredjajaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                tipUredjajaField.setAlignment(Pos.CENTER_RIGHT);

                HBox hb2 = new HBox();

                hb2.getChildren().addAll(tipUredjajaLabel, tipUredjajaField);
                hb2.setAlignment(Pos.CENTER);
                hb2.setSpacing(190);
                hb2.setPrefWidth(800);
                gridPane.add(hb2, 0, 2, 2, 1);

                Label oznakaUredjajaLabel = new Label("OZNAKA PROIZVOĐAČA: ");
                oznakaUredjajaLabel.setEffect(ds);
                oznakaUredjajaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                oznakaUredjajaLabel.setTextFill(Color.WHITE);
                //gridPane.add(oznakaUredjajaLabel, 0, 3);

                TextField oznakaUredjajaField = new TextField();
                oznakaUredjajaField.setPrefHeight(40);
                oznakaUredjajaField.setPrefWidth(400);
                //gridPane.add(oznakaUredjajaField, 1, 3);
                oznakaUredjajaField.setText(oznaka);
                oznakaUredjajaField.setStyle("-fx-background-color:  skyblue; -fx-text-inner-color: white;");
                oznakaUredjajaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                oznakaUredjajaField.setAlignment(Pos.CENTER_RIGHT);

                HBox hb3 = new HBox();

                hb3.getChildren().addAll(oznakaUredjajaLabel, oznakaUredjajaField);
                hb3.setAlignment(Pos.CENTER);
                hb3.setSpacing(100);
                hb3.setPrefWidth(800);
                gridPane.add(hb3, 0, 3, 2, 1);

                Button submitButton = new Button("POTVRDI IZMENE");
                submitButton.setPrefHeight(50);
                submitButton.setDefaultButton(true);
                submitButton.setPrefWidth(200);
                submitButton.setTextFill(Color.WHITE);
                submitButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                submitButton.setEffect(ds);
                gridPane.add(submitButton, 0, 6, 2, 1);
                GridPane.setHalignment(submitButton, HPos.CENTER);
                GridPane.setMargin(submitButton, new Insets(20, 0,20,0));


                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(sifraUredjajaField.getText().isEmpty()) {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite šifru uređaja");
                            return;
                        }

                        showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Uspešno izmenjeni podaci o uređaju!");

                    }
                });

            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(sifraUredjajaField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite šifru uređaja");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Uspešno obrisan uređaj!");

                /*
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stage.close();*/
            }
        });

        return gridPane;
    }

    private void prikaziStranicuZaAzuriranjeZaposlenog() {

        Stage stage = new Stage();

        stage.setTitle("Azuriranje informacija o zaposlenima");

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        // Create the registration form grid pane
        GridPane gridPane = createUpdateEmployeeFormPane(stage);
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);

        BackgroundImage myBI= new BackgroundImage(new Image("backg_h5.jpg",width, height,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        gridPane.setBackground(new Background(myBI));

        Scene scene = new Scene(gridPane, width, height);

        // Set the scene in primary stage
        stage.setScene(scene);

        stage.show();
    }

    GridPane createUpdateEmployeeFormPane(Stage stage) {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(20);

        // Set the vertical gap between rows
        gridPane.setVgap(20);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(100,100, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        // Add Header
        Label headerLabel = new Label("UNESITE IME I PREZIME SERVISERA");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setEffect(ds);
        headerLabel.setTextFill(Color.WHITE);
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        HBox hb1 = new HBox();

        Label imePrezimeLabel = new Label("IME I PREZIME: ");
        imePrezimeLabel.setEffect(ds);
        imePrezimeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        imePrezimeLabel.setTextFill(Color.WHITE);

        // Add Email Text Field
        TextField imePrezimeField = new TextField();
        imePrezimeField.setPrefHeight(40);
        imePrezimeField.setPrefWidth(400);
        imePrezimeField.setStyle("-fx-background-color:  skyblue; -fx-text-inner-color: white;");
        imePrezimeField.setAlignment(Pos.CENTER_RIGHT);
        imePrezimeField.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        hb1.getChildren().addAll(imePrezimeLabel, imePrezimeField);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(60);
        hb1.setPrefWidth(800);
        gridPane.add(hb1, 0, 1, 2, 1);

        HBox hb = new HBox();

        // Add Submit Button
        Button updateButton = new Button("IZMENA PODATAKA");
        updateButton.setPrefHeight(50);
        updateButton.setDefaultButton(true);
        updateButton.setPrefWidth(200);
        updateButton.setTextFill(Color.WHITE);
        updateButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        updateButton.setEffect(ds);
        //gridPane.add(updateButton, 0, 3, 1, 1);
        GridPane.setHalignment(updateButton, HPos.CENTER);
        GridPane.setMargin(updateButton, new Insets(20, 0,20,0));

        Button deleteButton = new Button("OBRIŠI ZAPOSLENOG");
        deleteButton.setPrefHeight(50);
        deleteButton.setDefaultButton(true);
        deleteButton.setPrefWidth(200);
        deleteButton.setTextFill(Color.WHITE);
        deleteButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        deleteButton.setEffect(ds);
        //gridPane.add(deleteButton, 1, 3, 1, 1);
        GridPane.setHalignment(deleteButton, HPos.CENTER);
        GridPane.setMargin(deleteButton, new Insets(20, 0,20,0));

        hb.getChildren().addAll(updateButton, deleteButton);
        hb.setPrefWidth(500);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(100.0);

        gridPane.add(hb, 0, 4, 2, 1);

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(imePrezimeField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite ime i prezime servisera");
                    return;
                }

                //showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Uspešno dodat uređaj!");

                String imePrezime = imePrezimeField.getText();

                gridPane.getChildren().clear();

                Map<String, LinkedList<String>> serviseri = new HashMap<String, LinkedList<String>>();
                LinkedList<String> marko = new LinkedList<String>(Arrays.asList("Marko", "Tijanić", "Požeška 46", "065 123 4567", "marko.tijanic@gmail.com", "Boki1234", "Srednja škola", "16.07.2014."));
                serviseri.put("Marko Tijanić", marko);

                // Add Header
                Label headerLabel = new Label("IZMENITE PODATKE O SERVISERU");

                DropShadow ds = new DropShadow();
                ds.setOffsetY(3.0f);
                ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

                headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                headerLabel.setEffect(ds);
                headerLabel.setTextFill(Color.WHITE);
                gridPane.add(headerLabel, 0,0,2,1);
                GridPane.setHalignment(headerLabel, HPos.CENTER);
                GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

                String ime = "Nepoznato ime";
                String prezime = "Nepoznato prezime";
                String adresa = "Nepoznata adresa";
                String telefon = "Nepoznat telefon";
                String email = "Nepoznat e-mail";
                String lozinka = "Nepoznata lozinka";
                String nivoObr = "Nepoznat nivo obrazovanja";
                String datZap = "Nepoznat datum zaposlenja";

                if (imePrezime.equalsIgnoreCase("Marko Tijanić") || imePrezime.equalsIgnoreCase("Marko Tijanic")) {
                    ime = serviseri.get("Marko Tijanić").get(0);
                    prezime = serviseri.get("Marko Tijanić").get(1);
                    adresa = serviseri.get("Marko Tijanić").get(2);
                    telefon = serviseri.get("Marko Tijanić").get(3);
                    email = serviseri.get("Marko Tijanić").get(4);
                    lozinka = serviseri.get("Marko Tijanić").get(5);
                    nivoObr = serviseri.get("Marko Tijanić").get(6);
                    datZap = serviseri.get("Marko Tijanić").get(7);
                }

                Label imeLabel = new Label("IME: ");
                imeLabel.setEffect(ds);
                imeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                imeLabel.setTextFill(Color.WHITE);
                imeLabel.setAlignment(Pos.CENTER_LEFT);

                // Add Email Text Field
                TextField imeField = new TextField();
                imeField.setPrefHeight(40);
                imeField.setPrefWidth(400);
                imeField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
                imeField.setAlignment(Pos.CENTER_RIGHT);
                imeField.setText(ime);
                imeField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                //gridPane.add(sifraUredjajaField, 1, 1);

                HBox hb1 = new HBox();
                hb1.getChildren().addAll(imeLabel, imeField);
                hb1.setAlignment(Pos.CENTER);
                hb1.setSpacing(210);
                gridPane.add(hb1, 0, 1, 2, 1);

                // Add Name Label
                Label prezimeLabel = new Label("PREZIME: ");
                prezimeLabel.setEffect(ds);
                prezimeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                prezimeLabel.setTextFill(Color.WHITE);
                prezimeLabel.setAlignment(Pos.CENTER_LEFT);

                // Add Name Text Field
                TextField prezimeField = new TextField();
                prezimeField.setPrefHeight(40);
                prezimeField.setPrefWidth(400);
                prezimeField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
                prezimeField.setAlignment(Pos.CENTER_RIGHT);
                prezimeField.setText(prezime);
                prezimeField.setFont(Font.font("Arial", FontWeight.BOLD, 15));

                HBox hb2 = new HBox();
                hb2.getChildren().addAll(prezimeLabel, prezimeField);
                hb2.setAlignment(Pos.CENTER);
                hb2.setSpacing(170);
                gridPane.add(hb2, 0, 2, 2, 1);

                Label adresaLabel = new Label("ADRESA: ");
                adresaLabel.setEffect(ds);
                adresaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                adresaLabel.setTextFill(Color.WHITE);
                adresaLabel.setAlignment(Pos.CENTER_LEFT);

                TextField adresaField = new TextField();
                adresaField.setPrefHeight(40);
                adresaField.setPrefWidth(400);
                adresaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
                adresaField.setAlignment(Pos.CENTER_RIGHT);
                adresaField.setText(adresa);
                adresaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

                HBox hb3 = new HBox();
                hb3.getChildren().addAll(adresaLabel, adresaField);
                hb3.setAlignment(Pos.CENTER);
                hb3.setSpacing(175);
                gridPane.add(hb3, 0, 3, 2, 1);

                Label telefonLabel = new Label("TELEFON: ");
                telefonLabel.setEffect(ds);
                telefonLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                telefonLabel.setTextFill(Color.WHITE);
                telefonLabel.setAlignment(Pos.CENTER_LEFT);

                TextField telefonField = new TextField();
                telefonField.setPrefHeight(40);
                telefonField.setPrefWidth(400);
                telefonField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
                telefonField.setAlignment(Pos.CENTER_RIGHT);
                telefonField.setText(telefon);
                telefonField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

                HBox hb4 = new HBox();
                hb4.getChildren().addAll(telefonLabel, telefonField);
                hb4.setAlignment(Pos.CENTER);
                hb4.setSpacing(170);
                gridPane.add(hb4, 0, 4, 2, 1);

                Label emailLabel = new Label("E-MAIL: ");
                emailLabel.setEffect(ds);
                emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                emailLabel.setTextFill(Color.WHITE);
                emailLabel.setAlignment(Pos.CENTER_LEFT);

                TextField emailField = new TextField();
                emailField.setPrefHeight(40);
                emailField.setPrefWidth(400);
                emailField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
                emailField.setAlignment(Pos.CENTER_RIGHT);
                emailField.setText(email);
                emailField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

                HBox hb5 = new HBox();
                hb5.getChildren().addAll(emailLabel, emailField);
                hb5.setAlignment(Pos.CENTER);
                hb5.setSpacing(190);
                gridPane.add(hb5, 0, 5, 2, 1);

                Label lozinkaLabel = new Label("LOZINKA: ");
                lozinkaLabel.setEffect(ds);
                lozinkaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                lozinkaLabel.setTextFill(Color.WHITE);
                lozinkaLabel.setAlignment(Pos.CENTER_LEFT);

                TextField lozinkaField = new TextField();
                lozinkaField.setPrefHeight(40);
                lozinkaField.setPrefWidth(400);
                lozinkaField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
                lozinkaField.setAlignment(Pos.CENTER_RIGHT);
                lozinkaField.setText(lozinka);
                lozinkaField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

                HBox hb6 = new HBox();
                hb6.getChildren().addAll(lozinkaLabel, lozinkaField);
                hb6.setAlignment(Pos.CENTER);
                hb6.setSpacing(175);
                gridPane.add(hb6, 0, 6, 2, 1);

                Label nivoObrLabel = new Label("NIVO OBRAZOVANJA: ");
                nivoObrLabel.setEffect(ds);
                nivoObrLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                nivoObrLabel.setTextFill(Color.WHITE);
                nivoObrLabel.setAlignment(Pos.CENTER_LEFT);

                TextField nivoObrField = new TextField();
                nivoObrField.setPrefHeight(40);
                nivoObrField.setPrefWidth(400);
                nivoObrField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
                nivoObrField.setAlignment(Pos.CENTER_RIGHT);
                nivoObrField.setText(nivoObr);
                nivoObrField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

                HBox hb7 = new HBox();
                hb7.getChildren().addAll(nivoObrLabel, nivoObrField);
                hb7.setAlignment(Pos.CENTER);
                hb7.setSpacing(80);
                gridPane.add(hb7, 0, 7, 2, 1);

                Label datumZapLabel = new Label("DATUM ZAPOSLENJA: ");
                datumZapLabel.setEffect(ds);
                datumZapLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                datumZapLabel.setTextFill(Color.WHITE);
                datumZapLabel.setAlignment(Pos.CENTER_LEFT);

                TextField datumZapField = new TextField();
                datumZapField.setPrefHeight(40);
                datumZapField.setPrefWidth(400);
                datumZapField.setStyle("-fx-background-color:  navy; -fx-text-inner-color: white;");
                datumZapField.setAlignment(Pos.CENTER_RIGHT);
                datumZapField.setText(datZap);
                datumZapField.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                //oznakaUredjajaField.setStyle("-fx-text-inner-color: white;");

                HBox hb8 = new HBox();
                hb8.getChildren().addAll(datumZapLabel, datumZapField);
                hb8.setAlignment(Pos.CENTER);
                hb8.setSpacing(80);
                gridPane.add(hb8, 0, 8, 2, 1);

                // Add Submit Button
                Button submitButton = new Button("POTVRDI");
                submitButton.setPrefHeight(50);
                submitButton.setStyle("-fx-background-color:  navy;");
                submitButton.setTextFill(Color.WHITE);
                submitButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                submitButton.setEffect(ds);
                submitButton.setPrefWidth(200);
                gridPane.add(submitButton, 0, 10, 2, 1);
                GridPane.setHalignment(submitButton, HPos.CENTER);
                GridPane.setMargin(submitButton, new Insets(20, 0,20,0));


                submitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(imePrezimeField.getText().isEmpty()) {
                            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite ime i prezime servisera");
                            return;
                        }

                        showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Uspešno izmenjeni podaci o serviseru!");

                    }
                });

            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(imePrezimeField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Greska!", "Molimo unesite ime i prezime servisera");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Uspeh", "Uspešno obrisan serviser!");

                /*
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stage.close();*/
            }
        });

        return gridPane;
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}