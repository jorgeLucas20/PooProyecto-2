module com.mycompany.projectgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.projectgame to javafx.fxml;
    exports com.mycompany.projectgame;
}
