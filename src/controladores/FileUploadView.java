/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import javax.swing.JFileChooser;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import recursos.recursoMensajes;

@ManagedBean
@ViewScoped
public class FileUploadView {

    private UploadedFile file;
    private Part uploadedFile;
    private String folder = "e:\\ArchivosSubidos";

    String path;
    String message;

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void saveFile() {
        //Crea el directorio donde se copiarán los archivos
        try {
            File directorio = new File("e:\\ArchivosSubidos");
            directorio.mkdir();
        } catch (Exception e) {
        }
        //copia el archivo al directorio para usar el path conocido
        try (InputStream input = uploadedFile.getInputStream()) {
            String fileName = uploadedFile.getSubmittedFileName();
            Files.copy(input, new File(folder, fileName).toPath());

        } catch (IOException e) {
            message = "Error Archivo ya Subido. Si desea Subirlo Nuevamente Cambiar el nombre del archivo";
            recursoMensajes.addErrorMessage(message);
        }
        //Subida del archivo svc a la base
        try {
            
            message = "Carga de Datos Realizada con Exito!";
            recursoMensajes.addSuccessMessage(message);
        } catch (Exception e) {
        }
        
    }
    


    public UploadedFile getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("¡Operación Exitosa!", file.getFileName() + "Los Datos se han cargado Correctamente.");
            System.out.print(file.getFileName() + " " + file.getContentType() + "  " + file.getSize());
            FacesContext.getCurrentInstance().addMessage(null, message);

        }
    }

    public void cargar() {
        System.out.print("real" + path);
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {
        FacesMessage msg = new FacesMessage("¡Operación Exitosa!", event.getFile().getFileName() + "Los Datos se han cargado Correctamente.");
        UploadedFile uploadedFile = event.getFile();
        InputStream inputStream = uploadedFile.getInputstream();

        File archivo = new File(uploadedFile.getFileName());
        System.out.println(archivo.getAbsolutePath());

        String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
        System.out.println("DIRECCIÓN REAL " + path);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
