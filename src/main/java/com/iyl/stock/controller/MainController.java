package com.iyl.stock.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyl.stock.service.ScheduleService;
import com.iyl.stock.vo.ScheduleVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

    @Autowired
    ScheduleService scheduleService;

    static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    //    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    /**
     * @Author 남준호
     * @Comment 메인화면
     * @param locale
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) throws Exception {
        ScheduleVo scheduleVo = new ScheduleVo();
        model.addAttribute("resultList", scheduleService.selectList(scheduleVo));

        return "home";
    }

    /**
     * @Author 남준호
     * @Comment 상세
     * @param locale
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{seqno}", method = RequestMethod.GET)
    public String selectScheduleView(@PathVariable Integer seqno, ScheduleVo scheduleVo, Model model) throws Exception {
        model.addAttribute("resultMap", scheduleService.select(scheduleVo));

        return "view";
    }

    /**
     * @Author 남준호
     * @Comment 메인화면
     * @param locale
     * @param model
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/push/{message}", method = RequestMethod.GET)
    public void pushTest(@PathVariable String message, Model model) throws Exception {
        this.scheduleService.insertPush(message);
    }

}
