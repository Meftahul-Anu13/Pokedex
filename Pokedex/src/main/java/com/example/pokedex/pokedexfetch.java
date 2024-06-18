package com.example.pokedex;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class pokedexfetch {

    @FXML private Label favLabel;
    @FXML private ImageView image;
    @FXML private Button removeButton;


    private String name;
    private String imageUrl;

    // Define MongoDB variables
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> favoriteCollection;
//    pokedexfetch(String name,String imageUrl)
//    {
//        this.name = name;
//        this.imageUrl = imageUrl;
//    }

    public void initialize() {
        setNameAndImageUrl(name,imageUrl);
        //System.out.println(name);
//        mongoClient = MongoClients.create("mongodb://localhost:27017");
//        database = mongoClient.getDatabase("Pokedex");
//        favoriteCollection = database.getCollection("Favorite");
//
////             Document query = new Document("name", name);
////        System.out.println(query);
//
//        System.out.println("Initializing Favorite");
//        Document favoriteData = favoriteCollection.find().first();
//        //here fetch the query document name and imageurl using find. dot any filter system
//
//
//       if (favoriteData != null) {
//            // Set the name from the database to the label
//            String name2 = favoriteData.getString("name");
//           System.out.println("jnina"+ name2);
//            favLabel.setText(name2);
//
//            // Set the image from the database to the image view
//            String imageUrl = favoriteData.getString("image_url");
//            if (imageUrl != null && !imageUrl.isEmpty()) {
//                try {
//                    Image img = new Image(new FileInputStream(imageUrl));
//                    image.setImage(img);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            }
//        if (name != null && !name.isEmpty()) {
//            favLabel.setText(name);
//        }
//        if (imageUrl != null && !imageUrl.isEmpty()) {
//            try {
//                Image img = new Image(new FileInputStream(imageUrl));
//                image.setImage(img);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }
    public void setData(Post post) {
        try {
            Image imag = new Image(getClass().getResourceAsStream(post.getImageUrl()));
            image.setImage(imag);
            favLabel.setText(post.getName());

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void setNameAndImageUrl(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("Pokedex");
        favoriteCollection = database.getCollection("Favorite");

//             Document query = new Document("name", name);
//        System.out.println(query);

        System.out.println("Initializing Favorite");
        Document favoriteData = favoriteCollection.find().first();
        //here fetch the query document name and imageurl using find. dot any filter system


        if (favoriteData != null) {
            // Set the name from the database to the label
            String name2 = favoriteData.getString("name");
            System.out.println("jnina"+ name2);
            favLabel.setText(name2);

            // Set the image from the database to the image view
            String imageUrl2= favoriteData.getString("image_url");
            if (imageUrl2 != null && !imageUrl2.isEmpty()) {
                try {
                    Image img = new Image(new FileInputStream(imageUrl2));
                    image.setImage(img);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("kaj krena ");
                }
            }
        }

    }
    public String getName() {
        return name;
    }

    // Getter for imageUrl
    public String getImageUrl() {
        return imageUrl;
    }
    @FXML
    private void removeFavorite() {
        // Implement logic to remove the favorite from the database and update the UI accordingly
    }
}
