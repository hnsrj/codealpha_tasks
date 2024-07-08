import java.util.ArrayList;

public class Room {
    private int roomId;
    private String roomNumber;
    private String roomType;
    private boolean available;
    private double pricePerNight;
    private int capacity;
    private ArrayList<String> amenities;
    private boolean hasWifi;
    private boolean hasTelevision;
    private boolean hasAirConditioning;
    private boolean hasMiniBar;
    private boolean hasBalcony;
    private boolean isSmokingAllowed;

    public Room(int roomId, String roomNumber, String roomType, double pricePerNight, int capacity) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.available = true;
        this.amenities = new ArrayList<>();
        this.hasWifi = false;
        this.hasTelevision = false;
        this.hasAirConditioning = false;
        this.hasMiniBar = false;
        this.hasBalcony = false;
        this.isSmokingAllowed = false;
    }

    // Getters and setters for basic attributes
    public int getRoomId() {
        return roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<String> getAmenities() {
        return amenities;
    }

    public void addAmenity(String amenity) {
        amenities.add(amenity);
    }

    // Getters and setters for additional features
    public boolean hasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public boolean hasTelevision() {
        return hasTelevision;
    }

    public void setHasTelevision(boolean hasTelevision) {
        this.hasTelevision = hasTelevision;
    }

    public boolean hasAirConditioning() {
        return hasAirConditioning;
    }

    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }

    public boolean hasMiniBar() {
        return hasMiniBar;
    }

    public void setHasMiniBar(boolean hasMiniBar) {
        this.hasMiniBar = hasMiniBar;
    }

    public boolean hasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isSmokingAllowed() {
        return isSmokingAllowed;
    }

    public void setSmokingAllowed(boolean smokingAllowed) {
        isSmokingAllowed = smokingAllowed;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", available=" + available +
                ", pricePerNight=" + pricePerNight +
                ", capacity=" + capacity +
                ", amenities=" + amenities +
                ", hasWifi=" + hasWifi +
                ", hasTelevision=" + hasTelevision +
                ", hasAirConditioning=" + hasAirConditioning +
                ", hasMiniBar=" + hasMiniBar +
                ", hasBalcony=" + hasBalcony +
                ", isSmokingAllowed=" + isSmokingAllowed +
                '}';
    }
}
