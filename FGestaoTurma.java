package Exerc7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FGestaoTurma {
    private JPanel panelFGestaoTurmas;
    private JTextField textFieldDesignTurma;
    private JButton atribuirAlunosButton;
    private JTextArea textAreaDadosAlunos;
    private JTextField textFieldNAlunos;
    private JTextField textFieldMedia;
    private JTextField textFieldNAlunos3Neg;
    private JTextField textFieldNotaMax;
    private JButton guardarTurmaButton;


    public void setVisible(boolean b){
        JFrame frame=new JFrame("Gestão de Turmas");
        frame.setContentPane(new FGestaoTurma().panelFGestaoTurmas);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public FGestaoTurma() {
        atribuirAlunosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    for (Aluno a: FGestaoAlunos.turma){
                        textAreaDadosAlunos.append(a.toString() + "\n");
                    }
                }
            });
        guardarTurmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldDesignTurma.getText()!="" && textAreaDadosAlunos.getText()!="") {
                    Turma t=new Turma();
                    t.setDesignacao(textFieldDesignTurma.getText());
                    t.setAlunos(FGestaoAlunos.turma);
                    textFieldNAlunos.setText(String.valueOf(t.Alunos.size()));
                    textFieldMedia.setText((String.valueOf(t.MediaTurma())));
                    textFieldNAlunos3Neg.setText(String.valueOf(t.Mais3Negativas()));
                    textFieldNotaMax.setText(String.valueOf(t.MediaMaisAlta()));
            }
        }
    });
    }
}
