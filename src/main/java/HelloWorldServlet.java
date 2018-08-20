import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        res.setContentType("text/html");
        PrintWriter out = null;

        //get parameter method on query string
        String name = (req.getParameter("name") != null) ? req.getParameter(("name")) : "World";
        // is a turinary statement-- if name is not null, pass in a <name> value, if not default to 'World'

        try {
            out = res.getWriter();
            out.printf("<h1>Hello, %s!</h1>", name); //use string <name> variable
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
