package Exerc7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FLogin {
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JButton cancelButton;
    private JButton buttonOK;
    private JPanel PanelLogin;
    private JPasswordField passwordField;

    public FLogin() {
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtUser=textFieldUsername.getText();
                String txtPass=String.valueOf(passwordField.getPassword());

                try{
                    Connection conn=Conexao.CreateConnection();
                    String sql="SELECT nome, username, password FROM user";
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ResultSet rs=ps.executeQuery();
                    boolean b=false;
                    while (rs.next()){
                        String nome=rs.getString(1);
                        String user=rs.getString("username");
                        String pass=rs.getString("password");
                        //System.out.printf("%s - %s - %s", nome, user, pass);
                        //JOptionPane.showMessageDialog(null, nome + ": " + user + "-" + pass);
                        if(txtUser.equals(user) && txtPass.equals(pass)){
                            new FPrincipal().setVisible(true);
                            b=true;
                        }
                    } if(!b)
                        JOptionPane.showMessageDialog(null,
                                "Erro! Login incorreto! username/password errados!");
                }
                catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestão de Alunos e Turmas");
        frame.setContentPane(new FLogin().PanelLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    }

