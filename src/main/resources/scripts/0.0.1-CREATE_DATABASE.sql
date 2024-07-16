CREATE SCHEMA IF NOT EXISTS appointment_schedule;

DROP TABLE IF EXISTS appointment_schedule.schedule;

CREATE TABLE appointment_schedule.schedule
(
    id                INT8           NOT NULL,
    uuid              UUID           NOT NULL,
    treatment_name    VARCHAR(255)   NOT NULL,
    treatment_uuid	  UUID           NOT NULL,
    schedule_start    TIMESTAMP      NOT NULL,
    schedule_end      TIMESTAMP      NOT NULL,
    creation_date     TIMESTAMP      NOT NULL,
    last_update       TIMESTAMP      NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS appointment_schedule.schedule_sequence
    INCREMENT BY 50
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;
