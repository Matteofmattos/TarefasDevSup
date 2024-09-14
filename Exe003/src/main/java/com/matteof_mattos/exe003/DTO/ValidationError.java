package com.matteof_mattos.exe003.DTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomErrorDTO{

    private List<FIeldMessege> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, int status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public void addFieldMessege(FIeldMessege fIeldMessege){
        this.errors.add(fIeldMessege);
    }

    public List<FIeldMessege> getErrors() {
        return errors;
    }
}
