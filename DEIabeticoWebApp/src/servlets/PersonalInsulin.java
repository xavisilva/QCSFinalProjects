package servlets;

import example.Voter;
import example.Voter_I;
import mypackage.InsulinaService;
import voter.PersonalBackup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xaviersilva on 08/04/17.
 */
@WebServlet(name = "/PersonalInsulin")
public class PersonalInsulin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean errorFlag = false;
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
            int physicalAct = Integer.parseInt(request.getParameter("physicalAct"));
            String[] physicalSamples = request.getParameterValues("physicalSamples");
            String[] bloodSamples = request.getParameterValues("bloodSample");

            // verificação dos campos
            if (carbsInMeal < 60 || carbsInMeal > 120 || bloodSugarLevel < 120 || bloodSugarLevel > 250 ||
                    targetBloodSugar < 80 || targetBloodSugar > 120 || physicalSamples.length < 2 || bloodSamples.length < 2 ||
                    physicalSamples.length != bloodSamples.length) {
                response.sendRedirect("/error/error.jsp");
            } else {
                // Apenas conversões para tipos difentes
                int[] physicalSamplesInt = new int[physicalSamples.length];
                int[] bloodSamplesInt = new int[bloodSamples.length];

                for (int i = 0; i < physicalSamples.length; i++) {
                    physicalSamplesInt[i] = Integer.parseInt(physicalSamples[i]);
                }

                for (int i = 0; i < bloodSamples.length; i++) {
                    bloodSamplesInt[i] = Integer.parseInt(bloodSamples[i]);
                }

                List<Integer> physicalSamplesList = new ArrayList<Integer>();
                for (int index = 0; index < physicalSamples.length; index++) {
                    physicalSamplesList.add(physicalSamplesInt[index]);
                }

                List<Integer> bloodSamplesList = new ArrayList<Integer>();
                for (int index = 0; index < bloodSamples.length; index++) {
                    bloodSamplesList.add(physicalSamplesInt[index]);
                }
                //

                //verificação do conteúdo dos elementos do bloodSamples [15,100]
                for (int sample : bloodSamplesInt) {
                    if (sample < 15 || sample > 100) {
                        errorFlag = true;
                        break;
                    }
                }

                // verifica se ocorreu algum erro na verficação dos elementos de BloodSamples
                if (errorFlag) {
                    response.sendRedirect("/error/error.jsp");
                } else {
                    //System.out.println(service.personalSensitivityToInsulin(physicalAct, physicalSamplesList, bloodSamplesList));

                    PersonalBackup personalBackup = new PersonalBackup(carbsInMeal, carbsRatio, bloodSugarLevel, targetBloodSugar, physicalAct, physicalSamplesList, bloodSamplesList);
                    Voter_I v = (Voter)new Voter(3, personalBackup);

                    //Object data = service.personalSensitivityToInsulin(physicalAct, physicalSamplesList, bloodSamplesList);
                    //request.setAttribute("data", data);
                    request.getRequestDispatcher("/output.jsp").forward(request, response);
                }

            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
