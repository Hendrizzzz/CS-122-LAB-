public class Consumer {
    private final String name;
    private final String consumerType;
    private final double startingWaterMeterReading;
    private final double[] waterReadingPerMonth;

    public Consumer(String name, String consumerType, double startingWaterMeterReading, double[] waterReadingPerMonth) {
        this.name = name;
        this.consumerType = consumerType;
        this.startingWaterMeterReading = startingWaterMeterReading;
        this.waterReadingPerMonth = waterReadingPerMonth;
    }

    public String getName() {
        return name;
    }

    public String getConsumerType() {
        return consumerType;
    }

    public double getStartingWaterMeterReading() {
        return startingWaterMeterReading;
    }

    public double[] getWaterReadingPerMonth() {
        return waterReadingPerMonth;
    }
}
