package elite.models;

public class User {
    private String nama;
    private String fotoProfil;
    private int exp;
    private int level;

    public void addExp(){
        exp+=10;
        if (exp>=getExpRequired()) {
            level+=1;
        }
    }

    public int getExpRequired() {
        return 30+(level-1)*10;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFotoProfil() {
        return fotoProfil;
    }

    public void setFotoProfil(String fotoProfil) {
        this.fotoProfil = fotoProfil;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public User(String nama, String fotoProfil) {
        this.nama = nama;
        this.level = 1;
        this.exp = 0;
        this.fotoProfil = fotoProfil;
    }
}


