
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Kernel extends javax.swing.JFrame {
    DefaultTableModel modeEntrada = new DefaultTableModel();
    DefaultTableModel modeMemoria = new DefaultTableModel();
    DefaultTableModel modeRegistros = new DefaultTableModel();
    DefaultTableModel modeSalida = new DefaultTableModel();
    int x;
    String registros[]=new String [3];
    String salida[]=new String [1];
    public Kernel() {
        initComponents();
        iniciarTablas();
        x=Integer.parseInt(String.valueOf(spTiempo.getNextValue()));
        spTiempo.setEnabled(false);
        textCpu.setEditable(false);
        tbMemoria.setEnabled(false);
        tbRegistros.setEnabled(false);
        tbSalida.setEnabled(false);
    }
    
    public void ingresar(){
        if(Integer.parseInt(spTiempo.getValue().toString())<=Integer.parseInt(String.valueOf(tbEntrada.getValueAt(tbEntrada.getRowCount()-1, 2)))){ //Validar si existen mas elementos en la tabla principal
            if(spTiempo.getValue().toString().equals(tbEntrada.getValueAt((Integer)spTiempo.getValue(), 2))){ //Valida el tiempo de entrada
                if(textCpu.getText().equals("")){ //Verifica si esta ocupado el CPU
                    if(tbMemoria.getRowCount()==0){
                        textCpu.setText(tbEntrada.getValueAt((Integer)spTiempo.getValue(), 0).toString());
                        registros[0]=(String) tbEntrada.getValueAt((Integer)spTiempo.getValue(), 0);
                        registros[1]="CPU";
                        registros[2]=(String) tbEntrada.getValueAt((Integer)spTiempo.getValue(), 1);
                        modeRegistros.addRow(registros);
                    }else{
                        for (int i = 0; i < tbRegistros.getRowCount(); i++) {
                            if(tbRegistros.getValueAt(i, 0).equals(tbMemoria.getValueAt(0, 0))){
                                tbRegistros.setValueAt("CPU", i, 1);
                            }
                        }
                        textCpu.setText(String.valueOf(tbMemoria.getValueAt(0, 0)));
                        modeMemoria.removeRow(0);
                    }
                }else{
                    String B[]=new String [1];
                    B[0]=tbEntrada.getValueAt((Integer)spTiempo.getValue(), 0).toString();
                    modeMemoria.addRow(B);
                    registros[0]=(String) tbEntrada.getValueAt((Integer)spTiempo.getValue(), 0);
                    registros[1]="Memoria";
                    registros[2]=(String) tbEntrada.getValueAt((Integer)spTiempo.getValue(), 1);
                    modeRegistros.addRow(registros);
                }
            }
        }else{
            if(textCpu.getText().equals("")){ //Verifica si esta ocupado el CPU
                if(tbMemoria.getRowCount()>0){
                    for (int i = 0; i < tbRegistros.getRowCount(); i++) {
                        if(tbRegistros.getValueAt(i, 0).equals(tbMemoria.getValueAt(0, 0))){
                            tbRegistros.setValueAt("CPU", i, 1);
                        }
                    }
                    textCpu.setText(String.valueOf(tbMemoria.getValueAt(0, 0)));
                    modeMemoria.removeRow(0);
                }else{
                    spTiempo.setEnabled(false);
                }
            }
        }
    }
    
    public void iniciarTablas(){
        String A[]=new String[3];
        modeEntrada.addColumn("PID"); modeEntrada.addColumn("Duracion"); modeEntrada.addColumn("Llegada");
        tbEntrada.setModel(modeEntrada);
        A[0]="P1"; A[1]="2"; A[2]="0";
        modeEntrada.addRow(A);
        A[0]="P2"; A[1]="3"; A[2]="1";
        modeEntrada.addRow(A);
        A[0]="P3"; A[1]="5"; A[2]="2";
        modeEntrada.addRow(A);
        A[0]="P4"; A[1]="1"; A[2]="3";
        modeEntrada.addRow(A);
        A[0]="P5"; A[1]="2"; A[2]="4";
        modeEntrada.addRow(A);
        
        modeMemoria.addColumn("M");
        tbMemoria.setModel(modeMemoria);
        
        modeSalida.addColumn("S");
        tbSalida.setModel(modeSalida);
        
        modeRegistros.addColumn("PID"); modeRegistros.addColumn("Estado"); modeRegistros.addColumn("Duracion");
        tbRegistros.setModel(modeRegistros);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbEntrada = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        spTiempo = new javax.swing.JSpinner();
        textCpu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMemoria = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbRegistros = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbSalida = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(695, 450));
        getContentPane().setLayout(null);

        tbEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbEntrada);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 170, 340);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tiempo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(194, 10, 60, 14);

        spTiempo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spTiempoStateChanged(evt);
            }
        });
        getContentPane().add(spTiempo);
        spTiempo.setBounds(190, 30, 70, 40);

        textCpu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(textCpu);
        textCpu.setBounds(360, 30, 100, 50);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CPU");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 10, 100, 14);

        tbMemoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbMemoria);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(190, 110, 70, 240);

        tbRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbRegistros);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(270, 110, 280, 240);

        tbSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbSalida);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(562, 10, 70, 340);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tabla de Registros");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 84, 280, 20);

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 360, 170, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spTiempoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spTiempoStateChanged
        if(Integer.parseInt(String.valueOf(spTiempo.getValue()))>=0){
            if(Integer.parseInt(String.valueOf(spTiempo.getValue()))==x){
                if(textCpu.getText().length()>=0){
                    for (int i = 0; i < tbRegistros.getRowCount(); i++) {
                        if(tbRegistros.getValueAt(i, 0).equals(textCpu.getText())&&tbRegistros.getValueAt(i, 1).equals("CPU")){
                            String valor=String.valueOf(Integer.parseInt(String.valueOf(tbRegistros.getValueAt(i, 2)))-1);
                            modeRegistros.setValueAt(valor, i, 2);
                        }
                    }
                }
                for (int i = 0; i < tbRegistros.getRowCount(); i++) {
                    if(tbRegistros.getValueAt(i, 2).equals("0")&&tbRegistros.getValueAt(i, 1).equals("CPU")){
                        String valor="Salida";
                        modeRegistros.setValueAt(valor, i, 1);
                        salida[0]=String.valueOf(tbRegistros.getValueAt(i, 0)); 
                        modeSalida.addRow(salida);
                        tbSalida.setModel(modeSalida);
                        textCpu.setText("");
                        ingresar();
                   }
                }
                ingresar();
                x++;
            } else {
                x--;
            }
        }
    }//GEN-LAST:event_spTiempoStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ingresar();
        spTiempo.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Kernel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kernel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kernel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kernel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kernel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner spTiempo;
    private javax.swing.JTable tbEntrada;
    private javax.swing.JTable tbMemoria;
    private javax.swing.JTable tbRegistros;
    private javax.swing.JTable tbSalida;
    private javax.swing.JTextField textCpu;
    // End of variables declaration//GEN-END:variables
}
