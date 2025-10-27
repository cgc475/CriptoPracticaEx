package com.example.CriptoPracticaEx.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "estudianteweb")
public class EstudianteWeb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codiEstdWeb")
    private Integer codiEstdWeb;

    @Column(name = "ndniEstdWeb", length = 50)
    private String ndniEstdWeb;

    @Column(name = "appaEstdWeb", length = 50)
    private String appaEstdWeb;

    @Column(name = "apmaEstdWeb", length = 50)
    private String apmaEstdWeb;

    @Column(name = "nombEstdWeb", length = 50)
    private String nombEstdWeb;

    @Column(name = "fechNaciEstdWeb")
    @Temporal(TemporalType.DATE)
    private Date fechNaciEstdWeb;

    @Column(name = "logiEstd", length = 100)
    private String logiEstd;

    @Column(name = "passEstd", length = 500)
    private String passEstd;

    // Getters y Setters
    public Integer getCodiEstdWeb() {
        return codiEstdWeb;
    }

    public void setCodiEstdWeb(Integer codiEstdWeb) {
        this.codiEstdWeb = codiEstdWeb;
    }

    public String getNdniEstdWeb() {
        return ndniEstdWeb;
    }

    public void setNdniEstdWeb(String ndniEstdWeb) {
        this.ndniEstdWeb = ndniEstdWeb;
    }

    public String getAppaEstdWeb() {
        return appaEstdWeb;
    }

    public void setAppaEstdWeb(String appaEstdWeb) {
        this.appaEstdWeb = appaEstdWeb;
    }

    public String getApmaEstdWeb() {
        return apmaEstdWeb;
    }

    public void setApmaEstdWeb(String apmaEstdWeb) {
        this.apmaEstdWeb = apmaEstdWeb;
    }

    public String getNombEstdWeb() {
        return nombEstdWeb;
    }

    public void setNombEstdWeb(String nombEstdWeb) {
        this.nombEstdWeb = nombEstdWeb;
    }

    public Date getFechNaciEstdWeb() {
        return fechNaciEstdWeb;
    }

    public void setFechNaciEstdWeb(Date fechNaciEstdWeb) {
        this.fechNaciEstdWeb = fechNaciEstdWeb;
    }

    public String getLogiEstd() {
        return logiEstd;
    }

    public void setLogiEstd(String logiEstd) {
        this.logiEstd = logiEstd;
    }

    public String getPassEstd() {
        return passEstd;
    }

    public void setPassEstd(String passEstd) {
        this.passEstd = passEstd;
    }
}