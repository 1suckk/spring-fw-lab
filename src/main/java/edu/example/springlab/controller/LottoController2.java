package edu.example.springlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.example.springlab.domain.LottoVO2;

import javax.servlet.http.HttpSession;

@Controller
public class LottoController2 {
    @RequestMapping(value="/lotto2")
    public String handle(@ModelAttribute("choice") LottoVO2 vo, int lottoNum, HttpSession s){

        /* 랜덤 번호 */
        vo.setLottoNum(lottoNum);
        int randNum = (int)(Math.random()*6)+1;
        s.setAttribute("randNum", randNum);
        System.out.println("랜덤번호:" +randNum);

        /* 응모횟수 */
        if (s.getAttribute("count") == null){
            s.setAttribute("count", 0);
        }
        Integer count = (Integer)(s.getAttribute("count"));
        System.out.println("count : " + count);
        s.setAttribute("count", count+1); //카운트 추가

        /* 결과 넘겨주기 */
        if (count > 3 ){
            vo.setMessage("로또 응모는 3번 까지만 가능합니다<br>브라우저를 재기동한 후에 응모한 후에 응모해 주세요");
            vo.setImage("images/snow.png");
        }else {
            if (lottoNum == randNum) {
                vo.setMessage("추카추카");
                vo.setImage("images/sun.png");

            } else {
                vo.setMessage("아쉽네요... 다음 기회를!!");
                vo.setImage("images/rain.png");
            }
        }
        return "lottoView2";
    }
}