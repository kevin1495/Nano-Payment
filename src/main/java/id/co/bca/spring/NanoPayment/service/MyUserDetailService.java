package id.co.bca.spring.NanoPayment.service;

import id.co.bca.spring.NanoPayment.model.MyUserDetail;
import id.co.bca.spring.NanoPayment.model.UserModel;
import id.co.bca.spring.NanoPayment.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserModel userModel = userRepo.findByUsername(username);
        if (userModel == null){
            throw new UsernameNotFoundException("No User found!");
        }
        return new MyUserDetail(userModel);
    }
}
