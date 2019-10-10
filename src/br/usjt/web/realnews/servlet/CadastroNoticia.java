package br.usjt.web.realnews.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.usjt.web.realnews.model.Noticia;
import br.usjt.web.realnews.model.Usuario;
import br.usjt.web.realnews.service.NoticiaService;

@WebServlet("/CadastroNoticia.do")
public class CadastroNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		Noticia noticia = new Noticia();
		noticia.setIdUsuario(usuario.getId());
		
		if (ServletFileUpload.isMultipartContent(request)) {
            try {
                /*Faz o parse do request*/
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
 
                /*Escreve a o arquivo na pasta img*/
                for (FileItem item : multiparts) {
                	if(item.isFormField()) {
                		String parametro;
                		/*Inserindo dados do parametro no objeto*/
                		if(item.getFieldName().equals("txtTitulo")) {
                			parametro = item.getString();
                			noticia.setTitulo(parametro);
                			System.out.println("txtT:" + parametro);
                		}
                		else if(item.getFieldName().equals("txtResumo")) {
                			parametro = item.getString();
                			noticia.setResumo(parametro);
                			System.out.println("txtR:" + parametro);
                		}
                		else if(item.getFieldName().equals("txtTexto")) {
                			parametro = item.getString();
                			noticia.setTexto(parametro);
                			System.out.println("txtT:" + parametro);
                		}
                	}
                	/*Inserindo a imagem no diretório*/
                    if (!item.isFormField()) {
                    	String imagem = item.getName();
                    	System.out.println("Name:" + imagem);
                    	noticia.setArquivo("arquivos/" + imagem);
                    	System.out.println(request.getServletContext().getRealPath("arquivos")+ File.separator + imagem);
                    	//System.out.println("content:" + request.getContentType());
                    	//System.out.println("context:" + request.getContextPath());
                        item.write(new File(request.getServletContext().getRealPath("arquivos")+ File.separator + imagem));
                    }
                    
                }
                NoticiaService noticiaService = new NoticiaService();
        		noticiaService.inserir(noticia);
        		response.getWriter().print("Noticia salva com sucesso!");
        		response.sendRedirect("index.jsp");
            } catch (Exception ex) {
            	ex.printStackTrace();
            }
        } else {
            request.setAttribute("message","Desculpe este Servlet lida apenas com pedido de upload de arquivos");
        }
		//response.sendRedirect("index.html");
	}
}






