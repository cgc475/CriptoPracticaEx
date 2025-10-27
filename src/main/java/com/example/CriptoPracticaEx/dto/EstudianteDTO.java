package com.example.CriptoPracticaEx.dto;

import java.util.Date;

public class EstudianteDTO {
    public int codiEst;
    public String dniEst;
    public String apaEst;
    public String amaEst;
    public String nombEst;
    public Date fechaNaciEst;
    public String loginEst;
    public String passEst;

    // Constructor vacío
    public EstudianteDTO() {
    }

    // Constructor con parámetros
    public EstudianteDTO(int codiEst, String dniEst, String apaEst, String amaEst, String nombEst,
                         Date fechaNaciEst, String loginEst, String passEst) {
        this.codiEst = codiEst;
        this.dniEst = dniEst;
        this.apaEst = apaEst;
        this.amaEst = amaEst;
        this.nombEst = nombEst;
        this.fechaNaciEst = fechaNaciEst;
        this.loginEst = loginEst;
        this.passEst = passEst;
    }

    // Getters y Setters
    public int getCodiEst() {
        return codiEst;
    }

    public void setCodiEst(int codiEst) {
        this.codiEst = codiEst;
    }

    public String getDniEst() {
        return dniEst;
    }

    public void setDniEst(String dniEst) {
        this.dniEst = dniEst;
    }

    public String getApaEst() {
        return apaEst;
    }

    public void setApaEst(String apaEst) {
        this.apaEst = apaEst;
    }

    public String getAmaEst() {
        return amaEst;
    }

    public void setAmaEst(String amaEst) {
        this.amaEst = amaEst;
    }

    public String getNombEst() {
        return nombEst;
    }

    public void setNombEst(String nombEst) {
        this.nombEst = nombEst;
    }

    public Date getFechaNaciEst() {
        return fechaNaciEst;
    }

    public void setFechaNaciEst(Date fechaNaciEst) {
        this.fechaNaciEst = fechaNaciEst;
    }

    public String getLoginEst() {
        return loginEst;
    }

    public void setLoginEst(String loginEst) {
        this.loginEst = loginEst;
    }

    public String getPassEst() {
        return passEst;
    }

    public void setPassEst(String passEst) {
        this.passEst = passEst;
    }
}
