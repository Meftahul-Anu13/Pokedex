package com.example.pokedex;
//
//
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.TilePane;
//import javafx.scene.text.Text;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//
//public class PokedexController {
//
//    private Pokedex pokedex = new Pokedex();
//
//    @FXML private Text nameTxt;
//    @FXML private Text typeTxt;
//@FXML
//    ImageView Title;
//    @FXML
//    private void initialize() {
//        nameTxt.textProperty().bind(pokedex.displayedNameProperty());
//        typeTxt.textProperty().bind(pokedex.displayedTypeProperty());
//        //Image image = new Image(new FileInputStream("pokemonTitle.jpg"));
//        try{
//
//        Image image = new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\pokemonTitle.jpg"));
//            Title.setImage(image);
//
//        }
//catch (FileNotFoundException e) {
//            System.out.println("Unable to locate image file: " + ".jpg");
//        }
//    }
//
//    @FXML
//    private void handleNext(ActionEvent event) {
//        pokedex.next();
//    }
//
//    @FXML
//    private void handlePrevious(ActionEvent event) {
//        pokedex.previous();
//    }
//}
import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.bson.Document;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class PokedexController {
    @FXML
    private Stage passStage;
    @FXML
    private ImageView bulbasaur;

    @FXML
    private ImageView ivysaur;

    @FXML
    private ImageView venusaur;

    @FXML
    private ImageView charmander;

    @FXML
    private ImageView charmeleon;

    @FXML
    private ImageView charizard;

    @FXML
    private ImageView squirtle;

    @FXML
    private ImageView wartortle;

    @FXML
    private ImageView blastoise;

    @FXML
    private ImageView caterpie;

    @FXML
    private ImageView metapod;

    @FXML
    private ImageView butterfree;

    @FXML
    private ImageView weedle;

    @FXML
    private ImageView kakuna;

    @FXML
    private ImageView beedrill;
    @FXML
    private ImageView fav1;

    @FXML
    private ImageView fav2;

    @FXML
    private ImageView fav3;

    @FXML
    private ImageView fav4;

    @FXML
    private ImageView fav5;

    @FXML
    private ImageView fav6;

    @FXML
    private ImageView fav7;

    @FXML
    private ImageView fav8;

    @FXML
    private ImageView fav9;

    @FXML
    private ImageView fav10;

    @FXML
    private ImageView fav11;

    @FXML
    private ImageView fav12;

    @FXML
    private ImageView fav13;

    @FXML
    private ImageView fav14;

    @FXML
    private ImageView fav15;

    @FXML
    private ImageView favourite;
    @FXML
    private ImageView searchicon;
    @FXML
    private AnchorPane a1;

    @FXML
    private AnchorPane a2;

    @FXML
    private AnchorPane a3;

    @FXML
    private AnchorPane a4;

    @FXML
    private AnchorPane a5;

    @FXML
    private AnchorPane a6;

    @FXML
    private AnchorPane a7;

    @FXML
    private AnchorPane a8;

    @FXML
    private AnchorPane a9;

    @FXML
    private AnchorPane a10;

    @FXML
    private AnchorPane a11;

    @FXML
    private AnchorPane a12;

    @FXML
    private AnchorPane a13;

    @FXML
    private AnchorPane a14;

    @FXML
    private AnchorPane a15;
    @FXML
    private TextField searchbar;
    @FXML
    private MongoDatabase database;
    @FXML
    private Button favoriteButton;
    @FXML private Button favorite;
    @FXML
    private MongoCollection<Document> PokemonCollection;
    MongoCollection<Document> favoriteCollection;
@FXML private   ImageView imageView ;

    // Assuming you have an array of Pokemon names and their corresponding IDs
    private String[] pokemonNames = {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill"};

    @FXML
    private void initialize() {
        // Set up action for the login button
        try {
            bulbasaur.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\bulbasaur.png")));
            ivysaur.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\ivysaur.png")));
            venusaur.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\venusaur.png")));
            charmander.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\charmander.png")));
            charmeleon.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\charmeleon.png")));
            charizard.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\charizard.png")));
            squirtle.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\squirtle.png")));
            wartortle.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\wartortle.png")));
            blastoise.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\blastoise-mega.png")));
            caterpie.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\caterpie.png")));
            metapod.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\metapod.png")));
            butterfree.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\butterfree.png")));
            weedle.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\weedle.png")));
            kakuna.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\kakuna.png")));
            beedrill.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\beedrill.png")));
            fav1.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav2.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav3.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav4.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav5.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav6.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav7.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav8.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav9.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav10.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav11.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav12.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav13.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav14.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            fav15.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart3.png")));
            favourite.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\heart.png")));
            searchicon.setImage(new Image(new FileInputStream("D:\\4rth Sem Product\\JavaProject\\Pokedex\\src\\main\\java\\com\\example\\pokedex\\Image\\search.png")));


        } catch (FileNotFoundException e) {
            System.out.println("Unable to locate image file: " + ".jpg");
        }

    }

    @FXML
    private void anchorClick(MouseEvent event) {
        //  Button source = (Button) event.getSource();
        AnchorPane source = (AnchorPane) event.getSource();
       // Button source = (Button) event.getSource();

        String id = source.getId();


        loadDetailsScene(id,event);
//        Object source = event.getSource();
//        String id;
//
//        if (source instanceof Button) {
//            Button button = (Button) source;
//            id = button.getId();
//        } else if (source instanceof ImageView) {
//            AnchorPane imageView = (AnchorPane) source;
//            id = imageView.getId();
//        } else {
//            // Handle other cases where the source is neither a Button nor an ImageView
//            return;
//        }
    }

    @FXML
    private void favclick(ActionEvent event) {
   Button favoriteButton = (Button) event.getSource();
//ShowFavorites(event);
    }

    @FXML
    private void handleSearch(ActionEvent event) {
        String searchText = searchbar.getText().toLowerCase();
        String searchTextWithFirstUppercase = searchText.substring(0, 1).toUpperCase() + searchText.substring(1).toLowerCase(); //
        // Implement search functionality here
        System.out.println("Search for: " + searchText);
        try {
            // Load the FXML file for the details scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsScene.fxml"));
            Parent root = loader.load();

            // Pass the ID to the controller of the details scene
            DetailsSceneController controller = loader.getController();
            controller.setSearch(searchTextWithFirstUppercase);


            // Create a new scene
            Scene scene = new Scene(root);

            // Get the stage and set the new scene
            Stage stage = new Stage();
            stage.setTitle(searchText);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML


    private void addToFavorites(ActionEvent event) {
        // Assuming you have a reference to the favorite icon button

        //ImageView favoriteButton = (ImageView) event.getSource();
        //String pokemonId = favoriteButton.getId(); // Get the ID of the Pokémon associated with the favorite button
        Button favoriteButton2 = (Button) event.getSource();
//       String replace = id.replace(id.substring(0,3),"a");
        String id = favoriteButton2.getId();
        String modifiedId = "a" + id.substring(3);

        String pokemonId = modifiedId;
        System.out.println(pokemonId);

        try {
            // Establish connection to the databases
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            database = mongoClient.getDatabase("Pokedex");
            PokemonCollection = database.getCollection("Pokedex_Details");


            favoriteCollection = database.getCollection("Favorite");

            // Query the Pokemon_Details database to get the full information of the Pokémon based on its ID
            Document pokemonQuery = PokemonCollection.find(Filters.eq("iden", pokemonId)).first();
            Document query = new Document("iden", pokemonId);
            Document pokedocs = PokemonCollection.find(query).first();
            Document pockesearch = favoriteCollection.find(query).first();

//            if (pokedocs != null) { // Check if the Pokémon information is found
//                // Save the retrieved Pokémon information into the favorites database
//                favoriteCollection.insertOne(pokedocs);
//                showAlert("Favorite!!!!","Yeahh!! You added the pokedex to your list...");
//                System.out.println("Pokemon added to favorites!");
//            }  if(pockesearch!=null){
//                System.out.println("Pokemon not found in the Pokemon_Details database.");
//                showAlert("Favorite!!!","you have already added your pokedex to your list...");
//            }
            if (pokedocs != null) { // Check if the Pokémon information is found
                if (pockesearch == null) { // Check if the Pokémon is not already in favorites
                    // Save the retrieved Pokémon information into the favorites database
                    favoriteCollection.insertOne(pokedocs);
                    showAlert("Favorite!!!!", "Yeahh!! You added the pokedex to your list...️", "😁😁");
                    System.out.println("Pokemon added to favorites!");
                } else {
                    // Pokémon is already in favorites
                    System.out.println("Pokemon already in favorites.");
                    showAlert("Favorite!!!", "You have already added your pokedex to your list...😒😒", "😉😉");

                }
            } else {
                // Pokémon not found in the Pokemon_Details database
                System.out.println("Pokemon not found in the Pokemon_Details database.");
                showAlert("Error", "Pokemon not found.", "🤷‍♀️🤷‍♀️");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void removeFromFavorites(ActionEvent event) {
        Button favoriteButton2 = (Button) event.getSource();
//       String replace = id.replace(id.substring(0,3),"a");
        String id = favoriteButton2.getId();
        String modifiedId = "a" + id.substring(3);

        String pokemonId = modifiedId;
        System.out.println(pokemonId);

        try {
            // Establish connection to the databases
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            database = mongoClient.getDatabase("Pokedex");
            PokemonCollection = database.getCollection("Pokedex_Details");


            favoriteCollection = database.getCollection("Favorite");

            // Query the Pokemon_Details database to get the full information of the Pokémon based on its ID
            Document pokemonQuery = PokemonCollection.find(Filters.eq("iden", pokemonId)).first();
            Document query = new Document("iden", pokemonId);
            Document pokedocs = PokemonCollection.find(query).first();
            Document pockesearch = favoriteCollection.find(query).first();

//            if (pokedocs != null) { // Check if the Pokémon information is found
//                // Save the retrieved Pokémon information into the favorites database
//                favoriteCollection.insertOne(pokedocs);
//                showAlert("Favorite!!!!","Yeahh!! You added the pokedex to your list...");
//                System.out.println("Pokemon added to favorites!");
//            }  if(pockesearch!=null){
//                System.out.println("Pokemon not found in the Pokemon_Details database.");
//                showAlert("Favorite!!!","you have already added your pokedex to your list...");
//            }
            if (pokedocs != null) { // Check if the Pokémon information is found
                if (pockesearch != null) { // Check if the Pokémon is not already in favorites
                    // Save the retrieved Pokémon information into the favorites database
                    favoriteCollection.deleteOne(pokedocs);
                    showAlert("Favorite!!!!", "Yeahh!! You have deleted the pokedex to your list...️", "😁😁");
                    System.out.println("Pokemon added to favorites!");
                } else {
                    // Pokémon is already in favorites
                    System.out.println("Pokemon already in favorites.");
                    showAlert("Favorite!!!", "You have already added your pokedex to your list...😒😒", "😉😉");

                }
            } else {
                // Pokémon not found in the Pokemon_Details database
                System.out.println("Pokemon not found in the Pokemon_Details database.");
                showAlert("Error", "Pokemon not found.", "🤷‍♀️🤷‍♀️");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @FXML private void showing(ActionEvent event){
//        favoriteButton.setOnAction(event1 -> {
//            try {
//                // Establish connection to the database
//                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
//                database = mongoClient.getDatabase("Pokedex");
//                favoriteCollection = database.getCollection("Favorite");
//
//                // Retrieve all Pokémon from the favorite collection
//                for (Document pokemon : favoriteCollection.find()) {
//                    // Create a new AnchorPane for each Pokémon
//                    AnchorPane pokemonPane = new AnchorPane();
//
//                    // Load the image of the Pokémon
//                    ImageView imageView = new ImageView();
//                    // Assuming you have a method to get the image of the Pokémon from its document
//                    Image image = new Image(getPokemonImage(pokemon));
//                    imageView.setImage(image);
//                    imageView.setFitWidth(100); // Adjust image width as needed
//                    imageView.setFitHeight(100); // Adjust image height as needed
//                    AnchorPane.setTopAnchor(imageView, 10.0);
//                    AnchorPane.setLeftAnchor(imageView, 10.0);
//
//                    // Set the name of the Pokémon with big font
//                    String pokemonName = getPokemonName(pokemon);
//                    javafx.scene.text.Text nameText = new javafx.scene.text.Text(pokemonName);
//                    nameText.setStyle("-fx-font-size: 20px;"); // Set big font size
//                    AnchorPane.setBottomAnchor(nameText, 10.0);
//                    AnchorPane.setLeftAnchor(nameText, 10.0);
//
//                    // Add image and name to the AnchorPane
//                    pokemonPane.getChildren().addAll(imageView, nameText);
//
//                    // Show the AnchorPane in the new scene
//                    showPokemonInScene(pokemonPane);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//}
//
//private void showPokemonInScene(AnchorPane pokemonPane) {
//    try {
//        // Load FXML file for the scene
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("favoritesScene.fxml"));
//        Parent root = loader.load();
//
//        // Set the AnchorPane as the root of the scene
//        ((AnchorPane) root).getChildren().add(pokemonPane);
//
//        // Create a new scene and show it
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//
//// Implement methods to get Pokémon image and name from its document
//private String getPokemonImage(Document pokemon) {
//    // Implement logic to get the image of the Pokémon from its document
//    String imageUrl = pokemon.getString("image_url");
//    return  imageUrl;
//}
//
//private String getPokemonName(Document pokemon) {
//    // Implement logic to get the name of the Pokémon from its document
//    return pokemon.getString("name");
//}

//    @FXML
//    private void ShowFavorites(ActionEvent event) {
//
//            try {
//                // Load the FXML file
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("FavScene.fxml"));
//                Parent root = loader.load();
//                FavoriteController controller = loader.getController();
////                controller.initialize();
//
//                // Create a new scene
//                Scene scene = new Scene(root);
//
//                // Get the stage information
//                Stage stage = new Stage();
//
//                stage.setScene(scene);
//                stage.show();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//    }
@FXML
private void ShowFavorites(ActionEvent event) {
    try {
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("FavScene.fxml"));

        // Create a new scene
        Scene scene = new Scene(root);

        // Get the stage information
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the scene and show the stage
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}








    private Optional<ButtonType> showAlert(String title, String message,String emoji) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(emoji);
        alert.setContentText(message);
        alert.showAndWait();
        return null;
    }
//    private void alert(String title, String message,String emoji)
//    {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle(title);
//
//        // Create a Text node with emojis and a larger font size
//        Text txt = new Text(message);
//        txt.setFont(Font.font(24)); // Set font siz
//        String txt2 = txt.getText()+emoji;
//
//
//        // Create a DialogPane and set its content to the Text node
////        DialogPane dialogPane = alert.getDialogPane();
////        dialogPane.setContent(txt2);
//        alert.setContentText(txt2);
//        alert.setContentText("😒😒");
//
//
//        alert.showAndWait();
//    }

    //ekhne loadDetailsScene func e just mouse event add kre 631 no line lagaichi ekhn just details scene eo ekta back button lagbe

@FXML
    private void loadDetailsScene(String id,MouseEvent event) {

    try {
        // Load the FXML file for the details scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsScene.fxml"));
        Parent root = loader.load();

        // Pass the ID to the controller of the details scene
        DetailsSceneController controller = loader.getController();
        controller.setData(id);

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(id);
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


//    public void initialize(URL location, ResourceBundle resources) {
//        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
//        database = mongoClient.getDatabase("Pokedex");
//         PokemonCollection= database.getCollection("Pokedex_Details");
//        Document pokedocs = PokemonCollection.find().first();
//        String name = pokedocs.getString("name");
//        System.out.println("Name: " + name);
//            initialize();
//
//
//    }



}
