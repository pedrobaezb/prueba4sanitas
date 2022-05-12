package com.sanitas.prueba4.pedro.calculadora.healthService;

public class HealthCheckResponse {
    private int status=0;
    private String statusDetail="OK";

    public HealthCheckResponse() {
    }

    public HealthCheckResponse(int status, String statusDetail) {
        this.status = status;
        this.statusDetail = statusDetail;
    }

    @Override
    public String toString() {
        return "HealthCheckResponse{" +
                "status=" + status +
                ", statusDetail='" + statusDetail + '\'' +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }
}
