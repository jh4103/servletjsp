package servlet.exam05;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//MultipartConfig 멀티파트를 해석할 수 있는 어노테이션
//maxFileSize의 10은 10메가를 의미함. 사이즈를 늘릴 수 있음
//maxRequestSize는 요청에서의 전체 사이즈를 의미함. 글자 용량, 사진 용량 전부 합친것. 
//fileSizeThreshold
//location 임시파일 저장소
@WebServlet(name = "exam05.FileUploadController", urlPatterns = "/exam05/FileUploadController")
@MultipartConfig(maxFileSize=1024*1024*10, maxRequestSize = 1024*1024*50)

public class FileUploadController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 복원을 위해서 문자셋을 지정
		request.setCharacterEncoding("UTF-8");

		//문자 파트의 정보 얻기
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		System.out.println("title: " + title);
		System.out.println("desc: " + desc);

//		//한개의 파일 파트의 정보 얻기
		//파일이 한개일때 attachPart.getSize() 는 별 의미 없다. 
//		Part attachPart = request.getPart("attach1");
//		if(!attachPart.getSubmittedFileName().equals("") && attachPart.getSize() !=0) {
//			String fileName = attachPart.getSubmittedFileName();
//			long fileSize = attachPart.getSize();
//			String contentType = attachPart.getContentType();
//			System.out.println("fileName: " + fileName);
//			System.out.println("fileSize: " + fileSize);
//			System.out.println("contentType: " + contentType);
//		}
//		
		//두 개 이상의 파일 파트의 정보 얻기 
		//여러개가 넘어올 때 거르기 위해서 쓰는 방법임. 
		Collection<Part> parts = request.getParts();
		for(Part part: parts) {
		//파일 파트인지 확인
			//파일이 실제로 전송되었는지 확인
			if(part.getSubmittedFileName() != null && !part.getSubmittedFileName().equals("")) {
				String fileName = part.getSubmittedFileName();
				long fileSize =part.getSize();
				String contentType = part.getContentType();
				
				System.out.println("fileName: " + fileName);				
				System.out.println("fileSize: " + fileSize);
				System.out.println("contentType: " + contentType);
				System.out.println();
			
				//파일을 파일 시스템에 저장 // 시간정보를 넣어주면 중복저장을 피하기 좋음
				String savedName = new Date().getTime() + "-" + fileName;
				String filePath = "C:/temp/download/" + savedName;
				part.write(filePath);
			}
				
		}
		response.sendRedirect("RequestParamInfoController");
	}


}
