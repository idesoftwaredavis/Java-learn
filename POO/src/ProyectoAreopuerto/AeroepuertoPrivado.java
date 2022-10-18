package ProyectoAreopuerto;

public class AeroepuertoPrivado extends Areopuerto{
    private String listaEmpresas[] = new String[10];

    private int numEmpresa;

    public AeroepuertoPrivado(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeroepuertoPrivado(String nombre, String ciudad, String pais, Compania[] listaCompanias, String[] listaEmpresas) {
        super(nombre, ciudad, pais, listaCompanias);
        this.listaEmpresas = listaEmpresas;
        this.numEmpresa = listaEmpresas.length;

    }

    public void insertarEmpresas(String e[]){
        this.listaEmpresas = e;
        this.numEmpresa = e.length;
    }

    public void insertarEmpresa(String e){
        listaEmpresas[numEmpresa] = e;
        numEmpresa ++ ;
    }

    public String[] getListaEmpresas() {
        return listaEmpresas;
    }

    public int getNumEmpresa() {
        return numEmpresa;
    }
}
