/*
 * CabBooking_SOLID.java
 * 
 * Single-file example demonstrating a cab-booking (ride-hailing) system
 * designed with SOLID principles in mind.
 *
 * - Single Responsibility: each class/interface has one responsibility.
 * - Open/Closed: behaviors (pricing, matching, payment, notifications)
 *   are implemented via interfaces so new implementations can be added
 *   without modifying existing code.
 * - Liskov Substitution: implementations follow their interfaces' contracts.
 * - Interface Segregation: small, focused interfaces (PaymentProcessor, NotificationService, etc.).
 * - Dependency Inversion: high-level modules depend on abstractions injected via constructors.
 *
 * This is a simple, runnable demonstration (no external frameworks).
 */

package com.example.cab;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class CabBookingApp {
    public static void main(String[] args) {
        // Compose dependencies
        DriverRepository driverRepo = new InMemoryDriverRepository();
        PricingStrategy pricing = new SurgePricingStrategy(1.0, 1.5); // base, surge
        MatchingStrategy matcher = new NearestDriverMatchingStrategy(driverRepo);
        PaymentProcessor payment = new FakePaymentProcessor();
        NotificationService notifier = new ConsoleNotificationService();

        // High-level service depends only on abstractions
        CabBookingService bookingService = new CabBookingService(driverRepo, pricing, matcher, payment, notifier);

        // Seed drivers
        driverRepo.addDriver(new Driver("d1", "Ramesh", new Location(12.9716, 77.5946), VehicleType.SEDAN));
        driverRepo.addDriver(new Driver("d2", "Sita", new Location(12.9720, 77.5950), VehicleType.HATCHBACK));

        // Rider requests a ride
        Rider rider = new Rider("r1", "Raj", new Location(12.9718, 77.5948));
        TripRequest req = new TripRequest(rider, new Location(12.9800, 77.6000));

        Optional<Trip> tripOpt = bookingService.requestTrip(req);
        tripOpt.ifPresent(trip -> {
            System.out.println("Trip confirmed: " + trip);
            // Simulate rider paying
            boolean paid = bookingService.chargeTrip(trip.getId());
            System.out.println("Payment status: " + paid);
        });
    }
}

/* --------------------------- Domain Models --------------------------- */

enum VehicleType { HATCHBACK, SEDAN, SUV }

final class Location {
    final double lat;
    final double lon;
    Location(double lat, double lon) { this.lat = lat; this.lon = lon; }
    double distanceTo(Location other) {
        double dx = lat - other.lat;
        double dy = lon - other.lon;
        return Math.sqrt(dx*dx + dy*dy); // Euclidean for demo
    }
    @Override public String toString() { return String.format("(%.6f, %.6f)", lat, lon); }
}

final class Rider {
    private final String id;
    private final String name;
    private final Location location;
    Rider(String id, String name, Location location) { this.id = id; this.name = name; this.location = location; }
    public String getId() { return id; }
    public String getName() { return name; }
    public Location getLocation() { return location; }
}

final class Driver {
    private final String id;
    private final String name;
    private volatile Location location; // drivers move
    private volatile boolean available = true;
    private final VehicleType vehicleType;

