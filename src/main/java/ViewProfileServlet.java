import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/guess") //#1/name //#2pickcolor
public class ViewProfileServlet extends HttpServlet {
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

        Random rand = new Random();
        int n = rand.nextInt(5) + 1;

        String number = request.getParameter("number");
        int userNum = Integer.parseInt(number);
        request.setAttribute("number", number);
        request.setAttribute("userNum", userNum);

        if(userNum != n) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        }


    }
}
