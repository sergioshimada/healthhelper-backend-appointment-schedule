package br.com.healthhelper.appointmentschedule.infra.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "schedule")
@EntityListeners(AuditingEntityListener.class)
public class AppointmentScheduleModel {

    @Id
    @GeneratedValue(generator = "schedule_sequence")
    @SequenceGenerator(name = "schedule_sequence", sequenceName = "schedule_sequence")
    private Long id;
    private UUID uuid;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_uuid")
    private UUID customerUuid;
    @Column(name = "treatment_name")
    private String treatmentName;
    @Column(name = "treatment_uuid")
    private UUID treatmentUuid;
    @Column(name = "schedule_start")
    private LocalDateTime scheduleStart;
    @Column(name = "schedule_end")
    private LocalDateTime scheduleEnd;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false, updatable = false)
    @CreatedDate
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update", nullable = false)
    @LastModifiedDate
    private Date lastUpdate;
}
