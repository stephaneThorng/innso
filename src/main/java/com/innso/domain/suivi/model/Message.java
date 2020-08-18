package com.innso.domain.suivi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "uuid", updatable = false, nullable = false)
  private UUID uuid;

  @Column(name = "auteur")
  private String auteur;

  @Column(name = "contenu")
  private String contenu;

  @Column(name = "canal")
  @Enumerated(EnumType.STRING)
  private Canal canal;

  @JoinColumn(name = "dossier_uuid")
  @ManyToOne
  private DossierClient dossier;

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
