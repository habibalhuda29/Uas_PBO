package id.ac.upj.tif.pbo_uas;

import id.ac.upj.tif.pbo_uas.Koneksi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable{

    public Label idlabel;

    public TextField nama_text;
    public TextArea penjelasan_text;
    private Koneksi koneksi = new Koneksi();

    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, String> kolom_nama;
    @FXML
    private TableColumn<ModelTable, String> kolom_penjelasan;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    // TAMPILKAN TABLE
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showPesan();
    }

    // SELECT DATABASE TABEL
    public ObservableList<ModelTable> getOblist() {
        //QUERY SELECT
        ResultSet rs = null;
        try {
            rs = koneksi.bacaData("SELECT * from tumbuhan");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try
        {
            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("nama"), rs.getString("penjelasan"), rs.getString("id")));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return oblist;
    }

    // VARIABLE TAMPIL PESAN
    public void showPesan(){
        oblist.clear();
        ObservableList<ModelTable> list = getOblist();

        kolom_nama.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("nama"));
        kolom_penjelasan.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("penjelasan"));

        table.setItems(list);
    }
    //BUTTON SIMPAN
    public void button_simpan_onclick(ActionEvent actionEvent) {
            String addQuery = "INSERT INTO tumbuhan VALUES(NULL,'" + nama_text.getText() +
                    "','" + penjelasan_text.getText() +"')";
            koneksi.manipulasiData(addQuery);
            showPesan();
    }

    @FXML
    public void handleClick(MouseEvent event) {
        ModelTable penjelasan = table.getSelectionModel().getSelectedItem();
        idlabel.setText("" + penjelasan.getId());
        nama_text.setText("" + penjelasan.getNama());
        penjelasan_text.setText("" + penjelasan.getPenjelasan());
    }

    //BUTTON UPDATE
    public void button_update_onclick(ActionEvent actionEvent) {
        String id_text = idlabel.getText();
        String addQuery = "UPDATE tumbuhan SET nama='"+ nama_text.getText() +"', penjelasan='"+ penjelasan_text.getText() +"' WHERE id='"+ id_text +"' ";
        koneksi.manipulasiData(addQuery);
        showPesan();
    }

    //BUTTON HAPUS
    public void onClickButtonHapus(ActionEvent event){
        String idnya = idlabel.getText();
        String query = "DELETE FROM tumbuhan WHERE id= "+ idnya +"";
        int hasil = koneksi.manipulasiData(query);
        if(hasil == 1) {
            System.out.println("Data Berhasil di Dihapus!!"
            );
        }
        showPesan();
    }

    public void onClickButtonLogout(ActionEvent actionEvent) throws IOException {
        // stop = true;
        HelloApplication m = new HelloApplication();
        m.changeScene("Login_aplikasi.fxml");
    }
}