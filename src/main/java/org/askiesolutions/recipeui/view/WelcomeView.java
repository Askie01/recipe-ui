package org.askiesolutions.recipeui.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class WelcomeView {

    @GetMapping
    public String welcomePage(Model model) {
        model.addAttribute("title", "Cooking recipes");
        model.addAttribute("view", "pages/welcome");
        return "layout/base";
    }
}
