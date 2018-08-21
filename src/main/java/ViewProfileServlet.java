import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/guess") //#1/name //#2pickcolor
public class ViewProfileServlet extends HttpServlet {
    public static Random rand = new Random();
    public static int n = rand.nextInt(5) + 1;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       1 String firstname = request.getParameter("firstname"); // use getParamter for key:value pairs from form
//        request.setAttribute("firstname", firstname); // Var accesible in the next page
//        request.getRequestDispatcher("/profile.jsp").forward(request, response);

//       2 String color = request.getParameter("color");
//        request.setAttribute("color", color);
//        request.getRequestDispatcher("/profile.jsp").forward(request, response);

        String number = request.getParameter("number");
        int userNum = Integer.parseInt(number);

        String again = (userNum < n) ? "Higher" : "Lower";

        request.setAttribute("n", n);
        request.setAttribute("userNum", userNum);
        request.setAttribute("again", again);

        if(userNum != n) {
            request.getRequestDispatcher("/wrong.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        }
//        Bonus: create a link that will reset the random computer number to a new number
//        DRILL 1 (HINTS)
//                Use one servlet and two JSPs.
//                Don't worry about styling.
//        DRILL 2 (HINTS)
//                One servlet and two JSPs.
//        Use style tags
//        DRILL 3
//        Use an instance field on a servlet
    }
}
