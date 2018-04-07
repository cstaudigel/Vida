package io.github.cstaudigel.domain.viewmodels;

import io.github.cstaudigel.domain.models.InvolvmentRequest;

import java.util.List;

public class InvolvmentViewModel {

    List<InvolvmentRequest> requests;

    public InvolvmentViewModel(List<InvolvmentRequest> requests) {
        this.requests = requests;
    }

    public List<InvolvmentRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<InvolvmentRequest> requests) {
        this.requests = requests;
    }
}
