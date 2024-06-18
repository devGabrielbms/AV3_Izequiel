import java.util.ArrayList;
import java.util.List;

public class Diretorio {
    private String nome;
    private List<Arquivo> arquivos = new ArrayList<>();
    private List<Diretorio> subdiretorios = new ArrayList<>();

    public Diretorio(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public List<Diretorio> getSubdiretorios() {
        return subdiretorios;
    }

    public void adicionarArquivo(Arquivo arquivo) {
        arquivos.add(arquivo);
    }

    public void adicionarSubdiretorio(Diretorio subdiretorio) {
        subdiretorios.add(subdiretorio);
    }

    public void removerArquivo(String nome) {
        arquivos.removeIf(arquivo -> arquivo.getNome().equals(nome));
    }

    public void removerSubdiretorio(String nome) {
        subdiretorios.removeIf(subdiretorio -> subdiretorio.getNome().equals(nome));
    }
}
