import java.util.ArrayList;
import java.util.List;

public class SimuladorSistemaArquivos {
    private Diretorio raiz;
    private Diario diario;

    public SimuladorSistemaArquivos() {
        raiz = new Diretorio("raiz");
        diario = new Diario();
    }

    private Diretorio encontrarDiretorio(String caminho) {
        String[] partes = caminho.split("/");
        Diretorio atual = raiz;
        for (String parte : partes) {
            if (parte.isEmpty()) continue;
            boolean encontrado = false;
            for (Diretorio dir : atual.getSubdiretorios()) {
                if (dir.getNome().equals(parte)) {
                    atual = dir;
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) return null;
        }
        return atual;
    }

    public void criarArquivo(String caminho, String nome) {
        Diretorio dir = encontrarDiretorio(caminho);
        if (dir != null) {
            Arquivo novoArquivo = new Arquivo(nome);
            dir.adicionarArquivo(novoArquivo);
            diario.adicionarEntrada("CRIAR ARQUIVO: " + caminho + "/" + nome);
        }
    }

    public void excluirArquivo(String caminho, String nome) {
        Diretorio dir = encontrarDiretorio(caminho);
        if (dir != null) {
            dir.removerArquivo(nome);
            diario.adicionarEntrada("EXCLUIR ARQUIVO: " + caminho + "/" + nome);
        }
    }

    public void renomearArquivo(String caminho, String nomeAntigo, String nomeNovo) {
        Diretorio dir = encontrarDiretorio(caminho);
        if (dir != null) {
            for (Arquivo arquivo : dir.getArquivos()) {
                if (arquivo.getNome().equals(nomeAntigo)) {
                    arquivo.setNome(nomeNovo);
                    diario.adicionarEntrada("RENOMEAR ARQUIVO: " + caminho + "/" + nomeAntigo + " para " + nomeNovo);
                    break;
                }
            }
        }
    }

    public void criarDiretorio(String caminho, String nome) {
        Diretorio dir = encontrarDiretorio(caminho);
        if (dir != null) {
            Diretorio novoDir = new Diretorio(nome);
            dir.adicionarSubdiretorio(novoDir);
            diario.adicionarEntrada("CRIAR DIRETORIO: " + caminho + "/" + nome);
        }
    }

    public void excluirDiretorio(String caminho, String nome) {
        Diretorio dir = encontrarDiretorio(caminho);
        if (dir != null) {
            dir.removerSubdiretorio(nome);
            diario.adicionarEntrada("EXCLUIR DIRETORIO: " + caminho + "/" + nome);
        }
    }

    public void renomearDiretorio(String caminho, String nomeAntigo, String nomeNovo) {
        Diretorio dir = encontrarDiretorio(caminho);
        if (dir != null) {
            for (Diretorio subDir : dir.getSubdiretorios()) {
                if (subDir.getNome().equals(nomeAntigo)) {
                    subDir.setNome(nomeNovo);
                    diario.adicionarEntrada("RENOMEAR DIRETORIO: " + caminho + "/" + nomeAntigo + " para " + nomeNovo);
                    break;
                }
            }
        }
    }

    public void listarArquivos(String caminho) {
        Diretorio dir = encontrarDiretorio(caminho);
        if (dir != null) {
            System.out.println("Listando arquivos em: " + caminho);
            for (Arquivo arquivo : dir.getArquivos()) {
                System.out.println("Arquivo: " + arquivo.getNome());
            }
            for (Diretorio subDir : dir.getSubdiretorios()) {
                System.out.println("Diretorio: " + subDir.getNome());
            }
            diario.adicionarEntrada("LISTAR ARQUIVOS: " + caminho);
        }
    }

    public Diario obterDiario() {
        return diario;
    }
}
