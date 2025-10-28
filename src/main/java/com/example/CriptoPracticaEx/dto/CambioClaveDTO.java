package com.example.CriptoPracticaEx.dto;

public class CambioClaveDTO {
    private String dniEst;
    private String passActual;
    private String passNueva;
    private String confirmarPass;

    public CambioClaveDTO() {}

    public CambioClaveDTO(String dniEst, String passActual, String passNueva, String confirmarPass) {
        this.dniEst = dniEst;
        this.passActual = passActual;
        this.passNueva = passNueva;
        this.confirmarPass = confirmarPass;
    }

    public String getDniEst() {
        return dniEst;
    }

    public void setDniEst(String dniEst) {
        this.dniEst = dniEst;
    }

    public String getPassActual() {
        return passActual;
    }

    public void setPassActual(String passActual) {
        this.passActual = passActual;
    }

    public String getPassNueva() {
        return passNueva;
    }

    public void setPassNueva(String passNueva) {
        this.passNueva = passNueva;
    }

    public String getConfirmarPass() {
        return confirmarPass;
    }

    public void setConfirmarPass(String confirmarPass) {
        this.confirmarPass = confirmarPass;
    }
}