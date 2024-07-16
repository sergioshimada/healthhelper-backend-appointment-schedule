package br.com.healthhelper.appointmentschedule.infra.db.repository;

import br.com.healthhelper.appointmentschedule.infra.db.model.AppointmentScheduleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentScheduleRepository extends JpaRepository<AppointmentScheduleModel, Long> {
    List<AppointmentScheduleModel> findAppointmentScheduleModelByScheduleStartGreaterThanEqualAndScheduleEndGreaterThanEqual(LocalDateTime scheduleStart, LocalDateTime scheduleEnd);
}
