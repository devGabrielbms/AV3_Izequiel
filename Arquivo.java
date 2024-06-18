public class Arquivo {
    private String nome;
    private String conteudo;

    public Arquivo(String nome) {
        this.nome = nome;
        this.conteudo = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
