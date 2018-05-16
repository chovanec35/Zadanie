package sk.zadanie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sk.zadanie.dao.ContactDao;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.Contact;
import sk.zadanie.entity.User;
import sk.zadanie.service.CategoryService;
import sk.zadanie.service.ContactService;
import sk.zadanie.service.impl.UtilService;

@Controller
@SessionAttributes("loggedUser")
public class ContactsControler {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ContactService contactService;

    @Autowired
    UtilService utilService;

    @Autowired
    ContactDao contactDao;

    @RequestMapping(value = "/my-contacts", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView viewLogin(@RequestParam(value = "page", defaultValue = "1") String page, HttpServletRequest request,
            HttpServletResponse response, HttpSession httpSession, Model model) throws ParseException {

        ModelAndView mav = new ModelAndView("my-contacts");
        User user = (User) httpSession.getAttribute("loggedUser");

        if (user != null) {
            ContactDto contactDto = contactDao.setParamertersNull();
            mav.addObject("page", page);
            mav.addObject("size", utilService.countPages(user));
            mav.addObject("countContacts", utilService.countContacts(user));
            mav.addObject("contactsList", contactService.getAllContacts(user, contactDto, Integer.parseInt(page)));
            mav.addObject("categoryList", categoryService.getAllCategories());
            mav.addObject("title", "Contacts");
            return mav;
        }
        mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping(value = "/searchProcess", method = RequestMethod.POST)
    public ModelAndView searchProcess(@RequestParam(value = "page", defaultValue = "1") String page,
            @ModelAttribute("contact") ContactDto contactDto, HttpSession httpSession,
            BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

        ModelAndView mav = new ModelAndView("my-contacts");
        User user = (User) httpSession.getAttribute("loggedUser");

        if (user != null) {
            String dateString = contactDto.getBirthdate();
            mav.addObject("size", utilService.countPages(user));
            mav.addObject("categoryList", categoryService.getAllCategories());
            mav.addObject("contactsList", contactService.getAllContacts(user, contactDto, Integer.parseInt(page)));
            mav.addObject("user_Id", user.getUserId());
            mav.addObject("title", "Contacts");
        } else {
            mav.addObject("title", "Not found");
            mav.addObject("login");
        }
        return mav;
    }

    @RequestMapping(params = {"delContact"}, method = RequestMethod.POST)
    public ModelAndView contactListProcess(@RequestParam(value = "page", defaultValue = "1") String page, HttpServletRequest request,
            HttpServletResponse response, HttpSession httpSession) throws IOException, ServletException, ParseException {

        ModelAndView mav = new ModelAndView("my-contacts");
        User user = (User) httpSession.getAttribute("loggedUser");
        String id = request.getParameter("delContact");
        ContactDto contactDto = contactDao.setParamertersNull();

        contactDao.delContact(Integer.parseInt(id));

        mav.addObject("size", utilService.countPages(user));
        mav.addObject("categoryList", categoryService.getAllCategories());
        mav.addObject("contactsList", contactService.getAllContacts(user, contactDto, Integer.parseInt(page)));
        mav.addObject("user_Id", user.getUserId());
        mav.addObject("title", "Contacts");

        return mav;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteContact(@RequestParam(value = "page", defaultValue = "1") String page,
            @RequestParam("id") String id, HttpServletRequest request,
            HttpSession httpSession) throws IOException, ServletException, ParseException {

        ModelAndView mav = new ModelAndView("redirect:my-contacts");
        User user = (User) httpSession.getAttribute("loggedUser");
        ContactDto contactDto = contactDao.setParamertersNull();

        contactDao.delContact(Integer.parseInt(id));
        mav.addObject("size", utilService.countPages(user));
        System.out.println("SIZE ---> " + utilService.countPages(user));
        mav.addObject("countContacts", utilService.countContacts(user));
        System.out.println("Count Contacts ---> " + utilService.countContacts(user));
        mav.addObject("categoryList", categoryService.getAllCategories());
        mav.addObject("contactsList", contactService.getAllContacts(user, contactDto, 1));
        mav.addObject("user_Id", user.getUserId());
        mav.addObject("title", "Contacts");

        return mav;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getContactDetail(@RequestParam("id") String id) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Contact> detail = new ArrayList<>();

        Contact contact = contactService.getContactById(Integer.parseInt(id));
        detail.add(contact);

        map.put("data", detail);
        return map;
    }
}