package com.climbook.climbook.domain;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.sql.Date;
import java.time.Instant;

@Entity
@Data
public class AccountFollower {

  @EmbeddedId
  AccountFollowerKey id;

  @ManyToOne
  @MapsId("accountId")
  Account account;
  @ManyToOne
  @MapsId("followerId")
  Account follower;

  Date followingStartingDate = new Date(Instant.now().toEpochMilli());
}