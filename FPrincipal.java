package Exerc7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FPrincipal {
    private JPanel PanelPrincipal;
    private JButton gestãoDeAlunosButton;
    private JButton gestãoDeTurmasButton;

    public FPrincipal() {
        gestãoDeAlunosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FGestaoAlunos().setVisible(true);
            }
        });
        gestãoDeTurmasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gestãoDeTurmasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new  FGestaoTurma().setVisible(true);
            }
        });
    }

    public void setVisible(boolean b){
        JFrame frame=new JFrame("Gestão de Alunos");
        frame.setContentPane(new FPrincipal().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null); //center
        frame.setVisible(true);
    }
}
