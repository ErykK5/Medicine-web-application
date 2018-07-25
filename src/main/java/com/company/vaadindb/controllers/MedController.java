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

        /**
         * GET /create  --> Create a new user and save it in the database.
         */
        @RequestMapping("/create")
        @ResponseBody
        public String create(String name, String numb) {
            String userId = "";
            try {
                Med med = new Med( name, numb );
                medDAO.save(med);
                userId = String.valueOf(med.getId());
            }
            catch (Exception ex) {
                return "Error creating the user: " + ex.toString();
            }
            return "User succesfully created with id = " + userId;
        }

        /**
         * GET /delete  --> Delete the user having the passed id.
         */
        @RequestMapping("/delete")
        @ResponseBody
        public String delete(long id) {
            try {
                Med med = new Med(id);
                medDAO.delete(med);
            }
            catch (Exception ex) {
                return "Error deleting the user:" + ex.toString();
            }
            return "User succesfully deleted!";
        }

        /**
         * GET /get-by-email  --> Return the id for the user having the passed
         * email.
         */
        @RequestMapping("/get-by-name")
        @ResponseBody
        public String getByName(String name) {
            String userId = "";
            try {
                Med med = medDAO.findByName(name);
                userId = String.valueOf(med.getId());
            }
            catch (Exception ex) {
                return "User not found";
            }
            return "The user id is: " + userId;
        }

        /**
         * GET /update  --> Update the email and the name for the user in the
         * database having the passed id.

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
