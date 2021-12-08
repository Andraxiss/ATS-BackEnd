package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Configs.TokenProvider;
import com.ecam.atsnum.Service.UserService;
import com.ecam.atsnum.Service.Interface.IUserService;
import com.ecam.atsnum.model.User;
import com.ecam.atsnum.model.DTO.AuthTokenDto;
import com.ecam.atsnum.model.DTO.LoginUserDto;
import com.ecam.atsnum.model.DTO.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private IUserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody UserDto loginUser) throws AuthenticationException {
        // System.out.println(loginUser);
        User currentUser = userService.getUserByEmail(loginUser.getEmail());
        if (currentUser == null) {
            userService.createUser(loginUser);
        }
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword_hash()));
        Object principal = authentication.getPrincipal();
        String username = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        currentUser = userService.getUserByEmail(username);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthTokenDto(token, currentUser));
    }

    @PutMapping()
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @PostMapping(value="/create")
    public User createUser(@RequestBody UserDto user){
        return this.userService.createUser(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value="/all")
    public List<User> getAllUsers(){
        return this.userService.getAllUser();
    }

    @GetMapping(value="/{id}")
    public User getUserById(@PathVariable(required=true,name="id") int id){
        return this.userService.getUserById(id);
    }

}
