package com.example.demo;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.jar.JarException;
import java.util.stream.Collectors;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.data.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yaml.snakeyaml.events.Event.ID;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import com.example.demo.UserAppService;
import com.example.demo.MusicService;

import com.example.data.Music;
import com.example.data.Schedule;


import java.util.Base64;
import com.example.demo.UserAppRepository;

// docker exec -it scoredei_devcontainer_database_1 psql -U postgres



@Controller
public class AppController {

    private static final long EXPIRATION_TIME = 860000000;

    private static final String SECRET = "secret_key";

    @Autowired
    UserAppService userService;

    @Autowired
    MusicService musicService;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    UserAppRepository userAppRepository;

    @Autowired
    MusicRepository musicRepository;

    @Autowired
    private HttpSession session;

    HttpHeaders headers = new HttpHeaders();

	@GetMapping("/")
	public String HomePage() {
		return "homepage";
	}
	

    @GetMapping("/music")
	public String Music(Model m) throws IOException{
        m.addAttribute("listMusic", this.musicService.getMusic());
        return "music";
	}
    

    @GetMapping("/register")
	public String Register(Model m) {
        m.addAttribute("user", new Users());
        return "register";
	}
    
    @PostMapping("/process_music")
    public String process_music(HttpServletRequest request) throws GeneralSecurityException, IOException {
        String[] selectedIds = request.getParameterValues("check"); // assuming the name of the checkbox is "check"
        // print debug

        this.musicService.reset();

        for(String m : this.musicService.getMusic()){
            Music music = this.musicRepository.findByName(m);
            this.musicRepository.deleteByName(m);
            music.setActive(false);
            this.musicRepository.save(music);
        }

        if (selectedIds != null) {
            for (String id : selectedIds){
                this.musicService.setActive(this.musicService.getMusic().get(Integer.parseInt(id)),true);
            }
        }
        return "clientHomePage";
    }


    @GetMapping("/process_snooze")
	public String process_snooze() throws GeneralSecurityException, IOException, Exception{
        Process process = Runtime.getRuntime().exec("/usr/bin/python3 " + "/home/seed/Downloads/Projeto-AI-main/Snooze.py");
        return "clientHomePage";
	}

    @GetMapping("/process_turnoff")
	public String process_turnoff() throws GeneralSecurityException, IOException, Exception{
        Process process = Runtime.getRuntime().exec("/usr/bin/python3 " + "/home/seed/Downloads/Projeto-AI-main/TurnOff.py");
        return "clientHomePage";
	}

    @GetMapping("/schedule")
	public String Schedule(Model m) {
        return "schedule";
	}

    @PostMapping("/process_schedule")
	public String process_schedule(@ModelAttribute("formData") Schedule schedule) throws GeneralSecurityException, IOException, Exception {
        this.scheduleService.create(schedule);
        return "clientHomePage";
	}

    @PostMapping("/process_register")
	public String process_register(@ModelAttribute Users u) throws GeneralSecurityException, IOException {

       if(this.userService.register(u) == null){
        return "register";
       }

        return "redirect:/";
	}
    
    @GetMapping("/login")
	public String Login(Model m) {
        m.addAttribute("user", new Users());
		return "login";
	}


    @PostMapping("/process_login")
	public String process_login(@ModelAttribute Users u, Model model , HttpServletResponse request,HttpServletResponse response) throws GeneralSecurityException, IOException {
        if(this.userService.authenticateUsers(u) == 1) // is client
        {
            return  "clientHomePage";
        }
        else if(this.userService.authenticateUsers(u) == 3) // not
        {
            System.out.println("Not Registed");
        }
        
        return "redirect:/";
	}
 
}