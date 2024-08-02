
package clases;

import java.sql.Date;


public class Rendimiento {
  private int id;
  private Date fechaRegistro;
  private int latencia;
  private double anchoBanda;
  private double usoRecurso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getLatencia() {
        return latencia;
    }

    public void setLatencia(int latencia) {
        this.latencia = latencia;
    }

    public double getAnchoBanda() {
        return anchoBanda;
    }

    public void setAnchoBanda(int anchoBanda) {
        this.anchoBanda = anchoBanda;
    }

    public double getUsoRecurso() {
        return usoRecurso;
    }

    public void setUsoRecurso(double usoRecurso) {
        this.usoRecurso = usoRecurso;
    }
  
}
