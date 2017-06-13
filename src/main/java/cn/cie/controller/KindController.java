package cn.cie.controller;

import cn.cie.services.KindService;
import cn.cie.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by RojerAlone on 2017/6/6.
 */
@CrossOrigin
@Controller
@RequestMapping(value = "kind")
public class KindController extends AbstractController {

    @Autowired
    private KindService kindService;

    @GetMapping(value = "all")
    @ResponseBody
    public Result allkinds(HttpServletResponse response) {
        Result result = kindService.getAll();
        return result;
    }

    @GetMapping(value = "{kind}/games")
    @ResponseBody
    public Result getGamesByKind(@PathVariable(value = "kind") Integer kind, HttpServletResponse response) {
        return kindService.getGamesByKind(kind);
    }

}
