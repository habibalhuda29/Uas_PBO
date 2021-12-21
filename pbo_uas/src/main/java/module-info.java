module id.ac.upj.tif.pbo_uas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens id.ac.upj.tif.pbo_uas to javafx.fxml;
    exports id.ac.upj.tif.pbo_uas;
}