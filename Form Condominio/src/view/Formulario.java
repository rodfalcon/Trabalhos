package view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import negocio.Condominio;
import negocio.NumeroApt;
import negocio.Logradouro;
import negocio.Morador;

public class Formulario {
	private JFrame form;
    private JLabel lblValor1, lblValor2, lblValor3, lblFiguras, lblResultado;
    private JTextField txtValor1, txtValor2, txtValor3;
    private JComboBox cboArea;
    private JButton btnMostrarAtributos;
    
    public Formulario() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        form = new JFrame("MOSTRAR VALORES DE ATRIBUTOS DE UM CONDOMINIO");
        form.setBounds(400, 150, 550, 350);
        form.setLayout(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container painel = form.getContentPane();
        
        lblFiguras = new JLabel("SELECT FORMAT: ");
        lblFiguras.setBounds(40, 30, 180, 20);
        painel.add(lblFiguras);
        
        lblValor1 = new JLabel("Atributo 1: ");
        lblValor1.setBounds(300, 30, 100, 20);
        painel.add(lblValor1);
        
        txtValor1 = new JTextField();
        txtValor1.setBounds(390, 30, 80, 20);
        txtValor1.setEnabled(false);
        painel.add(txtValor1);
        
        lblValor2 = new JLabel("Atributo 2: ");
        lblValor2.setBounds(300, 80, 100, 20);
        painel.add(lblValor2);

        txtValor2 = new JTextField();
        txtValor2.setBounds(390, 80, 80, 20);
        txtValor2.setEnabled(false);
        painel.add(txtValor2);
        
        lblValor3 = new JLabel("Atributo 3: ");
        lblValor3.setBounds(300, 130, 100, 20);
        painel.add(lblValor3);

        txtValor3 = new JTextField();
        txtValor3.setBounds(390, 130, 80, 20);
        txtValor3.setEnabled(false);
        painel.add(txtValor3);
        
        cboArea = new JComboBox();
        cboArea.setBounds(40, 60, 200, 25);
        cboArea.addItem("<< SELECIONE >>");
        cboArea.addItem("Endereco do Condominio");
        cboArea.addItem("Nome do Morador");
        cboArea.addItem("Numero do Apartamento");
        cboArea.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    switch(cboArea.getSelectedIndex()){
                        case 1: 
                            lblValor1.setText("CEP:");
                            lblValor2.setText("Endereco");
                            lblValor3.setText("-");
                            txtValor1.setEnabled(true);
                            txtValor2.setEnabled(true);
                            txtValor3.setEnabled(false);
                            break;
                        case 2: 
                            lblValor1.setText("Nome:");
                            lblValor2.setText("Sobrenome");
                            lblValor3.setText("-");
                            txtValor1.setEnabled(true);
                            txtValor2.setEnabled(true);
                            txtValor3.setEnabled(false);
                            break;
                        case 3: 
                            lblValor1.setText("Numero:");
                            lblValor2.setText("-");
                            lblValor3.setText("-");
                            txtValor1.setEnabled(true);
                            txtValor2.setEnabled(false);
                            txtValor3.setEnabled(false);
                            break;
                        default:
                            lblValor1.setText("Att 1:");
                            lblValor2.setText("Att 2:");
                            lblValor3.setText("Att 3:");
                            txtValor1.setEnabled(false);
                            txtValor2.setEnabled(false);
                            txtValor3.setEnabled(false);
                    }
                    lblResultado.setText("Resultado: ");
                    txtValor1.setText("");
                    txtValor2.setText("");
                    txtValor3.setText("");
                }
            }
        });
        painel.add(cboArea);
        
        btnMostrarAtributos = new JButton("Mostrar Atributos");
        btnMostrarAtributos.setBounds(150, 180, 220, 25);
        btnMostrarAtributos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                Condominio objFigura = null;
                
                switch (cboArea.getSelectedIndex()){
                
                    case 1: 
                    Logradouro objCirc = new Logradouro();
					
					objCirc.setNomeCondominio(txtValor1.getText());
					objCirc.setNomeRua(txtValor2.getText());
                    objFigura = objCirc;
                    break;
                        
                    case 2: 
                    Morador objRet = new Morador();

					objRet.setMorador(txtValor1.getText());
					objRet.setSobrenome(txtValor2.getText());
                    objFigura = objRet;
                    break;
                        
                    case 3: 
                    NumeroApt objTrap = new NumeroApt();
                    
					objTrap.setNumeroApt(txtValor1.getText());
                    objFigura = objTrap;
                    break;
                 
                }
                
                lblResultado.setText(objFigura.MostrarAtributos());
            }
        });
        painel.add(btnMostrarAtributos);
        
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(150, 230, 800, 30);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        lblResultado.setForeground(Color.RED);
        painel.add(lblResultado);
        
        form.setVisible(true);
    }

}
