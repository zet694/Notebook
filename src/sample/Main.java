package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class Main extends Application {

    Stage window;
    TableView <Product> table;
    TextField nameInput,lastNameInput,addressInput;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("NoteBook - zet694");

        TableColumn <Product,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn <Product,String> lastNameColumn = new TableColumn<>("LastName");
        lastNameColumn.setMinWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn <Product,String> addressColumn = new TableColumn<>("Address");
        addressColumn.setMinWidth(200);
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        // Input name
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        // Input lastName
        lastNameInput = new TextField();
        lastNameInput.setPromptText("Last Name");

        // Input Address
        addressInput = new TextField();
        addressInput.setPromptText("Address");

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        // HBox
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(10);
        hbox.getChildren().addAll(nameInput,lastNameInput,addressInput,addButton,deleteButton);

        table = new TableView<>();
        table.setItems(getProducts());
        table.getColumns().addAll(nameColumn,lastNameColumn,addressColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hbox);

        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("sample/MyStyle.css");
        primaryStage.getIcons().add(new Image("http://icons.iconarchive.com/icons/hydrattz/multipurpose-alphabet/256/Letter-Z-black-icon.png"));
        window.setScene(scene);
        window.show();
    }


    // Button AddClicked
    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setLastName(lastNameInput.getText());
        product.setAddress(addressInput.getText());
        table.getItems().add(product);
        nameInput.clear();
        lastNameInput.clear();
        addressInput.clear();
    }
    // Button DeleteClicked
    public void deleteButtonClicked(){
        ObservableList <Product> productSelected, allProduct;
        allProduct = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProduct :: remove);

    }

    public ObservableList<Product> getProducts(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Виталий","Врублевский","Москва"));
        products.add(new Product("Наташа","Орлова","Питер"));
        products.add(new Product("Дмитрий","Иванов","Урал"));
        products.add(new Product("Генадий","Бочкарев","Уфа"));
        return products;
    }

}
