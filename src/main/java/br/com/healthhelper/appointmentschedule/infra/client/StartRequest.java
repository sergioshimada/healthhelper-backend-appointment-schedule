package br.com.healthhelper.appointmentschedule.infra.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StartRequest {

    private String dateTime;
    private String timeZone;
}
