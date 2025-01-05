package webservice;

import annotation.Mapping;
import io.member.Member;
import io.member.MemberRepository;
import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;

import java.io.IOException;
import java.util.List;

import static util.MyLogger.log;

public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Mapping("/")
    public void home(HttpResponse response) {
        String str = "<html><body>" +
                "<h1>Member Manger</h1>" +
                "<ul>" +
                "<li><a href='/members'>Member List</a></li>" +
                "<li><a href='/add-member-form'>Add new Member</a></li>" +
                "</ul>";
        response.writeBody(str);
    }


    @Mapping("/members")
    public void members(HttpResponse response) {
        List<Member> members = memberRepository.findAll();

        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append("<h1>Member List</h1>");
        sb.append("<ul>");
        for (Member member : members) {
            sb.append("<li>").append("ID: ").append(member.getId())
                    .append(", Name: ").append(member.getName())
                    .append(", Age: ").append(member.getAge())
                    .append("</li>");
        }
        sb.append("</ul>");
        sb.append("<a href='/'>Back to Home</a>");
        sb.append("/body></html>");

        response.writeBody(sb.toString());
    }

    @Mapping("/add-member-form")
    public void addMemberForm(HttpResponse response) {
        String body = "<html><body>" +
                "<h1>Add New Member</h1>" +
                "<form method='POST' action='/add-member'>" +
                "ID: <input type='text' name='id'><br>" +
                "Name: <input type='text' name='name'><br>" +
                "Age: <input type='text' name='age'><br>" +
                "<input type='submit' value='Add'>" +
                "</form><br>" +
                "<a href='/'>Back to Home</a>" +
                "</body></html>";
        response.writeBody(body);
    }

    @Mapping("/add-member")
    public void addMember(HttpRequest request, HttpResponse response) throws IOException {
        log("MemberController.addMember");
        log("request = " + request);

        String id = request.getParam("id");
        String name = request.getParam("name");
        int age = Integer.parseInt(request.getParam("age"));

        Member member = new Member(id, name, age);
        memberRepository.add(member);

        response.writeBody("<h1>save ok</h1>");
        response.writeBody("<a href='/'>Back to Home</a>");
    }
}
