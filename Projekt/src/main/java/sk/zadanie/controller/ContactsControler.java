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
import org.springframework.web.bind.support.SessionStatus;
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
    ModelAndView viewLogin(@RequestParam(value = "page", defaultValue = "1") String page, 
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            HttpServletResponse response, HttpServletRequest request,
            HttpSession httpSession, Model model) throws ParseException {

        System.out.println(request.getParameter("firstName"));
        ContactDto contactDto = new ContactDto();
        ModelAndView mav = new ModelAndView("my-contacts");
        User user = (User) httpSession.getAttribute("loggedUser");

        if (request.getSession().getAttribute("contactDto") != null) {
            contactDto = contactDao.setParamertersNull((ContactDto) request.getSession().getAttribute("contactDto"));
        } else {
            contactDto = contactDao.setParamertersNull(contactDto);
        }

        if (user != null) {
            mav.addObject("page", page);
            System.out.println("po null " + contactDto);
            mav.addObject("size", utilService.countPages(user, contactDto));
            System.out.println("COUNT GET" + utilService.countPages(user, contactDto));
            mav.addObject("countContacts", utilService.countContacts(user));
            mav.addObject("contactsList", contactService.getAllContacts(user, contactDto, Integer.parseInt(page)));
            mav.addObject("categoryList", categoryService.getAllCategories());
            mav.addObject("title", "Contacts");
            return mav;
        }
        mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping(value = "/my-contacts", method = RequestMethod.POST)
    public ModelAndView searchProcess(@RequestParam(value = "page", defaultValue = "1") String page,
            @ModelAttribute("contact") ContactDto contactDto, HttpSession httpSession,
            HttpServletRequest request) throws IOException, ParseException {

        ModelAndView mav = new ModelAndView("my-contacts");
        User user = (User) httpSession.getAttribute("loggedUser");
        if (user != null) {
            String dateString = contactDto.getBirthdate();
            mav.addObject("size", utilService.countPages(user, contactDto));
            System.out.println("COUNT POST" + utilService.countPages(user, contactDto));
            mav.addObject("categoryList", categoryService.getAllCategories());
            mav.addObject("contactsList", contactService.getAllContacts(user, contactDto, Integer.parseInt(page)));
            mav.addObject("user_Id", user.getUserId());
            mav.addObject("title", "Contacts");
            mav.addObject("contact", contactDto);
            request.getSession().setAttribute("contactDto", contactDto);
        } else {
            mav.addObject("title", "Login");
            mav.addObject("redirect:login");
        }
        return mav;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteContact(@RequestParam(value = "page", defaultValue = "1") String page,
            @RequestParam("id") String id, HttpServletRequest request,
            HttpSession httpSession) throws IOException, ServletException, ParseException {

        ModelAndView mav = new ModelAndView("redirect:my-contacts");
        User user = (User) httpSession.getAttribute("loggedUser");

        contactDao.delContact(Integer.parseInt(id));

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
