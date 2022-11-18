package com.redhat.training;

import com.redhat.training.operation.Add;
import com.redhat.training.operation.Identity;
import com.redhat.training.operation.Multiply;
import com.redhat.training.operation.Operation;
import com.redhat.training.operation.Substract;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class OperationRegistry {
    @Inject
    Add add;

    @Inject
    Substract substract;

    @Inject
    Multiply multiply;

    @Inject
    Identity identity;

    private List<Operation> operations;

    @PostConstruct
    protected void buildOperationList() {
        setOperations(List.of(substract, add, multiply, identity));
    }
    public List<Operation> getOperations() {
        return operations;
    }
    private void setOperations(final List<Operation> operationsParam) {
        this.operations = operationsParam;
    }

}
