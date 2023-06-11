import br.univali.cc.garagemsteve.dominio.Galpao;
import br.univali.cc.garagemsteve.visao.InterfaceGUI;

public class App {
    public static void main(String[] args) throws Exception {
        InterfaceGUI interfaceGui = new InterfaceGUI(new Galpao());

        interfaceGui.menuPrincipal();
    }
}
