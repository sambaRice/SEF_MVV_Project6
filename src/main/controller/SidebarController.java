package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SidebarController {

    @FXML
    public void displayProject(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/project.fxml"));

        Parent project = loader.load();

        Scene scene = new Scene(project);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);

        ProjectController projectController = loader.<ProjectController>getController();
        //projectController.setUsername(this.username);

        window.show();
    }

    @FXML
    public void displayEmployee(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/employee.fxml"));

        Parent project = loader.load();

        Scene scene = new Scene(project);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);

        EmployeeController employeeController = loader.<EmployeeController>getController();
        //employeeController.setUsername(this.username);

        window.show();
    }

    @FXML
    public void displayCalendar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/calendar.fxml"));

        Parent project = loader.load();

        Scene scene = new Scene(project);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);

        CalendarController calendarController = loader.<CalendarController>getController();
        //calendarController.setUsername(this.username);

        window.show();
    }

    @FXML
    public void logoutUser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/login.fxml"));

        Parent project = loader.load();

        Scene scene = new Scene(project);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);

        LoginController loginController = loader.<LoginController>getController();

        window.show();
    }
}