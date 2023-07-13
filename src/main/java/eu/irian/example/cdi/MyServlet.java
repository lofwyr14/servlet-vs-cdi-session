package eu.irian.example.cdi;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet")
public class MyServlet extends HttpServlet {

  @Inject
  private SessionInfo sessionInfo;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      response.setContentType("text/html");
      PrintWriter writer=response.getWriter();

      writer.println("<html><body>");
      writer.println("<h1>Welcome to servlet</h1>");
      writer.println("<br/>");
      final HttpSession session = request.getSession(false);
      writer.println("sessionId=" + (session != null ? session.getId() : "<no session>"));
      writer.println("<br/>");
//      writer.println("sessionId=" + sessionInfo.getSessionId());
//      writer.println("<br/>");
      writer.println("counter=" + sessionInfo.getCounter());
      writer.println("<br/>");
      writer.println("sessionInfo.getIdentityHashCode=" + sessionInfo.getIdentityHashCode());
      writer.println("<br/>");
      writer.println("servlet.getIdentityHashCode=" + System.identityHashCode(this));
      writer.println("<br/>");
      writer.println("objectId=" + sessionInfo.getObjectId());
      writer.println("<br/>");
      writer.println("</body></html>");

      Thread.sleep(1000);

      writer.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
      e.printStackTrace(System.err);
    }
  }
}
