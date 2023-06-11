import br.univali.cc.aula8.dominio.Aluno;
// import br.univali.cc.aula8.dominio.*; // Importa todas as classes

public class App {
    public static void main(String[] args) {
        // br.univali.cc.aula8.dominio.Aluno mateus = new br.univali.cc.aula8.dominio.Aluno();
        Aluno mateus = new Aluno("Mateus");
        mateus.setMatricula(1);

        System.out.println(mateus.getMatricula());
    }
}
