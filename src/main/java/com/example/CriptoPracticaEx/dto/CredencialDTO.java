package com.example.CriptoPracticaEx.dto;

public class CredencialDTO {
    public String dniEst;
    public String passEst;

    public CredencialDTO() {
    }

    public CredencialDTO(String dniEst, String passEst) {
        this.dniEst = dniEst;
        this.passEst = passEst;
    }

    public String getDniEst() {
        return dniEst;
    }

    public void setDniEst(String dniEst) {
        this.dniEst = dniEst;
    }

    public String getPassEst() {
        return passEst;
    }

    public void setPassEst(String passEst) {
        this.passEst = passEst;
    }
}
