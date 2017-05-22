package servlets;

import example.Voter;
import example.Voter_I;
import mypackage.InsulinaService;
import voter.BackgroundBackup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xaviersilva on 06/04/17.
 */
@WebServlet(name = "/BackgroundInsulinDose")
public class BackgroundInsulinDose extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //mypackage.Insulina service = new InsulinaService().getInsulinaPort();

        if(request.getParameter("weight").compareTo("") == 0){
            response.sendRedirect("/error/error.jsp");
        }
        else {

            int weight = Integer.parseInt(request.getParameter("weight"));

            if (weight < 40 || weight > 130) {
                response.sendRedirect("/error/error.jsp");
            } else {

                BackgroundBackup backgroundBackup = new BackgroundBackup(weight);
                Voter_I v = (Voter)new Voter(1, backgroundBackup);

                request.getRequestDispatcher("/output.jsp").forward(request, response);
            }

        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
