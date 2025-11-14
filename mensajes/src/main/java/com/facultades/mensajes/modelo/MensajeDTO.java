package com.facultades.mensajes.modelo;



import java.util.Date;

public class MensajeDTO{
    private Long id;
    private String contenido;
    private Long idEmisor;
    private Long idReceptor;
    private Date fecha;
    private boolean leida;



    public String getContenido() {
        return contenido;
    }

    public MensajeDTO(Long id, Long idEmisor, String contenido, Long idReceptor, Date fecha, boolean leida) {
        this.id = id;
        this.idEmisor = idEmisor;
        this.contenido = contenido;
        this.idReceptor = idReceptor;
        this.fecha = fecha;
        this.leida = leida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(Long idEmisor) {
        this.idEmisor = idEmisor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(Long idReceptor) {
        this.idReceptor = idReceptor;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }
}
