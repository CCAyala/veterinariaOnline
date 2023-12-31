package com.example.veterinariaf.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="usuarios")
public class usuario {

    @Id
    private String email;

    @Column(name="nick", unique = true)
    private String nick;

    @Column(name="img")
    private String img;

    @Column(name="auth_id", unique = true)
    private String auth_id;

    @Column(name="rol")
    private String rol;

    public usuario() {
    }

    public usuario(String email, String nick, String img, String auth_id, String rol) {
        this.email = email;
        this.nick = nick;
        this.img = img;
        this.auth_id = auth_id;
        this.rol=rol;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(String auth_id) {
        this.auth_id = auth_id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}