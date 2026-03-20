package com.project.taskapp.models.DTO;

import java.util.List;

/**
 * DTO for list of IDs
 */
public class IdListRequest {

    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
