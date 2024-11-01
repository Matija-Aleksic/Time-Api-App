#!/bin/bash

# Define container name and image
CONTAINER_NAME="Time_Api_App"
IMAGE_NAME="time_api_app"

if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
    echo "Stopping existing container..."
    docker stop $CONTAINER_NAME
    docker rm $CONTAINER_NAME
fi

echo "Starting new container..."
docker run -d --name $CONTAINER_NAME -p 8081:8081 $IMAGE_NAME

while true; do
    sleep 60
done