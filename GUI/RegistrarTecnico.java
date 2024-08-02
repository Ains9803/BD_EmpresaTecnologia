package GUI;

import bd_conexion.Conexion1;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import rojerusan.RSPanelsSlider;

public class RegistrarTecnico extends javax.swing.JFrame {

    int xMouse, yMouse;
    String name = "";
    Conexion1 conectar = Conexion1.getInstancia();

    public RegistrarTecnico() {
        initComponents();
        this.setLocationRelativeTo(null);
        AdminLogin admin = new AdminLogin();
        name = AdminLogin.nombre;
        labelNombreAdmin.setText("Administrador: " + name);
        establecerFecha();
    }

    public void establecerFecha() {
        LocalDate ahora = LocalDate.now();
        Locale fechaAhora = new Locale("es", "ES");
        labelFecha.setText(ahora.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMM 'de' yyyy", fechaAhora)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        labelNombreAdmin = new javax.swing.JLabel();
        btnRegistrarTecnico = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        btnActualizarDatos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        pnlBarra = new javax.swing.JPanel();
        pnlBotonX = new javax.swing.JPanel();
        labelX = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        pnlInicio = new javax.swing.JPanel();
        labelFecha = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlRegistrarTecnico = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIDTecnico = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreTecnico = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtContrasenna = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        pnlActualizarDatos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNombreUsuario1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtNombreTecnico1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtContrasenna1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtProvincia1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtMunicipio1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtCalle1 = new javax.swing.JTextField();
        btnLimpiar1 = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        txtBuscarTecn = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaTecnico = new javax.swing.JTextArea();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(34, 36, 45));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-user-67.png"))); // NOI18N

        labelNombreAdmin.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelNombreAdmin.setForeground(new java.awt.Color(255, 255, 255));
        labelNombreAdmin.setText("Administrador: pepe");

        btnRegistrarTecnico.setText("Registrar Técnico");
        btnRegistrarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarTecnicoActionPerformed(evt);
            }
        });

        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnActualizarDatos.setText("Actualizar Datos");
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrarTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnSalir)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jPanel1.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 240, 530));

        pnlBarra.setBackground(new java.awt.Color(34, 36, 45));
        pnlBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlBarraMouseDragged(evt);
            }
        });
        pnlBarra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBarraMousePressed(evt);
            }
        });
        pnlBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBotonX.setBackground(new java.awt.Color(34, 36, 45));

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
        });

        javax.swing.GroupLayout pnlBotonXLayout = new javax.swing.GroupLayout(pnlBotonX);
        pnlBotonX.setLayout(pnlBotonXLayout);
        pnlBotonXLayout.setHorizontalGroup(
            pnlBotonXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonXLayout.createSequentialGroup()
                .addComponent(labelX, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlBotonXLayout.setVerticalGroup(
            pnlBotonXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonXLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelX, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlBarra.add(pnlBotonX, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 30, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-home-30.png"))); // NOI18N
        jLabel2.setText("Panel de Administración");
        pnlBarra.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 210, 30));

        jPanel1.add(pnlBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 982, -1));

        pnlInicio.setBackground(new java.awt.Color(56, 60, 74));
        pnlInicio.setName("pnlInicio"); // NOI18N

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelFecha.setText("Hoy es Sábado 1 de Junio  del 2024");

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-calendar-27-26.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Bienvenido al Panel de Administración ");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-monitor-52.png"))); // NOI18N

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelFecha)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInicioLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInicioLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(262, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlInicio, "card4");

        pnlRegistrarTecnico.setBackground(new java.awt.Color(56, 60, 74));
        pnlRegistrarTecnico.setName("pnlRegistrarTecnico"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BDadd.png"))); // NOI18N
        jLabel3.setText("Registrar Técnicos");

        jLabel6.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel6.setText("Ingrese el ID :");

        jLabel7.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel7.setText("Nombre de usuario :");

        jLabel8.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel8.setText("Nombre :");

        jLabel9.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel9.setText("Contraseña :");

        jLabel10.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel10.setText("Provincia :");

        jLabel11.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel11.setText("Municipio :");

        jLabel12.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel12.setText("Calle :");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegistrarTecnicoLayout = new javax.swing.GroupLayout(pnlRegistrarTecnico);
        pnlRegistrarTecnico.setLayout(pnlRegistrarTecnicoLayout);
        pnlRegistrarTecnicoLayout.setHorizontalGroup(
            pnlRegistrarTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistrarTecnicoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pnlRegistrarTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRegistrarTecnicoLayout.createSequentialGroup()
                        .addGroup(pnlRegistrarTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)
                        .addGroup(pnlRegistrarTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(pnlRegistrarTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(pnlRegistrarTecnicoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        pnlRegistrarTecnicoLayout.setVerticalGroup(
            pnlRegistrarTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarTecnicoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIDTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlRegistrarTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlRegistrarTecnicoLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegistrarTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlRegistrarTecnicoLayout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlRegistrarTecnicoLayout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNombreTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(pnlRegistrarTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        rSPanelsSlider1.add(pnlRegistrarTecnico, "card2");

        pnlActualizarDatos.setBackground(new java.awt.Color(56, 60, 74));
        pnlActualizarDatos.setName("pnlActualizarDatos"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BDactualizar.png"))); // NOI18N
        jLabel4.setText("Actualizar Datos de los Tecnicos");

        jLabel15.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel15.setText("Nombre de usuario :");

        jLabel16.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel16.setText("Nombre :");

        jLabel17.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel17.setText("Contraseña :");

        jLabel18.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel18.setText("Provincia :");

        txtProvincia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvincia1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel19.setText("Municipio :");

        jLabel20.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel20.setText("Calle :");

        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        txtBuscarTecn.setBackground(new java.awt.Color(56, 60, 74));
        txtBuscarTecn.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscarTecn.setText("Ingrese el ID del Técnico");
        txtBuscarTecn.setBorder(null);
        txtBuscarTecn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtBuscarTecnMousePressed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-24.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        txtAreaTecnico.setColumns(20);
        txtAreaTecnico.setRows(5);
        jScrollPane1.setViewportView(txtAreaTecnico);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar2.setText("Mostrar Datos");
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlActualizarDatosLayout = new javax.swing.GroupLayout(pnlActualizarDatos);
        pnlActualizarDatos.setLayout(pnlActualizarDatosLayout);
        pnlActualizarDatosLayout.setHorizontalGroup(
            pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlActualizarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlActualizarDatosLayout.createSequentialGroup()
                        .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasenna1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(26, 26, 26)
                        .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProvincia1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMunicipio1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlActualizarDatosLayout.createSequentialGroup()
                                .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreTecnico1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActualizarDatosLayout.createSequentialGroup()
                                .addComponent(txtCalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLimpiar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminar)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(29, 29, 29))))
                    .addGroup(pnlActualizarDatosLayout.createSequentialGroup()
                        .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnlActualizarDatosLayout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBuscarTecn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlActualizarDatosLayout.setVerticalGroup(
            pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlActualizarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlActualizarDatosLayout.createSequentialGroup()
                        .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProvincia1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreTecnico1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActualizarDatosLayout.createSequentialGroup()
                        .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)))
                .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMunicipio1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasenna1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlActualizarDatosLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(pnlActualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtBuscarTecn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        rSPanelsSlider1.add(pnlActualizarDatos, "card3");

        jPanel1.add(rSPanelsSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 740, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        if (!this.btnInicio.isSelected()) {
            this.btnInicio.setSelected(true);
            this.btnActualizarDatos.setSelected(false);
            this.btnRegistrarTecnico.setSelected(false);
            rSPanelsSlider1.setPanelSlider(20, pnlInicio, RSPanelsSlider.DIRECT.RIGHT);
        }
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnRegistrarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTecnicoActionPerformed
        if (!this.btnRegistrarTecnico.isSelected()) {
            this.btnInicio.setSelected(false);
            this.btnActualizarDatos.setSelected(false);
            this.btnRegistrarTecnico.setSelected(true);
            rSPanelsSlider1.setPanelSlider(20, pnlRegistrarTecnico, RSPanelsSlider.DIRECT.RIGHT);
        }
    }//GEN-LAST:event_btnRegistrarTecnicoActionPerformed

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed
        if (!this.btnActualizarDatos.isSelected()) {
            this.btnInicio.setSelected(false);
            this.btnActualizarDatos.setSelected(true);
            this.btnRegistrarTecnico.setSelected(false);
            rSPanelsSlider1.setPanelSlider(20, pnlActualizarDatos, RSPanelsSlider.DIRECT.RIGHT);
        }
    }//GEN-LAST:event_btnActualizarDatosActionPerformed

    private void pnlBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBarraMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlBarraMousePressed

    private void pnlBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBarraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_pnlBarraMouseDragged

    private void labelXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelXMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelXMouseClicked

    private void labelXMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelXMouseEntered
        pnlBotonX.setBackground(Color.red);
        labelX.setForeground(Color.decode("#22242D"));
    }//GEN-LAST:event_labelXMouseEntered

    private void labelXMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelXMouseExited
        pnlBotonX.setBackground(Color.decode("#22242D"));
        labelX.setForeground(Color.black);
    }//GEN-LAST:event_labelXMouseExited

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement insertarTecnico = conexion.prepareStatement("insert into tecnico values(?,?,?,?,?,?,?,?)");

            insertarTecnico.setString(1, txtIDTecnico.getText().trim());
            insertarTecnico.setString(2, txtNombreUsuario.getText().trim());
            insertarTecnico.setString(3, txtNombreTecnico.getText().trim());
            insertarTecnico.setString(4, txtContrasenna.getText().trim());
            insertarTecnico.setString(5, "30902");
            insertarTecnico.setString(6, txtProvincia.getText().trim());
            insertarTecnico.setString(7, txtMunicipio.getText().trim());
            insertarTecnico.setString(8, txtCalle.getText().trim());

            insertarTecnico.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Registrados");
            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);

        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtIDTecnico.setText("");
        txtNombreUsuario.setText("");
        txtNombreTecnico.setText("");
        txtContrasenna.setText("");
        txtProvincia.setText("");
        txtMunicipio.setText("");
        txtCalle.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        txtNombreUsuario1.setText("");
        txtNombreTecnico1.setText("");
        txtContrasenna1.setText("");
        txtProvincia1.setText("");
        txtMunicipio1.setText("");
        txtCalle1.setText("");

    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            Connection conexion = conectar.conectar();
            String id = txtBuscarTecn.getText().trim();
            PreparedStatement updateTecnico = conexion.prepareStatement("UPDATE tecnico SET user = ?,name = ?,password=?,provincia=?,municipio=?,calle=? WHERE id = " + id);

            updateTecnico.setString(1, txtNombreUsuario1.getText().trim());
            updateTecnico.setString(2, txtNombreTecnico1.getText().trim());
            updateTecnico.setString(3, txtContrasenna1.getText().trim());
            updateTecnico.setString(4, txtProvincia1.getText().trim());
            updateTecnico.setString(5, txtMunicipio1.getText().trim());
            updateTecnico.setString(6, txtCalle1.getText().trim());
            updateTecnico.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente!");
            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtProvincia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvincia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvincia1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement eliminarTecnico = conexion.prepareStatement("delete from tecnico WHERE id =?");
            eliminarTecnico.setString(1, txtBuscarTecn.getText().trim());
            eliminarTecnico.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente!");
            conectar.cerrarConexion();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error :" + e);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        txtAreaTecnico.setText(mostrarAERouter());
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void txtBuscarTecnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarTecnMousePressed
        if (txtBuscarTecn.getText().equals("Ingrese el ID del Técnico")) {
            txtBuscarTecn.setText("");
            txtBuscarTecn.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtBuscarTecnMousePressed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        txtAreaTecnico.setText(" ");
        try {
            Connection conexion = conectar.conectar();
            PreparedStatement buscarTecnico = conexion.prepareStatement("SELECT * FROM tecnico WHERE id = ?");
            buscarTecnico.setString(1, txtBuscarTecn.getText().trim());
            ResultSet consulta = buscarTecnico.executeQuery();

            while (consulta.next()) {
                txtAreaTecnico.append(consulta.getString(1));
                txtAreaTecnico.append("            ");
                txtAreaTecnico.append(consulta.getString(2));
                txtAreaTecnico.append("            ");
                txtAreaTecnico.append(consulta.getString(3));
                txtAreaTecnico.append("            ");
                txtAreaTecnico.append(consulta.getString(4));
                txtAreaTecnico.append("            ");
                txtAreaTecnico.append(consulta.getString(5));
                txtAreaTecnico.append("            ");
                txtAreaTecnico.append(consulta.getString(6));
                txtAreaTecnico.append("            ");
                txtAreaTecnico.append(consulta.getString(7));
                txtAreaTecnico.append("            ");
                txtAreaTecnico.append(consulta.getString(8));
                txtAreaTecnico.append("\n");
            }
            conectar.cerrarConexion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }//GEN-LAST:event_jLabel13MouseClicked
    public String mostrarAERouter() {
        StringBuilder contenido = new StringBuilder();
        contenido.append("ID                       Nombre de Usuario                       Contraseña                         Nombre                         Provincia                         Municipio                         Calle\n\n");
        txtAreaTecnico.setText(" ");
        try {

            Connection conexion = conectar.conectar();

            PreparedStatement buscarTecncico = conexion.prepareStatement("SELECT * FROM tecnico");
            ResultSet consulta = buscarTecncico.executeQuery();
            while (consulta.next()) {

                contenido.append(String.format("%-40s %-35s %-35s %-35s %-35s %-35s %-30s%n", consulta.getString(1), consulta.getString(2), consulta.getString(4), consulta.getString(3), consulta.getString(6), consulta.getString(7), consulta.getString(8)));

            }

            conectar.cerrarConexion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
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
            UIManager.put("TextComponent.arc", 999);
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarTecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarDatos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarTecnico;
    private javax.swing.JButton btnSalir;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelNombreAdmin;
    private javax.swing.JLabel labelX;
    private javax.swing.JPanel pnlActualizarDatos;
    private javax.swing.JPanel pnlBarra;
    private javax.swing.JPanel pnlBotonX;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlRegistrarTecnico;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private javax.swing.JTextArea txtAreaTecnico;
    private javax.swing.JTextField txtBuscarTecn;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCalle1;
    private javax.swing.JTextField txtContrasenna;
    private javax.swing.JTextField txtContrasenna1;
    private javax.swing.JTextField txtIDTecnico;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtMunicipio1;
    private javax.swing.JTextField txtNombreTecnico;
    private javax.swing.JTextField txtNombreTecnico1;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtNombreUsuario1;
    private javax.swing.JTextField txtProvincia;
    private javax.swing.JTextField txtProvincia1;
    // End of variables declaration//GEN-END:variables
}