    Driver(String id, String name, Location location, VehicleType v) {
        this.id = id; this.name = name; this.location = location; this.vehicleType = v;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Location getLocation() { return location; }
    public void setLocation(Location loc) { this.location = loc; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public VehicleType getVehicleType() { return vehicleType; }

    @Override public String toString() { return name + "(" + id + ")@" + location; }
}

final class TripRequest {
    private final Rider rider;
    private final Location destination;
    TripRequest(Rider rider, Location destination) { this.rider = rider; this.destination = destination; }
    public Rider getRider() { return rider; }
    public Location getDestination() { return destination; }
}

final class Trip {
    private final String id;
    private final Rider rider;
    private final Driver driver;
    private final Location from;
    private final Location to;
    private final double fare;
    private TripStatus status;

    Trip(String id, Rider rider, Driver driver, Location from, Location to, double fare) {
        this.id = id; this.rider = rider; this.driver = driver; this.from = from; this.to = to; this.fare = fare; this.status = TripStatus.CONFIRMED;
    }

    public String getId() { return id; }
    public Rider getRider() { return rider; }
    public Driver getDriver() { return driver; }
    public double getFare() { return fare; }
    public TripStatus getStatus() { return status; }
    public void setStatus(TripStatus status) { this.status = status; }

    @Override public String toString() { return String.format("Trip[%s]: %s -> %s by %s fare=%.2f status=%s", id, from, to, driver.getName(), fare, status); }
}

enum TripStatus { CONFIRMED, ONGOING, COMPLETED, CANCELLED }

/* --------------------------- Abstractions / Interfaces --------------------------- */

interface DriverRepository {
    void addDriver(Driver d);
    Optional<Driver> findById(String id);
    List<Driver> findAllAvailable();
    void updateDriver(Driver d);
}

interface PricingStrategy {
    double calculateFare(Location from, Location to);
}

interface MatchingStrategy {
    Optional<Driver> matchDriver(TripRequest request);
}

interface PaymentProcessor {
    boolean charge(String tripId, double amount);
}

interface NotificationService {
    void notifyDriver(Driver driver, String message);
    void notifyRider(Rider rider, String message);
}

/* --------------------------- Concrete Implementations --------------------------- */

class InMemoryDriverRepository implements DriverRepository {
    private final Map<String, Driver> drivers = new HashMap<>();

    @Override public synchronized void addDriver(Driver d) { drivers.put(d.getId(), d); }
    @Override public synchronized Optional<Driver> findById(String id) { return Optional.ofNullable(drivers.get(id)); }
    @Override public synchronized List<Driver> findAllAvailable() {
        List<Driver> res = new ArrayList<>();
        for (Driver d : drivers.values()) if (d.isAvailable()) res.add(d);
        return res;
    }
    @Override public synchronized void updateDriver(Driver d) { drivers.put(d.getId(), d); }
}

/** Simple pricing: base + distance * rate * surgeMultiplier */
class SurgePricingStrategy implements PricingStrategy {
    private final double baseFare;
    private final double surgeMultiplier;
    private final double perKm = 10.0; // demo
    SurgePricingStrategy(double baseFare, double surgeMultiplier) { this.baseFare = baseFare; this.surgeMultiplier = surgeMultiplier; }

    @Override public double calculateFare(Location from, Location to) {
        double kms = from.distanceTo(to); // fake km
        return (baseFare + kms * perKm) * surgeMultiplier;
    }
}

/** Nearest driver matching */
class NearestDriverMatchingStrategy implements MatchingStrategy {
    private final DriverRepository repo;
    NearestDriverMatchingStrategy(DriverRepository repo) { this.repo = repo; }

    @Override public Optional<Driver> matchDriver(TripRequest request) {
        List<Driver> candidates = repo.findAllAvailable();
        Driver best = null; double bestDist = Double.MAX_VALUE;
        for (Driver d : candidates) {
            double dist = d.getLocation().distanceTo(request.getRider().getLocation());
            if (dist < bestDist) { bestDist = dist; best = d; }
        }
        return Optional.ofNullable(best);
    }
}

/** Fake payment processor for demo; in real life use proper gateway integration */
class FakePaymentProcessor implements PaymentProcessor {
    private final Set<String> charged = new HashSet<>();
    @Override public boolean charge(String tripId, double amount) {
        // Pretend to perform payment and succeed
        System.out.println("Charging trip " + tripId + " amount=\u20B9" + String.format("%.2f", amount));
        charged.add(tripId);
        return true;
    }
}

class ConsoleNotificationService implements NotificationService {
    @Override public void notifyDriver(Driver driver, String message) {
        System.out.println("[Notify-Driver] " + driver.getName() + ": " + message);
    }
    @Override public void notifyRider(Rider rider, String message) {
        System.out.println("[Notify-Rider] " + rider.getName() + ": " + message);
    }
}

/* --------------------------- High-level Service --------------------------- */

class CabBookingService {
    private final DriverRepository driverRepo;
    private final PricingStrategy pricing;
    private final MatchingStrategy matching;
    private final PaymentProcessor payment;
    private final NotificationService notifier;
    private final Map<String, Trip> trips = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public CabBookingService(DriverRepository driverRepo, PricingStrategy pricing, MatchingStrategy matching,
                             PaymentProcessor payment, NotificationService notifier) {
        this.driverRepo = driverRepo;
        this.pricing = pricing;
        this.matching = matching;
        this.payment = payment;
        this.notifier = notifier;
    }

    /** Returns Optional<Trip> if matched and created */
    public Optional<Trip> requestTrip(TripRequest request) {
        Optional<Driver> driverOpt = matching.matchDriver(request);
        if (driverOpt.isEmpty()) {
            notifier.notifyRider(request.getRider(), "No drivers available");
            return Optional.empty();
        }
        Driver driver = driverOpt.get();
        // Reserve driver
        driver.setAvailable(false);
        driverRepo.updateDriver(driver);

        double fare = pricing.calculateFare(request.getRider().getLocation(), request.getDestination());
        String tripId = "T" + idGen.getAndIncrement();
        Trip trip = new Trip(tripId, request.getRider(), driver, request.getRider().getLocation(), request.getDestination(), fare);
        trips.put(tripId, trip);

        notifier.notifyDriver(driver, "You have a new trip: " + tripId + " fare=\u20B9" + String.format("%.2f", fare));
        notifier.notifyRider(request.getRider(), "Driver " + driver.getName() + " assigned. Trip id: " + tripId + " fare=\u20B9" + String.format("%.2f", fare));
        return Optional.of(trip);
    }

    public boolean chargeTrip(String tripId) {
        Trip trip = trips.get(tripId);
        if (trip == null) return false;
        if (trip.getStatus() != TripStatus.CONFIRMED && trip.getStatus() != TripStatus.ONGOING) return false;
        boolean ok = payment.charge(tripId, trip.getFare());
        if (ok) {
            trip.setStatus(TripStatus.COMPLETED);
            // release driver
            Driver d = trip.getDriver(); d.setAvailable(true); driverRepo.updateDriver(d);
            notifier.notifyRider(trip.getRider(), "Payment successful. Trip completed.");
            notifier.notifyDriver(trip.getDriver(), "Trip completed and payment processed.");
        } else {
            notifier.notifyRider(trip.getRider(), "Payment failed. Please try again.");
        }
        return ok;
    }
}
