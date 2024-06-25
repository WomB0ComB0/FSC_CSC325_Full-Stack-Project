package org.example.fsc_csc325_fullstackproject.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.fsc_csc325_fullstackproject.person.Person;

public class PersonController {

  @FXML
  private ImageView imageView;
  @FXML
  private TableView<Person> tableView;
  @FXML
  private TableColumn<Person, String> firstNameColumn;
  @FXML
  private TableColumn<Person, String> lastNameColumn;
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

  @FXML
  private void initialize() {
    imageView.setImage(new Image("/fsc_csc325_fullstackproject/src/main/resources/images/no_profile.jpg"));

    personList = FXCollections.observableArrayList();
    tableView.setItems(personList);

    firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

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
    if (!firstName.isEmpty() && !lastName.isEmpty()) {
      personList.add(new Person(firstName, lastName));
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
      tableView.refresh();
      clearFields();
    }
  }
}
