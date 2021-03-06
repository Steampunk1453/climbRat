package com.climbRat.security;

import com.climbRat.domain.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class ClimbRatUserDetails implements UserDetails {

  private Account currentUser;

  public ClimbRatUserDetails(Account currentUser) {
    this.currentUser = currentUser;
  }

  public String getProfileString(){
    return currentUser.getProfileString();
  }

  public Account getCurrentUser(){
    return currentUser;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("USER"));
  }

  @Override
  public String getPassword() {
    return currentUser.getPassword();
  }

  @Override
  public String getUsername() {
    return currentUser.getUserName();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
