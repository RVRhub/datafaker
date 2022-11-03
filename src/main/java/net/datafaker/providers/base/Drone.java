package net.datafaker.providers.base;

/**
 * An unmanned aerial vehicle (UAV), commonly known as a drone, is an aircraft without any human pilot, crew, or passengers on board.
 *
 * @since 1.7.0
 */
public class Drone extends AbstractProvider<BaseProviders> {

    protected Drone(BaseProviders faker) {
        super(faker);
    }

    public String name() {
        return resolve("drone.name");
    }

    public String weight() {
        return resolve("drone.weight");
    }

    public String maxAscentSpeed() {
        return resolve("drone.max_ascent_speed");
    }

    public String maxDescentSpeed() {
        return resolve("drone.max_descent_speed");
    }

    public String flightTime() {
        return resolve("drone.flight_time");
    }

    public String maxAltitude() {
        return resolve("drone.max_altitude");
    }

    public String maxFlightDistance() {
        return resolve("drone.max_flight_distance");
    }

    public String maxSpeed() {
        return resolve("drone.max_speed");
    }

    public String maxWindResistance() {
        return resolve("drone.max_wind_resistance");
    }

    public String maxAngularVelocity() {
        return resolve("drone.max_angular_velocity");
    }

    public String maxTiltAngle() {
        return resolve("drone.max_tilt_angle");
    }

    public String operatingTemperature() {
        return resolve("drone.operating_temperature");
    }

    public String batteryCapacity() {
        return resolve("drone.battery_capacity");
    }

    public String batteryVoltage() {
        return resolve("drone.battery_voltage");
    }

    public String batteryType() {
        return resolve("drone.battery_type");
    }

    public String batteryWeight() {
        return resolve("drone.battery_weight");
    }

    public String chargingTemperature() {
        return resolve("drone.charging_temperature");
    }

    public String maxChargingPower() {
        return resolve("drone.max_charging_power");
    }

    public String iso() {
        return resolve("drone.iso");
    }

    public String maxResolution() {
        return resolve("drone.max_resolution");
    }

    public String photoFormat() {
        return resolve("drone.photo_format");
    }

    public String videoFormat() {
        return resolve("drone.video_format");
    }

    public String maxShutterSpeed() {
        return resolve("drone.max_shutter_speed");
    }

    public String minShutterSpeed() {
        return resolve("drone.min_shutter_speed");
    }

    public String shutterSpeedUnits() {
        return resolve("drone.shutter_speed_units");
    }

}