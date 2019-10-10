package br.usjt.web.realnews.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.usjt.web.realnews.model.Noticia;

public class Upload {
	
	public String upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(request)) {
            try {
                /*Faz o parse do request*/
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
 
                /*Escreve a o arquivo na pasta img*/
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        item.write(new File(request.getServletContext().getRealPath("arquivos")+ File.separator + "uploadfile"));
                    }
                }
                System.out.println("uploadM:" + request.getServletContext().getRealPath("arquivos")+ File.separator + "uploadfile");
                return request.getServletContext().getRealPath("arquivos")+ File.separator + "uploadfile";
                //request.setAttribute("message", "Arquivo carregado com sucesso");
            } catch (Exception ex) {
            	ex.printStackTrace();
                //request.setAttribute("message", "Upload de arquivo falhou devido a "+ ex);
            }
 
        } else {
            request.setAttribute("message","Desculpe este Servlet lida apenas com pedido de upload de arquivos");
        }
		return null;
    }
	
	public void carregarImagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Obtem o caminho relatorio da pasta img*/
		String path = request.getServletContext().getRealPath("arquivos")+ File.separator;
        
        File files = new File(path);
        response.setContentType("image/jpeg");
        
        /*Mostra o arquivo que está na pasta img onde foi realizado o upload*/
        for (String file : files.list()) {
            File f = new File(path + file);
            BufferedImage bi = ImageIO.read(f);
            OutputStream out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.close();
        }
	}
	
	public String loadImagem(Noticia noticia) {
		String link = noticia.getArquivo();
		return link;
	}

}
//https://www.javaavancado.com/upload-de-imagens-com-servlet-e-jsp/
