package Exerc7;

import java.util.ArrayList;

public class Turma {
    public String Designacao;
    public ArrayList<Aluno> Alunos;

    public Turma() {}

    public Turma(String design, ArrayList<Aluno> alunos) {
        this.Designacao=design;
        this.Alunos=(ArrayList<Aluno>) alunos.clone();
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.Alunos = (ArrayList<Aluno>) alunos.clone();
    }

    public double MediaTurma() {
        int total=0;
        for (Aluno a: this.Alunos) {
         total += a.Media();
        }
        return (total/Alunos.size());
    }

    public int Mais3Negativas() {
        int totalAlunos=0;
        for (Aluno a: this.Alunos)
            if(a.NNegativas() >=3)
                totalAlunos++;
            return totalAlunos;
    }

    public double MediaMaisAlta() {
        double mediaMaisAlta=0;
        for (Aluno a: this.Alunos)
            if(a.Media() > mediaMaisAlta)
                mediaMaisAlta = a.Media();
            return mediaMaisAlta;
    }

    public void setDesignacao(String designacao) { this.Designacao = designacao; }

    public String getDesignacao() { return this.Designacao;}

    public ArrayList<Aluno> getAlunos() { return this.Alunos; }
}
