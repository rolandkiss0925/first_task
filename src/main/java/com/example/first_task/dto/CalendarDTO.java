package com.example.first_task.dto;

import com.example.first_task.entity.Calendar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalendarDTO {

    public enum Status {
        NEW,
        INPRO,
        DONE,
        DELETED;

        public Calendar.Status map() {
            switch (this) {
                case NEW:
                    return Calendar.Status.NEW;
                case INPRO:
                    return Calendar.Status.INPRO;
                case DONE:
                    return Calendar.Status.DONE;
                case DELETED:
                    return Calendar.Status.DELETED;
            }
            return null;
        }
    }

    private Date from;
    private Date to;
    private Long patientId;
    private Long creatorUserId;
    private Long servicePointId;
    private Status status;

}
