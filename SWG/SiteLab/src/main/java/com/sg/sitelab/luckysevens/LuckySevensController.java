package com.sg.sitelab.luckysevens;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
@Controller
public class LuckySevensController {

    private LuckySevensDao dao;

    @Inject
    public LuckySevensController(LuckySevensDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/luckySevens", method = RequestMethod.GET)
    public String displayLuckySevens() {
        return "luckySevens";
    }
    
    @RequestMapping(value = "/playLuckySevens", method = RequestMethod.POST)
    public String playGame(HttpServletRequest req, Model model) {

        int startingBet = Integer.parseInt(req.getParameter("wager"));
        // Create new Round object, set first field
        
        RoundStats roundStats = dao.returnRoundStats();
        dao.resetRoundStats();
        roundStats.setWager(startingBet);
        roundStats.setCurrentMoney(startingBet);

        int rollCounter = 0;

        do {
            dao.rollDice();
            dao.evaluateRollTotal();
            dao.calculateCurrentMoneyAfterRoll();
            dao.evaluateMaxMoneyRoll(rollCounter);
            rollCounter++;
        } while (roundStats.getCurrentMoney() > 0);
        // When out of money, set the final roll counter 
        roundStats.setEndRolls(rollCounter);

        model.addAttribute("roundStats", roundStats);
        return "luckySevens";
    }    
    
}
