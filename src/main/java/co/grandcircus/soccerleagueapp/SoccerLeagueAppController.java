package co.grandcircus.soccerleagueapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.soccerleagueapp.dao.Player;
import co.grandcircus.soccerleagueapp.dao.Team;
import co.grandcircus.soccerleagueapp.entity.PlayerDao;
import co.grandcircus.soccerleagueapp.entity.TeamDao;


@Controller
public class SoccerLeagueAppController {

	@Autowired
	private PlayerDao playerDao;
	
	@Autowired
	private TeamDao teamDao;
	
	// Creating Players
	@RequestMapping("/player/create")
	public ModelAndView showCreateForm() {
		ModelAndView mav = new ModelAndView("player-form");
		mav.addObject("title", "Add Player");
		mav.addObject("teams", teamDao.findAll());
		return mav;
	}

	@RequestMapping(value = "/player/create", method = RequestMethod.POST)
	public ModelAndView submitCreateForm(String name, int teamId) {
		Player player = new Player();
		player.setName(name);
		player.setTeam(teamDao.findById(teamId));
		System.out.println(player);
//		playerDao.create(player);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/make")
	public ModelAndView make() {
		Player player = new Player();
		player.setName("test");
		Team team = teamDao.findById(1);
		player.setTeam(team);
		playerDao.create(player);
		return new ModelAndView("redirect:/");
		
		
	}
	
}
