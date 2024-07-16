package br.com.healthhelper.appointmentschedule.app.config.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseError {

    private String message;
}