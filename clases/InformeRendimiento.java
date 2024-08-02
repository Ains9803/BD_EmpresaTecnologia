
package clases;

import java.sql.Date;

public class InformeRendimiento {
  private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTiempoInactiviadad() {
        return tiempoInactiviadad;
    }

    public void setTiempoInactiviadad(int tiempoInactiviadad) {
        this.tiempoInactiviadad = tiempoInactiviadad;
    }

    public int getTiempoActividad() {
        return tiempoActividad;
    }

    public void setTiempoActividad(int tiempoActividad) {
        this.tiempoActividad = tiempoActividad;
    }
  private Date fechaInicio;
  private Date fechaFin;
  private int tiempoInactiviadad;
  private int tiempoActividad;
}
