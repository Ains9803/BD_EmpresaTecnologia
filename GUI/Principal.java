package GUI;

import bd_conexion.Conexion1;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import rojerusan.RSPanelsSlider;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import javax.swing.UIManager;

public class Principal extends javax.swing.JFrame {

    int xMouse, yMouse;
    String nomb = "";
    JFreeChart grafica;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();
    Conexion1 conectar = Conexion1.getInstancia();

    public Principal() {

        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Principal");
        Login login = new Login();
        nomb = Login.nombre;
        labelNombreUser.setText("Usuario : " + nomb);
        txtAreaRouter.setEditable(false);
        txtAreaSwitch.setEditable(false);
        informacionRendimiento.setEditable(false);
        textAreaInformeRendimieto.setEditable(false);
        grafica = ChartFactory.createBarChart("Rendimiento por Semana",
                "", "Valores", Datos,
                PlotOrientation.VERTICAL, true, true, false);
        establecerFecha();
    }

    public void establecerFecha() {
        LocalDate ahora = LocalDate.now();
        Locale fechaAhora = new Locale("es", "ES");
        labelFecha.setText(ahora.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMM 'de' yyyy", fechaAhora)));
    }

    public void consultarBD(int n) {

        try {
            Connection conexion = conectar.conectar();
            PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM RENDIMIENTO");
            ResultSet consulta = seleccionar.executeQuery();

            ArrayList<Integer> idFKValues = new ArrayList<>();
            ArrayList<Integer> latenciaValues = new ArrayList<>();
            ArrayList<Double> anchoBandaValues = new ArrayList<>();
            ArrayList<Double> usoRecursoValues = new ArrayList<>();
            ArrayList<String> diasSemana = new ArrayList<>();

            diasSemana.add("Lunes");
            diasSemana.add("Martes");
            diasSemana.add("Miercoles");
            diasSemana.add("Jueves");
            diasSemana.add("Viernes");
            diasSemana.add("Sabado");
            diasSemana.add("Domingo");

            while (consulta.next()) {
                int idFK = Integer.parseInt(consulta.getString(2));
                int latencia = Integer.parseInt(consulta.getString(4));
                double anchoBanda = Double.parseDouble(consulta.getString(5));
                double usoRecurso = Double.parseDouble(consulta.getString(6));
                idFKValues.add(idFK);
                latenciaValues.add(latencia);
                anchoBandaValues.add(anchoBanda);
                usoRecursoValues.add(usoRecurso);
            }
            int cont = 0;

            for (int i = 0; i < idFKValues.size(); i++) {
                System.out.println(n);
                if (n == idFKValues.get(i)) {
                    if (cont < 7) {
                        System.out.println(latenciaValues.get(i));
                        Datos.addValue(latenciaValues.get(i), "Latencia", diasSemana.get(cont));
                        Datos.addValue(anchoBandaValues.get(i), "Ancho de Banda", diasSemana.get(cont));
                        Datos.addValue(usoRecursoValues.get(i), "Uso de Recurso", diasSemana.get(cont++));
                    }

                }
            }
            conectar.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAddRouter = new javax.swing.JButton();
        btnActualizarEliminarRouter = new javax.swing.JButton();
        btnActualizarEliminarSwitch = new javax.swing.JButton();
        btnInformeRendimiento = new javax.swing.JButton();
        btnEstadisticasRendimiento = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        btnaddSwitch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelNombreUser = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        btnEstadoEquipo = new javax.swing.JButton();
        jPanelBarra = new javax.swing.JPanel();
        jPanelBarraX = new javax.swing.JPanel();
        labelX = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        pnlInicio = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        pnlBtnRouter = new javax.swing.JPanel();
        labelPrueba1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIDRouter = new javax.swing.JTextField();
        txtModeloRouter = new javax.swing.JTextField();
        txtDirIPRouter = new javax.swing.JTextField();
        txtFechFabrRouter = new javax.swing.JTextField();
        btnLimpiartxtRouter = new javax.swing.JButton();
        btnAgregarRouter = new javax.swing.JButton();
        pnlBtnSwitch = new javax.swing.JPanel();
        labelPrueba2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIPSwitch = new javax.swing.JTextField();
        txtIDSwitch = new javax.swing.JTextField();
        txtFechFabSwitch = new javax.swing.JTextField();
        txtTipoSwitch = new javax.swing.JTextField();
        txtLimpiarSwitch = new javax.swing.JButton();
        btnAgregarSwitch = new javax.swing.JButton();
        pnlBtnActualizarEliminarRouter = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtModeloAERouter = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtFechaFabAERouter = new javax.swing.JTextField();
        txtIPAERouter = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaRouter = new javax.swing.JTextArea();
        txtBuscarRouter = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        labelBuscarRouter = new javax.swing.JLabel();
        btnEliminarAERouter = new javax.swing.JButton();
        btnLimpiarRouter = new javax.swing.JButton();
        btnActualizarAERouter = new javax.swing.JButton();
        btmostrarAERouter1 = new javax.swing.JButton();
        pnlBtnActualizarEliminarSwitch = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtBuscarSwitch = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtModeloAESwitch = new javax.swing.JTextField();
        btnEliminarAESwitch = new javax.swing.JButton();
        labelBuscarSwitch = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaSwitch = new javax.swing.JTextArea();
        txtFechaFabAESwitch = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtIPAESwitch = new javax.swing.JTextField();
        btnLimpiarSwitch = new javax.swing.JButton();
        btnActualizarAESwitch = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        btnMostrarDatosSwitch = new javax.swing.JButton();
        pnlBtnRgistrarRendimiento = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnGenerarGrafica = new javax.swing.JButton();
        txt_buscarRendimiento = new javax.swing.JTextField();
        labelBuscarRendimiento = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        informacionRendimiento = new javax.swing.JTextArea();
        mostrar = new javax.swing.JButton();
        registarRendimiento = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        txtfchRegistroRendimiento = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtIDRegistroRendimiento = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtLatenciaEquipo = new javax.swing.JTextField();
        txtanchoBanda = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtUsoRecurso = new javax.swing.JTextField();
        limpiarCampos = new javax.swing.JButton();
        pnlBtnInformeRendimiento = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaInformeRendimieto = new javax.swing.JTextArea();
        txtInforRendimiento = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        txtTiempoActividad = new javax.swing.JTextField();
        txtTiempoInactividad = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        btnRegistrarInfRendimiento = new javax.swing.JButton();
        btnLimiarCamposInfRendimiento = new javax.swing.JButton();
        btnIrInformes = new javax.swing.JButton();
        btnMostarDatosInfRendimiento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(34, 36, 45));

        btnAddRouter.setText("Agregar Router");
        btnAddRouter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRouterActionPerformed(evt);
            }
        });

        btnActualizarEliminarRouter.setText("Actualizar y Eliminar Router");
        btnActualizarEliminarRouter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarEliminarRouter.setName(""); // NOI18N
        btnActualizarEliminarRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEliminarRouterActionPerformed(evt);
            }
        });

        btnActualizarEliminarSwitch.setText("Actualizar y Eliminar Switch");
        btnActualizarEliminarSwitch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarEliminarSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEliminarSwitchActionPerformed(evt);
            }
        });

        btnInformeRendimiento.setText("Informe de Rendimiento");
        btnInformeRendimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInformeRendimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeRendimientoActionPerformed(evt);
            }
        });

        btnEstadisticasRendimiento.setText("Estadisticas y Rendimineto");
        btnEstadisticasRendimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstadisticasRendimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticasRendimientoActionPerformed(evt);
            }
        });

        btnInicio.setText("Inicio");
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnaddSwitch.setText("Agregar Switch");
        btnaddSwitch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnaddSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddSwitchActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-user-67.png"))); // NOI18N

        labelNombreUser.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelNombreUser.setForeground(new java.awt.Color(255, 255, 255));
        labelNombreUser.setText("Usuario : Eleiner");

        jButton1.setText("Salir");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEstadoEquipo.setText("Estado de Equipos");
        btnEstadoEquipo.setMaximumSize(new java.awt.Dimension(147, 23));
        btnEstadoEquipo.setMinimumSize(new java.awt.Dimension(147, 23));
        btnEstadoEquipo.setPreferredSize(new java.awt.Dimension(147, 23));
        btnEstadoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator11)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(labelNombreUser))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 98, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizarEliminarRouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEstadisticasRendimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInformeRendimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnaddSwitch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddRouter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarEliminarSwitch, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(btnEstadoEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNombreUser)
                .addGap(18, 18, 18)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnaddSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizarEliminarRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizarEliminarSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEstadisticasRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInformeRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEstadoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 250, 570));

        jPanelBarra.setBackground(new java.awt.Color(34, 36, 45));
        jPanelBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelBarraMouseDragged(evt);
            }
        });
        jPanelBarra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelBarraMousePressed(evt);
            }
        });

        jPanelBarraX.setBackground(new java.awt.Color(34, 36, 45));

        labelX.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        labelX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelX.setText("X");
        labelX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelXMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelXMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelXMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelXMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBarraXLayout = new javax.swing.GroupLayout(jPanelBarraX);
        jPanelBarraX.setLayout(jPanelBarraXLayout);
        jPanelBarraXLayout.setHorizontalGroup(
            jPanelBarraXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraXLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelBarraXLayout.setVerticalGroup(
            jPanelBarraXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraXLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-home-30.png"))); // NOI18N
        jLabel1.setText("Principal");

        javax.swing.GroupLayout jPanelBarraLayout = new javax.swing.GroupLayout(jPanelBarra);
        jPanelBarra.setLayout(jPanelBarraLayout);
        jPanelBarraLayout.setHorizontalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 724, Short.MAX_VALUE)
                .addComponent(jPanelBarraX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelBarraLayout.setVerticalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBarraX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanelBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 30));

        rSPanelsSlider1.setBackground(new java.awt.Color(255, 255, 255));

        pnlInicio.setBackground(new java.awt.Color(56, 60, 74));
        pnlInicio.setName("pnlInicio"); // NOI18N

        jLabel14.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-router-64.png"))); // NOI18N
        jLabel14.setText("Bienvenido al Sistema de Gestion de Equipos de Red ");

        jPanel3.setBackground(new java.awt.Color(89, 95, 118));

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel29.setText("Descrpción :");

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Sistema de Gestion para las Empresas de Tecnología. Control y administración de forma óptima y facil del los ");

        jLabel33.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("equipos de red.");

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Esta herraminta le permitira llevar un control completo y detallado de todos los equipos de la empresa, tendra ac-");

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("ceso a herramientas especiales para tareas esecíficas como lo son:");

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("-Registro y actualización de equipos. ");

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("-Monitoreo y estadísticas de rendimiento.");

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("-Generación de informes de rendimiento.");

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("-Emision de alerts de fallos.");

        jLabel40.setBackground(new java.awt.Color(0, 0, 0));
        jLabel40.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel40.setText("Servicios :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel35)
                            .addComponent(jLabel30)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addGap(4, 4, 4)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addGap(11, 11, 11)
                .addComponent(jLabel39)
                .addGap(120, 120, 120))
        );

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelFecha.setText("Hoy es Sábado 1 de Junio  del 2024");

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-calendar-27-26.png"))); // NOI18N

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelFecha)
                .addGap(22, 22, 22))
            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioLayout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        rSPanelsSlider1.add(pnlInicio, "card6");

        pnlBtnRouter.setBackground(new java.awt.Color(56, 60, 74));
        pnlBtnRouter.setName("pnlBtnRouter"); // NOI18N

        labelPrueba1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        labelPrueba1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrueba1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BDadd.png"))); // NOI18N
        labelPrueba1.setText("Agergar Nuevos Router");

        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel3.setText("Dirección IP : ");

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel4.setText("ID del dispositivo : ");

        jLabel5.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel5.setText("Fecha Fabricación :");

        jLabel6.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel6.setText("Modelo :");

        txtIDRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDRouterActionPerformed(evt);
            }
        });

        btnLimpiartxtRouter.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiartxtRouter.setText("Limpiar");
        btnLimpiartxtRouter.setMaximumSize(new java.awt.Dimension(79, 23));
        btnLimpiartxtRouter.setMinimumSize(new java.awt.Dimension(79, 23));
        btnLimpiartxtRouter.setPreferredSize(new java.awt.Dimension(79, 23));
        btnLimpiartxtRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiartxtRouterActionPerformed(evt);
            }
        });

        btnAgregarRouter.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarRouter.setText("Agregar");
        btnAgregarRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRouterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnRouterLayout = new javax.swing.GroupLayout(pnlBtnRouter);
        pnlBtnRouter.setLayout(pnlBtnRouterLayout);
        pnlBtnRouterLayout.setHorizontalGroup(
            pnlBtnRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(labelPrueba1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBtnRouterLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlBtnRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBtnRouterLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnAgregarRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiartxtRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBtnRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlBtnRouterLayout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechFabrRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBtnRouterLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(38, 38, 38)
                            .addComponent(txtIDRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlBtnRouterLayout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModeloRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlBtnRouterLayout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDirIPRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(328, Short.MAX_VALUE))
        );
        pnlBtnRouterLayout.setVerticalGroup(
            pnlBtnRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnRouterLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPrueba1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addGroup(pnlBtnRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBtnRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechFabrRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBtnRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModeloRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBtnRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDirIPRouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(pnlBtnRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiartxtRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        rSPanelsSlider1.add(pnlBtnRouter, "card2");

        pnlBtnSwitch.setBackground(new java.awt.Color(56, 60, 74));
        pnlBtnSwitch.setName("panelBtnSwitch"); // NOI18N

        labelPrueba2.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        labelPrueba2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrueba2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BDadd.png"))); // NOI18N
        labelPrueba2.setText("Agragar Nuevos Swicth");

        jLabel7.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel7.setText("Dirección IP :");

        jLabel8.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel8.setText("ID del dispositivo :");

        jLabel9.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel9.setText("Fecha de Fabricación :");

        jLabel10.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel10.setText("Tipo de switch : ");

        txtLimpiarSwitch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtLimpiarSwitch.setText("Limpiar");
        txtLimpiarSwitch.setMaximumSize(new java.awt.Dimension(79, 23));
        txtLimpiarSwitch.setMinimumSize(new java.awt.Dimension(79, 23));
        txtLimpiarSwitch.setPreferredSize(new java.awt.Dimension(79, 23));
        txtLimpiarSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLimpiarSwitchActionPerformed(evt);
            }
        });

        btnAgregarSwitch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarSwitch.setText("Agregar");
        btnAgregarSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSwitchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnSwitchLayout = new javax.swing.GroupLayout(pnlBtnSwitch);
        pnlBtnSwitch.setLayout(pnlBtnSwitchLayout);
        pnlBtnSwitchLayout.setHorizontalGroup(
            pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnSwitchLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlBtnSwitchLayout.createSequentialGroup()
                .addComponent(labelPrueba2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlBtnSwitchLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBtnSwitchLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechFabSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlBtnSwitchLayout.createSequentialGroup()
                            .addComponent(btnAgregarSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtLimpiarSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBtnSwitchLayout.createSequentialGroup()
                            .addGroup(pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIPSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTipoSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIDSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBtnSwitchLayout.setVerticalGroup(
            pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnSwitchLayout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPrueba2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addGroup(pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechFabSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnSwitchLayout.createSequentialGroup()
                        .addGroup(pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLimpiarSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnSwitchLayout.createSequentialGroup()
                        .addGroup(pnlBtnSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIPSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113))))
        );

        rSPanelsSlider1.add(pnlBtnSwitch, "card1");

        pnlBtnActualizarEliminarRouter.setBackground(new java.awt.Color(56, 60, 74));
        pnlBtnActualizarEliminarRouter.setName("pnalBtnActualizarEliminarRouter"); // NOI18N

        jLabel16.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel16.setText("Fecha Fabricación :");

        jLabel17.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel17.setText("Dirección IP : ");

        jLabel18.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel18.setText("Modelo :");

        jLabel11.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BDactualizar.png"))); // NOI18N
        jLabel11.setText("Actualizar y Eliminar Router");

        txtAreaRouter.setColumns(20);
        txtAreaRouter.setRows(5);
        jScrollPane1.setViewportView(txtAreaRouter);

        txtBuscarRouter.setBackground(new java.awt.Color(56, 60, 74));
        txtBuscarRouter.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscarRouter.setText("Ingrese el ID");
        txtBuscarRouter.setBorder(null);
        txtBuscarRouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtBuscarRouterMousePressed(evt);
            }
        });
        txtBuscarRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarRouterActionPerformed(evt);
            }
        });

        labelBuscarRouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-24.png"))); // NOI18N
        labelBuscarRouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBuscarRouterMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelBuscarRouterMousePressed(evt);
            }
        });

        btnEliminarAERouter.setText("Eliminar");
        btnEliminarAERouter.setMaximumSize(new java.awt.Dimension(79, 23));
        btnEliminarAERouter.setMinimumSize(new java.awt.Dimension(79, 23));
        btnEliminarAERouter.setPreferredSize(new java.awt.Dimension(79, 23));
        btnEliminarAERouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAERouterActionPerformed(evt);
            }
        });

        btnLimpiarRouter.setText("Limpiar");
        btnLimpiarRouter.setMaximumSize(new java.awt.Dimension(79, 23));
        btnLimpiarRouter.setMinimumSize(new java.awt.Dimension(79, 23));
        btnLimpiarRouter.setPreferredSize(new java.awt.Dimension(79, 23));
        btnLimpiarRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarRouterActionPerformed(evt);
            }
        });

        btnActualizarAERouter.setText("Actualizar");
        btnActualizarAERouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAERouterActionPerformed(evt);
            }
        });

        btmostrarAERouter1.setText("Mostrar Datos");
        btmostrarAERouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmostrarAERouter1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnActualizarEliminarRouterLayout = new javax.swing.GroupLayout(pnlBtnActualizarEliminarRouter);
        pnlBtnActualizarEliminarRouter.setLayout(pnlBtnActualizarEliminarRouterLayout);
        pnlBtnActualizarEliminarRouterLayout.setHorizontalGroup(
            pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBtnActualizarEliminarRouterLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBtnActualizarEliminarRouterLayout.createSequentialGroup()
                        .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaFabAERouter, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBtnActualizarEliminarRouterLayout.createSequentialGroup()
                                .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModeloAERouter, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIPAERouter, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(btnActualizarAERouter, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarAERouter, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiarRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnActualizarEliminarRouterLayout.createSequentialGroup()
                        .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(pnlBtnActualizarEliminarRouterLayout.createSequentialGroup()
                                .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator8)
                                    .addGroup(pnlBtnActualizarEliminarRouterLayout.createSequentialGroup()
                                        .addComponent(labelBuscarRouter)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBuscarRouter)))
                                .addGap(246, 246, 246)
                                .addComponent(btmostrarAERouter1)))
                        .addGap(29, 29, 29))))
        );
        pnlBtnActualizarEliminarRouterLayout.setVerticalGroup(
            pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnActualizarEliminarRouterLayout.createSequentialGroup()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBtnActualizarEliminarRouterLayout.createSequentialGroup()
                        .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBuscarRouter)
                            .addComponent(labelBuscarRouter, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btmostrarAERouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaFabAERouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIPAERouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtModeloAERouter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBtnActualizarEliminarRouterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizarAERouter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarAERouter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpiarRouter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        rSPanelsSlider1.add(pnlBtnActualizarEliminarRouter, "card3");

        pnlBtnActualizarEliminarSwitch.setBackground(new java.awt.Color(56, 60, 74));
        pnlBtnActualizarEliminarSwitch.setName("pnalBtnActualizarEliminarSwitch"); // NOI18N

        jLabel15.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BDactualizar.png"))); // NOI18N
        jLabel15.setText("Actualizar y Eliminar Switch");

        txtBuscarSwitch.setBackground(new java.awt.Color(56, 60, 74));
        txtBuscarSwitch.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscarSwitch.setText("Ingrese el ID");
        txtBuscarSwitch.setBorder(null);
        txtBuscarSwitch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtBuscarSwitchMousePressed(evt);
            }
        });
        txtBuscarSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarSwitchActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel21.setText("Fecha Fabricación :");

        btnEliminarAESwitch.setText("Eliminar");
        btnEliminarAESwitch.setMaximumSize(new java.awt.Dimension(79, 23));
        btnEliminarAESwitch.setMinimumSize(new java.awt.Dimension(79, 23));
        btnEliminarAESwitch.setPreferredSize(new java.awt.Dimension(79, 23));
        btnEliminarAESwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAESwitchActionPerformed(evt);
            }
        });

        labelBuscarSwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-24.png"))); // NOI18N
        labelBuscarSwitch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBuscarSwitchMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelBuscarSwitchMousePressed(evt);
            }
        });

        txtAreaSwitch.setColumns(20);
        txtAreaSwitch.setRows(5);
        jScrollPane2.setViewportView(txtAreaSwitch);

        jLabel23.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel23.setText("Tipo de Switch :");

        jLabel22.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel22.setText("Dirección IP : ");

        btnLimpiarSwitch.setText("Limpiar");
        btnLimpiarSwitch.setMaximumSize(new java.awt.Dimension(79, 23));
        btnLimpiarSwitch.setMinimumSize(new java.awt.Dimension(79, 23));
        btnLimpiarSwitch.setPreferredSize(new java.awt.Dimension(79, 23));
        btnLimpiarSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSwitchActionPerformed(evt);
            }
        });

        btnActualizarAESwitch.setText("Actualizar");
        btnActualizarAESwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAESwitchActionPerformed(evt);
            }
        });

        btnMostrarDatosSwitch.setText("Mostrar Datos");
        btnMostrarDatosSwitch.setMaximumSize(new java.awt.Dimension(79, 23));
        btnMostrarDatosSwitch.setMinimumSize(new java.awt.Dimension(79, 23));
        btnMostrarDatosSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDatosSwitchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnActualizarEliminarSwitchLayout = new javax.swing.GroupLayout(pnlBtnActualizarEliminarSwitch);
        pnlBtnActualizarEliminarSwitch.setLayout(pnlBtnActualizarEliminarSwitchLayout);
        pnlBtnActualizarEliminarSwitchLayout.setHorizontalGroup(
            pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator7)
            .addGroup(pnlBtnActualizarEliminarSwitchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBtnActualizarEliminarSwitchLayout.createSequentialGroup()
                        .addGroup(pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBtnActualizarEliminarSwitchLayout.createSequentialGroup()
                                .addComponent(labelBuscarSwitch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarSwitch)))
                        .addGap(274, 274, 274)
                        .addComponent(btnMostrarDatosSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(pnlBtnActualizarEliminarSwitchLayout.createSequentialGroup()
                        .addGroup(pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlBtnActualizarEliminarSwitchLayout.createSequentialGroup()
                                .addGroup(pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIPAESwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaFabAESwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlBtnActualizarEliminarSwitchLayout.createSequentialGroup()
                                        .addComponent(txtModeloAESwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnActualizarAESwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminarAESwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLimpiarSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(14, Short.MAX_VALUE))))
        );
        pnlBtnActualizarEliminarSwitchLayout.setVerticalGroup(
            pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnActualizarEliminarSwitchLayout.createSequentialGroup()
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBtnActualizarEliminarSwitchLayout.createSequentialGroup()
                        .addGroup(pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBuscarSwitch)
                            .addComponent(labelBuscarSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBtnActualizarEliminarSwitchLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnMostrarDatosSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBtnActualizarEliminarSwitchLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtFechaFabAESwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIPAESwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBtnActualizarEliminarSwitchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarAESwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarAESwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModeloAESwitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlBtnActualizarEliminarSwitch, "card8");

        pnlBtnRgistrarRendimiento.setBackground(new java.awt.Color(56, 60, 74));
        pnlBtnRgistrarRendimiento.setName("pnlBtnRgistrarRendimiento"); // NOI18N
        pnlBtnRgistrarRendimiento.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                pnlBtnRgistrarRendimientoComponentRemoved(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BDadd.png"))); // NOI18N
        jLabel12.setText("Registrar y Generar Gráfica de Estadisticas de Rendimineto ");

        btnGenerarGrafica.setText("Generar Grafico");
        btnGenerarGrafica.setMaximumSize(new java.awt.Dimension(79, 23));
        btnGenerarGrafica.setMinimumSize(new java.awt.Dimension(79, 23));
        btnGenerarGrafica.setPreferredSize(new java.awt.Dimension(79, 23));
        btnGenerarGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarGraficaActionPerformed(evt);
            }
        });

        txt_buscarRendimiento.setBackground(new java.awt.Color(56, 60, 74));
        txt_buscarRendimiento.setForeground(new java.awt.Color(204, 204, 204));
        txt_buscarRendimiento.setText("Ingrese el ID del Equipo");
        txt_buscarRendimiento.setBorder(null);
        txt_buscarRendimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_buscarRendimientoMousePressed(evt);
            }
        });
        txt_buscarRendimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarRendimientoActionPerformed(evt);
            }
        });
        txt_buscarRendimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscarRendimientoKeyTyped(evt);
            }
        });

        labelBuscarRendimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-24.png"))); // NOI18N
        labelBuscarRendimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBuscarRendimientoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelBuscarRendimientoMousePressed(evt);
            }
        });

        informacionRendimiento.setColumns(20);
        informacionRendimiento.setRows(5);
        jScrollPane3.setViewportView(informacionRendimiento);

        mostrar.setText("Mostrar Datos");
        mostrar.setMaximumSize(new java.awt.Dimension(79, 23));
        mostrar.setMinimumSize(new java.awt.Dimension(79, 23));
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });

        registarRendimiento.setText("Registar");
        registarRendimiento.setMaximumSize(new java.awt.Dimension(79, 23));
        registarRendimiento.setMinimumSize(new java.awt.Dimension(79, 23));
        registarRendimiento.setPreferredSize(new java.awt.Dimension(79, 23));
        registarRendimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registarRendimientoActionPerformed(evt);
            }
        });

        jLabel20.setText("Fecha de Registro :");

        jLabel24.setText("Ingrese el ID :");

        jLabel26.setText("Latencia del equipo :");

        jLabel27.setText("Ancho de banda :");

        jLabel28.setText("Uso de Recurso :");

        limpiarCampos.setText("Limpiar");
        limpiarCampos.setMaximumSize(new java.awt.Dimension(79, 23));
        limpiarCampos.setMinimumSize(new java.awt.Dimension(79, 23));
        limpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnRgistrarRendimientoLayout = new javax.swing.GroupLayout(pnlBtnRgistrarRendimiento);
        pnlBtnRgistrarRendimiento.setLayout(pnlBtnRgistrarRendimientoLayout);
        pnlBtnRgistrarRendimientoLayout.setHorizontalGroup(
            pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                                .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                                        .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel20)
                                            .addComponent(txtIDRegistroRendimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(txtfchRegistroRendimiento))
                                        .addGap(26, 26, 26)
                                        .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(txtLatenciaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                                                .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel27)
                                                    .addComponent(txtanchoBanda, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                                                .addGap(28, 28, 28)
                                                .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel28)
                                                    .addComponent(txtUsoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                                        .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                                                .addComponent(labelBuscarRendimiento)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_buscarRendimiento)))
                                        .addGap(214, 214, 214)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registarRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGenerarGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlBtnRgistrarRendimientoLayout.setVerticalGroup(
            pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                        .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelBuscarRendimiento)
                            .addComponent(txt_buscarRendimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(txtanchoBanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(txtIDRegistroRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(txtfchRegistroRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnRgistrarRendimientoLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(txtLatenciaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBtnRgistrarRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registarRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlBtnRgistrarRendimiento, "card4");

        pnlBtnInformeRendimiento.setBackground(new java.awt.Color(56, 60, 74));
        pnlBtnInformeRendimiento.setName("pnlBtnInformeRendimiento"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-health-graph-50.png"))); // NOI18N
        jLabel13.setText("Crear Informe de Rendimineto");

        textAreaInformeRendimieto.setColumns(20);
        textAreaInformeRendimieto.setRows(5);
        jScrollPane4.setViewportView(textAreaInformeRendimieto);

        txtInforRendimiento.setBackground(new java.awt.Color(56, 60, 74));
        txtInforRendimiento.setForeground(new java.awt.Color(204, 204, 204));
        txtInforRendimiento.setText("Ingrese el ID del Equipo");
        txtInforRendimiento.setBorder(null);
        txtInforRendimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtInforRendimientoMousePressed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-24.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        txtTiempoActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoActividadActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel31.setText("Tiempo de actividad del equipo : ");

        jLabel32.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel32.setText("Tiempo de Inactividad del equipo :");

        btnRegistrarInfRendimiento.setText("Registrar");
        btnRegistrarInfRendimiento.setMaximumSize(new java.awt.Dimension(79, 23));
        btnRegistrarInfRendimiento.setMinimumSize(new java.awt.Dimension(79, 23));
        btnRegistrarInfRendimiento.setPreferredSize(new java.awt.Dimension(79, 23));
        btnRegistrarInfRendimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarInfRendimientoActionPerformed(evt);
            }
        });

        btnLimiarCamposInfRendimiento.setText("Limpiar");
        btnLimiarCamposInfRendimiento.setMaximumSize(new java.awt.Dimension(79, 23));
        btnLimiarCamposInfRendimiento.setMinimumSize(new java.awt.Dimension(79, 23));
        btnLimiarCamposInfRendimiento.setPreferredSize(new java.awt.Dimension(79, 23));
        btnLimiarCamposInfRendimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimiarCamposInfRendimientoActionPerformed(evt);
            }
        });

        btnIrInformes.setText("Ir a Informes");
        btnIrInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrInformesActionPerformed(evt);
            }
        });

        btnMostarDatosInfRendimiento.setText("Ver Equipos");
        btnMostarDatosInfRendimiento.setMaximumSize(new java.awt.Dimension(79, 23));
        btnMostarDatosInfRendimiento.setMinimumSize(new java.awt.Dimension(79, 23));
        btnMostarDatosInfRendimiento.setPreferredSize(new java.awt.Dimension(79, 23));
        btnMostarDatosInfRendimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostarDatosInfRendimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnInformeRendimientoLayout = new javax.swing.GroupLayout(pnlBtnInformeRendimiento);
        pnlBtnInformeRendimiento.setLayout(pnlBtnInformeRendimientoLayout);
        pnlBtnInformeRendimientoLayout.setHorizontalGroup(
            pnlBtnInformeRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBtnInformeRendimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnInformeRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnInformeRendimientoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrarInfRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimiarCamposInfRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIrInformes))
                    .addGroup(pnlBtnInformeRendimientoLayout.createSequentialGroup()
                        .addGroup(pnlBtnInformeRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTiempoInactividad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBtnInformeRendimientoLayout.createSequentialGroup()
                                .addGroup(pnlBtnInformeRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel31))
                                .addGap(38, 38, 38)
                                .addComponent(txtTiempoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlBtnInformeRendimientoLayout.createSequentialGroup()
                        .addGroup(pnlBtnInformeRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBtnInformeRendimientoLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtInforRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMostarDatosInfRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlBtnInformeRendimientoLayout.setVerticalGroup(
            pnlBtnInformeRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnInformeRendimientoLayout.createSequentialGroup()
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBtnInformeRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBtnInformeRendimientoLayout.createSequentialGroup()
                        .addGroup(pnlBtnInformeRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtInforRendimiento)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMostarDatosInfRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBtnInformeRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTiempoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(pnlBtnInformeRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTiempoInactividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(pnlBtnInformeRendimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarInfRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimiarCamposInfRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIrInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        rSPanelsSlider1.add(pnlBtnInformeRendimiento, "card5");

        jPanel1.add(rSPanelsSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 660, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void labelXMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelXMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelXMousePressed

    private void jPanelBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBarraMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanelBarraMousePressed

    private void jPanelBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBarraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanelBarraMouseDragged

    private void labelXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelXMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelXMouseClicked

    private void labelXMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelXMouseEntered
        jPanelBarraX.setBackground(Color.red);
        labelX.setForeground(Color.decode("#22242D"));
    }//GEN-LAST:event_labelXMouseEntered

    private void labelXMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelXMouseExited
        jPanelBarraX.setBackground(Color.decode("#22242D"));
        labelX.setForeground(Color.black);
    }//GEN-LAST:event_labelXMouseExited

    private void btnAddRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRouterActionPerformed
        if (!this.btnAddRouter.isSelected()) {
            this.btnAddRouter.setSelected(true);
            this.btnaddSwitch.setSelected(false);
            this.btnActualizarEliminarRouter.setSelected(false);
            this.btnActualizarEliminarSwitch.setSelected(false);
            this.btnEstadisticasRendimiento.setSelected(false);
            this.btnInformeRendimiento.setSelected(false);
            this.btnInicio.setSelected(false);
            rSPanelsSlider1.setPanelSlider(20, pnlBtnRouter, RSPanelsSlider.DIRECT.RIGHT);

        }
    }//GEN-LAST:event_btnAddRouterActionPerformed

    private void btnaddSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddSwitchActionPerformed
        if (!this.btnaddSwitch.isSelected()) {
            this.btnAddRouter.setSelected(false);
            this.btnaddSwitch.setSelected(true);
            this.btnActualizarEliminarRouter.setSelected(false);
            this.btnActualizarEliminarSwitch.setSelected(false);
            this.btnEstadisticasRendimiento.setSelected(false);
            this.btnInformeRendimiento.setSelected(false);
            this.btnInicio.setSelected(false);
            rSPanelsSlider1.setPanelSlider(20, pnlBtnSwitch, RSPanelsSlider.DIRECT.RIGHT);

        }
    }//GEN-LAST:event_btnaddSwitchActionPerformed

    private void txtIDRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDRouterActionPerformed

    }//GEN-LAST:event_txtIDRouterActionPerformed

    private void btnActualizarEliminarRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEliminarRouterActionPerformed
        if (!this.btnActualizarEliminarRouter.isSelected()) {
            this.btnAddRouter.setSelected(false);
            this.btnaddSwitch.setSelected(false);
            this.btnActualizarEliminarRouter.setSelected(true);
            this.btnActualizarEliminarSwitch.setSelected(false);
            this.btnEstadisticasRendimiento.setSelected(false);
            this.btnInformeRendimiento.setSelected(false);
            this.btnInicio.setSelected(false);
            rSPanelsSlider1.setPanelSlider(20, pnlBtnActualizarEliminarRouter, RSPanelsSlider.DIRECT.RIGHT);
        }
    }//GEN-LAST:event_btnActualizarEliminarRouterActionPerformed

    private void btnEstadisticasRendimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticasRendimientoActionPerformed
        if (!this.btnEstadisticasRendimiento.isSelected()) {
            this.btnAddRouter.setSelected(false);
            this.btnaddSwitch.setSelected(false);
            this.btnActualizarEliminarRouter.setSelected(false);
            this.btnActualizarEliminarSwitch.setSelected(false);
            this.btnEstadisticasRendimiento.setSelected(true);
            this.btnInformeRendimiento.setSelected(false);
            this.btnInicio.setSelected(false);
            rSPanelsSlider1.setPanelSlider(20, pnlBtnRgistrarRendimiento, RSPanelsSlider.DIRECT.RIGHT);
        }
    }//GEN-LAST:event_btnEstadisticasRendimientoActionPerformed

    private void btnInformeRendimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeRendimientoActionPerformed
        if (!this.btnInformeRendimiento.isSelected()) {
            this.btnAddRouter.setSelected(false);
            this.btnaddSwitch.setSelected(false);
            this.btnActualizarEliminarRouter.setSelected(false);
            this.btnActualizarEliminarSwitch.setSelected(false);
            this.btnEstadisticasRendimiento.setSelected(false);
            this.btnInformeRendimiento.setSelected(true);
            this.btnInicio.setSelected(false);
            rSPanelsSlider1.setPanelSlider(20, pnlBtnInformeRendimiento, RSPanelsSlider.DIRECT.RIGHT);
        }
    }//GEN-LAST:event_btnInformeRendimientoActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        if (!this.btnInicio.isSelected()) {
            this.btnAddRouter.setSelected(false);
            this.btnaddSwitch.setSelected(false);
            this.btnActualizarEliminarRouter.setSelected(false);
            this.btnActualizarEliminarSwitch.setSelected(false);
            this.btnEstadisticasRendimiento.setSelected(false);
            this.btnInformeRendimiento.setSelected(false);
            this.btnInicio.setSelected(true);
            rSPanelsSlider1.setPanelSlider(20, pnlInicio, RSPanelsSlider.DIRECT.RIGHT);
        }
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnActualizarEliminarSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEliminarSwitchActionPerformed
        if (!this.btnActualizarEliminarSwitch.isSelected()) {
            this.btnAddRouter.setSelected(false);
            this.btnaddSwitch.setSelected(false);
            this.btnActualizarEliminarRouter.setSelected(false);
            this.btnActualizarEliminarSwitch.setSelected(true);
            this.btnEstadisticasRendimiento.setSelected(false);
            this.btnInformeRendimiento.setSelected(false);
            this.btnInicio.setSelected(false);
            rSPanelsSlider1.setPanelSlider(20, pnlBtnActualizarEliminarSwitch, RSPanelsSlider.DIRECT.RIGHT);
        }
    }//GEN-LAST:event_btnActualizarEliminarSwitchActionPerformed

    private void txtBuscarRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarRouterActionPerformed

    }//GEN-LAST:event_txtBuscarRouterActionPerformed

    private void txtBuscarRouterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarRouterMousePressed
        if (txtBuscarRouter.getText().equals("Ingrese el ID")) {
            txtBuscarRouter.setText("");
            txtBuscarRouter.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtBuscarRouterMousePressed

    private void txtBuscarSwitchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarSwitchMousePressed
        if (txtBuscarSwitch.getText().equals("Ingrese el ID")) {
            txtBuscarSwitch.setText("");
            txtBuscarSwitch.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtBuscarSwitchMousePressed

    private void txtBuscarSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarSwitchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarSwitchActionPerformed

    private void btnGenerarGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarGraficaActionPerformed
        ChartPanel Panel = new ChartPanel(grafica);
        JFrame Ventana = new JFrame("Estadísticas de Rendimiento");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
        int idAux = 0;
        if (evt.getSource() == btnGenerarGrafica) {
            String idFKString = String.valueOf(this.txt_buscarRendimiento.getText().trim());
            if (!idFKString.isEmpty()) {
                idAux = Integer.parseInt(idFKString);
            } else {
                idAux = 0;
            }

        }

        consultarBD(idAux);
    }//GEN-LAST:event_btnGenerarGraficaActionPerformed

    private void txt_buscarRendimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarRendimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarRendimientoActionPerformed

    private void txt_buscarRendimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarRendimientoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarRendimientoKeyTyped

    private void labelBuscarRendimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBuscarRendimientoMouseClicked
        informacionRendimiento.setText(" ");
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement buscar = conexion.prepareStatement("SELECT * FROM equipos_red WHERE id_equipo = ?");
            buscar.setString(1, txt_buscarRendimiento.getText().trim());

            ResultSet consulta = buscar.executeQuery();

            while (consulta.next()) {
                informacionRendimiento.append(consulta.getString(1));
                informacionRendimiento.append(" ");
                informacionRendimiento.append(consulta.getString(2));
                informacionRendimiento.append(" ");
                informacionRendimiento.append(consulta.getString(3));
                informacionRendimiento.append("\n");
            }
            conectar.cerrarConexion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }//GEN-LAST:event_labelBuscarRendimientoMouseClicked

    private void txt_buscarRendimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_buscarRendimientoMousePressed
        if (txt_buscarRendimiento.getText().equals("Ingrese el ID del Equipo")) {
            txt_buscarRendimiento.setText("");
            txt_buscarRendimiento.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_buscarRendimientoMousePressed

    private void labelBuscarRendimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBuscarRendimientoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBuscarRendimientoMousePressed

    private void labelBuscarRouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBuscarRouterMouseClicked
        txtAreaRouter.setText(" ");
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement buscar = conexion.prepareStatement("SELECT * FROM equipos_red WHERE id_equipo = ?");
            PreparedStatement buscarRouter = conexion.prepareStatement("SELECT modelo FROM router WHERE id_equipo_fk = ?");
            buscar.setString(1, txtBuscarRouter.getText().trim());
            buscarRouter.setString(1, txtBuscarRouter.getText().trim());
            ResultSet consulta = buscar.executeQuery();
            ResultSet consulta1 = buscarRouter.executeQuery();

            while (consulta.next() && consulta1.next()) {
                txtAreaRouter.append(consulta.getString(1));
                txtAreaRouter.append("            ");
                txtAreaRouter.append(consulta1.getString(1));
                txtAreaRouter.append("            ");
                txtAreaRouter.append(consulta.getString(2));
                txtAreaRouter.append("            ");
                txtAreaRouter.append(consulta.getString(3));
                txtAreaRouter.append("\n");
            }
            conectar.cerrarConexion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }//GEN-LAST:event_labelBuscarRouterMouseClicked

    private void btnAgregarRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRouterActionPerformed
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement insertarEquipo = conexion.prepareStatement("insert into equipos_red values(?,?,?)");
            PreparedStatement insertarRouter = conexion.prepareStatement("insert into router values(?,?)");
            insertarEquipo.setString(1, txtIDRouter.getText().trim());
            insertarEquipo.setString(2, txtDirIPRouter.getText().trim());
            insertarEquipo.setString(3, txtFechFabrRouter.getText().trim());
            insertarRouter.setString(1, txtIDRouter.getText().trim());
            insertarRouter.setString(2, txtModeloRouter.getText().trim());
            insertarEquipo.executeUpdate();
            insertarRouter.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Registrados");
            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);

        }
    }//GEN-LAST:event_btnAgregarRouterActionPerformed

    private void txtTiempoActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempoActividadActionPerformed

    private void btnIrInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrInformesActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informe().setVisible(true);
            }
        });
    }//GEN-LAST:event_btnIrInformesActionPerformed

    private void btnLimpiartxtRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiartxtRouterActionPerformed
        txtIDRouter.setText(" ");
        txtDirIPRouter.setText(" ");
        txtFechFabrRouter.setText(" ");
        txtModeloRouter.setText(" ");
    }//GEN-LAST:event_btnLimpiartxtRouterActionPerformed

    private void btnAgregarSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSwitchActionPerformed
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement insertarEquipo = conexion.prepareStatement("insert into equipos_red values(?,?,?)");
            PreparedStatement insertarSwitch = conexion.prepareStatement("insert into switch values(?,?)");
            insertarEquipo.setString(1, txtIDSwitch.getText().trim());
            insertarEquipo.setString(2, txtIPSwitch.getText().trim());
            insertarEquipo.setString(3, txtFechFabSwitch.getText().trim());
            insertarSwitch.setString(2, txtTipoSwitch.getText().trim());
            insertarSwitch.setString(1, txtIDSwitch.getText().trim());
            insertarEquipo.executeUpdate();
            insertarSwitch.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Registrados");
            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);

        }
    }//GEN-LAST:event_btnAgregarSwitchActionPerformed

    private void btnActualizarAERouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAERouterActionPerformed
        try {
            Connection conexion = conectar.conectar();
            String id = txtBuscarRouter.getText().trim();
            PreparedStatement updateEquipo = conexion.prepareStatement("UPDATE equipos_red SET direcion_ip = ?,fechaFab = ? WHERE id_equipo = ?");
            PreparedStatement updateRouter = conexion.prepareStatement("UPDATE router SET modelo = ? WHERE id_equipo_fk = ?");

            updateEquipo.setString(1, txtIPAERouter.getText().trim());
            updateEquipo.setString(2, txtFechaFabAERouter.getText().trim());
            updateEquipo.setString(3, id);
            updateRouter.setString(1, txtModeloAERouter.getText().trim());
            updateRouter.setString(2, id);

            updateEquipo.executeUpdate();
            updateRouter.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente!");
            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_btnActualizarAERouterActionPerformed

    private void labelBuscarRouterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBuscarRouterMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBuscarRouterMousePressed

    private void pnlBtnRgistrarRendimientoComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_pnlBtnRgistrarRendimientoComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlBtnRgistrarRendimientoComponentRemoved

    private void labelBuscarSwitchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBuscarSwitchMouseClicked
        txtAreaSwitch.setText(" ");
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement buscar = conexion.prepareStatement("SELECT * FROM equipos_red WHERE id_equipo = ?");
            PreparedStatement buscarRouter = conexion.prepareStatement("SELECT tipoSwitch FROM switch WHERE id_equipo_fk = ?");
            buscar.setString(1, txtBuscarSwitch.getText().trim());
            buscarRouter.setString(1, txtBuscarSwitch.getText().trim());
            ResultSet consulta = buscar.executeQuery();
            ResultSet consulta1 = buscarRouter.executeQuery();

            while (consulta.next() && consulta1.next()) {
                txtAreaSwitch.append(consulta.getString(1));
                txtAreaSwitch.append("            ");
                txtAreaSwitch.append(consulta1.getString(1));
                txtAreaSwitch.append("            ");
                txtAreaSwitch.append(consulta.getString(2));
                txtAreaSwitch.append("            ");
                txtAreaSwitch.append(consulta.getString(3));
                txtAreaSwitch.append("\n");
            }
            conectar.cerrarConexion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }//GEN-LAST:event_labelBuscarSwitchMouseClicked

    private void labelBuscarSwitchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBuscarSwitchMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelBuscarSwitchMousePressed

    private void btnActualizarAESwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAESwitchActionPerformed
        try {
            Connection conexion = conectar.conectar();
            String id = txtBuscarSwitch.getText().trim();
            PreparedStatement updateEquipo = conexion.prepareStatement("UPDATE equipos_red SET direcion_ip = ?,fechaFab = ? WHERE id_equipo = ?");
            PreparedStatement updateSwitch = conexion.prepareStatement("UPDATE switch SET tipoSwitch = ? WHERE id_equipo_fk = ?");

            updateEquipo.setString(1, txtIPAESwitch.getText().trim());
            updateEquipo.setString(2, txtFechaFabAESwitch.getText().trim());
            updateEquipo.setString(3, id);
            updateSwitch.setString(1, txtModeloAESwitch.getText().trim());
            updateSwitch.setString(2, id);

            updateEquipo.executeUpdate();
            updateSwitch.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente!");
            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_btnActualizarAESwitchActionPerformed

    private void btnEliminarAERouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAERouterActionPerformed
        try {
            Connection conexion = conectar.conectar();

            PreparedStatement eliminarInformeRendimiento = conexion.prepareStatement("DELETE FROM informe_rendimiento WHERE id_equipo = ?");
            eliminarInformeRendimiento.setString(1, txtBuscarRouter.getText().trim());
            eliminarInformeRendimiento.executeUpdate();

            PreparedStatement eliminarRendimiento = conexion.prepareStatement("DELETE FROM rendimiento WHERE id_equipo = ?");
            eliminarRendimiento.setString(1, txtBuscarRouter.getText().trim());
            eliminarRendimiento.executeUpdate();

            PreparedStatement eliminarRouter = conexion.prepareStatement("delete from router WHERE id_equipo_fk =?");
            eliminarRouter.setString(1, txtBuscarRouter.getText().trim());
            eliminarRouter.executeUpdate();

            PreparedStatement eliminar = conexion.prepareStatement("delete from equipos_red WHERE id_equipo = ?");
            eliminar.setString(1, txtBuscarRouter.getText().trim());
            eliminar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente!");
            conectar.cerrarConexion();

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error :" + e);
        }
    }//GEN-LAST:event_btnEliminarAERouterActionPerformed

    private void btnEliminarAESwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAESwitchActionPerformed
        try {
            Connection conexion = conectar.conectar();

            PreparedStatement eliminarInformeRendimiento = conexion.prepareStatement("DELETE FROM informe_rendimiento WHERE id_equipo = ?");
            eliminarInformeRendimiento.setString(1, txtBuscarRouter.getText().trim());
            eliminarInformeRendimiento.executeUpdate();

            PreparedStatement eliminarRendimiento = conexion.prepareStatement("DELETE FROM rendimiento WHERE id_equipo = ?");
            eliminarRendimiento.setString(1, txtBuscarRouter.getText().trim());
            eliminarRendimiento.executeUpdate();

            PreparedStatement eliminarSwitch = conexion.prepareStatement("delete from switch WHERE id_equipo_fk =?");
            eliminarSwitch.setString(1, txtBuscarSwitch.getText().trim());
            eliminarSwitch.executeUpdate();

            PreparedStatement eliminar = conexion.prepareStatement("delete from equipos_red WHERE id_equipo = ?");
            eliminar.setString(1, txtBuscarSwitch.getText().trim());
            eliminar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente!");
            conectar.cerrarConexion();

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error :" + e);
        }
    }//GEN-LAST:event_btnEliminarAESwitchActionPerformed

    private void btnLimpiarSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSwitchActionPerformed
        txtFechaFabAESwitch.setText(" ");
        txtIPAESwitch.setText(" ");
        txtModeloAESwitch.setText(" ");
    }//GEN-LAST:event_btnLimpiarSwitchActionPerformed

    private void btnLimpiarRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarRouterActionPerformed
        txtFechaFabAERouter.setText(" ");
        txtIPAERouter.setText(" ");
        txtModeloAERouter.setText(" ");
    }//GEN-LAST:event_btnLimpiarRouterActionPerformed

    private void txtLimpiarSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLimpiarSwitchActionPerformed
        txtFechFabSwitch.setText(" ");
        txtIDSwitch.setText(" ");
        txtTipoSwitch.setText(" ");
        txtIPSwitch.setText(" ");
    }//GEN-LAST:event_txtLimpiarSwitchActionPerformed

    private void limpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarCamposActionPerformed
        txtIDRegistroRendimiento.setText(" ");
        txtanchoBanda.setText(" ");
        txtfchRegistroRendimiento.setText(" ");
        txtLatenciaEquipo.setText(" ");
        txtUsoRecurso.setText(" ");
    }//GEN-LAST:event_limpiarCamposActionPerformed

    private void registarRendimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registarRendimientoActionPerformed
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement agregarRendimiento = conexion.prepareStatement("insert into rendimiento values(?,?,?,?,?,?)");

            agregarRendimiento.setString(1, txtIDRegistroRendimiento.getText().trim());
            agregarRendimiento.setString(2, txt_buscarRendimiento.getText().trim());
            agregarRendimiento.setString(3, txtfchRegistroRendimiento.getText().trim());
            agregarRendimiento.setString(4, txtLatenciaEquipo.getText().trim());
            agregarRendimiento.setString(5, txtanchoBanda.getText().trim());
            agregarRendimiento.setString(6, txtUsoRecurso.getText().trim());
            agregarRendimiento.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Registrados");
            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);

        }
    }//GEN-LAST:event_registarRendimientoActionPerformed

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        informacionRendimiento.setText(mostrarEstadisticasRendimiento());
    }//GEN-LAST:event_mostrarActionPerformed

    private void btmostrarAERouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmostrarAERouter1ActionPerformed
        txtAreaRouter.setText(mostrarAERouter());
    }//GEN-LAST:event_btmostrarAERouter1ActionPerformed

    private void btnMostrarDatosSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDatosSwitchActionPerformed
        txtAreaSwitch.setText(mostrarDatosSwitch());
    }//GEN-LAST:event_btnMostrarDatosSwitchActionPerformed

    private void txtInforRendimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtInforRendimientoMousePressed
        if (txtInforRendimiento.getText().equals("Ingrese el ID del Equipo")) {
            txtInforRendimiento.setText("");
            txtInforRendimiento.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtInforRendimientoMousePressed

    private void btnLimiarCamposInfRendimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimiarCamposInfRendimientoActionPerformed
        txtTiempoActividad.setText(" ");
        txtTiempoInactividad.setText(" ");
    }//GEN-LAST:event_btnLimiarCamposInfRendimientoActionPerformed

    private void btnMostarDatosInfRendimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarDatosInfRendimientoActionPerformed

        textAreaInformeRendimieto.setText(mostarDatosInfRendimiento());

    }//GEN-LAST:event_btnMostarDatosInfRendimientoActionPerformed

    private void btnRegistrarInfRendimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarInfRendimientoActionPerformed
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement insertarInformeRendimiento = conexion.prepareStatement("insert into informe_rendimiento values(?,?,?,?)");
            insertarInformeRendimiento.setString(1, "0");
            insertarInformeRendimiento.setString(2, txtInforRendimiento.getText().trim());
            insertarInformeRendimiento.setString(3, txtTiempoActividad.getText().trim());
            insertarInformeRendimiento.setString(4, txtTiempoInactividad.getText().trim());
            insertarInformeRendimiento.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos Registrados");
            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);

        }
    }//GEN-LAST:event_btnRegistrarInfRendimientoActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        textAreaInformeRendimieto.setText(" ");
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement buscar = conexion.prepareStatement("SELECT * FROM equipos_red WHERE id_equipo = ?");
            buscar.setString(1, txtInforRendimiento.getText().trim());

            ResultSet consulta = buscar.executeQuery();

            while (consulta.next()) {
                textAreaInformeRendimieto.append(consulta.getString(1));
                textAreaInformeRendimieto.append("                ");
                textAreaInformeRendimieto.append(consulta.getString(2));
                textAreaInformeRendimieto.append("                ");
                textAreaInformeRendimieto.append(consulta.getString(3));
                textAreaInformeRendimieto.append("\n");
            }
            conectar.cerrarConexion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEstadoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoEquipoActionPerformed
        mostrarAlerta();
    }//GEN-LAST:event_btnEstadoEquipoActionPerformed

    private void mostrarAlerta() {
        String falla = obtenerFallaEquipo(generarIDEquipoAleatorio());

        JOptionPane.showMessageDialog(this, "¡Alerta de Falla!\n\nEquipo: Equipo de Red\nFalla: " + falla, "Alerta", JOptionPane.WARNING_MESSAGE);
    }

    private String obtenerFallaEquipo(String idEquipo) {
        String falla = "";

        try {
            Connection connection = conectar.conectar();
            PreparedStatement seleccionar = connection.prepareStatement("SELECT tipo_alerta FROM alertas WHERE id_equipo = ? ORDER BY fecha DESC LIMIT 1");
            seleccionar.setString(1, idEquipo);
            ResultSet consulta = seleccionar.executeQuery();

            if (consulta.next()) {
                falla = consulta.getString("tipo_alerta");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error :" + e);
        }

        return falla;
    }

    private String generarIDEquipoAleatorio() {
        Random random = new Random();
        int idEquipo = random.nextInt(50) + 1;
        return String.valueOf(idEquipo);
    }

    public String mostarDatosInfRendimiento() {
        StringBuilder contenido = new StringBuilder();
        contenido.append("Fecha de Fabricación                       Dirección IP                        ID del Equipo\n\n");
        textAreaInformeRendimieto.setText(" ");
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM equipos_red");
            ResultSet consulta = seleccionar.executeQuery();

            while (consulta.next()) {
                contenido.append(String.format("%-50s%-42s%-17s%n", consulta.getString(3), consulta.getString(2), consulta.getString(1)));

            }
            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }

        return contenido.toString();
    }

    public String mostrarAERouter() {
        StringBuilder contenido = new StringBuilder();
        contenido.append("Fecha de Fabricación                       Dirección IP                       ID del Router                         Modelo\n\n");
        txtAreaRouter.setText(" ");
        try {
            boolean existe = false;
            Connection conexion = conectar.conectar();

            PreparedStatement buscarRouter = conexion.prepareStatement("SELECT * FROM router");
            ResultSet consulta1 = buscarRouter.executeQuery();
            while (consulta1.next()) {
                PreparedStatement buscar = conexion.prepareStatement("SELECT * FROM equipos_red WHERE id_equipo='" + consulta1.getString(1) + "'");
                ResultSet consulta = buscar.executeQuery();
                if (consulta.next()) {
                    existe = true;
                    if (existe == true) {
                        String aux = consulta.getString(1);
                        String aux1 = consulta1.getString(1);
                        System.out.println(aux);
                        System.out.println(aux1);
                        if (consulta.getString(1).equals(consulta1.getString(1))) {

                            contenido.append(String.format("%-50s%-40s%-37s%-37s%n", consulta.getString(3), consulta.getString(2), consulta.getString(1), consulta1.getString(2)));

                        }
                    }
                }
            }

            conectar.cerrarConexion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return contenido.toString();
    }

    public String mostrarDatosSwitch() {
        StringBuilder contenido = new StringBuilder();
        contenido.append("ID del Switch                            Tipo de Switch                         Dirección IP                       Fecha de Fabricación\n\n");
        txtAreaSwitch.setText(" ");
        try {
            boolean existe = false;
            Connection conexion = conectar.conectar();

            PreparedStatement buscarSwitch = conexion.prepareStatement("SELECT * FROM switch");
            ResultSet consulta1 = buscarSwitch.executeQuery();
            while (consulta1.next()) {
                PreparedStatement buscar = conexion.prepareStatement("SELECT * FROM equipos_red WHERE id_equipo='" + consulta1.getString(1) + "'");
                ResultSet consulta = buscar.executeQuery();
                if (consulta.next()) {
                    existe = true;
                    if (existe == true) {
                        String aux = consulta.getString(1);
                        String aux1 = consulta1.getString(1);
                        System.out.println(aux);
                        System.out.println(aux1);
                        if (consulta.getString(1).equals(consulta1.getString(1))) {
                            contenido.append(String.format("%-50s%-42s%-37s%-37s%n", consulta.getString(1), consulta1.getString(2), consulta.getString(2), consulta.getString(3)));
                        }
                    }
                }
            }

            conectar.cerrarConexion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return contenido.toString();
    }

    public String mostrarEstadisticasRendimiento() {
        StringBuilder contenido = new StringBuilder();
        contenido.append("ID Rendimiento               ID del Equipo               Fecha de Registro                   Latencia                  Ancho de Banda                     Uso de Recurso\n\n");
        informacionRendimiento.setText(" ");
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement seleccionar = conexion.prepareStatement("SELECT * FROM RENDIMIENTO");
            ResultSet consulta = seleccionar.executeQuery();

            while (consulta.next()) {
                contenido.append(String.format("%-45s%-40s%-40s%-40s%-40s%-40s%n", consulta.getString(1), consulta.getString(2), consulta.getString(3), consulta.getString(4), consulta.getString(5), consulta.getString(6)));
            }
            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
        return contenido.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            FlatArcDarkOrangeIJTheme.setup();
            UIManager.put("Button.arc", 999);
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmostrarAERouter1;
    private javax.swing.JButton btnActualizarAERouter;
    private javax.swing.JButton btnActualizarAESwitch;
    private javax.swing.JButton btnActualizarEliminarRouter;
    private javax.swing.JButton btnActualizarEliminarSwitch;
    private javax.swing.JButton btnAddRouter;
    private javax.swing.JButton btnAgregarRouter;
    private javax.swing.JButton btnAgregarSwitch;
    private javax.swing.JButton btnEliminarAERouter;
    private javax.swing.JButton btnEliminarAESwitch;
    private javax.swing.JButton btnEstadisticasRendimiento;
    private javax.swing.JButton btnEstadoEquipo;
    private javax.swing.JButton btnGenerarGrafica;
    private javax.swing.JButton btnInformeRendimiento;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnIrInformes;
    private javax.swing.JButton btnLimiarCamposInfRendimiento;
    private javax.swing.JButton btnLimpiarRouter;
    private javax.swing.JButton btnLimpiarSwitch;
    private javax.swing.JButton btnLimpiartxtRouter;
    private javax.swing.JButton btnMostarDatosInfRendimiento;
    private javax.swing.JButton btnMostrarDatosSwitch;
    private javax.swing.JButton btnRegistrarInfRendimiento;
    private javax.swing.JButton btnaddSwitch;
    private javax.swing.JTextArea informacionRendimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelBarra;
    private javax.swing.JPanel jPanelBarraX;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel labelBuscarRendimiento;
    private javax.swing.JLabel labelBuscarRouter;
    private javax.swing.JLabel labelBuscarSwitch;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelNombreUser;
    private javax.swing.JLabel labelPrueba1;
    private javax.swing.JLabel labelPrueba2;
    private javax.swing.JLabel labelX;
    private javax.swing.JButton limpiarCampos;
    private javax.swing.JButton mostrar;
    private javax.swing.JPanel pnlBtnActualizarEliminarRouter;
    private javax.swing.JPanel pnlBtnActualizarEliminarSwitch;
    private javax.swing.JPanel pnlBtnInformeRendimiento;
    private javax.swing.JPanel pnlBtnRgistrarRendimiento;
    private javax.swing.JPanel pnlBtnRouter;
    private javax.swing.JPanel pnlBtnSwitch;
    private javax.swing.JPanel pnlInicio;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private javax.swing.JButton registarRendimiento;
    private javax.swing.JTextArea textAreaInformeRendimieto;
    private javax.swing.JTextArea txtAreaRouter;
    private javax.swing.JTextArea txtAreaSwitch;
    private javax.swing.JTextField txtBuscarRouter;
    private javax.swing.JTextField txtBuscarSwitch;
    private javax.swing.JTextField txtDirIPRouter;
    private javax.swing.JTextField txtFechFabSwitch;
    private javax.swing.JTextField txtFechFabrRouter;
    private javax.swing.JTextField txtFechaFabAERouter;
    private javax.swing.JTextField txtFechaFabAESwitch;
    private javax.swing.JTextField txtIDRegistroRendimiento;
    private javax.swing.JTextField txtIDRouter;
    private javax.swing.JTextField txtIDSwitch;
    private javax.swing.JTextField txtIPAERouter;
    private javax.swing.JTextField txtIPAESwitch;
    private javax.swing.JTextField txtIPSwitch;
    private javax.swing.JTextField txtInforRendimiento;
    private javax.swing.JTextField txtLatenciaEquipo;
    private javax.swing.JButton txtLimpiarSwitch;
    private javax.swing.JTextField txtModeloAERouter;
    private javax.swing.JTextField txtModeloAESwitch;
    private javax.swing.JTextField txtModeloRouter;
    private javax.swing.JTextField txtTiempoActividad;
    private javax.swing.JTextField txtTiempoInactividad;
    private javax.swing.JTextField txtTipoSwitch;
    private javax.swing.JTextField txtUsoRecurso;
    private javax.swing.JTextField txt_buscarRendimiento;
    private javax.swing.JTextField txtanchoBanda;
    private javax.swing.JTextField txtfchRegistroRendimiento;
    // End of variables declaration//GEN-END:variables
}
