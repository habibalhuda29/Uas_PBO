package id.ac.upj.tif.pbo_uas;

public class ModelTable {
    String id;
    String nama, penjelasan;

    public ModelTable(String nama, String penjelasan, String id) {
        this.id = id;
        this.nama = nama;
        this.penjelasan = penjelasan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }
}
