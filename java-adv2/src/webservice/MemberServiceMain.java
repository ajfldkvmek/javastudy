package webservice;

import annotation.AnnotationServletV3;
import io.member.impl.FileMemberRepository;
import was.httpserver.HttpServer;
import was.httpserver.HttpServlet;
import was.httpserver.ServletManager;
import was.httpserver.servlet.DiscardServlet;

import java.io.IOException;
import java.util.List;

public class MemberServiceMain {

    private final static int PORT = 12345;

    public static void main(String[] args) throws IOException {

        FileMemberRepository memberRepository = new FileMemberRepository(); //MemberRepository 는 메모리나 파일 관계 없음
        MemberController memberController = new MemberController(memberRepository);

        HttpServlet servlet = new AnnotationServletV3(List.of(memberController));

        ServletManager servletManager = new ServletManager();
        servletManager.add("/favicon.ico", new DiscardServlet());
        servletManager.setDefaultServlet(servlet);

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
