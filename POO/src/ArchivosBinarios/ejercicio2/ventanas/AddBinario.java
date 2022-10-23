
package ArchivosBinarios.ejercicio2.ventanas;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class AddBinario extends ObjectOutputStream{

    public AddBinario(OutputStream out) throws IOException {
        super(out);
    }

    public AddBinario() throws IOException, SecurityException {
    }
    
    
    // Sobreescritura de metodo
    @Override
    public void writeStreamHeader() throws IOException{
        File archivo = new File("RegistroAtletas.bin");
        
        if(archivo.length() == 0) // Si el archivo esta vacio
        {
            super.writeStreamHeader();
        }else{
            reset();
        }
    }
}
