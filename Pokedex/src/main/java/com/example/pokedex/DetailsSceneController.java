package com.example.pokedex;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.util.List;



import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;
import org.bson.Document;

import java.io.FileInputStream;
import java.util.List;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import static javafx.application.Application.launch;

public class DetailsSceneController {

    @FXML
   private ImageView imageView;

    @FXML
    private Button nameButton;



    @FXML
    private Label typeButton;

String name,description,height,weight;



    @FXML
    private Label descriptionButton;

    @FXML
    private Label evolutionsButton;

    @FXML
    private Label heightButton;
    @FXML private Label weightButton;
    @FXML private Label EvolutionsButton;

    private MongoDatabase database;
    private MongoCollection<Document> PokemonCollection;
    private Stage detailsScene;
    @FXML
    private Label welcomeText;
    @FXML
    private Button hello;
    @FXML private List<String>type;
    @FXML private List<String>evolution;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText(name);
        descriptionButton.setText(description);
        String typestr = String.join(", ", type);
        typeButton.setText(typestr);
        heightButton.setText(height);
        weightButton.setText(weight);
        String evolutionStr = String.join(", ", evolution);
        evolutionsButton.setText(evolutionStr);

    }
    public void setData(String id)
    {
        try {

        Document query = new Document("iden",id);
        initialize(query);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public void setSearch(String text)
    {
        try {

            Document query = new Document("name",text);
            initialize(query);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @FXML



    public void initialize(Document query) {


        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("Pokedex");
        PokemonCollection = database.getCollection("Pokedex_Details");
        Document pokedocs = PokemonCollection.find(query).first();

        name = pokedocs.getString("name");
        description = pokedocs.getString("description");
        type = pokedocs.getList("type", String.class);
        height = pokedocs.getString("height");
        weight = pokedocs.getString("weight");

        evolution = pokedocs.getList("evolutions", String.class);
        System.out.println(name);


        onHelloButtonClick();

        String imageUrl = pokedocs.getString("image_url");

        try {
            Image image = new Image(new FileInputStream(imageUrl));
            imageView.setImage(image);
            // imageView.setFitWidth(200); // Set the width of the image view --> -->
            imageView.setPreserveRatio(false); // Preserve the aspect ratio -->
        } catch (Exception e) {
            System.out.println("Failed to load image: " + e.getMessage());
        }
    }

    @FXML
    public void setLoginStage(Stage stage) {
        this.detailsScene = stage;
    }

}
