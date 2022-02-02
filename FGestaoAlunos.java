package Exerc7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Random;

public class FGestaoAlunos {
    private JPanel panelGestãodeAlunos;
    private JTabbedPane tabbedPanelConsultar;
    private JTextArea textAreaNotas;
    private JTextField textFieldidentificação;
    private JTextField textFieldMedia;
    private JButton gerarDisciplinasButton;
    private JTextField textFieldNNegativas;
    private JTextField textFieldNota;
    private JButton GuardarButton;
    private JButton AdicionarNotabutton;
    private JButton buttonNovoAluno;
    private JTextField textFieldAlunoAPesquisar;
    private JButton Pesquisarbutton;
    private JTextField textFieldAlNome;
    private JTextField textFieldAlMedia;
    private JTextField textFieldAlNNeg;
    private JButton Alterarbutton;
    private JTextArea textAreaAlterar;
    private JTextArea textArea1;
    private JTextField textFieldNomeAlunoApagar;
    private JTextField textFieldMediaApagar;
    private JButton EncontrarAlunoButton;
    private JButton dadosApósApagarAlunoButton;
    private JTextArea textAreaDadosAposApagar;
    private JTextField textFieldNomeApagar;
    private JTextField textFieldNNegativasApagar;

    int nDscp=10;
    int[] notas=new int[nDscp];
    short ap=0;

public static ArrayList<Aluno>    turma=new ArrayList<Aluno>();
public static Aluno al, alu;

    public FGestaoAlunos() {
        gerarDisciplinasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                Short nNeg = 0;

                textAreaNotas.setText("");
                for (int i = 0; i < nDscp; i++) {
                    notas[i] = rnd.nextInt(21);
                    textAreaNotas.append(notas[i] + "\n");
                }
            }
        });
        GuardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((textFieldidentificação.getText() != "") && (textAreaNotas.getText() != "")) {
                    alu = new Aluno();
                    alu.setNome(textFieldidentificação.getText());
                    alu.Notas=new int[notas.length];
                    System.arraycopy(notas,0,alu.Notas,0, notas.length);
                    turma.add(alu);

                    textFieldMedia.setText(String.valueOf(alu.Media()));
                    textFieldNNegativas.setText(String.valueOf(alu.NNegativas()));
                    JOptionPane.showMessageDialog(null,
                            "Aluno guardado com sucesso: " + alu.getNome());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Dados Incompletos! Introduza o nome e as notas por favor");
                }
            }
        });
        buttonNovoAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldidentificação.setText("");
                textAreaNotas.setText("");
                textFieldMedia.setText("");
                textFieldNota.setText("");
                textFieldNNegativas.setText("");
            }
        });
        Alterarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                al.setNome(textFieldAlNome.getText());
                String[] newStr = textAreaAlterar.getText().split("\n");
                int[] arNotas = new int[newStr.length];
                try {
                    for (int i = 0; i < newStr.length; i++)
                        arNotas[i] = Integer.parseInt(newStr[i]);
                    al.Notas = arNotas.clone();
                    textFieldAlMedia.setText(String.valueOf(al.Media()));
                    textFieldAlNNeg.setText(String.valueOf(al.NNegativas()));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro:  " + ex.getMessage());
                }

            }
        });

        Pesquisarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome=textFieldAlunoAPesquisar.getText();
                for (Aluno a: turma){
                    if(a.getNome().equals(nome)){
                        textFieldAlNome.setText(a.getNome());
                        textAreaAlterar.setText("");
                        for(int nota: a.getNotas())
                            textAreaAlterar.append(nota+"\n");
                        textFieldAlMedia.setText(String.valueOf(a.Media()));
                        textFieldAlNNeg.setText(String.valueOf(a.NNegativas()));
                        al=a;
                    }
                }

            }
        });
        EncontrarAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome=textFieldNomeAlunoApagar.getText();
                for(Aluno a: turma){
                    if(a.getNome().equals(nome)){
                        textFieldNomeApagar.setText(a.getNome());
                        textFieldMediaApagar.setText(String.valueOf(a.Media()));
                        textFieldNNegativasApagar.setText(String.valueOf(a.NNegativas()));
                        int res=JOptionPane.showConfirmDialog(null, "Tem a certeza que deseja eliminar os dados do aluno?");

                        //0- yes,1-no, 2-cancel
                        if(res==0){
                            turma.remove(a);
                            JOptionPane.showMessageDialog(null, "Dados do aluno removido com sucesso!");
                        }
                    }
                }
            }
        });
        dadosApósApagarAlunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaDadosAposApagar.setText("");
                for(Aluno a: turma)
                textAreaDadosAposApagar.append(a.toString() + "\n");
                textFieldNomeApagar.setText("");
                textFieldNomeAlunoApagar.setText("");
                textFieldMediaApagar.setText("");
                textFieldNNegativasApagar.setText("");
            }
        });
        tabbedPanelConsultar.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textArea1.setText("");
                for(Aluno a: turma)
                    textArea1.append(a.toString() + "\n");
            }
        });
    }

    public void setVisible(boolean b){
        JFrame frame=new JFrame("Gestão de Alunos");
        frame.setContentPane(new FGestaoAlunos().panelGestãodeAlunos);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null); //center
        frame.setVisible(true);
    }
}
