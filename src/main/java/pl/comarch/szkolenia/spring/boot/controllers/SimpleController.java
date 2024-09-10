package pl.comarch.szkolenia.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class SimpleController {

    @RequestMapping(path = "/test1", method = RequestMethod.GET)
    public String test1() {
        System.out.println("cos zadzialalo !!!");
        return "test";
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    public String test2(@RequestParam("name") String imie,
                        @RequestParam("surname") String nazwisko,
                        @RequestParam("age") int wiek) {
        System.out.println(imie);
        System.out.println(nazwisko);
        System.out.println(wiek);

        return "test";
    }

    @RequestMapping(path = "/test3/{name}/{surname}/{age}", method = RequestMethod.GET)
    public String test3(@PathVariable("name") String name,
                        @PathVariable("surname") String surname,
                        @PathVariable("age") int age) {
        System.out.println("Nasz nowy mappping");
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);

        return "test";
    }

    @RequestMapping(path = "/test4", method = RequestMethod.GET)
    public String test4() {
        System.out.println("wysylam form !!");
        return "form";
    }

    @RequestMapping(path = "/test4", method = RequestMethod.POST)
    public String test4(@RequestParam("name") String name,
                        @RequestParam("surname") String surname,
                        @RequestParam("age") int age) {
        System.out.println("przyszlo nam z formularza !!!");

        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);

        return "test";
    }

    @RequestMapping(path = "/test5/{name}/{surname}", method = RequestMethod.GET)
    public String test5(@PathVariable("name") String imie,
                        @PathVariable("surname") String nazwisko,
                        @RequestParam("wiek") int wiek) {
        System.out.println(imie);
        System.out.println(nazwisko);
        System.out.println(wiek);

        return "test";
    }

    @RequestMapping(path = "/test6", method = RequestMethod.GET)
    public String test6(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Janusz");
        names.add("Zbyszek");
        names.add("Wiesiek");
        names.add("Mateusz");
        names.add("Karol");

        String randomName = names.get(new Random().nextInt(names.size()));

        model.addAttribute("imie", randomName);
        model.addAttribute("imiona", names);

        return "names";
    }

    @RequestMapping(path = "/form2", method = RequestMethod.GET)
    public String form2(Model model) {
        Client client = new Client();
        System.out.println(client);
        model.addAttribute("modelObject", client);
        return "form2";
    }

    @RequestMapping(path = "/form2", method = RequestMethod.POST)
    public String form2(@ModelAttribute Client client) {
        System.out.println(client);
        System.out.println(client.getName());
        System.out.println(client.getSurname());
        System.out.println(client.getAge());
        System.out.println(client.getCity());
        System.out.println(client.getStreet());
        System.out.println(client.getNo());

        return "test";
    }
}
