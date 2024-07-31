package com.devapps.scoutProMalawi.Utils;

import com.devapps.scoutProMalawi.data.repositories.AgentRepository;
import com.devapps.scoutProMalawi.data.repositories.TeamRepository;
import com.devapps.scoutProMalawi.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final AgentRepository agentRepository;
    private final TeamRepository teamRepository;

    @Bean
    public JwtService jwtService() {
        return new JwtService();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return agentRepository.findAgentByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Agent with username " + username + " not found"));
            }
        };
    }

    @Bean
    public UserDetailsService userDetailsService1() {

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return teamRepository.findTeamByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Team with username " + username + "not found"));
            }
        };
    }
}
