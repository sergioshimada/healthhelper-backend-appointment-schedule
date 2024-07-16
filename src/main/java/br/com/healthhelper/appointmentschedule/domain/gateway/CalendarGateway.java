package br.com.healthhelper.appointmentschedule.domain.gateway;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface CalendarGateway {
    AppointmentSchedule findAvailableSchedule() throws GeneralSecurityException, IOException;
    void insertSchedule(final AppointmentSchedule appointmentSchedule);
}