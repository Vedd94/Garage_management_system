package entity;

public class invoice {
    private int id;
    private int customerId;
    private int vehicleID;
    private int serviceId;

    public invoice(int id, int customerId, int vehicleID, int serviceId) {
        this.id = id;
        this.customerId = customerId;
        this.vehicleID = vehicleID;
        this.serviceId = serviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "invoice [" +
                "id=" + id +
                ", customerId = " + customerId +
                ", vehicleID = " + vehicleID +
                ", serviceId = " + serviceId +
                " ]";
    }
}
