/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.service.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class UtilService {

    public Date convertStringToDate(String dateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(dateString);

        return d;
    }

}
