package servlets;

import example.Voter;
import example.Voter_I;

import voter.StandardBackup;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xaviersilva on 08/04/17.
 */
@WebServlet(name = "/StandardBackup")
public class StandardInsulin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //mypackage.Insulina service = new InsulinaService().getInsulinaPort();

        // verifica se os campos são deixados em branco
        if(request.getParameter("carbsInMeal").compareTo("") == 0 || request.getParameter("bloodSugarLevel").compareTo("") == 0 ||
                request.getParameter("targetBloodSugar").compareTo("") == 0){
            response.sendRedirect("/error/error.jsp");
        }
        else {
            int carbsInMeal = Integer.parseInt(request.getParameter("carbsInMeal"));
            int carbsRatio  =  Integer.parseInt(request.getParameter("carbsRatio"));
            int bloodSugarLevel = Integer.parseInt(request.getParameter("bloodSugarLevel"));
            int targetBloodSugar = Integer.parseInt(request.getParameter("targetBloodSugar"));
            int indSens = Integer.parseInt(request.getParameter("indSens"));

            if (carbsInMeal < 60 || carbsInMeal > 120 || bloodSugarLevel < 120 || bloodSugarLevel > 250 ||
                    targetBloodSugar < 80 || targetBloodSugar > 120 || indSens < 15 || indSens > 100) {
                response.sendRedirect("/error/error.jsp");
            } else {
                //System.out.println(service.mealtimeInsulinDose(carbsInMeal, carbsRatio, bloodSugarLevel, targetBloodSugar, indSens));

                StandardBackup standardBackup = new StandardBackup(carbsInMeal, carbsRatio, bloodSugarLevel, targetBloodSugar, indSens);
                Voter_I v = (Voter)new Voter(2, standardBackup);

                //Object data = service.mealtimeInsulinDose(carbsInMeal, carbsRatio, bloodSugarLevel, targetBloodSugar, indSens);
                //request.setAttribute("data", data);
                request.getRequestDispatcher("/output.jsp").forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
