package controller;

import com.sun.xml.bind.v2.runtime.property.Property;
import modell.Player;
import org.hibernate.Session;
import org.hibernate.sql.Select;
import sample.MyApplication;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.jar.Attributes;
import javax.persistence.*;
import modell.Player;


/**
 * Az eredménytáblát kezelő modell.controller.
 */
public class ScoreController implements Initializable{

    /**
     * Kilépést kezelő gomb.
     */
    @FXML
    private Button closebutton = new Button();

    @FXML
    private TextArea T10;

    @FXML
    private TextArea T11;

    @FXML
    private TextArea T20;

    @FXML
    private TextArea T21;

    @FXML
    private TextArea T30;

    @FXML
    private TextArea T31;

    @FXML
    private TextArea T40;

    @FXML
    private TextArea T41;

    @FXML
    private TableView<Player> ScoreTable;

    @FXML
    private TableColumn NameColumn;

    @FXML
    private TableColumn StepColumn;




    private ObservableList<Player> PlayerData = FXCollections.observableArrayList();
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public String getName(Player np){
        return np.getName();
    }

    public Integer getSteps(Player sp){
        return sp.getSteps();
    }



    @Override
    @FXML
    public final void initialize(
            final URL location, final ResourceBundle resources) {
        closebutton.setOnAction(e -> Platform.exit());

        initcolumns();
        ScoreTable.setItems(getPlayerData());




        emf= Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
        em=emf.createEntityManager();



        TypedQuery query = em.createQuery ("SELECT asd FROM modell.Player asd",modell.Player.class);

        List<Player> list = query.getResultList();
        PlayerData.addAll(list);
        ScoreTable.setEditable(true);
        ScoreTable.getItems().addAll(PlayerData);

    }

    private void initcolumns() {
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        StepColumn.setCellValueFactory(new PropertyValueFactory<>("steps"));

    }

    private ObservableList<Player> data;
    public ObservableList<Player> getPlayerData(){
        data= FXCollections.observableArrayList();

        return data;
    }



}

