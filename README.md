# Cache API with Spring, Docker, and Render

This project implements a simple **Cache API** using **Spring** and Docker. It provides basic caching functionalities (store, retrieve, and delete) with a predefined size limit on the cache. The application is containerized using Docker and deployed on **Render** for easy access. The API is live and accessible at the following URL:

[Live API URL](https://cache-7kmf.onrender.com/)

## Technologies Used

- **Spring 3.4.2**: Used for building the Cache API with Spring MVC.
- **Docker**: Containerized the application for consistent and easy deployment.
- **Render**: Deployed the Dockerized application to Render for hosting.

## Project Setup

### 1. Spring Project Setup

The Spring project was set up using Spring Initializr (https://start.spring.io/) with the **Web** dependency to create the REST API.

### 2. Docker Setup

To create a Docker image for the application, the following command was used:

```bash
docker build -t <user_docker_repository>cactorcache:latest .
```

This command builds the Docker image using the `Dockerfile` in the project directory, tagging it as `cactorcache:latest`. Once the image was built successfully, it was pushed to Docker Hub.

### 3. Docker Hub

The Docker image was pushed to **Docker Hub** to make it accessible for deployment. This allows the application to be deployed easily to cloud services like **Render**.

### 4. Deployment on Render

The application was deployed using **Render Web Services**. It is now live and can be accessed at the following URL:

[https://cache-7kmf.onrender.com/](https://cache-7kmf.onrender.com/)

## API Endpoints

### 1. **POST /cache**

- **Description**: Stores a key-value pair in the cache.
- **Request Body (JSON)**:

```json
{
    "key": "key1",
    "value": {
        "randomData1": "data1",
        "randomData2": "data2"
    },
    "expireAfterMilliseconds": "30000"
}
```

- **Response**: 
  - `Stored successfully` if the key-value pair is added successfully.
  - `Error: Cache size limit reached!` if the cache size limit is reached (set to 10).

### 2. **GET /cache/{key}**

- **Description**: Retrieves the value for the provided key from the cache.
- **Response**: The value associated with the provided key.

### 3. **DELETE /cache/{key}**

- **Description**: Removes the key-value pair from the cache.
- **Response**: 
  - `Removed successfully` if the key is found and removed.
  - `Key not found` if the key does not exist in the cache.

## Testing with Postman

You can test the API using the provided **Postman Collection**. Follow these steps to import and use the collection.

### Import the Postman Collection

1. **Open Postman**.
2. **Click on `Import`** located at the top left of the Postman window.
3. **Select `Raw Text`** and paste the collection JSON provided below.
4. **Click `Continue`** and then click **Import**.

### Setting the `server_cache` Environment Variable

Before running the requests, you need to set the `server_cache` variable to the **base URL** of the API. In this case, the URL is:

```
https://cache-7kmf.onrender.com
```

1. **Click on the gear icon** in the top right corner of Postman to open **Manage Environments**.
2. **Create a new environment** named `Cache API`.
3. Add a variable:
   - **Variable Name**: `server_cache`
   - **Initial Value**: `https://cache-7kmf.onrender.com`
4. **Save** the environment.
5. Select the environment from the top-right dropdown in Postman.

### Testing the Endpoints

Now that you have set up the collection, you can test the following endpoints:

1. **POST /cache**
   - **URL**: `{{server_cache}}/cache`
   - **Method**: POST
   - **Body**: 
     ```json
     {
         "key": "key1",
         "value": {
             "randomData1": "data1",
             "randomData2": "data2"
         },
         "expireAfterMiliseconds": "30000"
     }
     ```

2. **GET /cache/{key}**
   - **URL**: `{{server_cache}}/cache/{{key}}`
   - **Method**: GET
   - **Response**: The value for the given key.

3. **DELETE /cache/{key}**
   - **URL**: `{{server_cache}}/cache/{{key}}`
   - **Method**: DELETE
   - **Response**: `Removed successfully` if the key is removed or `Key not found` if the key doesn't exist.

## Conclusion

This project provides a simple **Cache API** using **Spring**, **Docker**, and **Render**. The API allows storing, retrieving, and deleting cache entries with a predefined cache size limit. You can test the API using the provided Postman collection and deploy the application to Render for live usage.
