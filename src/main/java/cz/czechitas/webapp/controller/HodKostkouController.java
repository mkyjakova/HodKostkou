package cz.czechitas.webapp.controller;

import java.lang.reflect.*;
import java.util.*;
import javax.xml.ws.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HodKostkouController {

    private static final List<String> vyroky = Arrays.asList(
            "Když jsem přijížděl domů, vjel jsem omylem do jiného dvora a naboural do stromu, protože ho doma na tomto místě nemám.",
            "To druhé auto do mne nabouralo bez jakéhokoliv předchozího varování.",
            "Myslel jsem, že mám stažené okénko. Zjistil jsem ale, že je zavřené, když jsem vystrčil ruku ven.",
            "Srazil jsem se se stojícím nákladním automobilem, když přijížděl z opačného směru.",
            "Ten dědula, kterého jsem porazil, by se na druhou stranu silnice stejně nedostal.",
            "Chodec do mne narazil a pak mi skočil pod auto.",
            "Ten chodec váhal, kterým směrem se má vydat, tak jsem ho přejel."
            );

    @RequestMapping("/hod.html")
    public ModelAndView zobrazHod(){
        ModelAndView drzakNaDataAJmenoStranky;
        drzakNaDataAJmenoStranky = new ModelAndView("hod-template");
        drzakNaDataAJmenoStranky.addObject("hozeno", 6);

        Random generatorNahodnychCisel;
        generatorNahodnychCisel = new Random();

        Random generatorNahodnychVyrokov;
        generatorNahodnychVyrokov = new Random();

        int nahodneCislo = generatorNahodnychCisel.nextInt(6) + 1;
        drzakNaDataAJmenoStranky.addObject("hozeno", nahodneCislo);

        int nahodnyVyrok = generatorNahodnychVyrokov.nextInt(vyroky.size());

        String vyrok;
        vyrok = new String();
        vyrok=vyroky.get(nahodnyVyrok);

        drzakNaDataAJmenoStranky.addObject("vyrok", vyrok);


        return drzakNaDataAJmenoStranky;
    }

}

