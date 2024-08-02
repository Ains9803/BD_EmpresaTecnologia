
package clases;

import java.sql.Date;


public class EqiposRed {
  private int ID; 
  private String direcionIP;
  private Date fechaFab;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDirecionIP() {
        return direcionIP;
    }

    public void setDirecionIP(String direcionIP) {
        this.direcionIP = direcionIP;
    }

    public Date getFechaFab() {
        return fechaFab;
    }

    public void setFechaFab(Date fechaFab) {
        this.fechaFab = fechaFab;
    }

    
}
