package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.bo.custom.OrderHistoryBO;
import com.example.layeredarchitecture.bo.custom.impl.OrderHistoryBoImpl;
import com.example.layeredarchitecture.model.SearchOrderDTO;
import com.example.layeredarchitecture.view.tdm.SearchOrderTM;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchFromController {
    @FXML
    private AnchorPane root;

    @FXML
    private TableView<SearchOrderTM> tblOrder;

    @FXML
    private TableColumn<?, ?> columnOrderId;

    @FXML
    private TableColumn<?, ?> columnDate;

    @FXML
    private TableColumn<?, ?> columnCustId;

    @FXML
    private TableColumn<?, ?> columnItemCode;

    @FXML
    private TableColumn<?, ?> columnQty;

    OrderHistoryBO orderHistoryBO = new OrderHistoryBoImpl();
    @FXML
    void navigateToHome(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/com/example/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }
    public void initialize(){
        setvaluesFactory();
        loadAllOrders();
    }
    private void setvaluesFactory() {
        columnOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnCustId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        columnItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        columnQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
    }
    private void loadAllOrders() {
        tblOrder.getItems().clear();
        /*Get all orders*/
        try {
            ArrayList<SearchOrderDTO> allOrders = orderHistoryBO.getAllOrderHistory();
            for (SearchOrderDTO dto : allOrders) {
                tblOrder.getItems().add(new SearchOrderTM(dto.getOrderId(),dto.getDate(),dto.getCustomerId(), dto.getItemCode(),dto.getQtyOnHand()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }


}
