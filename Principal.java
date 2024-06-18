public class Principal {
    public static void main(String[] args) {
        SimuladorSistemaArquivos ss = new SimuladorSistemaArquivos();
        
        // Operações de exemplo
        ss.criarDiretorio("/raiz", "documentos");
        ss.criarArquivo("/raiz/documentos", "arquivo1.txt");
        ss.listarArquivos("/raiz");
        ss.listarArquivos("/raiz/documentos");
        
        ss.renomearArquivo("/raiz/documentos", "arquivo1.txt", "arquivo2.txt");
        ss.listarArquivos("/raiz/documentos");
        
        ss.excluirArquivo("/raiz/documentos", "arquivo2.txt");
        ss.listarArquivos("/raiz/documentos");
        
        ss.renomearDiretorio("/raiz", "documentos", "docs");
        ss.listarArquivos("/raiz");
        
        ss.excluirDiretorio("/raiz", "docs");
        ss.listarArquivos("/raiz");

        // Exibir o log do Diario
        System.out.println("\nDiario Log:");
        for (String entrada : ss.getDiario().getRegistros()) {
            System.out.println(entrada);
        }
    }
}
