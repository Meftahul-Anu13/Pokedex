module com.example.pokedex {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;
    requires java.desktop;
    opens com.example.pokedex to javafx.fxml;
    exports com.example.pokedex;
}
//module com.example.plantorum {
//        requires javafx.controls;
//        requires javafx.fxml;
//
//        requires org.controlsfx.controls;
//        requires com.dlsc.formsfx;
//        requires org.kordamp.bootstrapfx.core;
//        requires com.almasb.fxgl.all;
////    requires org.mongodb.driver.sync.client;
////
////    opens com.example.plantora to javafx.fxml;
////    exports com.example.plantora;
////    requires javafx.controls;
////    requires javafx.fxml;
//        requires org.mongodb.bson;
//        requires org.mongodb.driver.core;
//        requires org.mongodb.driver.sync.client;
//
//        opens com.example.plantorum to javafx.fxml;
//        exports com.example.plantorum;
//
//        }