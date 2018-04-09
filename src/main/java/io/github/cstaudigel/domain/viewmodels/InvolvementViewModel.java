package io.github.cstaudigel.domain.viewmodels;

import io.github.cstaudigel.domain.models.InvolvementRequest;

import java.util.List;

public class InvolvementViewModel {

    List<InvolvementRequest> requests;

    public InvolvementViewModel(List<InvolvementRequest> requests) {
        this.requests = requests;
    }

    public List<InvolvementRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<InvolvementRequest> requests) {
        this.requests = requests;
    }
}
