#!/bin/bash

CONTAINER_NAME="Time_Api_App"
IMAGE_NAME="time_api_app"

echo "Building Docker image..."
docker build -t $IMAGE_NAME .

if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
    echo "Stopping existing container..."
    docker stop $CONTAINER_NAME
    docker rm $CONTAINER_NAME
fi

echo "Starting new container..."
docker run -d --name $CONTAINER_NAME -p 8081:8081 $IMAGE_NAME
