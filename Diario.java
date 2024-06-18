import java.util.ArrayList;
import java.util.List;

public class Diario {
    private List<String> registros = new ArrayList<>();

    public void adicionarEntrada(String entrada) {
        registros.add(entrada);
    }

    public List<String> getRegistros() {
        return registros;
    }
}
