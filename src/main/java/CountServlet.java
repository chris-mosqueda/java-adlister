import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet {

    private int count = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //count = (req.getParameter("reset") != null) ? 0 : count; // (Without using a redirect)

        // redirects count?reset back to count... and continues ++count (below if())
        if (req.getParameter("reset") != null) {
            count = 0;
            res.sendRedirect("/count"); //will still evaluate try catch below (= incorrect count)
            return; // stops the do get method running below (would equal incorrect count, (have to use - count = -1)
        }

        PrintWriter out;
        try {
            out = res.getWriter();
            out.println("Count " + ++count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
