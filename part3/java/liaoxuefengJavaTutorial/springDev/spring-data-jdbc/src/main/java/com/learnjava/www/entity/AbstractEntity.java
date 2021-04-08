package com.learnjava.www.entity;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

  private Long id;
  private Long createdAt;

  public void setId(Long id) {
    this.id = id;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  public Long getId() {
    return this.id;
  }

  @Column(nullable = false, updatable = false)
  public Long getCreatedAt() {
    return this.createdAt;
  }

  @Transient
  public ZonedDateTime getCreatedDateTime() {
    return Instant.ofEpochMilli(this.createdAt).atZone(ZoneId.systemDefault());
  }

  @PrePersist
  public void preInsert() {
    setCreatedAt(System.currentTimeMillis());
  }
}
