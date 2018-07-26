package com.company.vaadindb.controllers;

import com.company.vaadindb.dao.MedDAO;
import com.company.vaadindb.model.Med;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MedController {

    @Autowired
    private MedDAO medDAO;

        @RequestMapping("/create")
        @ResponseBody
        public void create(String name, String numb) {
            try {
                Med med = new Med( name, numb );
                medDAO.save(med);
            }
            catch (Exception ex) {
                ex.getStackTrace();
            }
        }

        @RequestMapping("/delete")
        @ResponseBody
        public void delete(long id) {
            try {
                Med med = new Med(id);
                medDAO.delete(med);
            }
            catch (Exception ex) {
                ex.getStackTrace();
            }
        }

        @RequestMapping("/get-by-name")
        @ResponseBody
        public void getByName(String name) {
            try {
                Med med = medDAO.findByName(name);
            }
            catch (Exception ex) {
                ex.getStackTrace();
            }
        }

        /*
        @RequestMapping("/update")
        @ResponseBody
        public String updateUser(Long id, String name, String numb) {
            try {
                Med med = medDAO.findById(id);
                med.setName(name);
                med.setName(numb);
                medDAO.save(med);
            }
            catch (Exception ex) {
                return "Error updating the user: " + ex.toString();
            }
            return "User succesfully updated!";
        }
        */

}
