import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class support extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext sc = this.getServletContext();
        String suportEmail = sc.getInitParameter("support-email");
        PrintWriter out = resp.getWriter();
        out.print("<html><body><form action=\"support\" method=\"POST\">  <label style=\"display: block\"> Email  <input type=\"email\" name=\"email\" id=\"email\"> </label><label style=\"display: block\"> Name <input type=\"text\" name=\"name\" id=\"name\"> <label style=\"display: block\"> Problem <input type=\"text\" name=\"problem\" id=\"problem\"> </label> <label style=\"display: block\"> Problem  description<textarea style=\"display: block\" name=\"probdesc\" id=\"probdesc\" cols=\"30\" rows=\"10\" placeholder=\"Decribe your problem here\"></textarea> </label><input type=\"submit\" value=\"Help!\"> <p>By clicking submit, you will send an email to "+suportEmail+" with the details of your problem</p></form></body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext sc = this.getServletContext();
        String suportEmail = sc.getInitParameter("support-email");
        String ticketID = "TKT_ID_"+ UUID.randomUUID();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Request Received</title></head><body>");
        out.print("<p>Thank you! "+name +" for contacting us. You should receive reply from us within 24 hrs in your email inbox "+email+". Let us know in our support email "+suportEmail+" if you don’t receive reply within 24 hrs. Please be sure to attach your reference "+ticketID+" in your email.</p>");
        out.print("</body></html>");
    }
}
