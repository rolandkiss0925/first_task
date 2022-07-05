package com.example.first_task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class CalendarPeriodQueryDTO {
    private Date from;
    private Date to;
}
