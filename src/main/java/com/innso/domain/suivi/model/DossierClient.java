package com.innso.domain.suivi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "dossier_client")
public class DossierClient implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "uuid", updatable = false, nullable = false)
  private UUID uuid;

  @Column(name = "nom")
  private String nom;

  @Column(name = "reference")
  private String reference;

  @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "dossier")
  private Set<Message> messages = new HashSet<>();

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @PrePersist
  public void prePersist() {
    this.setCreatedAt(new Date());
  }

  @PreUpdate
  public void preUpdate() {
    this.setUpdatedAt(new Date());
  }

}
