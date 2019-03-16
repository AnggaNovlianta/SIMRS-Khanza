package keuangan;
import fungsi.WarnaTable;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.var;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class DlgBubes extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private Jurnal jur=new Jurnal();
    private Connection koneksi=koneksiDB.condb();

    /** Creates new form DlgProgramStudi
     * @param parent
     * @param modal */
    public DlgBubes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        tabMode=new DefaultTableModel(null,new Object[]{
                "Tgl.Jurnal","No.Jurnal","No.Bukti","Keterangan","Saldo Awal","Debet","Kredit","Saldo Akhir"
            }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbDokter.setModel(tabMode);

        tbDokter.setPreferredScrollableViewportSize(new Dimension(800,800));
        tbDokter.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 8; i++) {
            TableColumn column = tbDokter.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(65);
            }else if(i==1){
                column.setPreferredWidth(110);
            }else if(i==2){
                column.setPreferredWidth(120);
            }else if(i==3){
                column.setPreferredWidth(360);
            }else{
                column.setPreferredWidth(130);
            }
        }
        tbDokter.setDefaultRenderer(Object.class, new WarnaTable());  
        
        rekening.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(var.getform().equals("DlgBubes")){
                    if(rekening.getTabel().getSelectedRow()!= -1){      
                        kdrek.setText(rekening.getTabel().getValueAt(rekening.getTabel().getSelectedRow(),1).toString());
                        nmrek.setText(rekening.getTabel().getValueAt(rekening.getTabel().getSelectedRow(),2).toString());                        
                        kdrek.requestFocus();
                    }                 
                }
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        rekening.getTabel().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(var.getform().equals("DlgBubes")){
                    if(e.getKeyCode()==KeyEvent.VK_SPACE){
                        rekening.dispose();
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });  
        
        Valid.LoadTahun(Tahun);
     
    }
    private Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
    private DecimalFormat df2 = new DecimalFormat("###,###,###,###,###,###,###");    

    private DlgRekeningTahun rekening=new DlgRekeningTahun(null,false);

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kd2 = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        scrollPane1 = new widget.ScrollPane();
        tbDokter = new widget.Table();
        panelisi4 = new widget.panelisi();
        label32 = new widget.Label();
        Tahun = new widget.ComboBox();
        label17 = new widget.Label();
        kdrek = new widget.TextBox();
        nmrek = new widget.TextBox();
        BtnCari6 = new widget.Button();
        label19 = new widget.Label();
        BtnCari = new widget.Button();
        panelisi1 = new widget.panelisi();
        BtnPrint = new widget.Button();
        BtnKeluar = new widget.Button();

        Kd2.setName("Kd2"); // NOI18N
        Kd2.setPreferredSize(new java.awt.Dimension(207, 23));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Buku Besar ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(70, 70, 70))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        scrollPane1.setName("scrollPane1"); // NOI18N
        scrollPane1.setOpaque(true);

        tbDokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbDokter.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbDokter.setName("tbDokter"); // NOI18N
        scrollPane1.setViewportView(tbDokter);

        internalFrame1.add(scrollPane1, java.awt.BorderLayout.CENTER);

        panelisi4.setName("panelisi4"); // NOI18N
        panelisi4.setPreferredSize(new java.awt.Dimension(100, 44));
        panelisi4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 9));

        label32.setText("Tahun :");
        label32.setName("label32"); // NOI18N
        label32.setPreferredSize(new java.awt.Dimension(52, 23));
        panelisi4.add(label32);

        Tahun.setName("Tahun"); // NOI18N
        Tahun.setPreferredSize(new java.awt.Dimension(80, 23));
        Tahun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TahunKeyPressed(evt);
            }
        });
        panelisi4.add(Tahun);

        label17.setText("Rekening :");
        label17.setName("label17"); // NOI18N
        label17.setPreferredSize(new java.awt.Dimension(70, 23));
        panelisi4.add(label17);

        kdrek.setName("kdrek"); // NOI18N
        kdrek.setPreferredSize(new java.awt.Dimension(70, 23));
        kdrek.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdrekKeyPressed(evt);
            }
        });
        panelisi4.add(kdrek);

        nmrek.setEditable(false);
        nmrek.setName("nmrek"); // NOI18N
        nmrek.setPreferredSize(new java.awt.Dimension(200, 23));
        panelisi4.add(nmrek);

        BtnCari6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnCari6.setMnemonic('1');
        BtnCari6.setToolTipText("Alt+1");
        BtnCari6.setName("BtnCari6"); // NOI18N
        BtnCari6.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCari6ActionPerformed(evt);
            }
        });
        panelisi4.add(BtnCari6);

        label19.setName("label19"); // NOI18N
        label19.setPreferredSize(new java.awt.Dimension(10, 23));
        panelisi4.add(label19);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setToolTipText("Alt+2");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelisi4.add(BtnCari);

        internalFrame1.add(panelisi4, java.awt.BorderLayout.PAGE_START);

        panelisi1.setName("panelisi1"); // NOI18N
        panelisi1.setPreferredSize(new java.awt.Dimension(100, 56));
        panelisi1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnPrint.setBackground(new java.awt.Color(50, 70, 50));
        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('P');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+P");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelisi1.add(BtnPrint);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelisi1.add(BtnKeluar);

        internalFrame1.add(panelisi1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
private void KdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TKdKeyPressed
    Valid.pindah(evt,BtnCari,Nm);
}//GEN-LAST:event_TKdKeyPressed
*/

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BtnCariActionPerformed(evt);
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            Tahun.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            
            Sequel.queryu("delete from temporary");
            int row=tabMode.getRowCount();
            for(int i=0;i<row;i++){  
                Sequel.menyimpan("temporary","'0','"+
                                tabMode.getValueAt(i,0).toString()+"','"+
                                tabMode.getValueAt(i,1).toString()+"','"+
                                tabMode.getValueAt(i,2).toString()+"','"+
                                tabMode.getValueAt(i,3).toString()+"','"+
                                tabMode.getValueAt(i,4).toString()+"','"+
                                tabMode.getValueAt(i,5).toString()+"','"+
                                tabMode.getValueAt(i,6).toString()+"','"+
                                tabMode.getValueAt(i,7).toString()+"','"+
                                kdrek.getText()+", "+nmrek.getText()+"','"+Tahun.getSelectedItem()+"','','','','','','','','','','','','','','','','','','','','','','','','','','',''","Keuangan"); 
            }
            
            Map<String, Object> param = new HashMap<>(); 
                param.put("namars",var.getnamars());
                param.put("alamatrs",var.getalamatrs());
                param.put("kotars",var.getkabupatenrs());
                param.put("propinsirs",var.getpropinsirs());
                param.put("kontakrs",var.getkontakrs());
                param.put("emailrs",var.getemailrs()); 
            param.put("logo",Sequel.cariGambar("select logo from setting")); 
            Valid.MyReport("rptBubes.jrxml","report","::[ Laporan Keuangan ]::",
                "select no, temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14 from temporary order by no asc",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt,Tahun,BtnKeluar);
        }
    }//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnPrint,Tahun);}
    }//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        prosesCari();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, Tahun, BtnPrint);
        }
    }//GEN-LAST:event_BtnCariKeyPressed

    private void kdrekKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdrekKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            kdrek.setText(rekening.getTextField().getText());
            Sequel.cariIsi("select nm_rek from rekening where kd_rek='"+kdrek.getText()+"'",nmrek);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            kdrek.setText(rekening.getTextField().getText());
            Sequel.cariIsi("select nm_rek from rekening where kd_rek='"+kdrek.getText()+"'",nmrek);
            Tahun.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            kdrek.setText(rekening.getTextField().getText());
            Sequel.cariIsi("select nm_rek from rekening where kd_rek='"+kdrek.getText()+"'",nmrek);
            BtnKeluar.requestFocus();
        }
    }//GEN-LAST:event_kdrekKeyPressed

    private void BtnCari6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCari6ActionPerformed
        var.setform("DlgBubes");
        rekening.emptTeks();
        rekening.isCek();
        rekening.tampil();
        rekening.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        rekening.setLocationRelativeTo(internalFrame1);
        rekening.setVisible(true);
    }//GEN-LAST:event_BtnCari6ActionPerformed

    private void TahunKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TahunKeyPressed
        Valid.pindah(evt,BtnKeluar,kdrek);
    }//GEN-LAST:event_TahunKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        prosesCari();
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgBubes dialog = new DlgBubes(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnCari;
    private widget.Button BtnCari6;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.TextBox Kd2;
    private widget.ComboBox Tahun;
    private widget.InternalFrame internalFrame1;
    private widget.TextBox kdrek;
    private widget.Label label17;
    private widget.Label label19;
    private widget.Label label32;
    private widget.TextBox nmrek;
    private widget.panelisi panelisi1;
    private widget.panelisi panelisi4;
    private widget.ScrollPane scrollPane1;
    private widget.Table tbDokter;
    // End of variables declaration//GEN-END:variables

    private void prosesCari() {
       Valid.tabelKosong(tabMode);
       String thn=" rekeningtahun.thn='"+Tahun.getSelectedItem()+"' ";               
       try{
            
            ResultSet rs=koneksi.prepareStatement("select jurnal.tgl_jurnal,jurnal.no_jurnal,detailjurnal.debet,detailjurnal.kredit,jurnal.no_bukti,jurnal.keterangan "+
                            "from jurnal inner join detailjurnal on jurnal.no_jurnal=detailjurnal.no_jurnal  where "+
                            "detailjurnal.kd_rek='"+kdrek.getText()+"' and jurnal.tgl_jurnal like '%"+Tahun.getSelectedItem()+"%' ").executeQuery();
            
            ResultSet rs2=koneksi.prepareStatement("select rekeningtahun.saldo_awal,rekening.tipe, "+
                            " rekening.balance from rekeningtahun inner join rekening on rekeningtahun.kd_rek=rekening.kd_rek "+
                            " where rekeningtahun.kd_rek='"+kdrek.getText()+"' and rekeningtahun.thn like '%"+Tahun.getSelectedItem()+"%'  ").executeQuery();
            double saldoakhir = 0,saldoawal=0,tampawal=0;
            String tipe="",balance="";
            while(rs2.next()){
                 saldoawal=rs2.getDouble(1);    
                 saldoakhir=rs2.getDouble(1); 
                 tipe=rs2.getString(2);
                 balance=rs2.getString(3);
            }          
                
            while(rs.next()){  
                switch (balance) {
                    case "K":
                        saldoakhir=saldoakhir+(rs.getDouble("kredit")-rs.getDouble("debet"));
                        break;
                    case "D":
                        saldoakhir=saldoakhir+rs.getDouble("debet")-rs.getDouble("kredit");
                        break;
                }
                
                if(saldoawal<0){
                        saldoawal=saldoawal*(-1);
                }
                
                tabMode.addRow(new Object[]{rs.getString(1),
                               rs.getString(2),rs.getString("no_bukti"),rs.getString("keterangan"),
                               df2.format(saldoawal),
                               df2.format(rs.getDouble("debet")),
                               df2.format(rs.getDouble("kredit")),
                               df2.format(saldoakhir)});
                saldoawal=saldoawal+rs.getDouble("debet")-rs.getDouble("kredit");
                //tampawal=saldoawal;
                //saldoakhir=saldoawal;
                
            }
        }catch(SQLException e){
            System.out.println("Notifikasi : "+e);
        }
    }
    
    public void isCek(){
        BtnPrint.setEnabled(var.getbuku_besar());
    }
     
 
}
