package co.grandcircus.soccerleagueapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.soccerleagueapp.dao.Player;
import co.grandcircus.soccerleagueapp.entity.PlayerDao;
import co.grandcircus.soccerleagueapp.entity.TeamDao;


@Controller
public class SoccerLeagueAppController {

	@Autowired
	private PlayerDao playerDao;
	
	@Autowired
	private TeamDao teamDao;
	
	// Index
	@RequestMapping("/")
	public ModelAndView listPlayers(
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="teamId", required=false) Integer teamId) {
		ModelAndView mav = new ModelAndView("index");
		if (keyword != null && !keyword.isEmpty()) {
			mav.addObject("players", playerDao.findByKeyword(keyword));
		} else if (teamId != null) {
			mav.addObject("players", playerDao.findByTeamId(teamId));
		} else {
			mav.addObject("players", playerDao.findAll());
		}
		// list of teams needed for <select>
		mav.addObject("teams", teamDao.findAll());
		return mav;
	}
	
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
		playerDao.create(player);
		return new ModelAndView("redirect:/");
	}
	
	// Deleting Players
	@RequestMapping("/delete-player/{playerId}")
	public ModelAndView deleteItem(@PathVariable("playerId") int playerId) {
		playerDao.delete(playerId);
		return new ModelAndView("redirect:/");
	}
	
}
