package imguptest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(urlPatterns="/imguptest.do")
public class ImageUpTestServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println(req.getParameter("username"));
//		System.out.println(req.getParameter("image"));
//		InputStream in = req.getInputStream();
//		byte[] by = new byte[1024];
//		String str = "";
//		while((in.read(by)) != -1){
//			str += new String(by);
//		}
//		System.out.println(str);
		
		//step1����һ���������ʵ��,��ʵ��
		//Ϊ�������ṩ��ȱʡ�����á�
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//����һ�����������
		ServletFileUpload sfu = new ServletFileUpload(factory);
		//ʹ�ý�������������
		//����֮��,�Ὣ���е�����ת����һ����
		//FileItem ����һ�������е����ݶ�Ӧ��һ��
		//FileItem����
		List<FileItem> items = null;
		try {
			items = sfu.parseRequest(req);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		//����items����
		for(int i=0;i<items.size();i++){
			FileItem item = items.get(i);
			//�������е�����ʱ,Ҫ���ֱ��������
			if(item.isFormField()){
				//getFieldName()�ǻ�ô˱���ļ�
				//getString()���ֵ
				String key = item.getFieldName();
				String value = item.getString();
				System.out.println("key:"+key);
				System.out.println("value:"+value);
			}else{
				//�ļ��ϴ�����
				ServletContext application = getServletContext();
				String path = application.getRealPath("upload");
				//����ļ���
				String fileName = item.getName();
				//�ļ�ǰ׺
//				String prefix = System.currentTimeMillis()+"";
				String prefix = UUID.randomUUID().toString().replaceAll("-", "");
				//�ļ���׺
				String suffix = fileName.substring(fileName.lastIndexOf("."));
				File file = new File(path + "\\" + prefix + suffix);
				System.out.println(file);
				try {
					item.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
