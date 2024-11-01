# Time-Api-App

## Overview
**Time-Api-App** is a Dockerized API wrapper application that interfaces with the [World Time API](http://worldtimeapi.org/pages/examples) to provide time-related data through a simple API.

## Quick Start
To start the application in detached mode using Docker, run the `deploy.sh` script:

```bash
./deploy.sh
```

## API Usage
This application serves as a wrapper for API calls to the World Time API. Here are some example API calls:

### Example API Calls
- **Get Current Time for a Specific Location:**
  - **Endpoint:** 
    ```
    GET http://localhost:8081/America/Argentina/Salta
    ```
  - **cURL Command:**
    ```bash
    curl -X GET http://localhost:8081/America/Argentina/Salta
    ```

- **Retrieve Database Entry:**
  - **Endpoint for Database Entry with ID 3:**
    ```
    GET http://localhost:8081/db/3
    ```
  - **cURL Command:**
    ```bash
    curl -X GET http://localhost:8081/db/3
    ```


## Conclusion
This application allows for easy access to time data from the World Time API and includes database functionality for storing and retrieving specific time entries. For any issues or contributions, please feel free to reach out or submit a pull request.
