package com.tailor.Shop.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String imgname;
    private String description;
    private boolean isActive;
    private String budget;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "job")
    private List<Quotation> quotations;
}
