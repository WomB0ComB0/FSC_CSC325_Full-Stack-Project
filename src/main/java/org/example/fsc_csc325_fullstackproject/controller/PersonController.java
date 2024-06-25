package org.example.fsc_csc325_fullstackproject.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.fsc_csc325_fullstackproject.person.Person;

import java.util.Objects;

public class PersonController {

  @FXML
  private ImageView imageView;
  @FXML
  private TableView<Person> tableView;
  @FXML
  private TableColumn<Person, Integer> idColumn;
  @FXML
  private TableColumn<Person, String> firstNameColumn;
  @FXML
  private TableColumn<Person, String> lastNameColumn;
  @FXML
  private TableColumn<Person, String> departmentColumn;
  @FXML
  private TableColumn<Person, String> majorColumn;
  @FXML
  private TableColumn<Person, String> emailColumn;
  @FXML
  private TableColumn<Person, String> imageURLColumn;
  @FXML
  private TextField txtFirstName;
  @FXML
  private TextField txtLastName;
  @FXML
  private TextField txtDepartment;
  @FXML
  private TextField txtMajor;
  @FXML
  private TextField txtEmail;
  @FXML
  private TextField txtImageURL;
  @FXML
  private Button btnClear;
  @FXML
  private Button btnAdd;
  @FXML
  private Button btnDelete;
  @FXML
  private Button btnEdit;

  private ObservableList<Person> personList;
  private int nextId = 1;

  @FXML
  private void initialize() {
    try {
      Image image = new Image(Objects.requireNonNull(getClass().getResource("/org/example/fsc_csc325_fullstackproject/images/no_profile.jpeg")).toExternalForm());
      imageView.setImage(image);
    } catch (Exception e) {
      System.err.println("Error loading image: " + e.getMessage());
    }
    personList = FXCollections.observableArrayList();
    tableView.setItems(personList);

    idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
    firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    departmentColumn.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());
    majorColumn.setCellValueFactory(cellData -> cellData.getValue().majorProperty());
    emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
    imageURLColumn.setCellValueFactory(cellData -> cellData.getValue().imageURLProperty());

    btnClear.setOnAction(e -> clearFields());

    btnAdd.setOnAction(e -> addPerson());

    btnDelete.setOnAction(e -> deletePerson());

    btnEdit.setOnAction(e -> editPerson());
  }

  private void clearFields() {
    txtFirstName.clear();
    txtLastName.clear();
    txtDepartment.clear();
    txtMajor.clear();
    txtEmail.clear();
    txtImageURL.clear();
  }

  private void addPerson() {
    String firstName = txtFirstName.getText();
    String lastName = txtLastName.getText();
    String imageUrl = txtImageURL.getText();
    String department = txtDepartment.getText();
    String major = txtMajor.getText();
    String email = txtEmail.getText();
    if (!firstName.isEmpty() && !lastName.isEmpty()) {
      loadImage(imageUrl);
      personList.add(new Person(nextId++, firstName, lastName, department, major, email, imageUrl));
      clearFields();
    }
  }

  private void deletePerson() {
    Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
    if (selectedPerson != null) {
      personList.remove(selectedPerson);
    }
  }

  private void editPerson() {
    Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
    if (selectedPerson != null) {
      selectedPerson.setFirstName(txtFirstName.getText());
      selectedPerson.setLastName(txtLastName.getText());
      selectedPerson.setDepartment(txtDepartment.getText());
      selectedPerson.setMajor(txtMajor.getText());
      selectedPerson.setEmail(txtEmail.getText());
      selectedPerson.setImageURL(txtImageURL.getText());
      tableView.refresh();
      clearFields();
    }
  }

  private void loadImage(String imageUrl) {
    try {
      Image image = new Image(imageUrl);
      imageView.setImage(image);
    } catch (Exception e) {
      System.err.println("Error loading image from URL: " + e.getMessage());
      setDefaultImage();
    }
  }

  private void setDefaultImage() {
    try {
      Image defaultImage = new Image(Objects.requireNonNull(getClass().getResource("/org/example/fsc_csc325_fullstackproject/images/no_profile.jpeg")).toExternalForm());
      imageView.setImage(defaultImage);
    } catch (Exception e) {
      System.err.println("Error loading default image: " + e.getMessage());
    }
  }
}
