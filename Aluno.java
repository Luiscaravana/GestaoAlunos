package Exerc7;

public class Aluno {
    public String Nome;
    public int[] Notas;

    public Aluno() {}

    public Aluno(String nome, int[] notas)
    {
        this.Nome=nome;
        this.Notas=notas;
    }

    public double Media()
    {
        double total=0;
        for (int i=0; i<Notas.length; i++)
            total += Notas[i];
        return (total / Notas.length);
    }

    public int NNegativas()
    {
        int nneg=0;
        for (int i=0; i<Notas.length; i++)
            if(Notas[i] < 10) nneg++;
            return nneg;
    }

    public String getNome() { return this.Nome;}
    public void  setNome(String nome) { this.Nome = nome;}
    public int[] getNotas() { return this.Notas; }
    public void setNotas(int[] notas) { this.Notas=notas;}

    public String toString()
    {
        String s=this.Nome+" , Notas: ";
        for (int i=0; i<Notas.length; i++)
            s +=Notas[i] + ", ";
        s += ", Media: " + this.Media();
        s += ", Nº Negativas: " + this.NNegativas();
        return s;

    }
}
