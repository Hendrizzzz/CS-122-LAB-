# Consumer Class

The `Consumer` class represents a consumer with water consumption data. It includes details such as the consumer's name, type, starting water meter reading, and water readings for each month.

## Usage

### 1. Create a Consumer Instance

```java
Consumer consumer = new Consumer("John Doe", "Residential", 100.0, new double[]{25.0, 30.0, 22.5, 18.0});

## Access Consumer Information

String name = consumer.getName();
String type = consumer.getConsumerType();
double startingReading = consumer.getStartingWaterMeterReading();
double[] readings = consumer.getWaterReadingPerMonth();

## Constructor

/**
 * Constructs a new Consumer with the specified details.
 *
 * @param name                     The name of the consumer.
 * @param consumerType             The type of consumer.
 * @param startingWaterMeterReading The starting water meter reading.
 * @param waterReadingPerMonth     An array of water readings for each month.
 */
public Consumer(String name, String consumerType, double startingWaterMeterReading, double[] waterReadingPerMonth);


## Public Methods

### getName()
Gets the name of the consumer.

### getConsumerType()
Gets the type of the consumer.

### getStartingWaterMeterReading()
Gets the starting water meter reading for the consumer.

### getWaterReadingPerMonth()
Gets an array of water readings for each month.
