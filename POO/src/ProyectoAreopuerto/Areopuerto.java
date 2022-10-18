package ProyectoAreopuerto;

public class Areopuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private Compania listaCompanias[] = new Compania[10];
    private int numCompania;

    public Areopuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numCompania = 0;
    }

    public Areopuerto(String nombre, String ciudad, String pais, Compania[] listaCompanias) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.listaCompanias = listaCompanias;
        this.numCompania = listaCompanias.length;
    }

    public void insertarCompania(Compania c){
        listaCompanias[numCompania] = c;
        numCompania++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Compania[] getListaCompanias() {
        return listaCompanias;
    }

    public int getNumCompania() {
        return numCompania;
    }

    public Compania getCompania(int id){
        return listaCompanias[id];
    }

    public Compania getCompania(String nombreCompania){
        boolean encontrado =false;
        int i=0;
        Compania c = null;

        while((!encontrado) && (i < listaCompanias.length))
        {
            if(nombreCompania.equals(listaCompanias[i].getNombre())){
                encontrado = true;
                c = listaCompanias[i];
            }
            i++;
        }
        return c;
    }
}
