package com.evrenvural.admin.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "issue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "description", length = 1000)
    private  String descirption;

    @Column(name = "details", length = 4000)
    private  String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issueStatus")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY) // Lazy seçildiğinde issue'lar çağrıldığı zaman userId'si getirilmez. Eğer Eager seçilseydi getirilirdi.
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY) // Lazy seçildiğinde issue'lar çağrıldığı zaman userId'si getirilmez. Eğer Eager seçilseydi getirilirdi.
    private Project project;
}
