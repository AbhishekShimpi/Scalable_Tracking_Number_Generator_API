# Scalable Tracking Number Generator API

This project is a scalable RESTful API designed to generate unique tracking numbers for parcels. Built with Spring Boot and Java, it provides a single, efficient endpoint that can handle high volumes of concurrent requests without relying on a centralized database.

## Requirements

* **Java 8+**
* **Spring Boot**
* **Maven**

## Setup and Run Instructions

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/AbhishekShimpi/Scalable_Tracking_Number_Generator_API.git
    cd Scalable_Tracking_Number_Generator_API
    ```

2.  **Build the project:**
    Use Maven to package the application.
    ```sh
    ./mvnw clean package
    ```

3.  **Run the application:**
    You can run the application using the Spring Boot Maven plugin.
    ```sh
    ./mvnw spring-boot:run
    ```
    The API will be available at `http://localhost:8080`.

## API Endpoint

### `GET /next-tracking-number`

This endpoint generates a new, unique tracking number.

**Query Parameters:**
The API accepts several optional query parameters, though they are not used in the number generation process for this implementation.

| Parameter | Type | Description | Required |
| --- | --- | --- | --- |
| `origin_country_id` | string | The order's origin country code. | No |
| `destination_country_id` | string | The order's destination country code. | No |
| `weight` | string | The order's weight in kilograms. | No |
| `created_at` | string | The order's creation timestamp. | No |
| `customer_id` | string | The customer's UUID. | No |
| `customer_name` | string | The customer's name. | No |
| `customer_slug` | string | The customer's name in slug-case. | No |

**Example Request:**
GET http://localhost:8080/next-tracking-number

**Example Response:**
```json
{
    "tracking_number": "8RVJaFITE",
    "created_at": "2025-09-18T06:45:37.892367100Z"
}
