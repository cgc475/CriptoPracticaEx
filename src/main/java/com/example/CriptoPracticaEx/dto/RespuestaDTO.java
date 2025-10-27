package com.example.CriptoPracticaEx.dto;


public class RespuestaDTO {
    private String respuesta; // "ok" o "error"
    private String mensaje;
    private Object data;

    public RespuestaDTO() {}

    public RespuestaDTO(String respuesta, String mensaje, Object data) {
        this.respuesta = respuesta;
        this.mensaje = mensaje;
        this.data = data;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta= respuesta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
