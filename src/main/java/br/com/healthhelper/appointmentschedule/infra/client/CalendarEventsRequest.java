package br.com.healthhelper.appointmentschedule.infra.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalendarEventsRequest {

    private StartRequest start;
    private EndRequest end;
    private String description;
    private String summary;
}
